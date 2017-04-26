$billNoProviderPath = StringMid(@ScriptDir,1,StringInStr(@ScriptDir,"\",1,-2))&"DataProviders\BillNoProvider.txt"
$returnBillNoPath = StringMid(@ScriptDir,1,StringInStr(@ScriptDir,"\",1,-2))&"DataProviders\ReturnBillNo.txt"
$folder = StringMid(@ScriptDir,1,StringInStr(@ScriptDir,"\",1,-1))&"RecordBill_info.ini"

Func GetTitle($wPointName)
	$title = "鲁班物流管理系统1.0.3.7     登录网点:【"&$wPointName&"】"
	Return $title
EndFunc

#cs
登录鲁班客户端
#ce
Func Login($userName,$password)
	;等待加载登录窗口
	WinWait("鲁班物流管理系统1.0.3.7","",10)
	;切换到主干环境
	ControlClick("鲁班物流管理系统1.0.3.7", "","WindowsForms10.BUTTON.app.0.378734a4")
	
	;输入用户名
	ControlSetText("鲁班物流管理系统1.0.3.7", "","WindowsForms10.EDIT.app.0.378734a2",$userName)
	Sleep(1000)
	;输入密码
	ControlSetText("鲁班物流管理系统1.0.3.7", "","WindowsForms10.EDIT.app.0.378734a1",$password)
	Sleep(1000)
	;点击登录按钮
	ControlClick("鲁班物流管理系统1.0.3.7", "","WindowsForms10.BUTTON.app.0.378734a5")

	;等待账号余额信息提示窗口
	WinWait("账号余额信息","",60)
	;点击键盘ENTER键使提示信息消失
	Send("{ENTER}")
	Sleep(1000)
EndFunc

#cs
加盟网点输入寄方信息
#ce
Func FranchiseeWPoint_InputSenderInfor($wPointName,$billNo,$sender,$send_company,$send_address,$send_phone)
	$title = GetTitle($wPointName)
	;使用快捷键SHIFT+F8调出加盟网点录单页面
	Send("+{F8}")
	;等待加盟网点录单页面加载完成
	WaitFor($title,"运单号")
	;输入运单号
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a10",$billNo)
	Sleep(1000)
	;输入寄件人
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a2",$sender)
	;输入寄件公司
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a4",$send_company)
	;输入寄件地址
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a5",$send_address)
	;输入寄件手机
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a6",$send_phone)
	Sleep(1000)

	;勾选是否电子子单
	ControlSend($title,"","WindowsForms10.Window.b.app.0.378734a5","{SPACE}")
	Sleep(1000)
EndFunc

#cs
加盟网点输入收方信息
#ce
Func FranchiseeWPoint_InputReceiverInfor($wPointName,$receiver,$receive_company,$receive_address,$wpoint,$receive_phone)
	$title = GetTitle($wPointName)
	;输入收件人
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a53",$receiver)
	;输入收件公司
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a49",$receive_company)
	;输入收件地址
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a46",$receive_address)
	;填写目的网点
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a54")
	Send($wpoint)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a54","{ENTER}")

	;填写收件手机
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a50",$receive_phone)
	Sleep(1000)
EndFunc

#cs
加盟网点输入货物信息
#ce
Func FranchiseeWPoint_InputGoodsInfor($wPointName,$goodsName,$packType,$realWeight,$volume,$amount,$checkOrNot,$returnBillNo)
	$title = GetTitle($wPointName)
	;填写物品名称
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a41",$goodsName)
	;填写包装类型
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a38",$packType)
	;填写实际重量
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a37",$realWeight)
	Sleep(1000)
	;填写体积
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a40")
	Send($volume)
	Sleep(1000)
	
	If WinExists("提示","超过了小包重量范围，请重新选择产品类型！") Then
		ControlClick("提示","","Button1")
		Sleep(1000)
	EndIf
	
	;填写总件数
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a39",$amount)
	Sleep(1000)	
	
	If($checkOrNot = "check") Then
		ControlSend($title,"","WindowsForms10.Window.b.app.0.378734a65","{SPACE}")
		Sleep(1000)
		ControlSend($title,"","WindowsForms10.Window.b.app.0.378734a73",$returnBillNo)
		Sleep(500)
	EndIf
	
	;点击支付类型窗口确保子单带出
	ControlClick($title,"","WindowsForms10.Window.b.app.0.378734a28")
EndFunc

#cs
加盟网点输入收费信息
#ce
Func FranchiseeWPoint_InputChargeInfor($wPointName,$payType,$carriageFee,$insurePriceFee)
	$title = GetTitle($wPointName)
	;选择支付类型
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a12")
	Send($payType)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a12","{ENTER}")
	Sleep(1000)
	;填写运费
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a13")
	Send($carriageFee)
	Sleep(1000)
	;填写保价金额
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a11")
	Send($insurePriceFee)
	Sleep(1000)
	;点击计算成本按钮
	ControlClick($title,"","WindowsForms10.BUTTON.app.0.378734a2")

	;等待燃油费显示
	Wait($wPointName,"WindowsForms10.EDIT.app.0.378734a28",0)
EndFunc

#cs
直营网点输入寄方信息
#ce
Func RegularChainWPoint_InputSenderInfor($wPointName,$recordButton_x,$recordButton_y,$billNo,$sender,$send_company,$send_address,$send_phone)
	$title = GetTitle($wPointName)
	
	;点击坐标进入直营网点录单界面
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a1","left",1,$recordButton_x,$recordButton_y)
	;等待直营网点录单页面加载完成
	DynamicWait(4,8,10,$wPointName,$title,"运单号","WindowsForms10.Window.8.app.0.378734a1",$recordButton_x,$recordButton_y)

	;输入运单号
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a66",$billNo)
	Sleep(1000)
	;输入寄件人
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a61",$sender)
	;输入寄件公司
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a63",$send_company)
	;输入寄件地址
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a64",$send_address)
	;输入寄件手机
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a65",$send_phone)
	Sleep(1000)

	;勾选是否电子子单
	ControlSend($title,"","WindowsForms10.Window.b.app.0.378734a83","{SPACE}")
	Sleep(1000)
EndFunc

#cs
直营网点输入收方信息
#ce
Func RegularChainWPoint_InputReceiverInfor($wPointName,$receiver,$receive_company,$receive_address,$wpoint,$receive_phone)
	$title = GetTitle($wPointName)
	;输入收件人
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a58",$receiver)
	;输入收件公司
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a55",$receive_company)
	;输入收件地址
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a53",$receive_address)

	;填写目的网点
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a59")
	Send($wpoint)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a59","{ENTER}")

	;输入收件电话
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a56",$receive_phone)
	Sleep(1000)
EndFunc

#cs
直营网点输入货物信息
#ce
Func RegularChainWPoint_InputGoodsInfor($wPointName,$goodsName,$packType,$realWeight,$volume,$amount,$checkOrNot,$returnBillNo)
	$title = GetTitle($wPointName)
	;填写物品名称
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a50",$goodsName)
	;填写包装类型
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a49",$packType)
	;填写实际重量
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a48",$realWeight)
	Sleep(1000)
	;填写体积
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a47")
	Send($volume)
	Sleep(1000)
	
	If WinExists("提示","超过了小包重量范围，请重新选择产品类型！") Then
		ControlClick("提示","","Button1")
		Sleep(1000)
	EndIf
	
	;填写总件数
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a46",$amount)
	
	If($checkOrNot = "check") Then
		ControlSend($title,"","WindowsForms10.Window.b.app.0.378734a58","{SPACE}")
		Sleep(1000)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a51",$returnBillNo)
		Sleep(500)
	EndIf
	;点击保价金额窗口确保子单带出
	ControlClick($title,"","WindowsForms10.Window.b.app.0.378734a15")
EndFunc

#cs
直营网点输入收费信息
#ce
Func RegularChainWPoint_InputChargeInfor($wPointName,$insurePriceFee,$deliveryFee,$payType,$otherFee)
	$title = GetTitle($wPointName)
	;输入保价金额
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a23")
	Send($insurePriceFee)
	Sleep(1000)
	;输入提货费
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a14",$deliveryFee)
	
	;选择支付类型
	ControlFocus($title,"","WindowsForms10.Window.b.app.0.378734a23")
	Send($payType)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.Window.b.app.0.378734a23","{ENTER}")
	
	;输入其他费用
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a8",$otherFee)
	;点击计算费用按钮
	ControlClick($title,"","WindowsForms10.BUTTON.app.0.378734a1")
	;等待实收总金额显示
	Wait($wPointName,"WindowsForms10.EDIT.app.0.378734a16",0)
EndFunc

#cs
发件扫描
$choiceNo:等于1只发运单号；等于2只发回单号；等于3运单号和回单号一起发
#ce
Func SendScan($wPointName,$sendScanButton_x,$sendScanButton_y,$nextWpoint,$billNo,$choiceNo,$returnBillNo)
	$title = GetTitle($wPointName)
	;点击坐标进入发件扫描界面
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a1","left",1,$sendScanButton_x,$sendScanButton_y)

	;等待发件扫描界面页面加载完成
	DynamicWait(4,8,10,$wPointName,$title,"下一网点","WindowsForms10.Window.8.app.0.378734a1",$sendScanButton_x,$sendScanButton_y)

	;输入下一网点后点击回车
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a1")
	Send($nextWpoint)
	Sleep(500)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a1","{ENTER}")
	Sleep(1000)
	;输入运单号后点击回车
	If ($choiceNo = "1") Then
		ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a2",$billNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)
	ElseIf ($choiceNo = "2") Then
		ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a2",$returnBillNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)
	ElseIf ($choiceNo = "3") Then
		ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a2",$billNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)
		ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a2",$returnBillNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)
	Else
		MsgBox(0,"提示","$choiceNo只能从数字（1、2、3）中选择")
	EndIf
		
EndFunc

#cs
到件扫描
$choiceNo:等于1只收运单号；等于2只收回单号；等于3运单号和回单号一起收
#ce
Func RecieveScan($wPointName,$recieveScanButton_x,$recieveScanButton_y,$billNo,$choiceNo,$returnBillNo)
	$title = GetTitle($wPointName)
	;点击坐标进入到件扫描界面
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a1","left",1,$recieveScanButton_x,$recieveScanButton_y)
	;等待到件扫描界面页面加载完成
	DynamicWait(4,8,10,$wPointName,$title,"上一网点","WindowsForms10.Window.8.app.0.378734a1",$recieveScanButton_x,$recieveScanButton_y)

	;输入运单号后点击回车
	If ($choiceNo = "1") Then
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2",$billNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(100)

		If WinExists("提示","上一站网点不能为空") Then
			;点掉提示框
			ControlClick("提示", "","Button1")
			Sleep(1000)
			;勾选获取上一网点
			ControlCommand ($title,"","WindowsForms10.BUTTON.app.0.378734a2","Check") 
			Sleep(1000)
			;运单号窗口点击回车键带出订单信息
			ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
			Sleep(1000)
		EndIf
	ElseIf ($choiceNo = "2") Then
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2",$returnBillNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)

		If WinExists("提示","上一站网点不能为空") Then
			;点掉提示框
			ControlClick("提示", "","Button1")
			Sleep(1000)
			;勾选获取上一网点
			ControlCommand ($title,"","WindowsForms10.BUTTON.app.0.378734a2","Check") 
			Sleep(1000)
			;运单号窗口点击回车键带出订单信息
			ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
			Sleep(1000)
		EndIf
	ElseIf ($choiceNo = "3") Then
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2",$billNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)

		If WinExists("提示","上一站网点不能为空") Then
			;点掉提示框
			ControlClick("提示", "","Button1")
			Sleep(1000)
			;勾选获取上一网点
			ControlCommand ($title,"","WindowsForms10.BUTTON.app.0.378734a2","Check") 
			Sleep(1000)
			;运单号窗口点击回车键带出订单信息
			ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
			Sleep(1000)
		EndIf
		ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a2",$returnBillNo)
		Sleep(500)
		ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
		Sleep(1000)
	Else 
		MsgBox(0,"提示","$choiceNo只能从数字（1、2、3）中选择")
	EndIf
EndFunc

#cs
派件扫描
#ce
Func DeliverScan($wPointName,$deliverScanButton_x,$delievrScanButton_y,$deliver,$billNo)
	$title = GetTitle($wPointName)
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a1","left",1,$deliverScanButton_x,$delievrScanButton_y)
	;等待到件扫描界面页面加载完成
	DynamicWait(4,8,10,$wPointName,$title,"派件人","WindowsForms10.Window.8.app.0.378734a1",$deliverScanButton_x,$delievrScanButton_y)
	;输入派件人
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a1")
	Send($deliver)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a1","{ENTER}")

	;输入运单号后点击回车
	ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a2",$billNo)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a2","{ENTER}")
	Sleep(1000)
EndFunc

#cs
签收扫描
#ce
Func SignScan($wPointName,$signScanButton_x,$signScanButton_y,$deliver,$reciever,$billNo)
	$title = GetTitle($wPointName)
	;点击坐标进入签收扫描界面
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a1","left",1,$signScanButton_x,$signScanButton_y)
	;等待到件扫描界面页面加载完成
	DynamicWait(4,8,10,$wPointName,$title,"签收密匙","WindowsForms10.Window.8.app.0.378734a1",$signScanButton_x,$signScanButton_y)

	;输入派件人
	ControlFocus($title,"","WindowsForms10.EDIT.app.0.378734a5")
	Send($deliver)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a5","{ENTER}")
	;输入收件人
	ControlSetText($title,"","WindowsForms10.EDIT.app.0.378734a3",$reciever)

	;输入单号后点击回车
	ControlSend($title, "","WindowsForms10.EDIT.app.0.378734a7",$billNo)
	Sleep(1000)
	ControlSend($title,"","WindowsForms10.EDIT.app.0.378734a7","{ENTER}")
	Sleep(1000)

EndFunc

#cs
上传
#ce
Func Upload($wPointName,$instance,$saveButton_x,$uploadButton_x,$uploadButton_y)
	$title = GetTitle($wPointName)
	;点击本地保存按钮
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a"&$instance,"left",1,$saveButton_x,$uploadButton_y)
	Sleep(1000)
	If WinExists("提示","运单号不能为空！") Then
			;点掉提示框
			ControlClick("提示", "","Button1")
			Sleep(1000)
	EndIf
	;点击上传按钮
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a"&$instance,"left",1,$uploadButton_x,$uploadButton_y)
	;等待加载上传窗口
	DynamicWait(5,10,30,$wPointName,"上传","确定","WindowsForms10.Window.8.app.0.378734a"&$instance,$uploadButton_x,$uploadButton_y)

	;点击确定按钮
	ControlClick("上传", "","WindowsForms10.Window.b.app.0.378734a2")
	Sleep(1000)
EndFunc

#cs
保存
#ce
Func Save($wPointName,$instance,$save_x,$save_y,$id1,$id2)
	$title = GetTitle($wPointName)
	;点击保存按钮
	ControlClick($title, "","WindowsForms10.Window.8.app.0.378734a"&$instance,"left",1,$save_x,$save_y)

	;等待第一个提示窗口加载
	DynamicWait(10,30,60,$wPointName,"提示","是否打印子单？","WindowsForms10.Window.8.app.0.378734a"&$instance,$save_x,$save_x)
	;点击第一个提示框的取消按钮
	ControlClick("提示","","Button"&$id1)

	;等待第二个提示窗口加载
	WaitFor("提示","新增保存成功，是否打印主单？")
	;点击第二个提示框的取消按钮
	ControlClick("提示","","Button"&$id2)
	Sleep(2000)
EndFunc

#cs
该方法用来退出应用
#ce
Func CloseClient($wPointName)
   $title = GetTitle($wPointName)
   WinClose($title)
   WinWait("退出提示","",5)
   ;点击确认按钮
   ControlClick("退出提示","","Button1")
EndFunc

#cs
该方法主要针对通过点击控件坐标来实现某些特定操作的动态等待，
当等待时长等于$firstTime或$secondTime时还未发现等待的特定窗口则会再次点击坐标，
当等待时长等于$endTime时还未发现等待的特定窗口则会退出应用。
#ce

Func DynamicWait($firstTime,$secondTime,$endTime,$wPointName,$title1,$text,$controlID,$x,$y)
   $counter = 0
   $title = GetTitle($wPointName)
   Do
	  Sleep(1000)
	  $counter = $counter + 1
	  If($counter = $firstTime Or $counter = $secondTime) Then
		 ControlClick($title, "",$controlID,"left",1,$x,$y)
	  ElseIf($counter > $endTime) Then
		 ExitLoop
		 CloseClient($wPointName)
	  EndIf
   Until WinExists($title1,$text)
EndFunc

#cs
该方法用来删除指定路径的文件
#ce
Func DeleteFile($path)
   ;判断文件是否存在
   If FileExists($path) Then
	  FileDelete($path)
   EndIf
EndFunc

#cs
该方法用来将数据写入指定文件中
#ce
Func WriteCostInfor($path,$wPointName)
	$title = GetTitle($wPointName)
	$targetWpoint = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a54")
	$realWeight = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a37")
	$volume = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a40")
	$totalAmount = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a39")
	$insurePriceAmount = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a11")
	$carriageFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a13")
	$transferFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a24")
	$fuelFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a28")
	$procedureFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a22")
	$registrationFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a20")
	$deliveryFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a26")
	$insuranceFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a27")
	$operationFee = ControlGetText($title,"","WindowsForms10.EDIT.app.0.378734a25")
	$file = FileOpen($path , 1)
	; 检查文件是否正常打开
	If $file = -1 Then
		MsgBox(0, "错误", "无法打开目标文件。")
		Exit
	Else
		FileWriteLine($file, "targetWpoint:"&$targetWpoint)
		FileWriteLine($file, "realWeight:"&$realWeight)
		FileWriteLine($file, "volume:"&$volume)
		FileWriteLine($file, "totalAmount:"&$totalAmount)
		FileWriteLine($file, "insurePriceAmount:"&$insurePriceAmount)
		FileWriteLine($file, "carriageFee:"&$carriageFee)
		FileWriteLine($file, "transferFee:"&$transferFee)
		FileWriteLine($file, "fuelFee:"&$fuelFee)
		FileWriteLine($file, "procedureFee:"&$procedureFee)
		FileWriteLine($file, "registrationFee:"&$registrationFee)
		FileWriteLine($file, "deliveryFee:"&$deliveryFee)
		FileWriteLine($file, "insuranceFee:"&$insuranceFee)
		FileWriteLine($file, "operationFee:"&$operationFee)
		FileClose($file)
   EndIf
EndFunc

#cs
该方法用来从特定文件中获取运单号
#ce
Func ReadData($path,$lineNo)
   $file = FileOpen($path, 0)

   ; 检查文件是否正常打开
   If $file = -1 Then
	  MsgBox(0, "错误", "无法打开目标文件。")
	  Exit
   Else
	  $billNumber = FileReadLine($file,$lineNo)
	  FileClose($file)
   EndIf
   Return $billNumber
EndFunc

#cs
该方法用来动态等待指定窗口，退出条件是窗口出现或者等待超时
#ce
Func WaitFor($title,$text)
   $counter = 1000
   Do
      Sleep($counter)
	  $counter = $counter + 1000
	  If($counter > 3000) Then
		 ExitLoop
	  EndIf
   Until WinExists($title,$text)
EndFunc

#cs
该方法用来动态等待指定窗口，退出条件是获取的窗口text值满足条件或者等待超时
#ce
Func Wait($wPointName,$controlID,$target)
   $title = GetTitle($wPointName)
   $counter = 1000
   Do
      Sleep($counter)
	  $counter = $counter + 1000
	  If($counter>5000) Then
		 ExitLoop
		 CloseClient($wPointName)
	  EndIf
   Until ControlGetText($title,"",$controlID) > $target
EndFunc
