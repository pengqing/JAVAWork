#include <PublicMethods.au3>

;将billNoProvider.txt文件的第一行单号赋值给$billNo
$billNo = ReadData($billNoProviderPath,17)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "password", "default" )
$nextWpoint = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "firstDistribution", "default" )

;登录鲁班客户端
Login($userName,$password)

;发件扫描
SendScan("西安城西",660,94,$nextWpoint,$billNo,"1","")

;上传
Upload("西安城西","16",75,128,19)

;退出应用
CloseClient("西安城西")
