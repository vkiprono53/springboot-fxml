package com.kip.employee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmployeeApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    private Parent parent;

    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
      /*  SpringApplication.run(EmployeeApplication.class, args);
        System.out.println("Hello Spring boot");*/
    }

    @Override
    public void init() throws Exception {
      applicationContext=  SpringApplication.run(EmployeeApplication.class);
        fxmlLoader = new FXMLLoader();
       fxmlLoader.setControllerFactory(applicationContext::getBean);

     //    super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/scene.fxml"));
        parent=fxmlLoader.load();
        primaryStage.setTitle("User Administration");
        Scene scene = new Scene(parent,600,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
