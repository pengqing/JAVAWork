#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,11)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "firstDistributionUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )

;登录鲁班客户端
Login($userName,$password)

;到件扫描
RecieveScan("西安分拨中心",305,90,$billNo,"1","")

;上传
Upload("西安分拨中心","14",75,128,19)

;退出应用
CloseClient("西安分拨中心")

