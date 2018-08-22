lctrl:: 
MouseGetPos, MouseX, MouseY
PixelGetColor, color, %MouseX%, %MouseY%
MsgBox x:%MouseX% y:%MouseY% color:%color%.
return