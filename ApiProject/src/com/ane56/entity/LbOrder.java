package com.ane56.entity;



import java.util.Date;

/**
 * 标准接口订单实体类
 * @author hws
 * 修改时间:2016-9-5
 */
public class LbOrder {
    private String orderNo;//订单号

    private String ecId;//订单来源ID 60 微信下单 61 呼叫中心；62 网上营业厅
    
    private Integer orderType; //订单类型
    /**
      1-零担快运：普通零担快运订单，安能只负责干线运输。
	  2-家装：家装一站式服务订单，安能负责干线运输以及第三方配送、安装服务（外包）。
	  3-电商入仓：电商入仓订单，安能负责干线运输以及第三方入仓服务（外包）。
	       默认为1，建议设置成配置。
     */
    private Integer orderStatus;//订单状态
    /**
     * -1：撤销
     * 0：等待接单
     * 1：接单成功
     * 2：接单失败
     * 3：揽件成功
     * 4：揽件失败
     * 5：运输中
     * 6:派件中
     * 7：派件成功
     * 8：派件失败
     */
    private String customerCode;//客户简码
    
    private Integer serviceType;//产品类型
    
    private String orderStatusName;//订单状态名
    
    private Date gmtUpdated;//状态更新时间
    
    private String sendSiteId; //寄件网点id
    
    private String dispatchSiteId;//派件网点id
    
    private String ewbNo;//运单号
    
    private Integer ewbFlag;//开单标识（0-未开  1-已开）
    
    private String productType; //产品类型  MNXB-Mini小包，DSD-定时达，BZKY-标准快运
    
    private Integer deliveryType;//0-自提，1-派送
    
    private String goodsName; //货物名称
    
    private Integer goodsType;//商品类别
    /**默认为0
    0：文件类
    1：电子产品类（包括家用电器）
    2：办公用品类, 服装鞋帽，箱包类
    3：化妆品  美容产品类
    4：珠宝，手表，眼镜，贵重饰品类
    5：食品，保健药品类
    6：工艺品类（包括瓷器，茶具，烹饪用品）
    7：玩具乐器类
    8：其他类
    */
    private Integer totalPiece;//总件数

    private Double  totalWeight;//重量

    private Double  totalVol;//体积
    
    private String commodityRemark;//商品描述
    
    private String remark;//备注
    
    private String sendCompanyName;//寄件公司名称 没有公司名则填人名

    private String sendLinkMan;//寄件联系人

    private String sendPhoneSms;//寄件手机

    private String sendPhone;//寄件联系电话

    private String sendAddress;//寄件地址

    private String sendPostcode;//寄件邮编

    private String sendProvince;//寄件省份

    private String sendCity;//寄件城市

    private String sendCounty;//寄件区县
    
    private String dispatchCompanyName;//收件公司名称

    private String dispatchLinkMan;//收件联系人

    private String dispatchPhoneSms;//收件手机

    private String dispatchPhone;//收件联系电话

    private String dispatchAddress;//收件地址

    private String dispatchPostcode;//收件邮编

    private String dispatchProvince;//收件省份

    private String dispatchCity;//收件城市

    private String dispatchCounty;//收件区县
    
    private Integer payModeId;//支付方式 103-到付，104-月结，102-现金，109-返款到付
    
    private Double weightRate;//重量单价
    
    private Double volumeRate;//体积单价
    
    private Double leastExpenses;//最低一票运费
    
    private Double freightCharge ; //运费
    
    private Double fuelSurchargePrice ;//燃油附加费
    
    private Double deliveryPrice ;//派送费
    
    private Double insuredAmount ;//报价金额
    
    private Double insurancePrice;//客户保险费
    
    private Double otherPrice ;//其他费用
    
    private Double totalPrice; //总金额

    private Integer receiveFlag;//上门接货  1-上门接货，0-客户自送
    
    private Double vistReceivePrice;//上门接货费
    
    private Integer backSignBill ; // 签收回单   1-是  0-否
    
    private Double backSignBillPrice;//回单费用
    
    private String packageDesc ; //包装描述
    
    private Double packageServicePrice;//包装服务费
    
    private Integer smsFlag;//短信通知 1-是  0-否
    
    private Double smsNotifyPrice;//短信服务费
    
    private Double codCharge;//代收货款金额
    
    private Double codPrice;//代收服务费
    
    private Integer codType;//代收返款类型
    
    private Integer returnTarget;//1-客户，0-网点代收；代收货款必填，默认为客户

    private String couponId;//优惠券编号
    
    private String memberType;//CXT：诚信通；PT：普通客户
    
    private Integer waitNotifySend;//1-是  0-否

    private Double waitNotifySendPrice;//等通知发货费

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getEcId() {
		return ecId;
	}

	public void setEcId(String ecId) {
		this.ecId = ecId;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public Date getGmtUpdated() {
		return gmtUpdated;
	}

	public void setGmtUpdated(Date gmtUpdated) {
		this.gmtUpdated = gmtUpdated;
	}

	public String getSendSiteId() {
		return sendSiteId;
	}

	public void setSendSiteId(String sendSiteId) {
		this.sendSiteId = sendSiteId;
	}

	public String getDispatchSiteId() {
		return dispatchSiteId;
	}

	public void setDispatchSiteId(String dispatchSiteId) {
		this.dispatchSiteId = dispatchSiteId;
	}

	public String getEwbNo() {
		return ewbNo;
	}

	public void setEwbNo(String ewbNo) {
		this.ewbNo = ewbNo;
	}

	public Integer getEwbFlag() {
		return ewbFlag;
	}

	public void setEwbFlag(Integer ewbFlag) {
		this.ewbFlag = ewbFlag;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getTotalPiece() {
		return totalPiece;
	}

	public void setTotalPiece(Integer totalPiece) {
		this.totalPiece = totalPiece;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Double getTotalVol() {
		return totalVol;
	}

	public void setTotalVol(Double totalVol) {
		this.totalVol = totalVol;
	}

	public String getCommodityRemark() {
		return commodityRemark;
	}

	public void setCommodityRemark(String commodityRemark) {
		this.commodityRemark = commodityRemark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSendCompanyName() {
		return sendCompanyName;
	}

	public void setSendCompanyName(String sendCompanyName) {
		this.sendCompanyName = sendCompanyName;
	}

	public String getSendLinkMan() {
		return sendLinkMan;
	}

	public void setSendLinkMan(String sendLinkMan) {
		this.sendLinkMan = sendLinkMan;
	}

	public String getSendPhoneSms() {
		return sendPhoneSms;
	}

	public void setSendPhoneSms(String sendPhoneSms) {
		this.sendPhoneSms = sendPhoneSms;
	}

	public String getSendPhone() {
		return sendPhone;
	}

	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getSendPostcode() {
		return sendPostcode;
	}

	public void setSendPostcode(String sendPostcode) {
		this.sendPostcode = sendPostcode;
	}

	public String getSendProvince() {
		return sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	public String getSendCity() {
		return sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public String getSendCounty() {
		return sendCounty;
	}

	public void setSendCounty(String sendCounty) {
		this.sendCounty = sendCounty;
	}

	public String getDispatchCompanyName() {
		return dispatchCompanyName;
	}

	public void setDispatchCompanyName(String dispatchCompanyName) {
		this.dispatchCompanyName = dispatchCompanyName;
	}

	public String getDispatchLinkMan() {
		return dispatchLinkMan;
	}

	public void setDispatchLinkMan(String dispatchLinkMan) {
		this.dispatchLinkMan = dispatchLinkMan;
	}

	public String getDispatchPhoneSms() {
		return dispatchPhoneSms;
	}

	public void setDispatchPhoneSms(String dispatchPhoneSms) {
		this.dispatchPhoneSms = dispatchPhoneSms;
	}

	public String getDispatchPhone() {
		return dispatchPhone;
	}

	public void setDispatchPhone(String dispatchPhone) {
		this.dispatchPhone = dispatchPhone;
	}

	public String getDispatchAddress() {
		return dispatchAddress;
	}

	public void setDispatchAddress(String dispatchAddress) {
		this.dispatchAddress = dispatchAddress;
	}

	public String getDispatchPostcode() {
		return dispatchPostcode;
	}

	public void setDispatchPostcode(String dispatchPostcode) {
		this.dispatchPostcode = dispatchPostcode;
	}

	public String getDispatchProvince() {
		return dispatchProvince;
	}

	public void setDispatchProvince(String dispatchProvince) {
		this.dispatchProvince = dispatchProvince;
	}

	public String getDispatchCity() {
		return dispatchCity;
	}

	public void setDispatchCity(String dispatchCity) {
		this.dispatchCity = dispatchCity;
	}

	public String getDispatchCounty() {
		return dispatchCounty;
	}

	public void setDispatchCounty(String dispatchCounty) {
		this.dispatchCounty = dispatchCounty;
	}

	public Integer getPayModeId() {
		return payModeId;
	}

	public void setPayModeId(Integer payModeId) {
		this.payModeId = payModeId;
	}

	public Double getWeightRate() {
		return weightRate;
	}

	public void setWeightRate(Double weightRate) {
		this.weightRate = weightRate;
	}

	public Double getVolumeRate() {
		return volumeRate;
	}

	public void setVolumeRate(Double volumeRate) {
		this.volumeRate = volumeRate;
	}

	public Double getLeastExpenses() {
		return leastExpenses;
	}

	public void setLeastExpenses(Double leastExpenses) {
		this.leastExpenses = leastExpenses;
	}

	public Double getFreightCharge() {
		return freightCharge;
	}

	public void setFreightCharge(Double freightCharge) {
		this.freightCharge = freightCharge;
	}

	public Double getFuelSurchargePrice() {
		return fuelSurchargePrice;
	}

	public void setFuelSurchargePrice(Double fuelSurchargePrice) {
		this.fuelSurchargePrice = fuelSurchargePrice;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Double getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(Double insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	public Double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public Double getOtherPrice() {
		return otherPrice;
	}

	public void setOtherPrice(Double otherPrice) {
		this.otherPrice = otherPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getReceiveFlag() {
		return receiveFlag;
	}

	public void setReceiveFlag(Integer receiveFlag) {
		this.receiveFlag = receiveFlag;
	}

	public Double getVistReceivePrice() {
		return vistReceivePrice;
	}

	public void setVistReceivePrice(Double vistReceivePrice) {
		this.vistReceivePrice = vistReceivePrice;
	}

	public Integer getBackSignBill() {
		return backSignBill;
	}

	public void setBackSignBill(Integer backSignBill) {
		this.backSignBill = backSignBill;
	}

	public Double getBackSignBillPrice() {
		return backSignBillPrice;
	}

	public void setBackSignBillPrice(Double backSignBillPrice) {
		this.backSignBillPrice = backSignBillPrice;
	}

	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public Double getPackageServicePrice() {
		return packageServicePrice;
	}

	public void setPackageServicePrice(Double packageServicePrice) {
		this.packageServicePrice = packageServicePrice;
	}

	public Integer getSmsFlag() {
		return smsFlag;
	}

	public void setSmsFlag(Integer smsFlag) {
		this.smsFlag = smsFlag;
	}

	public Double getSmsNotifyPrice() {
		return smsNotifyPrice;
	}

	public void setSmsNotifyPrice(Double smsNotifyPrice) {
		this.smsNotifyPrice = smsNotifyPrice;
	}

	public Double getCodCharge() {
		return codCharge;
	}

	public void setCodCharge(Double codCharge) {
		this.codCharge = codCharge;
	}

	public Double getCodPrice() {
		return codPrice;
	}

	public void setCodPrice(Double codPrice) {
		this.codPrice = codPrice;
	}

	public Integer getCodType() {
		return codType;
	}

	public void setCodType(Integer codType) {
		this.codType = codType;
	}

	public Integer getReturnTarget() {
		return returnTarget;
	}

	public void setReturnTarget(Integer returnTarget) {
		this.returnTarget = returnTarget;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Integer getWaitNotifySend() {
		return waitNotifySend;
	}

	public void setWaitNotifySend(Integer waitNotifySend) {
		this.waitNotifySend = waitNotifySend;
	}

	public Double getWaitNotifySendPrice() {
		return waitNotifySendPrice;
	}

	public void setWaitNotifySendPrice(Double waitNotifySendPrice) {
		this.waitNotifySendPrice = waitNotifySendPrice;
	}
    
}