package com.ane56.api.lb;

import com.alibaba.fastjson.JSONObject;
import com.ane56.utils.HttpUtils;
import com.ane56.utils.SecurityUtil;
import com.ane56.entity.LbOrder;
import com.ane56.utils.DataProviders;
/**
 * ���˱�׼�ӿڶ����½�������
 * @author hws
 *
 */
public class Api_LbOpcNewTest {
	

	public  String lb_NewTest(String orderNo,String GoodsName,String SendCompanyName,String SendLinkMan,String SendPhoneSms,
		String SendAddress,String SendCity,String SendCounty,String SendProvince,String code,String secretKey,String url ) throws Exception {


	String response ="";
////�ͻ�����
		LbOrder order = new LbOrder();
		order.setOrderNo(orderNo);
		order.setGoodsName(GoodsName);
		order.setSendCompanyName(SendCompanyName);
		order.setSendLinkMan(SendLinkMan);
		order.setSendPhoneSms(SendPhoneSms);
        order.setSendAddress(SendAddress);
		order.setSendCity(SendCity);
		order.setSendCounty(SendCounty);
    	order.setSendProvince(SendProvince);
////		order.setSendPhone("/");
		
////		order.setDispatchCompanyName("ane");
////		order.setDispatchLinkMan("��С��1");
////		order.setDispatchPhoneSms("000000");
////		order.setSendPhone("123585");
////		order.setDispatchAddress("�����˲�");
////		order.setDispatchCity("�˲�");
////		order.setDispatchCounty("Ƽ��");
////		order.setDispatchProvince("����");
////		order.setProductType("DSD");
//		
		JSONObject json = new JSONObject();
		String params = JSONObject.toJSONString(order);
////		String params = "{\"dispatchAddress\":\"\",\"dispatchCity\":\"��Ͻ��\",\"dispatchCounty\":\"������\",\"dispatchLinkMan\":\"\",\"dispatchPhone\":\"\",\"dispatchProvince\":\"������\",\"goodsName\":\"111\",\"orderNo\":\"ASW20161128165056990\",\"sendAddress\":\"111\",\"sendCity\":\"��Ͻ��\",\"sendCompanyName\":\"cest\",\"sendCounty\":\"������\",\"sendLinkMan\":\"cest\",\"sendPhoneSms\":\"18419556887\",\"sendProvince\":\"������\"}";
////		String code = "dd";   XH
////		String secretKey = secretKey;   279965345745e9078485e4902826b23c
		String digest = SecurityUtil.getDigest(params, code, secretKey);
//		// �������
		json.put("code", code);
		json.put("timestamp", SecurityUtil.getTimestamp());
		json.put("params", params);
		json.put("digest", digest);
	
//		//��������
		try{
			System.out.println("�����������ӿ�-���˱�׼�ӿڡ�request:" + json.toString());
			response = HttpUtils.sendRequest(url, json.toString(), "UTF-8", 60000);
		   }catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println("�����������ӿ�-���˱�׼�ӿڡ�response:" + response);
			return response;
	
	}
}
