package bns.util;

import bns.config.Constant;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 9:48 2018/8/21
 * @Modified By
 */
public class Util {

    /**
     * 判断字符串是否是纯数字
     */
    public static boolean isFullNumber(String str){
        if (isEmpty(str)){
            return false;
        }
        return str.matches("[0-9]+");
    }
    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String str){
        if (str == null || "".equals(str)){
            return true;
        }
        return false;
    }

    /**
     * 判断某点颜色是否相同
     */
    public static boolean isEquals(Robot robot, String xs, String ys, String cs) {
        if (isEmpty(cs))
            return false;
        java.awt.Color color = null;
        try {
            int x = Integer.parseInt(xs);
            int y = Integer.parseInt(ys);
            color = robot.getPixelColor(x, y);
        }catch (Exception e){
            return false;
        }
        String rgbStr = getRgbStrByColor(color);
        return rgbStr.equals(cs);
    }

    /**
     * 判断某点颜色是否相同 相同则按下
     *
     * @param xs，ys,cs s : string
     * @return
     */
    public static boolean pressKey(Robot robot, String xs, String ys, String cs, int keyCode, int delay) {
        if (isEquals(robot, xs, ys, cs)) {
            robot.keyPress(keyCode);
            robot.delay(delay);
            robot.keyRelease(keyCode);
            robot.delay(delay);
            return true;
        }
        return false;
    }

    /**
     * Color对象 转rgb字符串
     */
    public static String getRgbStrByColor(java.awt.Color color) {
        if (color == null) {
            return "";
        }
        return color.getRed() + Constant.COLOR_SPLIT.v() + color.getGreen() + Constant.COLOR_SPLIT.v() + color.getBlue();
    }


    /**
     * RGB字符串转Color对象
     */
    public static Color getColorByRgbStr(String rgb) {
        if (rgb == null || "".equals(rgb))
            return null;
        String array[] = rgb.split(Constant.COLOR_SPLIT.v(), -1);
        if (array.length == 3) {
            int red = Integer.parseInt(array[0]);
            int green = Integer.parseInt(array[1]);
            int blue = Integer.parseInt(array[2]);
            return Color.rgb(red, green, blue);
        }
        return null;
    }

    /**
     * 读取配置文件
     */
    public static Map<String, String> loadingConfigFiles() {
        Map<String, String> keyMap = new HashMap();
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(new File(Constant.CONFIG_PATH.v())));
            String line = "";
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                keyMap.put(line.split(Constant.CONFIG_SPLIT.v(), -1)[0], line.split(Constant.CONFIG_SPLIT.v(), -1)[1]);
            }
        } catch (Exception e) {
            System.out.println("未找到配置文件:" + Constant.CONFIG_PATH.v());
            createConfingFile();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return keyMap;
    }


    /**
     * 重新创建配置文件
     */
    public static void createConfingFile() {
        File file = new File("config");
        try {
            file.createNewFile();
            String path = file.getPath();
            System.out.println("重新创建配置文件:" + path);
        } catch (Exception ex) {
            System.out.println("重新创建配置文件失败");
        }
    }

    /**
     * 保存数据
     */
    public static void savaKeyMap(Map<String, String> keyMap) {
        PrintStream ps = null;        // 声明打印流对象
        try {
            ps = new PrintStream(new FileOutputStream(new File(Constant.CONFIG_PATH.v())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : keyMap.entrySet()) {
            ps.println(entry.getKey() + Constant.CONFIG_SPLIT.v() + entry.getValue());
        }
        ps.close();
        System.out.println("数据保存完成");

//        KeyThread kt = new KeyThread();
//        kt.init(robot,keyMap);
//        kt.start();
    }
}
