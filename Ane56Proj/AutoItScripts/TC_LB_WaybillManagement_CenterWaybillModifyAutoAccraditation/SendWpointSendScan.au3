#include <PublicMethods.au3>

;��billNoProvider.txt�ļ��ĵ�һ�е��Ÿ�ֵ��$billNo
$billNo = ReadData($billNoProviderPath,17)

;��ȡrecordBill_info.ini�ļ��е�����
$userName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "password", "default" )
$nextWpoint = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "firstDistribution", "default" )

;��¼³��ͻ���
Login($userName,$password)

;����ɨ��
SendScan("��������",660,94,$nextWpoint,$billNo,"1","")

;�ϴ�
Upload("��������","16",75,128,19)

;�˳�Ӧ��
CloseClient("��������")
