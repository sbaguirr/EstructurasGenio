/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Vista.PaneVistaPrincipal;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tiffy
 */
public class Start extends Application {
    public static final Scene SCENE = new Scene(new Group(),600,550);
    @Override
    public void start(Stage primaryStage) {
        PaneVistaPrincipal vp = new PaneVistaPrincipal();
        SCENE.setRoot(vp.getRoot());
        SCENE.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Genio Politécnico");
        primaryStage.setScene(SCENE);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
