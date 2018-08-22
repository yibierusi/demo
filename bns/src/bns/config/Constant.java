package bns.config;

/**
 * @Auther: zhouhy
 * @Description: Constant enum
 * @Date: Create in 17:00 2018/8/20
 * @Modified By
 */
public enum Constant {
    CONFIG_SPLIT(1, ": "),
    COLOR_SPLIT(2, ","),
    CONFIG_PATH(3, "config"),
    X(4, "x"),
    Y(5, "y"),
    C(6, "c"),
    BNS(7,"/bns/fxml/bns.fxml"),
    SKILL(8,"/bns/fxml/skill.fxml"),
    JAVA(9,"/bns/img/java.png"),
    START_SCRIPT(10,"1.启动脚本(F11)"),
    STOP_SCRIPT(11,"1.停止脚本(F11)");

    Constant(int k, String v) {
        this.k = k;
        this.v = v;
    }

    private int k;

    private String v;

    public int k() {
        return k;
    }

    public String v() {
        return v;
    }
}
