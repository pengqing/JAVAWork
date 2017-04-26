#include <PublicMethods.au3>

;将billNoProvider.txt文件的第一行单号赋值给$billNo
$billNo = ReadData($billNoProviderPath,1)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "password", "default" )
$sender = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sender", "default" )
$sendCompany = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendCompany", "default" )
$sendAddress = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendAddress", "default" )
$sendPhone = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "sendPhone", "default" )
$receiver = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiver", "default" )
$receiveCompany = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiveCompany", "default" )
$receiveAddress = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receiveAddress", "default" )
$targetWpoint = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "targetWpoint", "default" )
$receivePhone = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "receivePhone", "default" )
$goodsName = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "goodsName", "default" )
$packageType = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "packageType", "default" )
$realWeight = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "realWeight", "default" )
$volume = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "volume", "default" )
$totalAmount = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "totalAmount", "default" )
$payType = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "payType", "default" )
$carriageFee = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "carriageFee", "default" )
$insurePriceFee = IniRead ( $folder, "FranchiseeWPoint_RecordBill", "insurePriceFee", "default" )

;登录鲁班客户端
Login($userName,$password)

;输入寄方信息
FranchiseeWPoint_InputSenderInfor("西安城西",$billNo,$sender,$sendCompany,$sendAddress,$sendPhone)

;输入收方信息
FranchiseeWPoint_InputReceiverInfor("西安城西",$receiver,$receiveCompany,$receiveAddress,$targetWpoint,$receivePhone)

;输入货物信息
FranchiseeWPoint_InputGoodsInfor("西安城西",$goodsName,$packageType,$realWeight,$volume,$totalAmount,"uncheck","")

;输入收费信息
FranchiseeWPoint_InputChargeInfor("西安城西",$payType,$carriageFee,$insurePriceFee)

;获取costInfor.txt文件的路径
$targetPath  =  StringMid(@ScriptDir,1,StringInStr(@ScriptDir,"\",1,-2))&"\DataProviders\"&"CostInfor.txt"
;删除旧的costInfor.txt文件
DeleteFile($targetPath)
;将获取的数据写入文件
WriteCostInfor($targetPath,"西安城西")
Sleep(1000)

;保存
Save("西安城西","34",62,20,"2","2")

;退出应用
CloseClient("西安城西")



