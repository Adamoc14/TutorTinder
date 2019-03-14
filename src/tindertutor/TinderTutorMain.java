/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    Scene SignUpStudentPage;
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
                TinderTutorSignUpStudent tindertutorSignUpStudent = new TinderTutorSignUpStudent();
                
                ImageView logoView2 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),120,120,true,true));
                
                Label lblStudentProf = new Label("Student Profile");
                lblStudentProf.setTextFill(Color.RED);
                lblStudentProf.setStyle("-fx-font-size: 20;");
                
                Image mainImage = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
                Circle mainPicView = new Circle(250,250,50);
                mainPicView.setFill(new ImagePattern(mainImage));
                
                Label lblUsers_Name = new Label("Name");
                TextField txtUsers_Name = new TextField();
                
                Label lblUsers_Email = new Label("Email");
                TextField txtUsers_Email = new TextField();
                
                Label lblUsers_Pass = new Label("Password");
                PasswordField passUsers_Email = new PasswordField(); 
                
                ImageView loginDetails = new ImageView(new Image(getClass().getResourceAsStream("Assets/LoginDetailsLine.png"),400,400,true,true));
                
                Label lblUsers_Year = new Label("Year");
                TextField txtUsers_Year = new TextField();
                
                Label lblUsers_Course = new Label("Course");
                TextField txtUsers_Course = new TextField();
                
                Label lblUsers_Module = new Label("Module");
                TextField txtUsers_Module = new TextField();
                
                Label lblLocationSlider = new Label("Location");
                
                Slider locationSlider = new Slider(0, 1, 0.5);
                locationSlider.setShowTickMarks(true);
                locationSlider.setShowTickLabels(true);
                locationSlider.setMajorTickUnit(0.25f);
                locationSlider.setBlockIncrement(0.1f);
                
                Label lblUsers_preferredPrice = new Label("Price");
                ObservableList<String> preferredPriceOptions = 
                FXCollections.observableArrayList(
                    "1.00",
                    "2.00",
                    "3.00"
                );
                ComboBox priceComboBox = new ComboBox(preferredPriceOptions);
                
                Label lblUsers_Type = new Label("Type");
                
                ToggleGroup typeGroup = new ToggleGroup();
                RadioButton button1 = new RadioButton("Single");
                button1.setToggleGroup(typeGroup);
                button1.setSelected(true);
                RadioButton button2 = new RadioButton("Group");
                button2.setToggleGroup(typeGroup);
                
                
                Button btnSignUpReal = new Button("Sign Up");
                
                btnSignUpReal.setOnAction(r-> {
                  String ErrorsArray[];
                  String Student_Name = txtUsers_Name.getText();
                  String Student_Email = txtUsers_Email.getText();
                  String Student_Password = passUsers_Email.getText();
                  double Student_Year = Double.valueOf(txtUsers_Year.getText());
                  String Student_Course = txtUsers_Course.getText();
                  String Student_Module = txtUsers_Module.getText();
                  double Student_Location = locationSlider.getValue();
//                  double Student_Price = 
                  String Student_Type = typeGroup.getSelectedToggle().selectedProperty().toString();
                    
                  try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/Tinder_Tutor","Adam","gaelic football");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("Select * From Student_Users");
                    
                    
                    Student student = new Student();
                    
                    student.setStudentName(Student_Name);
                    student.setStudentEmail(Student_Email);
                    student.setStudentPass(Student_Password);
                    student.setStudentYear(Student_Year);
                    student.setStudentCourse(Student_Course);
                    student.setStudentModule(Student_Module);
                    student.setStudentLocation(Student_Location);
                    
                    System.out.println(student.toString());
                    
                    
                    while(rs.next()){
                        System.out.println(rs.getString(1));
                        System.out.println(rs.getString(2));
                        System.out.println(rs.getString(3));
                        System.out.println(rs.getString(4));
                    }
                    
                    
                 
                  } catch(SQLException y){
                    System.out.println(y.getMessage());
                  } 
                  
                });

                SignUpStudentPage = new Scene(tindertutorSignUpStudent.SignUpStudentView(logoView2,lblStudentProf ,mainPicView, lblUsers_Name,txtUsers_Name,lblUsers_Email,txtUsers_Email,lblUsers_Pass,passUsers_Email, loginDetails,lblUsers_Year, txtUsers_Year,lblUsers_Course, txtUsers_Course,lblUsers_Module, txtUsers_Module, lblLocationSlider, locationSlider, lblUsers_preferredPrice , priceComboBox , lblUsers_Type , button1 , button2,  btnSignUpReal), 600 ,700);
              
                window.setScene(SignUpStudentPage);
            });
            
            
            btnTeacher.setOnAction(evnt -> {
                TinderTutorSignUpTutor tindertutorSignUpTutor = new TinderTutorSignUpTutor();
                
                ImageView logoView2 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),120,120,true,true));

                Label lblTutorProf = new Label("Tutor Profile");
                lblTutorProf.setTextFill(Color.RED);
                lblTutorProf.setStyle("-fx-font-size: 20;");

                Image mainImage2 = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
                Circle mainPicView2 = new Circle(250,250,50);
                mainPicView2.setFill(new ImagePattern(mainImage2));

                Label lblUsers_Name2 = new Label("Name");
                TextField txtUsers_Name = new TextField();

                Label lblUsers_Email = new Label("Email");
                TextField txtUsers_Email = new TextField();

                Label lblUsers_Pass = new Label("Password");
                PasswordField passUsers_Email = new PasswordField(); 

                ImageView loginDetails = new ImageView(new Image(getClass().getResourceAsStream("Assets/LoginDetailsLine.png"),400,400,true,true));

                Label lblUsers_RLinks= new Label("Relevant Links");
                TextField txtUsers_RLinks = new TextField();

                Label lblUsers_Qualifications = new Label("Qualifications");
                TextField txtUsers_Qualifications = new TextField();

                Label lblUsers_Description = new Label("Description");
                TextField txtUsers_Description = new TextField();

                Label lblLocationSlider = new Label("Location");

                Slider locationSlider = new Slider(0, 1, 0.5);
                locationSlider.setShowTickMarks(true);
                locationSlider.setShowTickLabels(true);
                locationSlider.setMajorTickUnit(0.25f);
                locationSlider.setBlockIncrement(0.1f);

                Label lblUsers_preferredPrice = new Label("Price");
                ObservableList<String> preferredPriceOptions = 
                FXCollections.observableArrayList(
                    "1.00",
                    "2.00",
                    "3.00"
                );
                ComboBox priceComboBox = new ComboBox(preferredPriceOptions);

                Label lblUsers_Type = new Label("Type");

                ToggleGroup typeGroup = new ToggleGroup();
                RadioButton button1 = new RadioButton("Single");
                button1.setToggleGroup(typeGroup);
                button1.setSelected(true);
                RadioButton button2 = new RadioButton("Group");
                button2.setToggleGroup(typeGroup);


                Button btnSignUpReal = new Button("Sign Up");

                SignUpStudentPage = new Scene(tindertutorSignUpTutor.SignUpTutorView(logoView2,lblTutorProf ,mainPicView2, lblUsers_Name2,txtUsers_Name,lblUsers_Email,txtUsers_Email,lblUsers_Pass,passUsers_Email, loginDetails,lblUsers_RLinks, txtUsers_RLinks,lblUsers_Qualifications, txtUsers_Qualifications,lblUsers_Description, txtUsers_Description, lblLocationSlider, locationSlider, lblUsers_preferredPrice , priceComboBox , lblUsers_Type , button1 , button2,  btnSignUpReal), 600 ,700);

                window.setScene(SignUpStudentPage);
            });
            
            SignUpPage = new Scene(tindertutorSignUp.SignUpView(logoView,lblSignUp , lblUserType, btnStudent, btnTeacher,  lblStudent , lblTeacher ), 600 ,700);
              
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
                            
                            btnUserProfile.setOnAction(evet -> {
                              TinderTutorSignUpStudent tindertutorSignUpStudent = new TinderTutorSignUpStudent();
                
                                ImageView logoView2 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),120,120,true,true));

                                Label lblStudentProf = new Label("Student Profile");
                                lblStudentProf.setTextFill(Color.RED);
                                lblStudentProf.setStyle("-fx-font-size: 20;");

                                Image mainImage2 = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
                                Circle mainPicView2 = new Circle(250,250,50);
                                mainPicView2.setFill(new ImagePattern(mainImage2));

                                Label lblUsers_Name2 = new Label("Name");
                                TextField txtUsers_Name = new TextField();

                                Label lblUsers_Email = new Label("Email");
                                TextField txtUsers_Email = new TextField();

                                Label lblUsers_Pass = new Label("Password");
                                PasswordField passUsers_Email = new PasswordField(); 

                                ImageView loginDetails = new ImageView(new Image(getClass().getResourceAsStream("Assets/LoginDetailsLine.png"),400,400,true,true));

                                Label lblUsers_Year = new Label("Year");
                                TextField txtUsers_Year = new TextField();

                                Label lblUsers_Course = new Label("Course");
                                TextField txtUsers_Course = new TextField();

                                Label lblUsers_Module = new Label("Module");
                                TextField txtUsers_Module = new TextField();

                                Label lblLocationSlider = new Label("Location");

                                Slider locationSlider = new Slider(0, 1, 0.5);
                                locationSlider.setShowTickMarks(true);
                                locationSlider.setShowTickLabels(true);
                                locationSlider.setMajorTickUnit(0.25f);
                                locationSlider.setBlockIncrement(0.1f);

                                Label lblUsers_preferredPrice = new Label("Price");
                                ObservableList<String> preferredPriceOptions = 
                                FXCollections.observableArrayList(
                                    "1.00",
                                    "2.00",
                                    "3.00"
                                );
                                ComboBox priceComboBox = new ComboBox(preferredPriceOptions);

                                Label lblUsers_Type = new Label("Type");

                                ToggleGroup typeGroup = new ToggleGroup();
                                RadioButton button1 = new RadioButton("Single");
                                button1.setToggleGroup(typeGroup);
                                button1.setSelected(true);
                                RadioButton button2 = new RadioButton("Group");
                                button2.setToggleGroup(typeGroup);


                                Button btnSignUpReal = new Button("Sign Up");

                                SignUpStudentPage = new Scene(tindertutorSignUpStudent.SignUpStudentView(logoView2,lblStudentProf ,mainPicView2, lblUsers_Name2,txtUsers_Name,lblUsers_Email,txtUsers_Email,lblUsers_Pass,passUsers_Email, loginDetails,lblUsers_Year, txtUsers_Year,lblUsers_Course, txtUsers_Course,lblUsers_Module, txtUsers_Module, lblLocationSlider, locationSlider, lblUsers_preferredPrice , priceComboBox , lblUsers_Type , button1 , button2,  btnSignUpReal), 600 ,700);

                                window.setScene(SignUpStudentPage);
                            });
                            
                            
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
        root.setStyle("-fx-background-color: #ffffff");
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
