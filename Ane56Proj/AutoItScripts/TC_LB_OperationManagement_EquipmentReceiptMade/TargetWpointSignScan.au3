#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,16)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "targetWpointUserName", "default" )
$password = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "password", "default" )
$deliver = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "deliver", "default" )
$reciever = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiver", "default" )

;登录鲁班客户端
Login($userName,$password)

;签收扫描
SignScan("广州海珠",860,90,$deliver,$reciever,$billNo)

;上传
Upload("广州海珠","15",75,128,19)

;退出应用
CloseClient("广州海珠")


