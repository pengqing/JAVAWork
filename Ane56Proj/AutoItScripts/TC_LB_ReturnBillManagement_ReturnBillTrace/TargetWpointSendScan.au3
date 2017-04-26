#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,2)

;将returnBillNo.txt文件的第一行赋值给$returnBillNo
$returnBillNo = ReadData($returnBillNoPath,1)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetWpointUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )
$nextWpoint = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetDistribution", "default" )

;登录鲁班客户端
Login($userName,$password)

;发件扫描
SendScan("广州海珠",655,90,$nextWpoint,$billNo,"2",$returnBillNo)

;上传
Upload("广州海珠","16",75,128,19)

;退出应用
CloseClient("广州海珠")