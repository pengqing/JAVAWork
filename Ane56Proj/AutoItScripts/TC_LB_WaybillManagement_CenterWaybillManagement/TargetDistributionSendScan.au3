#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,18)

;读取recordBill_info.ini文件中的数据
$userName=IniRead ( $folder, "FranchiseeWPoint_RecordBill", "targetDistributionUserName", "default" )
$password=IniRead ( $folder, "FranchiseeWPoint_RecordBill", "password", "default" )
$nextWpoint=IniRead ( $folder, "FranchiseeWPoint_RecordBill", "targetWpoint1", "default" )

;登录鲁班客户端
Login($userName,$password)

;发件扫描
SendScan("广州分拨中心",165,90,$nextWpoint,$billNo,"1","")

;上传
Upload("广州分拨中心","16",75,128,19)

;退出应用
CloseClient("广州分拨中心")

