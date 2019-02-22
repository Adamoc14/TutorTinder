/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author adamoc
 */


public class TinderTutorMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    Stage window;
    Scene scene2;
    
    @Override
    public void start(Stage primaryStage) {
        
        //Setting up the primaryStage to be switchable
        window = primaryStage;
        
        //Declaring all our objects that need to go on scene
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),220,220,true,true));
        Button btnLogin = new Button("Login");
        Button btnSignUp = new Button("Sign Up");
        Button btnLinkedIN = new Button("Linked In");
        Button btnFacebook = new Button("Facebook");
        Button btnGooglePlus = new Button("Google +");
        
        //Adding all Button functionality in lambda expressions
        btnLogin.setOnAction(e -> {
            TinderTutorLogin tinderTutorLogin = new TinderTutorLogin();
            Label lblSignIn = new Label("Sign in to your account");
            lblSignIn.setTextFill(Color.RED);
            TextField txtUsername = new TextField();
            PasswordField txtPassword = new PasswordField();
            txtUsername.setMaxWidth(340);
            txtPassword.setMaxWidth(340);
            Label forgotPass = new Label("Forgot Your password ?");
            btnLogin.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            tinderTutorLogin.LoginView(image, lblSignIn, txtUsername, txtPassword, forgotPass, btnLogin).setMargin(lblSignIn , new Insets(-40 ,0 ,0,0));
            scene2 = new Scene(tinderTutorLogin.LoginView(image, lblSignIn, txtUsername, txtPassword, forgotPass, btnLogin) , 600 ,700);
            window.setScene(scene2);
        });
        
        // Setting the images position
        HBox imagePos = new HBox(image);
        imagePos.setAlignment(Pos.CENTER);
        imagePos.setMargin(image , new Insets(-50 ,0,0,0));
        
        //Setting the Buttons positions
        HBox buttonsPos = new HBox(btnLogin , btnSignUp);
        buttonsPos.setAlignment(Pos.CENTER);
        buttonsPos.setSpacing(20);
        buttonsPos.setMargin(btnLogin, new Insets(-30,0,30,0));
        buttonsPos.setMargin(btnSignUp, new Insets(-30,0,30,0));
        
        //Setting the social buttons positions
        VBox socialButtons = new VBox(20, btnLinkedIN , btnFacebook , btnGooglePlus);
        socialButtons.setAlignment(Pos.CENTER);
        
        //Setting up the VBox to take everything put it on itself and then add to the scene which is added to the stage 
        VBox root = new VBox(imagePos , buttonsPos , socialButtons);
        root.setAlignment(Pos.CENTER);
        
        //Setting up the scene
        Scene scene = new Scene(root , 600 , 700);
        
        //Setting up the stage
        primaryStage.setTitle("Tutor Tinder");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    /**
     * @param args the command line arguments
     */
    
    
}
