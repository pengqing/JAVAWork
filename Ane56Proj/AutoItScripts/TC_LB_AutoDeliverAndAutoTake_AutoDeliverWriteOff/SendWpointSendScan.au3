#include <PublicMethods.au3>

;��billNoProvider.txt�ļ��ĵ�һ�е��Ÿ�ֵ��$billNo
$billNo = ReadData($billNoProviderPath,11)

;��ȡrecordBill_info.ini�ļ��е�����
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )
$nextWpoint = IniRead ( $folder, "RegularChainWPoint_RecordBill", "firstDistribution", "default" )

;��¼³��ͻ���
Login($userName,$password)

;����ɨ��
SendScan("����Ӫҵ��",515,90,$nextWpoint,$billNo,"1","")

;�ϴ�
Upload("����Ӫҵ��","16",75,128,19)

;�˳�Ӧ��
CloseClient("����Ӫҵ��")
