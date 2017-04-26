#include <PublicMethods.au3>

;��billNoProvider.txt�ļ��ĵ�һ�е��Ÿ�ֵ��$billNo
$billNo = ReadData($billNoProviderPath,1)

;��ȡrecordBill_info.ini�ļ��е�����
$userName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "password", "default" )
$sender = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sender", "default" )
$sendCompany = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendCompany", "default" )
$sendAddress = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendAddress", "default" )
$sendPhone = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendPhone", "default" )
$receiver = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiver", "default" )
$receiveCompany = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiveCompany", "default" )
$receiveAddress = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiveAddress", "default" )
$targetWpoint = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "targetWpoint", "default" )
$receivePhone = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receivePhone", "default" )
$goodsName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "goodsName", "default" )
$packageType = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "packageType", "default" )
$realWeight = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "realWeight", "default" )
$volume = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "volume", "default" )
$totalAmount = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "totalAmount", "default" )
$payType = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "payType", "default" )
$carriageFee = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "carriageFee", "default" )
$insurePriceFee = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "insurePriceFee", "default" )

;��¼³��ͻ���
Login($userName,$password)

;����ķ���Ϣ
FranchiseeWPoint_InputSenderInfor("��������",$billNo,$sender,$sendCompany,$sendAddress,$sendPhone)

;�����շ���Ϣ
FranchiseeWPoint_InputReceiverInfor("��������",$receiver,$receiveCompany,$receiveAddress,$targetWpoint,$receivePhone)

;���������Ϣ
FranchiseeWPoint_InputGoodsInfor("��������",$goodsName,$packageType,$realWeight,$volume,$totalAmount,"uncheck","")

;�����շ���Ϣ
FranchiseeWPoint_InputChargeInfor("��������",$payType,$carriageFee,$insurePriceFee)

;��ȡcostInfor.txt�ļ���·��
$targetPath  =  StringMid(@ScriptDir,1,StringInStr(@ScriptDir,"\",1,-2))&"\DataProviders\"&"CostInfor.txt"
;ɾ���ɵ�costInfor.txt�ļ�
DeleteFile($targetPath)
;����ȡ������д���ļ�
WriteCostInfor($targetPath,"��������")
Sleep(1000)

;����
Save("��������","34",62,20,"2","2")

;�˳�Ӧ��
CloseClient("��������")



