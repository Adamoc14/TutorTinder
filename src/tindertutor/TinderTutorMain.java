/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

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
import javafx.scene.control.TextArea;
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
import tindertutor.DataAccess.Student;
import tindertutor.UI.SwitchView;

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
    Scene GrindRecieved;
    Scene WaitScreen;
    Scene MessageScreen;
    
        //Set up the switch view to class to switch in and out the views
        SwitchView TinderTutorSwitcher = new SwitchView();
    
    
         //Main Screen Set Up View
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),220,220,true,true));
        Button btnLogin = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnLogin.png"),150,280,true,true)));
        Button btnSignUp = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSignUp.png"),150,280,true,true)));
        Button btnLinkedIn = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnLinkedIn.png"),150,280,true,true)));
        Button btnFacebook = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnFacebook.png"),150,280,true,true)));
        Button btnGooglePlus = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnGooglePlus.png"),150,280,true,true)));
        
        //Sign Up Screen Set Up Type View
        ImageView logoView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),220,220,true,true));
        Label lblSignUp = new Label("Sign Up");
        Label lblUserType = new Label("Are you a ");
        Button btnStudent = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnStudents.png"),280,280,true,true)));
        Button btnTeacher = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnTeacher.png"),280,280,true,true)));
        Label lblStudent = new Label("Student ?");
        Label lblTeacher = new Label("Teacher ?");
        
        //Sign up Screen Set up Student View
        ImageView logoView2 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),120,120,true,true));
        Label lblStudentProf = new Label("Student Profile");
        Image mainImage = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
        Circle mainPicView = new Circle(250,250,50);
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
        RadioButton button2 = new RadioButton("Group");
        Button btnSignUpReal = new Button("Sign Up");
        
        //Sign Up Teacher / Tutor Set Up View
        Label lblTutorProf = new Label("Tutor Profile");
        Image mainImage2 = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
        Circle mainPicView2 = new Circle(250,250,50);
        Label lblUsers_Name2 = new Label("Name");
        Label lblUsers_RLinks= new Label("Relevant Links");
        TextField txtUsers_RLinks = new TextField();
        Label lblUsers_Qualifications = new Label("Qualifications");
        TextField txtUsers_Qualifications = new TextField();
        Label lblUsers_Description = new Label("Description");
        TextField txtUsers_Description = new TextField();
        
        //Login Set Up View
        Label lblSignIn = new Label("Sign in to your account");
        TextField txtUsername = new TextField();
        PasswordField txtPassword = new PasswordField();
        Label forgotPass = new Label("Forgot Your password ?");
        Button btnLoginReal = new Button("Login");
        
        //Splashscreen Set Up View
        Label lblTitle = new Label("Tinder Tutor");
        ImageView tinderTutorSplashscreen = new ImageView(new Image(getClass().getResourceAsStream("Assets/tinderTutorSplashscreen.png"),280,280,true,true));
        Label lblTagLine = new Label("Where students and tutors worlds collide!");
        Button btnContinue = new Button("Continue");
        
        //Tinder Tutor Main Swipe Page
        Button btnSettings = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,true,true)));
        ImageView logoView4 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true));
        Button btnChat= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnChat.png"),80,80,true,true)));
        Circle mainPicViewSwipe = new Circle(500,500,150);
        Label lblUser_Name= new Label("Username : ");
        Label lblUsers_Qualification= new Label("Qualification: ");
        Label lblUsers_Subject= new Label("Subject: ");
        Label lblUsers_Location= new Label("Location: ");
        Label lblUsers_Price= new Label("Price: ");
        Button btnCheckYes= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnYes.png"),90,60,true,true)));
        Button btnCheckNo = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnNo.png"),90,60,true,true)));
        Group grpBtns = new Group(btnCheckNo , btnCheckYes);
        Image mainImagePic = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
        Circle userPicView = new Circle(500,500,150);
        
        
        //Tinder tutor grind recieved page 
        ImageView logoView3 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true));
        ImageView picGrindRecieved = new ImageView(new Image(getClass().getResourceAsStream("Assets/PicGrindRecieved.png"),280,120,true,true));
        Circle TutorPicView = new Circle(250,250,80);
        Image mainImage3 = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
        Circle StudentPicView  = new Circle(250,250,80);
        Label lblGrindRecievedConfirmation = new Label("This tutor is available for a grind with you !");
        Button btnMessageUser = new Button("Message...");
        
        //Tinder Tutor Message View 
        ImageView grindsView = new ImageView(new Image(getClass().getResourceAsStream("Assets/btnChat.png"),90,80,false,true));;
        ImageView formatView = new ImageView(new Image(getClass().getResourceAsStream("Assets/MainFormatting.png"),650,150,false,true));
        Label lblUsers_NameMessage = new Label("John Dorney");
        Image mainImage_Pic = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),220,220,true,true);
        Circle Users_Pic = new Circle(500,500,100);
        Label lblInvitation = new Label("Set up a grind with John");
        ImageView FormatBottomView = new ImageView(new Image(getClass().getResourceAsStream("Assets/formatBottom.png"),120,120,true,true));
        TextArea txtMessageMainArea = new TextArea();
        Button btnSendMessage = new Button("Send Message");
        
        //Tinder Tutor Settings View 
        ImageView settingsView = new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,false,true));
        Label lblUserName = new Label("John Barton , New England");
        Label lblUsersType = new Label("Student");
        Label lblUniName = new Label("Stanford");
        Button btnUserProfile = new Button("My Profile");
        
    @Override
    public void start(Stage primaryStage) {
        
        //Setting up the primaryStage to be switchable
        window = primaryStage;
        
        //Restricting the posibility of making screen bigger
        window.setResizable(false);
        
        //Styling all our objects that need to go on Main scene
        btnLogin.setStyle("-fx-background-color: transparent");
        btnSignUp.setStyle("-fx-background-color: transparent");
        btnLinkedIn.setStyle("-fx-background-color: transparent");
        btnFacebook.setStyle("-fx-background-color: transparent");
        btnGooglePlus.setStyle("-fx-background-color: transparent"); 
        
        btnSignUp.setOnAction(e-> {
            //Styling all objects that need to go on our sign up choice view 
            lblSignUp.setTextFill(Color.RED);
            lblSignUp.setStyle("-fx-font-size: 30;");
            btnStudent.setStyle("-fx-background-color: transparent");
            btnTeacher.setStyle("-fx-background-color: transparent");
            lblStudent.setStyle("fx-font-weight: bolder; fx-text-fill: black; ");
            btnStudent.setOnAction(event-> {
                //Styling all objects that need to go on our sign up student view 
                lblStudentProf.setTextFill(Color.RED);
                lblStudentProf.setStyle("-fx-font-size: 20;");
                mainPicView.setFill(new ImagePattern(mainImage));
                locationSlider.setShowTickMarks(true);
                locationSlider.setShowTickLabels(true);
                locationSlider.setMajorTickUnit(0.25f);
                locationSlider.setBlockIncrement(0.1f);
                button1.setToggleGroup(typeGroup);
                button1.setSelected(true);
                button2.setToggleGroup(typeGroup);
                btnSignUpReal.setOnAction(r-> {
                   //Adding the functionality to add the new user to the database 
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
                SignUpStudentPage = new Scene(TinderTutorSwitcher.SignUpStudentView(logoView2,lblStudentProf ,mainPicView, lblUsers_Name,txtUsers_Name,lblUsers_Email,txtUsers_Email,lblUsers_Pass,passUsers_Email, loginDetails,lblUsers_Year, txtUsers_Year,lblUsers_Course, txtUsers_Course,lblUsers_Module, txtUsers_Module, lblLocationSlider, locationSlider, lblUsers_preferredPrice , priceComboBox , lblUsers_Type , button1 , button2,  btnSignUpReal), 600 ,700);
                window.setScene(SignUpStudentPage);
            });
            btnTeacher.setOnAction(evnt -> {
                //Styling all objects that need to go on our sign up tutor view 
                lblTutorProf.setTextFill(Color.RED);
                lblTutorProf.setStyle("-fx-font-size: 20;");
                mainPicView2.setFill(new ImagePattern(mainImage2));
                locationSlider.setShowTickMarks(true);
                locationSlider.setShowTickLabels(true);
                locationSlider.setMajorTickUnit(0.25f);
                locationSlider.setBlockIncrement(0.1f);
                ObservableList<String> preferredPriceOptions = 
                FXCollections.observableArrayList(
                    "1.00",
                    "2.00",
                    "3.00"
                );
                button1.setToggleGroup(typeGroup);
                button1.setSelected(true);
                button2.setToggleGroup(typeGroup);
                SignUpStudentPage = new Scene(TinderTutorSwitcher.SignUpTutorView(logoView2,lblTutorProf ,mainPicView2, lblUsers_Name2,txtUsers_Name,lblUsers_Email,txtUsers_Email,lblUsers_Pass,passUsers_Email, loginDetails,lblUsers_RLinks, txtUsers_RLinks,lblUsers_Qualifications, txtUsers_Qualifications,lblUsers_Description, txtUsers_Description, lblLocationSlider, locationSlider, lblUsers_preferredPrice , priceComboBox , lblUsers_Type , button1 , button2,  btnSignUpReal), 600 ,700);
                window.setScene(SignUpStudentPage);
            });
            
            SignUpPage = new Scene(TinderTutorSwitcher.SignUpView(logoView,lblSignUp , lblUserType, btnStudent, btnTeacher,  lblStudent , lblTeacher ), 600 ,700);
            window.setScene(SignUpPage);
        });
        
        //Adding all Button functionality in lambda expressions
        btnLogin.setOnAction(e -> {
            lblSignIn.setTextFill(Color.RED);
            txtUsername.setMaxWidth(340);
            txtPassword.setMaxWidth(340);
            btnLoginReal.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            TinderTutorSwitcher.LoginView(image, lblSignIn, txtUsername, txtPassword, forgotPass, btnLoginReal).setMargin(lblSignIn , new Insets(-40 ,0 ,0,0));
            LoginRealPage = new Scene(TinderTutorSwitcher.LoginView(image, lblSignIn, txtUsername, txtPassword, forgotPass, btnLoginReal) , 600 ,700);
            window.setScene(LoginRealPage);
            btnLoginReal.setOnAction(event -> {
                    if(txtUsername.getText().equals("Adam")&& txtPassword.getText().equals("1234")){
                        lblTitle.setStyle("-fx-font-size : 30; -fx-text-fill :#ef5350 ");
                        tinderTutorSplashscreen.setStyle("-fx-background-color: transparent");
                        lblTagLine.setStyle("-fx-font-size: 20;");
                        WaitScreen = new Scene(TinderTutorSwitcher.WaitScreenView(lblTitle, tinderTutorSplashscreen, lblTagLine, btnContinue), 600 , 700);
                        window.setScene(WaitScreen);
                        btnContinue.setOnAction(t-> {
                            btnSettings.setStyle("-fx-background-color: transparent;");
                            btnChat.setOnAction(p-> {
                            });
                            btnChat.setStyle("-fx-background-color: transparent;");
                            userPicView.setFill(new ImagePattern(mainImagePic));
                            btnCheckYes.setStyle("-fx-background-color: transparent;");
                            btnCheckYes.setOnAction(r-> {
                                TutorPicView.setFill(new ImagePattern(mainImage2));
                                StudentPicView.setFill(new ImagePattern(mainImage3));
                                lblGrindRecievedConfirmation.setStyle("-fx-font-size : 20;");
                                btnMessageUser.setOnAction(o-> {
                                    Users_Pic.setFill(new ImagePattern(mainImage_Pic));
                                    txtMessageMainArea.setStyle("-fx-background-radius: 20px;");
                                    btnSendMessage.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
                                    MessageScreen = new Scene(TinderTutorSwitcher.MainMessageView(grindsView, formatView, lblUsers_NameMessage, Users_Pic, lblInvitation, FormatBottomView, txtMessageMainArea , btnSendMessage), 600 ,700);
                                    window.setScene(MessageScreen);
                                });
                                GrindRecieved = new Scene(TinderTutorSwitcher.GrindRecievedView(logoView3, picGrindRecieved, StudentPicView, TutorPicView, lblGrindRecievedConfirmation, btnMessageUser), 600 ,700);
                                window.setScene(GrindRecieved);
                            });
                            btnCheckNo.setStyle("-fx-background-color: transparent;");
                            SwipePage = new Scene(TinderTutorSwitcher.SwipeView(btnSettings, logoView4, btnChat, userPicView, lblUser_Name, lblUsers_Qualification, lblUsers_Subject, lblUsers_Location, lblUsers_Price, btnCheckNo , btnCheckYes) , 600 , 700);
                            window.setScene(SwipePage);
                            btnSettings.setOnAction(evt-> {
                                userPicView.setFill(new ImagePattern(mainImagePic));
                                btnUserProfile.setOnAction(evet -> {
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
                                    Button btnSignUpReal = new Button("Update");
                                    SignUpStudentPage = new Scene(TinderTutorSwitcher.SignUpStudentView(logoView2,lblStudentProf ,mainPicView2, lblUsers_Name2,txtUsers_Name,lblUsers_Email,txtUsers_Email,lblUsers_Pass,passUsers_Email, loginDetails,lblUsers_Year, txtUsers_Year,lblUsers_Course, txtUsers_Course,lblUsers_Module, txtUsers_Module, lblLocationSlider, locationSlider, lblUsers_preferredPrice , priceComboBox , lblUsers_Type , button1 , button2,  btnSignUpReal), 600 ,700);
                                    window.setScene(SignUpStudentPage);
                                });


                                btnUserProfile.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
                                ImageView logoPlusView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogoPlus.png"),150,100,false,true));
                                SettingsPage = new Scene(TinderTutorSwitcher.SettingsView(settingsView, formatView ,userPicView , lblUserName ,lblUsersType ,lblUniName, btnUserProfile ,logoPlusView), 600, 700);
                                window.setScene(SettingsPage);
                            });

                            
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
