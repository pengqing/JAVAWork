#include <PublicMethods.au3>

;��billNoProvider.txt�ļ��ĵڶ��и�ֵ��$billNo
$billNo = ReadData($billNoProviderPath,2)

;��returnBillNo.txt�ļ��ĵ�һ�и�ֵ��$returnBillNo
$returnBillNo = ReadData($returnBillNoPath,1)

;��ȡrecordBill_info.ini�ļ��е�����
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "firstDistributionUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )

;��¼³��ͻ���
Login($userName,$password)

;����ɨ��
RecieveScan("�����ֲ�����",305,90,$billNo,"3",$returnBillNo)

;�ϴ�
Upload("�����ֲ�����","14",75,128,19)

;�˳�Ӧ��
CloseClient("�����ֲ�����")

