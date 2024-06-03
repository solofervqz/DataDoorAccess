/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package biblioteca;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author bombo
 */
public class FXMLDocumentController implements Initializable {

        @FXML
    private Label biblioTec;

    @FXML
    private Label biblioTec2;

    @FXML
    private Hyperlink create_account;

    @FXML
    private Hyperlink login_account;

    @FXML
    private Button login_btn;
    
    @FXML
    private AnchorPane login_form;
        
    @FXML
    private PasswordField password;

    @FXML
    private Button signup_btn;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private TextField su_email;

    @FXML
    private PasswordField su_password;

    @FXML
    private TextField su_username;

    @FXML
    private TextField username;
    
    // Tools for Database
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    
    // Create Database
    private double x = 0;
    private double y = 0;

     public void exit(){
        
        System.exit(0);        
        
    }
    
    public void textfieldDesign(){
        
        if(username.isFocused()){
            
            username.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
            password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
        }else if(password.isFocused()){
            
            username.setStyle("-fx-background-color:transparent;"
                    + "-f-border-width:1px");
            
            password.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
        }
        
    }
    
    public void textfieldDesign1(){
        
        if(su_username.isFocused()){
            
            su_username.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
            su_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
            su_email.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
        }else if(su_email.isFocused()){
            
            su_username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
            su_password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
            su_email.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
        }else if(su_password.isFocused()){
            
            su_username.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
            su_password.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
            su_email.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
        }
        
    }
    
    public void dropShadowEffect(){
        
        DropShadow original = new DropShadow(30, Color.valueOf("#ecf1f6"));
        
        original.setRadius(30);
        
        biblioTec.setEffect(original);
        
        biblioTec2.setEffect(original);
        
        biblioTec.setOnMouseEntered((MouseEvent event) ->{
            
            DropShadow shadow = new DropShadow(60, Color.valueOf("#ecf1f6"));
            
            biblioTec.setCursor(Cursor.HAND);
            biblioTec.setStyle("-fx-text-fill:#2c4277");
            biblioTec.setEffect(shadow);
            
        });
        
        biblioTec.setOnMouseExited((MouseEvent event) ->{
            
            DropShadow shadow = new DropShadow(20, Color.valueOf("#ecf1f6"));
            
            shadow.setRadius(30);
            
            biblioTec.setStyle("-fx-text-fill:#000");
            biblioTec.setEffect(shadow);
            
        });
        
        biblioTec2.setOnMouseEntered((MouseEvent event) ->{
            
            DropShadow shadow = new DropShadow(60, Color.valueOf("#ecf1f6"));
            
            biblioTec2.setCursor(Cursor.HAND);
            biblioTec2.setStyle("-fx-text-fill:#2c4277");
            biblioTec2.setEffect(shadow);
            
        });
        
        biblioTec2.setOnMouseExited((MouseEvent event) ->{
            
            DropShadow shadow = new DropShadow(20, Color.valueOf("#ecf1f6"));
            
            shadow.setRadius(30);
            
            biblioTec2.setStyle("-fx-text-fill:#000");
            biblioTec2.setEffect(shadow);
            
        });
        
    }
    
    public void changeForm(ActionEvent event){
        
        if(event.getSource() == create_account){
            
            signup_form.setVisible(true);
            login_form.setVisible(false);
            
            su_username.setText("");
            su_password.setText("");
            su_email.setText("");
            
        }else if(event.getSource() == login_account){
            
            login_form.setVisible(true);
            signup_form.setVisible(false);
            
            username.setText("");
            password.setText("");
            
        }
        
    }
    
    public boolean validationEmail(){
    // EXAMPLE: admin_123@bibliotec.com [FIRST LETTER] [2ND LETTER TO NUMBER] @ [bibliotec] . [com]
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        
        Matcher match = pattern.matcher(su_email.getText());
        
        if(match.find() && match.group().equals(su_email.getText())){
            
            return true;
            
        }else{
            
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Correo electrónico inválido");
            alert.showAndWait();
            
            return false;
            
        }
        
    }
    
    public void login(){
        
        connect = database.connectDb();
        
        String sql = "SELECT * FROM account WHERE username = ? and password = ?";
        
        try{
            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
            
            if(result.next()){
                
                getData.username = username.getText();
                
                //dashboard if the login form passed
                        /*Alert alert = new Alert(AlertType.INFORMATION);

                        alert.setTitle("biblioTec Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Ingresó correctamente!");
                        alert.showAndWait();*/

                login_btn.getScene().getWindow().hide(); // hide the login form
                
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard2.fxml")); //link to our dashboard
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
        
                // Establecer el icono de la aplicación
                stage.getIcons().add(new Image(getClass().getResourceAsStream("DataDoor_Access_logo.png")));

                //User.username = result.getString("username");
                //User.path = result.getString("image");
                                                                             
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
                
                stage.initStyle(StageStyle.TRANSPARENT);
                
                stage.setScene(scene);
                stage.show();
                
            }else{     //dashboard if something is wrong
                
                Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Usuario/Contraseña es incorrecta");
                alert.showAndWait();
                
            }
            
        }catch(Exception e){}
        
    }
    
    //Método para llamar a la función login cuando se presione la tecla enter
    public void PassLoginKeyReleased(KeyEvent event){
        if(event.getCode() == event.getCode().ENTER){
            login();
        }
    }

    
    public void signup(){
        
        connect = database.connectDb();
        
        String sql = "INSERT INTO account (username,password,email) VALUES(?,?,?)";
        
        try{
            
            if(su_username.getText().isEmpty() 
                    | su_password.getText().isEmpty()
                    | su_email.getText().isEmpty()){
                
                Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Llene todos los campos!");
                alert.showAndWait();
                
            }else if(su_password.getText().length() < 8){
                
                Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Contraseña inválida");
                alert.showAndWait();
                
            }else{
                
                if(validationEmail()){
                
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, su_username.getText()); 
                    prepare.setString(2, su_password.getText());
                    prepare.setString(3, su_email.getText());
                    //prepare.setString(4, User.path);
                    
                    prepare.execute();

                    su_email.setText("");
                    su_username.setText("");
                    su_password.setText("");
                    
                    Alert alert = new Alert(AlertType.INFORMATION);

                    alert.setTitle("biblioTec Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Creación de la cuenta exitosamente!");
                    alert.showAndWait();
                    
                }
            }
                
        }catch(Exception e){e.printStackTrace();}
            
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dropShadowEffect();
    }    
}
