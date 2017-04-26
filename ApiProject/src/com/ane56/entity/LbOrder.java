package com.ane56.entity;



import java.util.Date;

/**
 * ��׼�ӿڶ���ʵ����
 * @author hws
 * �޸�ʱ��:2016-9-5
 */
public class LbOrder {
    private String orderNo;//������

    private String ecId;//������ԴID 60 ΢���µ� 61 �������ģ�62 ����Ӫҵ��
    
    private Integer orderType; //��������
    /**
      1-�㵣���ˣ���ͨ�㵣���˶���������ֻ����������䡣
	  2-��װ����װһվʽ���񶩵������ܸ�����������Լ����������͡���װ�����������
	  3-������֣�������ֶ��������ܸ�����������Լ���������ַ����������
	       Ĭ��Ϊ1���������ó����á�
     */
    private Integer orderStatus;//����״̬
    /**
     * -1������
     * 0���ȴ��ӵ�
     * 1���ӵ��ɹ�
     * 2���ӵ�ʧ��
     * 3�������ɹ�
     * 4������ʧ��
     * 5��������
     * 6:�ɼ���
     * 7���ɼ��ɹ�
     * 8���ɼ�ʧ��
     */
    private String customerCode;//�ͻ�����
    
    private Integer serviceType;//��Ʒ����
    
    private String orderStatusName;//����״̬��
    
    private Date gmtUpdated;//״̬����ʱ��
    
    private String sendSiteId; //�ļ�����id
    
    private String dispatchSiteId;//�ɼ�����id
    
    private String ewbNo;//�˵���
    
    private Integer ewbFlag;//������ʶ��0-δ��  1-�ѿ���
    
    private String productType; //��Ʒ����  MNXB-MiniС����DSD-��ʱ�BZKY-��׼����
    
    private Integer deliveryType;//0-���ᣬ1-����
    
    private String goodsName; //��������
    
    private Integer goodsType;//��Ʒ���
    /**Ĭ��Ϊ0
    0���ļ���
    1�����Ӳ�Ʒ�ࣨ�������õ�����
    2���칫��Ʒ��, ��װЬñ�������
    3����ױƷ  ���ݲ�Ʒ��
    4���鱦���ֱ��۾���������Ʒ��
    5��ʳƷ������ҩƷ��
    6������Ʒ�ࣨ������������ߣ������Ʒ��
    7�����������
    8��������
    */
    private Integer totalPiece;//�ܼ���

    private Double  totalWeight;//����

    private Double  totalVol;//���
    
    private String commodityRemark;//��Ʒ����
    
    private String remark;//��ע
    
    private String sendCompanyName;//�ļ���˾���� û�й�˾����������

    private String sendLinkMan;//�ļ���ϵ��

    private String sendPhoneSms;//�ļ��ֻ�

    private String sendPhone;//�ļ���ϵ�绰

    private String sendAddress;//�ļ���ַ

    private String sendPostcode;//�ļ��ʱ�

    private String sendProvince;//�ļ�ʡ��

    private String sendCity;//�ļ�����

    private String sendCounty;//�ļ�����
    
    private String dispatchCompanyName;//�ռ���˾����

    private String dispatchLinkMan;//�ռ���ϵ��

    private String dispatchPhoneSms;//�ռ��ֻ�

    private String dispatchPhone;//�ռ���ϵ�绰

    private String dispatchAddress;//�ռ���ַ

    private String dispatchPostcode;//�ռ��ʱ�

    private String dispatchProvince;//�ռ�ʡ��

    private String dispatchCity;//�ռ�����

    private String dispatchCounty;//�ռ�����
    
    private Integer payModeId;//֧����ʽ 103-������104-�½ᣬ102-�ֽ�109-�����
    
    private Double weightRate;//��������
    
    private Double volumeRate;//�������
    
    private Double leastExpenses;//���һƱ�˷�
    
    private Double freightCharge ; //�˷�
    
    private Double fuelSurchargePrice ;//ȼ�͸��ӷ�
    
    private Double deliveryPrice ;//���ͷ�
    
    private Double insuredAmount ;//���۽��
    
    private Double insurancePrice;//�ͻ����շ�
    
    private Double otherPrice ;//��������
    
    private Double totalPrice; //�ܽ��

    private Integer receiveFlag;//���Žӻ�  1-���Žӻ���0-�ͻ�����
    
    private Double vistReceivePrice;//���Žӻ���
    
    private Integer backSignBill ; // ǩ�ջص�   1-��  0-��
    
    private Double backSignBillPrice;//�ص�����
    
    private String packageDesc ; //��װ����
    
    private Double packageServicePrice;//��װ�����
    
    private Integer smsFlag;//����֪ͨ 1-��  0-��
    
    private Double smsNotifyPrice;//���ŷ����
    
    private Double codCharge;//���ջ�����
    
    private Double codPrice;//���շ����
    
    private Integer codType;//���շ�������
    
    private Integer returnTarget;//1-�ͻ���0-������գ����ջ�����Ĭ��Ϊ�ͻ�

    private String couponId;//�Ż�ȯ���
    
    private String memberType;//CXT������ͨ��PT����ͨ�ͻ�
    
    private Integer waitNotifySend;//1-��  0-��

    private Double waitNotifySendPrice;//��֪ͨ������

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