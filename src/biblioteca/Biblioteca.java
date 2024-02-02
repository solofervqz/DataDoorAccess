/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author bombo
 */
public class Biblioteca extends Application{

private double x=0;
    private double y=0;
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("BiblioTec"); //Titulo de la ventana
        stage.initStyle(StageStyle.TRANSPARENT); //Oculta la barra de la ventana
        
        root.setOnMousePressed((MouseEvent event) ->{    
            x = event.getSceneX();
            y = event.getSceneY();
        });
        
        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            
            stage.setOpacity(0.8);
        });
        
        root.setOnMouseReleased((MouseEvent event) ->{
            stage.setOpacity(1);
        });
        
        stage.setScene(scene);
        stage.show();
    }    
    
    
    
public static void main(String[] args) {
        launch(args);
    }
}
