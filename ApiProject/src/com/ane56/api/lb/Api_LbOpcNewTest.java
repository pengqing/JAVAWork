package com.ane56.api.lb;

import com.alibaba.fastjson.JSONObject;
import com.ane56.utils.HttpUtils;
import com.ane56.utils.SecurityUtil;
import com.ane56.entity.LbOrder;
import com.ane56.utils.DataProviders;
/**
 * 快运标准接口订单新建测试类
 * @author hws
 *
 */
public class Api_LbOpcNewTest {
	

	public  String lb_NewTest(String orderNo,String GoodsName,String SendCompanyName,String SendLinkMan,String SendPhoneSms,
		String SendAddress,String SendCity,String SendCounty,String SendProvince,String code,String secretKey,String url ) throws Exception {


	String response ="";
////客户参数
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
////		order.setDispatchLinkMan("王小华1");
////		order.setDispatchPhoneSms("000000");
////		order.setSendPhone("123585");
////		order.setDispatchAddress("江西宜昌");
////		order.setDispatchCity("宜昌");
////		order.setDispatchCounty("萍乡");
////		order.setDispatchProvince("江西");
////		order.setProductType("DSD");
//		
		JSONObject json = new JSONObject();
		String params = JSONObject.toJSONString(order);
////		String params = "{\"dispatchAddress\":\"\",\"dispatchCity\":\"市辖区\",\"dispatchCounty\":\"东城区\",\"dispatchLinkMan\":\"\",\"dispatchPhone\":\"\",\"dispatchProvince\":\"北京市\",\"goodsName\":\"111\",\"orderNo\":\"ASW20161128165056990\",\"sendAddress\":\"111\",\"sendCity\":\"市辖区\",\"sendCompanyName\":\"cest\",\"sendCounty\":\"东城区\",\"sendLinkMan\":\"cest\",\"sendPhoneSms\":\"18419556887\",\"sendProvince\":\"北京市\"}";
////		String code = "dd";   XH
////		String secretKey = secretKey;   279965345745e9078485e4902826b23c
		String digest = SecurityUtil.getDigest(params, code, secretKey);
//		// 请求参数
		json.put("code", code);
		json.put("timestamp", SecurityUtil.getTimestamp());
		json.put("params", params);
		json.put("digest", digest);
	
//		//发送请求
		try{
			System.out.println("【订单创建接口-快运标准接口】request:" + json.toString());
			response = HttpUtils.sendRequest(url, json.toString(), "UTF-8", 60000);
		   }catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println("【订单创建接口-快运标准接口】response:" + response);
			return response;
	
	}
}
