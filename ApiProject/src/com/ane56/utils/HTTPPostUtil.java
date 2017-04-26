package com.ane56.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HTTPPostUtil
{
	String url;
	HttpURLConnection connection;                           
	String boundary = "";
	Map<String,String> textParams = new HashMap<String,String>();
	Map<String,File> fileParams = new HashMap<String,File>();
	Map<String,String> urlParams = new HashMap<String,String>();
	
	DataOutputStream ds;
	
	/**
	 * Constructor Function
	 * @param url
	 * @throws Exception
	 */
	public HTTPPostUtil(String url) throws Exception
	{
		this.url = url;
	}
	
	//ÉèÖÃÊôÐÔ·½·¨
	public void setUrl(String  url) throws Exception
	{
		this.url = url;
	}
	
	//Ôö¼ÓÒ»¸öÎÄ¼þµ½Form±íµ¥Êý¾ÝÖÐ
	public void addFileParameter(String name,File value)
	{
		fileParams.put(name, value);
	}
	
	//Ôö¼ÓÒ»¸öÆÕÍ¨×Ö·û´®Êý¾Ýµ½Form±íµ¥Êý¾ÝÖÐ
	public void addTextParameter(String name,String value)
	{
		textParams.put(name, value);
	}
	
	//Ìí¼ÓÒ»¸öURLÇëÇókey-value
	public void addUrlParameter(String key,String value)
	{
		urlParams.put(key, value);
	}
	
	public Map<String,String> getUrlParams()
	{
		return urlParams;
	}
	
	//ÆÕÍ¨×Ö·û´®Êý¾Ý
	public void writeStringParams() throws Exception
	{
		Set<String> keySet = textParams.keySet();
		for(Iterator<String> it = keySet.iterator();it.hasNext();)
		{
			String name = it.next();
			String value = textParams.get(name);
			ds.writeBytes(value);
		}
	}
	
	//ÎÄ¼þÊý¾Ý
	public void writeFileParams() throws Exception
	{
		Set<String> keySet = fileParams.keySet();
		for(Iterator<String> it = keySet.iterator();it.hasNext();)
		{
			String name = it.next();
			File value = fileParams.get(name);
			ds.write(getBytes(value));
		}
	}
	
	//»ñÈ¡ÎÄ¼þÉÏ´«ÀàÐÍ£¬Í¼Æ¬¸ñÊ½Îªimage/png, image/jpgµÈ¡£
	//·ÇÍ¼Æ¬Îªapplication/octet-stream
	public String getContentType(File file) throws Exception
	{
		ImageInputStream imageIn = ImageIO.createImageInputStream(file);
		if(imageIn == null)
		{
			return "application/octet-stream";
		}
		
		Iterator<ImageReader> it = ImageIO.getImageReaders(imageIn);
		if(!it.hasNext())
		{
			imageIn.close();
			return "application/octet-stream";
		}
		
		imageIn.close();
		//½«FormatName·µ»ØµÄÖµ×ªÎªÐ¡Ð´£¬Ä¬ÈÏÎª´óÐ´.
		return "image/"+it.next().getFormatName().toLowerCase();
	}
	
	//°ÑÎÄ¼þ×ª»»³É×Ö½ÚÊý×é
	public byte[] getBytes(File file) throws Exception
	{
		FileInputStream in = new FileInputStream(file);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int n;
		while((n=in.read(b))!= -1)
		{
			out.write(b,0,n);
		}
		
		in.close();
		return out.toByteArray();
	}
	
	//Ìí¼Ó½áÎ²Êý¾Ý
	public void paramsEnd() throws Exception
	{
		ds.writeBytes("--" + boundary + "--" + "\r\n");
		ds.writeBytes("\r\n");
	}
	
	//Çå¿ÕËùÓÐÒÑÌí¼ÓµÄForm±íµ¥Êý¾Ý
	public void clearAllFormParameters()
	{
		textParams.clear();
		fileParams.clear();
	}
	
	//ÎÄ¼þÉÏ´«Ê±ºò£¬Á´½ÓµÄÒ»Ð©±ØÐëÉèÖÃ²ÎÊý
	public void initConnection() throws Exception
	{
		StringBuffer params = new StringBuffer();
		for(Map.Entry<String, String> entry:urlParams.entrySet())
		{
			params.append("&" + entry.getKey() + "=" +encode(entry.getValue()));
		}
		
		if(!url.contains("?"))
		{
			params.replace(0, 1, "?");
		}
		
		URL urlConn = new URL(this.url + params.toString());
		connection = (HttpURLConnection) urlConn.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setConnectTimeout(10000);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	}
	
	//¶Ô°üº¬ÖÐÎÄµÄ×Ö·û´®½øÐÐ×ªÂë£¬´ËÎªUTF-8.
	//·þÎñÆ÷Òª½øÐÐÒ»´Î½âÂë
	public String encode(String value) throws Exception
	{
		return URLEncoder.encode(value,"UTF-8");
	}
	
	//·¢ËÍÊý¾Ýµ½·þÎñÆ÷£¬·µ»ØÒ»¸ö×Ö½Ú°üº¬·þÎñÆ÷µÄ·µ»Ø½á¹ûµÄÊý×é
	public byte[] send() throws Exception
	{
		initConnection();
		try
		{
			connection.connect();
		}
		catch(SocketTimeoutException ex)
		{
			throw new RuntimeException();
		}
		
		ds = new DataOutputStream(connection.getOutputStream());
		writeFileParams();
		writeStringParams();
		paramsEnd();
		InputStream in = connection.getInputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int b;
		
		while((b=in.read())!= -1)
		{
			out.write(b);
		}
		
		connection.disconnect();
		return out.toByteArray();
	}
	

	/*public static void main(String[] args) throws Exception
	{
		HTTPPostUtil post = new HTTPPostUtil("http://192.168.10.47:10200/customer/OCityHandler/getCityPrice");
		post.addUrlParameter("params", "{\"CityName\":\"ÉÏº£\",\"BusinessType\":10}");
		post.addUrlParameter("safecode", "");
		byte[] b = post.send();
		String response = URLDecoder.decode(new String(b,"UTF-8"),"utf-8");
		System.out.println("response from server:="+response);	
		
		//½âÎö·µ»ØµÄJSON
		JSONObject json = JSONObject.fromObject(response);
		boolean isSuccess = json.getBoolean("IsSuccess");
		if(isSuccess)
		{
			JSONObject result = json.getJSONObject("Result");
			JSONObject cityPrice = result.getJSONObject("CityPrice");
			int cityPriceId = cityPrice.getInt("CityPriceId");
			System.out.println("cityPriceID:="+cityPriceId);
			
			JSONArray cityPriceList = result.getJSONArray("CityPriceList");
			int intLength = cityPriceList.toArray().length;
			
			for(int i=0;i<intLength;i++)
			{
				System.out.println("element is:=" + cityPriceList.getJSONObject(i).get("StartPrice").toString());
			}
			
			ListIterator iterator = cityPriceList.listIterator();
			while(iterator.hasNext())
			{
				JSONObject temp = (JSONObject) iterator.next();
				System.out.println("startPrice:=" + temp.get("StartPrice"));
			}
			
			
		}
		else
		{
			
		}
		
		
		
		//{"IsSuccess":true,"ErrorMsg":"","ErrorCode":0,"Result":{"CityPrice":{"CityPriceId":2,"CityId":37,"CityPinYin":"shanghai","BusinessType":10,"CityName":"ÉÏº£ÊÐ","Remark":"1¡¢²»Í¬Ê±¶ÎµÄ´ú¼Ý·Ñ¼ÆËã£¬ÒÔ¿ª³µÆð²½µÄÆðÊ¼Ê±¼äµãÎª×¼¡£Èç21:50¿ªÊ¼´ú¼Ý£¬22:20½áÊø´ú¼Ý£¬Æð²½¼Û¼´Îª38Ôª¡£\\n2¡¢Ã¿³¬¹ý10¹«Àï¼ÓÊÕ20Ôª,²»×ã10¹«Àï°´10¹«Àï¼ÆËã¡£\\n3¡¢30·ÖÖÓÃâ·ÑµÈ´ý£¬³¬³ö²¿·ÖÃ¿30·ÖÖÓ¼ÓÊÕ20Ôª£¬²»×ã30·ÖÖÓ°´30·ÖÖÓ¼ÆËã¡£"},"CityPriceList":[{"CityPriceId":2,"UnitPrice":20,"WaitUnitPrice":20,"UnitMileage":10,"EndTime":"21:59","StartMileage":10,"WaitUnitTime":30,"StartTime":"05:00","StartPrice":38,"Remark":""},{"CityPriceId":2,"UnitPrice":20,"WaitUnitPrice":20,"UnitMileage":10,"EndTime":"22:59","StartMileage":10,"WaitUnitTime":30,"StartTime":"22:00","StartPrice":58,"Remark":""},{"CityPriceId":2,"UnitPrice":20,"WaitUnitPrice":20,"UnitMileage":10,"EndTime":"23:59","StartMileage":10,"WaitUnitTime":30,"StartTime":"23:00","StartPrice":78,"Remark":""},{"CityPriceId":2,"UnitPrice":20,"WaitUnitPrice":20,"UnitMileage":10,"EndTime":"04:59","StartMileage":10,"WaitUnitTime":30,"StartTime":"00:00","StartPrice":98,"Remark":""}]}}

	}*/

}