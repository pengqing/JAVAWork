#include <PublicMethods.au3>

;��billNoProvider.txt�ļ��ĵڶ��и�ֵ��$billNo
$billNo = ReadData($billNoProviderPath,2)

;��returnBillNo.txt�ļ��ĵ�һ�и�ֵ��$returnBillNo
$returnBillNo = ReadData($returnBillNoPath,1)

;��ȡrecordBill_info.ini�ļ��е�����
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetWpointUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )
$nextWpoint = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetDistribution", "default" )

;��¼³��ͻ���
Login($userName,$password)

;����ɨ��
SendScan("���ݺ���",655,90,$nextWpoint,$billNo,"2",$returnBillNo)

;�ϴ�
Upload("���ݺ���","16",75,128,19)

;�˳�Ӧ��
CloseClient("���ݺ���")