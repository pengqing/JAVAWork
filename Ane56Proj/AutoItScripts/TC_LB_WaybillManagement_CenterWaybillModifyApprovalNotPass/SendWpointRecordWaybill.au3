#include <PublicMethods.au3>

;将billNoProvider.txt文件的第二行赋值给$billNo
$billNo = ReadData($billNoProviderPath,15)

;读取recordBill_info.ini文件中的数据
$userName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendWpointUserName", "default" )
$password = IniRead ( $folder, "RegularChainWPoint_RecordBill", "password", "default" )
$sender = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sender", "default" )
$sendCompany = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendCompany", "default" )
$sendAddress = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendAddress", "default" )
$sendPhone = IniRead ( $folder, "RegularChainWPoint_RecordBill", "sendPhone", "default" )
$receiver = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receiver", "default" )
$receiveCompany = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receiveCompany", "default" )
$receiveAddress = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receiveAddress", "default" )
$targetWpoint = IniRead ( $folder, "RegularChainWPoint_RecordBill", "targetWpoint", "default" )
$receivePhone = IniRead ( $folder, "RegularChainWPoint_RecordBill", "receivePhone", "default" )
$goodsName = IniRead ( $folder, "RegularChainWPoint_RecordBill", "goodsName", "default" )
$packageType = IniRead ( $folder, "RegularChainWPoint_RecordBill", "packageType", "default" )
$realWeight = IniRead ( $folder, "RegularChainWPoint_RecordBill", "realWeight", "default" )
$volume = IniRead ( $folder, "RegularChainWPoint_RecordBill", "volume", "default" )
$totalAmount = IniRead ( $folder, "RegularChainWPoint_RecordBill", "totalAmount", "default" )
$insurePriceFee = IniRead ( $folder, "RegularChainWPoint_RecordBill", "insurePriceFee", "default" )
$deliveryFee = IniRead ( $folder, "RegularChainWPoint_RecordBill", "deliveryFee", "default" )
$payType = IniRead ( $folder, "RegularChainWPoint_RecordBill", "payType", "default" )
$otherFee = IniRead ( $folder, "RegularChainWPoint_RecordBill", "otherFee", "default" )

; 登录鲁班客户端
Login($userName,$password)

; 输入寄方信息
RegularChainWPoint_InputSenderInfor("西安营业部",40,90,$billNo,$sender,$sendCompany,$sendAddress,$sendPhone)

; 输入收方信息
RegularChainWPoint_InputReceiverInfor("西安营业部",$receiver,$receiveCompany,$receiveAddress,$targetWpoint,$receivePhone)

; 输入货物信息
RegularChainWPoint_InputGoodsInfor("西安营业部",$goodsName,$packageType,$realWeight,$volume,$totalAmount,"uncheck","")

; 输入收费信息
RegularChainWPoint_InputChargeInfor("西安营业部",$insurePriceFee,$deliveryFee,$payType,$otherFee)

; 保存
Save("西安营业部","32",62,20,"2","2")

; 退出应用
CloseClient("西安营业部")
