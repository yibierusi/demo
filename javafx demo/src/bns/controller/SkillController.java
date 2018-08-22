package bns.controller;

import bns.config.Constant;
import bns.util.Util;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class SkillController implements Initializable {
    private Robot robot;

    private Point point;

    private String current;

    @FXML
    private TextField fx;
    @FXML
    private TextField fy;
    @FXML
    private TextField fc;
    @FXML
    private Label fs;

    @FXML
    private TextField rx;
    @FXML
    private TextField ry;
    @FXML
    private TextField rc;
    @FXML
    private Label rs;

    @FXML
    private TextField sfx;
    @FXML
    private TextField sfy;
    @FXML
    private TextField sfc;
    @FXML
    private Label sfs;

    @FXML
    private TextField srx;
    @FXML
    private TextField sry;
    @FXML
    private TextField src;
    @FXML
    private Label srs;

    @FXML
    private TextField xx;
    @FXML
    private TextField xy;
    @FXML
    private TextField xc;
    @FXML
    private Label xs;

    @FXML
    private TextField buffx;
    @FXML
    private TextField buffy;
    @FXML
    private TextField buffc;
    @FXML
    private Label buffs;


    private Map<String, String> keyMap;


    /**
     * 判断是否按下
     *
     * @param event
     */
    @FXML
    public void isCtrlDown(KeyEvent event) {
        if (event.isControlDown()) {
            try {
                point = MouseInfo.getPointerInfo().getLocation();
                String x = point.x + "";
                String y = point.y + "";
                java.awt.Color color = robot.getPixelColor(point.x, point.y);
                if (current != null && !"".equals(current)) {
                    System.out.println("保存按键信息中...");
                    keyDataHandle(x, y, color.getRed(), color.getGreen(), color.getBlue());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 填充保存某个按键数据
     */
    public void keyDataHandle(String x, String y, int red, int green, int blue) {
        if (!Util.isFullNumber(x) || !Util.isFullNumber(y)){
            System.out.println("x,y 坐标格式不正确");
            return;
        }
        if (red > 255 || green > 255 || blue > 255){
            System.out.println("颜色格式不正确");
            return;
        }
        String c = red + Constant.COLOR_SPLIT.v() + green + Constant.COLOR_SPLIT.v() + blue;
        keyMap.put(current + Constant.X.v(), x);
        keyMap.put(current + Constant.Y.v(), y);
        keyMap.put(current + Constant.C.v(), c);
        switch (current) {
            case "f":
                fillData(fx, fy, fc, fs, "f");
                break;
            case "r":
                fillData(rx, ry, rc, rs, "r");
                break;
            case "sf":
                fillData(sfx, sfy, sfc, sfs, "sf");
                break;
            case "sr":
                fillData(srx, sry, src, srs, "sr");
                break;
            case "x":
                fillData(xx, xy, xc, xs, "x");
                break;
            case "buff":
                fillData(buffx, buffy, buffc, buffs, "buff");
                break;
            default:
                return;
        }

        Util.savaKeyMap(keyMap);
    }


    /**
     * 界面填充数据
     */
    public void fillFullData() {
        fillData(fx, fy, fc, fs, "f");
        fillData(rx, ry, rc, rs, "r");

        fillData(sfx, sfy, sfc, sfs, "sf");
        fillData(srx, sry, src, srs, "sr");

        fillData(xx, xy, xc, xs, "x");
        fillData(buffx, buffy, buffc, buffs, "buff");
    }

    /**
     * 填充数据
     */
    public void fillData(TextField x, TextField y, TextField c, Label s, String skill) {
        x.setText(keyMap.get(skill + Constant.X.v()));
        y.setText(keyMap.get(skill + Constant.Y.v()));
        String rgbStr = keyMap.get(skill + Constant.C.v());
        c.setText(rgbStr);
        s.setTextFill(Util.getColorByRgbStr(rgbStr));
    }


    /**
     * 获取f键信息
     *
     * @param event
     */
    @FXML
    public void getf(MouseEvent event) {
        current = "f";
    }

    @FXML
    public void getr(MouseEvent event) {
        current = "r";
    }

    @FXML
    public void getsf(MouseEvent event) {
        current = "sf";
    }

    @FXML
    public void getsr(MouseEvent event) {
        current = "sr";
    }

    @FXML
    public void getx(MouseEvent event) {
        current = "x";
    }

    @FXML
    public void getbuff(MouseEvent event) {
        current = "buff";
    }


    /**
     * 初始化
     */
    public void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.out.println("初始化Robot出错");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("正在初始化...");
        init();
        System.out.println("正在读取配置...");
        keyMap = Util.loadingConfigFiles();
        System.out.println("正在填充数据...");
        fillFullData();
    }
}