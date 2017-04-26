;获取billNoProvider.txt文件的路径
$path = StringMid(@ScriptDir,1,StringInStr(@ScriptDir,"\",1,-1))&"DataProviders\BillNoProvider.txt"

;删除billNoProvider.txt文件
DeleteFile($path)

;获取20条单号写入billNoProvider.txt文件
For $i = 1 To 3 
	WriteData($path,getBillNo())
	Sleep(1000)
Next

;关闭 "单号生成器.exe"
WinClose("单号自动生成器")



Func getBillNo()
   ;等待加载登录窗口
   WinWait("单号自动生成器","",10)
   ;点击生成单号按钮
   ControlClick("单号自动生成器", "","TButton1")
   ;获取生成的单号
   $billNo = ControlGetText("单号自动生成器","","TMemo2")
   Return $billNo
EndFunc

Func DeleteFile($path)
   ;判断文件是否存在
   If FileExists($path) Then
	  FileDelete($path)
   EndIf
EndFunc

Func WriteData($path,$billNo)
   $file = FileOpen($path , 1)
   ; 检查文件是否正常打开
   If $file = -1 Then
	  MsgBox(0, "错误", "无法打开目标文件。")
	  Exit
   Else
	  FileWriteLine($file,$billNo)
   EndIf
   FileClose($file)
EndFunc