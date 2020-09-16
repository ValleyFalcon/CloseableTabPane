package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CloseableTabPane closeableTabPane = new CloseableTabPane();
        BorderPane root = new BorderPane();
        Button addTabBtn = new Button("添加Tab");
        AtomicInteger count = new AtomicInteger(1);
        addTabBtn.setOnAction(e->{
            Tab tab = new Tab("Tab"+count);
            tab.setContent(new Label("这是Tab"+count+"的内容"));
            count.getAndIncrement();
            closeableTabPane.addTab(tab);
        });
        BorderPane.setMargin(addTabBtn,new Insets(20));
        root.setTop(addTabBtn);
        root.setCenter(closeableTabPane);

        primaryStage.setTitle("可自定义关闭标签的TabPane控件（qq 1761552314）");
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
