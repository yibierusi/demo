lctrl:: 
MouseGetPos, MouseX, MouseY
PixelGetColor, color, %MouseX%, %MouseY%
MsgBox X��%MouseX% Y��%MouseY% Color��%color%.
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

    MsgBox, 4, , ��%A_Index%�е������ǣ�"%line%" ,
	send ,StrSplit(%line% [ ",", ","]) 
	
    IfMsgBox, No
        return
}
MsgBox, �ļ��ѵ���ĩβ��������⡣.
return