#include <PublicMethods.au3>

;��billNoProvider.txt�ļ��ĵڶ��и�ֵ��$billNo
$billNo = ReadData($billNoProviderPath,15)

;��ȡrecordBill_info.ini�ļ��е�����
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )
$sender = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sender", "default" )
$sendCompany = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendCompany", "default" )
$sendAddress = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendAddress", "default" )
$sendPhone = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendPhone", "default" )
$receiver = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receiver", "default" )
$receiveCompany = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receiveCompany", "default" )
$receiveAddress = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receiveAddress", "default" )
$targetWpoint = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetWpoint", "default" )
$receivePhone = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receivePhone", "default" )
$goodsName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "goodsName", "default" )
$packageType = IniRead ( $folder, "RegularChainWPoint_RecordBill", "packageType", "default" )
$realWeight = IniRead ( $folder, "RegularChainWPoint_RecordBill", "realWeight", "default" )
$volume = IniRead ( $folder, "RegularChainWPoint_RecordBill", "volume", "default" )
$totalAmount = IniRead ( $folder, "RegularChainWPoint_RecordBill", "totalAmount", "default" )
$insurePriceFee = IniRead ( $folder, "RegularChainWPoint_RecordBill", "insurePriceFee", "default" )
$deliveryFee = IniRead ( $folder, "RegularChainWPoint_RecordBill", "deliveryFee", "default" )
$payType = IniRead ( $folder, "RegularChainWPoint_RecordBill", "payType", "default" )
$otherFee = IniRead ( $folder, "RegularChainWPoint_RecordBill", "otherFee", "default" )

; ��¼³��ͻ���
Login($userName,$password)

; ����ķ���Ϣ
RegularChainWPoint_InputSenderInfor("����Ӫҵ��",40,90,$billNo,$sender,$sendCompany,$sendAddress,$sendPhone)

; �����շ���Ϣ
RegularChainWPoint_InputReceiverInfor("����Ӫҵ��",$receiver,$receiveCompany,$receiveAddress,$targetWpoint,$receivePhone)

; ���������Ϣ
RegularChainWPoint_InputGoodsInfor("����Ӫҵ��",$goodsName,$packageType,$realWeight,$volume,$totalAmount,"uncheck","")

; �����շ���Ϣ
RegularChainWPoint_InputChargeInfor("����Ӫҵ��",$insurePriceFee,$deliveryFee,$payType,$otherFee)

; ����
Save("����Ӫҵ��","32",62,20,"2","2")

; �˳�Ӧ��
CloseClient("����Ӫҵ��")
