#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,11)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetWpointUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )
$deliver = IniRead ( $folder, "RegularChainWPoint_RecordBill", "deliver", "default" )

;登录鲁班客户端
Login($userName,$password)

;派件扫描
DeliverScan("广州海珠",725,90,$deliver,$billNo)

;上传
Upload("广州海珠","17",75,128,19)

;退出应用
CloseClient("广州海珠")


