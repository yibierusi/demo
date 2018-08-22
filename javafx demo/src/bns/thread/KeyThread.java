package bns.thread;

import bns.util.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 9:35 2018/8/21
 * @Modified By
 */
public class KeyThread extends Thread {
    private Robot robot;
    private Map<String, String> keyMap;
    private boolean state;

    private boolean isPressKey; //是否按下某键
    private boolean isBuffExit; //闪电buff是否存在

    public KeyThread(Map<String, String> keyMap) {
        init();
        this.keyMap = keyMap;
    }

    public void init() {
        try {
            this.robot = new Robot();
        }catch (AWTException e){
            e.printStackTrace();
        }
        this.state = true;
    }

    @Override
    public void run() {
        if (keyMap == null) {
            System.out.println("keyMap 为空");
        }
        System.out.println("脚本已启动。");
        while (state) {
            isPressKey = Util.pressKey(robot, keyMap.get("sfx"), keyMap.get("sfy"), keyMap.get("sfc"), KeyEvent.VK_F, 100);
            if (isPressKey) {
                System.out.println("释放觉醒雷炎闪");
                continue;
            }
            isPressKey = Util.pressKey(robot, keyMap.get("fx"), keyMap.get("fy"), keyMap.get("fc"), KeyEvent.VK_F, 100);
            if (isPressKey) {
                System.out.println("释放雷炎闪");
                continue;
            }
            isBuffExit = Util.isEquals(robot,keyMap.get("buffx"), keyMap.get("buffy"), keyMap.get("buffc"));
            if (isBuffExit){
                System.out.println("雷电buff存在");
                isPressKey = Util.pressKey(robot, keyMap.get("rx"), keyMap.get("ry"), keyMap.get("rc"), KeyEvent.VK_R, 100);
                if (isPressKey) {
                    System.out.println("释放拔剑");
                    continue;
                }
                isPressKey = Util.pressKey(robot, keyMap.get("srx"), keyMap.get("sry"), keyMap.get("src"), KeyEvent.VK_R, 100);
                if (isPressKey) {
                    System.out.println("释放觉醒拔剑");
                    continue;
                }

            }else {
                isPressKey = Util.pressKey(robot, keyMap.get("xx"), keyMap.get("xy"), keyMap.get("xc"), KeyEvent.VK_X, 100);
                if (isPressKey) {
                    System.out.println("释放雷鸣斩");
                    continue;
                }
            }
        }
        System.out.println("脚本已停止。");
    }

    public void kill() {
        this.state = false;
    }
}
