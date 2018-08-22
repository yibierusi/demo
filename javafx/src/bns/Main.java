package bns;

import bns.config.Constant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(Constant.BNS.v()));
        primaryStage.setTitle("BNS");
        Scene scene = new Scene(root, 122, 67);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(
                Main.class.getResourceAsStream(Constant.JAVA.v())));
        primaryStage.setAlwaysOnTop(true);//窗口总是在最前面
        primaryStage.setResizable(false);//禁止改变窗口大小
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
