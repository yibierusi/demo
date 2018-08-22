Loop
{
    FileReadLine, line, C:\Users\zhouhy\Downloads\雷灵剑卡刀宏V6.3.1【雷电定制版】\DD\getPointColor.ahk, %A_Index%
    if ErrorLevel
        break
    MsgBox, 4, , 第%A_Index%行的内容是："%line%"
    IfMsgBox, No
        return
}
MsgBox, 文件已到达末尾或出现问题。.
return