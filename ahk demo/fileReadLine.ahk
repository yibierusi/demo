Loop
{
    FileReadLine, line, C:\Users\zhouhy\Downloads\���齣������V6.3.1���׵綨�ư桿\DD\getPointColor.ahk, %A_Index%
    if ErrorLevel
        break
    MsgBox, 4, , ��%A_Index%�е������ǣ�"%line%"
    IfMsgBox, No
        return
}
MsgBox, �ļ��ѵ���ĩβ��������⡣.
return