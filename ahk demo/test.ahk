lctrl:: 
MouseGetPos, MouseX, MouseY
PixelGetColor, color, %MouseX%, %MouseY%
MsgBox X：%MouseX% Y：%MouseY% Color：%color%.
FileAppend,
(
%MouseX%,%MouseY%,%color%

), config
return   

space::
Loop
{
    FileReadLine, line, config, %A_Index%
    if ErrorLevel
        break 

    MsgBox, 4, , 第%A_Index%行的内容是："%line%" ,
	send ,StrSplit(%line% [ ",", ","]) 
	
    IfMsgBox, No
        return
}
MsgBox, 文件已到达末尾或出现问题。.
return