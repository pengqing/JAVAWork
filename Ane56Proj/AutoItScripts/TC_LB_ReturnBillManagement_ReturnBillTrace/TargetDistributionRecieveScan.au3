#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,2)

;将returnBillNo.txt文件的第一行赋值给$returnBillNo
$returnBillNo = ReadData($returnBillNoPath,1)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetDistributionUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )

;登录鲁班客户端
Login($userName,$password)

;到件扫描
RecieveScan("广州分拨中心",235,90,$billNo,"2",$returnBillNo)

;上传
Upload("广州分拨中心","14",75,128,19)

;退出应用
CloseClient("广州分拨中心")
