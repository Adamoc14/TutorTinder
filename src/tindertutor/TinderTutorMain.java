/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    Scene SwipePage;
    Scene LoginRealPage;
    Scene SignUpPage;
    Scene SettingsPage;
    
    @Override
    public void start(Stage primaryStage) {
        
        //Setting up the primaryStage to be switchable
        window = primaryStage;
        
        //Restricting the posibility of making screen bigger
        window.setResizable(false);
        
        //Declaring all our objects that need to go on scene
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),220,220,true,true));
        Button btnLogin = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnLogin.png"),150,280,true,true)));
        Button btnSignUp = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSignUp.png"),150,280,true,true)));
        btnLogin.setStyle("-fx-background-color: transparent");
        btnSignUp.setStyle("-fx-background-color: transparent");
        Button btnLinkedIn = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnLinkedIn.png"),150,280,true,true)));
        Button btnFacebook = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnFacebook.png"),150,280,true,true)));
        Button btnGooglePlus = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnGooglePlus.png"),150,280,true,true)));
        btnLinkedIn.setStyle("-fx-background-color: transparent");
        btnFacebook.setStyle("-fx-background-color: transparent");
        btnGooglePlus.setStyle("-fx-background-color: transparent");
        
        btnSignUp.setOnAction(e-> {
            TinderTutorSignUp tindertutorSignUp = new TinderTutorSignUp();
            ImageView logoView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),220,220,true,true));
            Label lblSignUp = new Label("Sign Up");
            lblSignUp.setTextFill(Color.RED);
            lblSignUp.setStyle("-fx-font-size: 30;");
            Label lblUserType = new Label("Are you a ");
            Button btnStudent = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnStudents.png"),280,280,true,true)));
            Button btnTeacher = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnTeacher.png"),280,280,true,true)));
            btnStudent.setStyle("-fx-background-color: transparent");
            btnTeacher.setStyle("-fx-background-color: transparent");
            Label lblStudent = new Label("Student ?");
            lblStudent.setStyle("fx-font-weight: bolder; fx-text-fill: black; ");
            Label lblTeacher = new Label("Teacher ?");
            
            btnStudent.setOnAction(event-> {
                System.out.println("Well");
            });
            btnTeacher.setOnAction(evnt -> {
                System.out.println("Boi");
            });
            
            SignUpPage = new Scene(tindertutorSignUp.SignUpView(logoView,lblSignUp , lblUserType, btnStudent, btnTeacher,  lblStudent , lblTeacher), 600 ,700);
            window.setScene(SignUpPage);
        });
        
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
            Button btnLoginReal = new Button("Login");
            btnLoginReal.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            tinderTutorLogin.LoginView(image, lblSignIn, txtUsername, txtPassword, forgotPass, btnLoginReal).setMargin(lblSignIn , new Insets(-40 ,0 ,0,0));
            LoginRealPage = new Scene(tinderTutorLogin.LoginView(image, lblSignIn, txtUsername, txtPassword, forgotPass, btnLoginReal) , 600 ,700);
            window.setScene(LoginRealPage);
        
            btnLoginReal.setOnAction(event -> {
                    if(txtUsername.getText().equals("Adam")&& txtPassword.getText().equals("1234")){

                        TinderTutorMainSwipe tinderTutorSwipe = new TinderTutorMainSwipe();
                        Button btnSettings = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,true,true)));
                        btnSettings.setStyle("-fx-background-color: transparent;");
                        ImageView logoView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true));
                        Button btnChat= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnChat.png"),80,80,true,true)));
                        btnChat.setStyle("-fx-background-color: transparent;");
                        Image mainImage = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
                        Circle mainPicView = new Circle(500,500,150);
                        mainPicView.setFill(new ImagePattern(mainImage));
                        Label lblUsers_Name= new Label("Username : ");
                        Label lblUsers_Qualification= new Label("Qualification: ");
                        Label lblUsers_Subject= new Label("Subject: ");
                        Label lblUsers_Location= new Label("Location: ");
                        Label lblUsers_Price= new Label("Price: ");
                        Button btnCheckYes= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnYes.png"),60,30,true,true)));
                        Button btnCheckNo = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnNo.png"),60,30,true,true)));
                        btnCheckYes.setStyle("-fx-background-color: transparent;");
                        Group grpBtns = new Group(btnCheckNo , btnCheckYes);
                        btnCheckYes.toFront();
                        btnCheckNo.setStyle("-fx-background-color: transparent;");
                        ImageView FormattingView = new ImageView(new Image(getClass().getResourceAsStream("Assets/FormattingMain.png"),250,150,false,true));
                        SwipePage = new Scene(tinderTutorSwipe.SwipeView(btnSettings, logoView, btnChat, mainPicView, lblUsers_Name, lblUsers_Qualification, lblUsers_Subject, lblUsers_Location, lblUsers_Price, grpBtns , FormattingView) , 600 , 700);
                        window.setScene(SwipePage);
                        
                        btnChat.setOnAction(event2 -> {
                            
                            
                            
                            
                            
                        });
                        
                        btnSettings.setOnAction(evt-> {
                            TinderTutorSettings tinderTutorSettings = new TinderTutorSettings();
                            ImageView settingsView = new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,false,true));
                            ImageView formatView = new ImageView(new Image(getClass().getResourceAsStream("Assets/MainFormatting.png"),650,150,false,true));
                            Image mainImagePic = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
                            Circle userPicView = new Circle(500,500,150);
                            userPicView.setFill(new ImagePattern(mainImagePic));
                            Label lblUserName = new Label("John Barton , New England");
                            Label lblUserType = new Label("Student");
                            Label lblUniName = new Label("Stanford");
                            Button btnUserProfile = new Button("My Profile");
                            btnUserProfile.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
                            ImageView logoPlusView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogoPlus.png"),150,100,false,true));
                            SettingsPage = new Scene(tinderTutorSettings.SettingsView(settingsView, formatView ,userPicView , lblUserName ,lblUserType ,lblUniName, btnUserProfile ,logoPlusView), 600, 700);
                            window.setScene(SettingsPage);
                        });

                    } else {
                        Alert helpAlert = new Alert(Alert.AlertType.WARNING,  "Please enter correct login details");
                        helpAlert.setTitle("Error");
                        helpAlert.showAndWait();
                    }
                });
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
        VBox socialButtons = new VBox(20, btnLinkedIn ,btnGooglePlus, btnFacebook );
        socialButtons.setAlignment(Pos.CENTER);
        
        //Setting up the VBox to take everything put it on itself and then add to the scene which is added to the stage 
        VBox root = new VBox(imagePos , buttonsPos , socialButtons);
        root.setAlignment(Pos.CENTER);
        
        //Setting up the scene
        Scene scene = new Scene(root , 600 , 700);
        
        //Setting up the stage
        primaryStage.setTitle("Tutor Tinder");
        Image tutorTinderIcon = new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true);
        primaryStage.getIcons().add(tutorTinderIcon);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    
    
}
