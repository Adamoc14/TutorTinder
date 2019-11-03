/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tindertutor.Controller.DBAdapter;
import tindertutor.DataAccess.Student;
import tindertutor.DataAccess.Tutor;
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
    Scene MainPage;
    Scene SwipePage;
    Scene LoginRealPage;
    Scene SignUpPage;
    Scene SignUpStudentPage;
    Scene SignUpTutorPage;
    Scene SettingsPage;
    Scene GrindRecieved;
    Scene WaitScreen;
    Scene OverviewScreen;
    Scene MessageScreen;
    
        //Set up the switch view to class to switch in and out the views
        SwitchView TinderTutorSwitcher = new SwitchView();
        
        //Variable to carry over the user to use in the settings view 
        String user = "";
        
        //Variable to carry over username and password of user signed in 
        String Username_Logged = "";
        String Password_Logged = "";
        
        //Variables to distinguish whether the user is logged in or signing up 
        Boolean SignUp = false;
        Boolean LoggedIn = false;
        
        //Variable to carry over the id of the person logged in 
        String ID_LoggedIN = "";
        
        
        //Important variables to update the student user's data
        String Student_Name = "";
        String Student_Username = "";
        String Student_Password = "";
        String Student_Year = "";
        String Student_ModuleCode = "";
        double Student_Location = 0.00;
        String Student_Type = "";
        double Student_Price = 0.00;
        
        //Important variables to update the tutor's user data
        String Tutor_Name = "";
        String Tutor_Username = "";
        String Tutor_Password = "";
        String Tutor_SubjectArea = "";
        String Tutor_Qualifications = "";
        double Tutor_Location = 0.00;
        String Tutor_Type = "";
        double Tutor_Price = 0.00;
        
        
        
        //Setting up the common back buttons to move back through the app
        Button btnBack = new Button("Back");
        Button btnBackArrow = new Button ("", new ImageView(new Image(getClass().getResourceAsStream("Assets/BtnBackArrow2.png"),60,200,true,true)));
        
        //Setting up the common images and circles to be used in the various different scenes 
        ImageView logoView2 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),120,120,true,true));
        ImageView logoView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),220,220,true,true));
        ImageView loginDetails = new ImageView(new Image(getClass().getResourceAsStream("Assets/LoginDetailsLine.png"),400,400,true,true));
        ImageView tinderTutorSplashscreen = new ImageView(new Image(getClass().getResourceAsStream("Assets/tinderTutorSplashscreen.png"),280,280,true,true));
        ImageView logoView4 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true));
        ImageView settingsView = new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,false,true));
        ImageView logoPlusView = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogoPlus.png"),150,100,false,true));
        ImageView logoView3 = new ImageView(new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true));
        ImageView picGrindRecieved = new ImageView(new Image(getClass().getResourceAsStream("Assets/PicGrindRecieved.png"),280,120,true,true));
        ImageView grindsView = new ImageView(new Image(getClass().getResourceAsStream("Assets/btnChat.png"),90,80,false,true));;
        ImageView formatView = new ImageView(new Image(getClass().getResourceAsStream("Assets/MainFormatting.png"),650,150,false,true));
        ImageView FormatBottomView = new ImageView(new Image(getClass().getResourceAsStream("Assets/formatBottom.png"),120,120,true,true));
        ImageView chatView = new ImageView(new Image(getClass().getResourceAsStream("Assets/BBoardTick.png"),120,120,true,true));
        Image mainImage = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),280,280,true,true);
        Image tutorTinderIcon = new Image(getClass().getResourceAsStream("Assets/TinderTutorLogo.png"),280,120,true,true);
        Image mainImage_Pic = new Image(getClass().getResourceAsStream("Assets/MainTestProfilePic.jpg"),220,220,true,true);
        Circle mainPicView = new Circle(250,250,50);
        Circle mainPicViewSwipe = new Circle(500,500,150);
        Circle userPicView = new Circle(300,300,100);
        Circle TutorPicView = new Circle(250,250,80);
        Circle StudentPicView  = new Circle(250,250,80);
        Circle Users_Pic = new Circle(500,500,100);
        Rectangle rect = new Rectangle(340,420 , Color.FLORALWHITE);
          


        //Setting the important things needed on the login view for signing in 
        TextField txtUsername = new TextField();
        PasswordField txtPassword = new PasswordField();
        
        
        //Setting the important things needed on the student view for signing up 
        TextField txtSUsers_Name = new TextField();
        TextField txtSUsers_Username = new TextField();
        PasswordField txtSUsers_Pass = new PasswordField(); 
        TextField txtSUsers_Year = new TextField();
        TextField txtSUsers_ModuleCode = new TextField();
        Slider SlocationSlider = new Slider(1.0, 5.0, 1.0);
        ObservableList<String> preferredTypeOptions = FXCollections.observableArrayList(
            "Single",
            "Group"
        );
        TextField txtSPreferredPrice = new TextField();
        ComboBox StypeComboBox = new ComboBox(preferredTypeOptions);
        Button btnSignUpSReal = new Button("Sign Up");
        
        //Setting the important things needed on the tutor view for signing up 
        TextField txtTUsers_Name = new TextField();
        TextField txtTUsers_Username = new TextField();
        PasswordField txtTUsers_Pass = new PasswordField(); 
        TextField txtTUsers_SubjectArea = new TextField();
        TextField txtTUsers_Qualifications = new TextField();
        Slider TlocationSlider = new Slider(1.0, 5.0, 1.0);
        TextField txtTPreferredPrice = new TextField();
        ComboBox TtypeComboBox = new ComboBox(preferredTypeOptions);
        Button btnSignUpTReal = new Button("Sign Up");
        
        //Setting the important things needed on the tutor view for signing up 
        
        
         //This function takes the double number and takes the amount of decimal places you want then uses big decimal to return the double with that amount of d.p's
        public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

            BigDecimal bd = new BigDecimal(Double.toString(value));
            bd = bd.setScale(places, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        
        
        
        //This function takes all the values and calls method on student object to post them all to the database 
        public void StudentSignUp(){
            Student_Name = txtSUsers_Name.getText();
            Student_Username = txtSUsers_Username.getText();
            Student_Password = txtSUsers_Pass.getText();
            Student_Year = txtSUsers_Year.getText();
            Student_ModuleCode = txtSUsers_ModuleCode.getText();
            Student_Location = SlocationSlider.getValue();
            Student_Type = StypeComboBox.getValue().toString();
            Student_Price = Double.valueOf(txtSPreferredPrice.getText());
            try{
                      Student newstudent = new Student();
                      Boolean StudentPost = newstudent.StudentPost(Student_Name, Student_Username, Student_Password, Student_Year, Student_ModuleCode, round(Student_Location,2), Student_Type , Student_Price );
                      if(StudentPost){
                          Alert SuccessUser = new Alert(Alert.AlertType.CONFIRMATION,  "You're now successfully a tinder tutor user");
                          SuccessUser.setTitle("Congratulations");
                          SuccessUser.showAndWait();
                          wipesStudentDisplay();
                          SignUp = true;
                          setWaitScreen("Student");
                      }
                } catch(Exception t){
                      System.out.println(t);
            }
        }
        
        
        //This function takes all the values and calls method on tutor object to post them all to the database 
         public void TutorSignUp(){
            
            Tutor_Name = txtTUsers_Name.getText();
            Tutor_Username = txtTUsers_Username.getText();
            Tutor_Password = txtTUsers_Pass.getText();
            Tutor_SubjectArea = txtTUsers_SubjectArea.getText();
            Tutor_Qualifications = txtTUsers_Qualifications.getText();
            Tutor_Location = TlocationSlider.getValue();
            Tutor_Type = TtypeComboBox.getValue().toString();
            Tutor_Price = Double.valueOf(txtTPreferredPrice.getText());
            
            try{
                      Tutor newtutor = new Tutor();
                      Boolean TutorPost = newtutor.TutorPost(Tutor_Name, Tutor_Username, Tutor_Password, Tutor_SubjectArea, Tutor_Qualifications, round(Tutor_Location , 2),  Tutor_Type , Tutor_Price);
                      if(TutorPost){
                          Alert SuccessUser = new Alert(Alert.AlertType.CONFIRMATION,  "You're now successfully a tinder tutor user");
                          SuccessUser.setTitle("Congratulations");
                          SuccessUser.showAndWait();
                          wipesTutorDisplay();
                          SignUp = true;
                          setWaitScreen("Tutor");
                      }
                } catch(Exception t){
                      System.out.println(t);
            }
        }
        
         
         /*This takes the login details from the textboxes and calls the method DBCheckLoginDetails in the database class to check whether this person is in the database already as either studnet or tutor 
         and then set screens accordingly and also retrieves the person's who's logged in details or data 
         */
        public void CheckDBLoginDetails(){
            Username_Logged = txtUsername.getText();
            Password_Logged = txtPassword.getText();
            try {
                DBAdapter dbadapter = new DBAdapter();
                Boolean DBCheck = dbadapter.DBCheckLoginDetails(Username_Logged, Password_Logged);
                /* This checks whether the returned value was false and deals with them accodingly as in error message 
                   or if the value is true sets up the screen accordingly 
                */
                if(DBCheck == false){
                    Alert ErrorUser = new Alert(Alert.AlertType.ERROR,  "You're not registered as a Tinder Tutor user");
                    ErrorUser.setTitle("Error");
                    ErrorUser.showAndWait();
                } else if (DBCheck == true) {
                    LoggedIn = true;
                    /*This calls the function to check the user that's signing in, after we know this person is in the database 
                      and passes in the username and password asa reference to find if their a student or tutor
                    */
                    user = checkDBUser(Username_Logged , Password_Logged);
                    /*This calls the function to setWaitScreen and passes in the user retrieved above to the set wait screen to deal
                    with accordingly and decide because it's a student it's now going to show swipe screen or if tutor the overview screen
                    */
                    setWaitScreen(user);
                }
            } catch (Exception ec){
                System.out.println(ec);
            }
        }
        
        
        /* This returns whether the person logged in is a student or a tutor based on username and password 
        returns String with user type in it for use in rest of app  
        */
        public String checkDBUser(String Username , String Password){
            
            try {
                DBAdapter dbadapter = new DBAdapter();
                String DBCheckUser = dbadapter.DBCheckUser(Username, Password);
                setWaitScreen(DBCheckUser);
                return DBCheckUser;
            } catch (Exception ec){
                System.out.println(ec);
            }
            return null;
        }
        
        //This retrieves the users data based on the username and password given and returns a resultset with specified amount of values in it
        public ResultSet retrieveDBPreferences(String Username , String Password){
            
            try{
                DBAdapter dbadapter = new DBAdapter();
                ResultSet DBData = dbadapter.DBRetrievePreferences(Username, Password);
                while (DBData.next()){
                    Alert LoginUser = new Alert(Alert.AlertType.INFORMATION,"Welcome " + DBData.getString("User_Name"));
                    LoginUser.setTitle("Welcome Back");
                    LoginUser.showAndWait();
                    Tutor newTutor = new Tutor();
                    Student newStudent = new Student();
                    ResultSet tutorData = newTutor.TutorRetrieve(Username_Logged , Password_Logged);
                    newStudent.setStudentLocation(DBData.getDouble("Student_Location"));
                    newTutor.setTutorLocation(tutorData.getDouble("Tutor_Location"));
                    newStudent.setStudentType(DBData.getString("Grind_Type"));
                    newTutor.setTutorType(tutorData.getString("Grind_Type"));
                    
                    
                    while(tutorData.next()){
                        checkLocationMatch(DBData.getDouble("Student_Location"),tutorData.getDouble("Tutor_Location") );
                        checkGType(DBData.getString("Grind_Type"), tutorData.getString("Grind_Type"));
//                            ResultSetMetaData resultSetMetaData = tutorData.getMetaData();
//                            final int columnCount = resultSetMetaData.getColumnCount();
//                            Object[] values = new Object[columnCount];
//                            for (int i = 1; i <= columnCount; i++) {
//                                values[i - 1] = tutorData.getObject(i);
//                                System.out.println(values[i-1]);
//                            }

                        Boolean lCheck = checkLocationMatch(DBData.getDouble("Student_Location"),tutorData.getDouble("Tutor_Location"));
                            
                                System.out.println(lCheck);
                            
                    }
                }
                return DBData;
            
            } catch(Exception exc) {
              System.out.println(exc);  
            }
            return null;
        }
        
        public Boolean checkLocationMatch(double S_Location , double T_Location){
           double MaxSLocation = S_Location + .5;
           double MinSLocation = S_Location - .5;
           
           if (T_Location > MinSLocation && T_Location < MaxSLocation){
               return true;
           }
           return null;
        }
        
        public Boolean checkGType(String SType , String TType){
            if(SType == "Single"&& TType == "Single"){
                return true;
            } else if(SType == "Group" && TType== "Group"){
                return false;
            }
            return null;
        }
        
        public String retrieveModuleCodeLink(String Username , String Password){
            String baseURL = "https://www-ucc-ie.ucc.idm.oclc.org/cgi-bin/uncgi/examsearch?q=";
            String mCode = "";
            try{
                ResultSet DBData = retrieveDBPreferences(Username ,Password);
                while(DBData.next()){
                    mCode = DBData.getString("College_ModuleCode");
                    baseURL += mCode;
                    System.out.println(baseURL);
                }
            } catch(Exception e){
                System.out.println(e);
            }
            return null;
        }
        
        public void setMainScreen(){
             //Main Screen Set Up View
            Button btnLogin = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnLogin.png"),150,280,true,true)));
            Button btnSignUp = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSignUp.png"),150,280,true,true)));
            Button btnLinkedIn = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnLinkedIn.png"),150,280,true,true)));
            Button btnFacebook = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnFacebook.png"),150,280,true,true)));
            Button btnGooglePlus = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnGooglePlus.png"),150,280,true,true)));
            btnLogin.setStyle("-fx-background-color: transparent");
            btnSignUp.setStyle("-fx-background-color: transparent");
            btnLinkedIn.setStyle("-fx-background-color: transparent");
            btnFacebook.setStyle("-fx-background-color: transparent");
            btnGooglePlus.setStyle("-fx-background-color: transparent");
            MainPage = new Scene(TinderTutorSwitcher.MainView(logoView, btnLogin, btnSignUp, btnLinkedIn, btnFacebook, btnGooglePlus),600,700);
            window.setScene(MainPage);
            btnSignUp.setOnAction(e-> {
            //Styling all objects that need to go on our sign up choice view 
                setSignUpScreen();
            });
            btnLogin.setOnAction(e -> {
                setLoginScreen();
            });
            //Setting up the stage
            window.setTitle("Tutor Tinder");
            //Restricting the posibility of making screen bigger
            window.setResizable(false);
            window.getIcons().add(tutorTinderIcon);
            window.show();
        }
        
        public void setSignUpScreen(){
             //Sign Up Screen Set Up Type View
            Label lblSignUp = new Label("Sign Up");
            Label lblUserType = new Label("Are you a ");
            Button btnStudent = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnStudents.png"),280,280,true,true)));
            Button btnTeacher = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnTeacher.png"),280,280,true,true)));
            Label lblStudent = new Label("Student ?");
            Label lblTeacher = new Label("Teacher ?");
            btnBackArrow.setStyle("-fx-background-color: transparent");
            lblSignUp.setTextFill(Color.RED);
            lblSignUp.setStyle("-fx-font-size: 30;");
            btnStudent.setStyle("-fx-background-color: transparent");
            btnTeacher.setStyle("-fx-background-color: transparent");
            lblStudent.setStyle("fx-font-weight: bolder; fx-text-fill: black; ");
            SignUpPage = new Scene(TinderTutorSwitcher.SignUpView(btnBackArrow, logoView,lblSignUp , lblUserType, btnStudent, btnTeacher,  lblStudent , lblTeacher ), 600 ,700);
            window.setScene(SignUpPage);
            btnBackArrow.setOnAction(e->{
                setMainScreen();
            });
            btnStudent.setOnAction(event-> {
                //Calling a function which Styles all objects that need to go on our sign up student view 
                setSignUpStudentScreen();
            });
            btnTeacher.setOnAction(evnt -> {
                //Calling a function which Styles all objects that need to go on our sign up tutor view 
                setSignUpTutorScreen();
            });
        }
        
        public void setSignUpStudentScreen(){
            //Sign up Screen Set up Student View
            Label lblStudentProf = new Label("Student Profile");
            Label lblSUsers_Name = new Label("Name");
            Label lblSUsers_Username = new Label("Username");
            Label lblSUsers_Pass = new Label("Password");
            Label lblSUsers_Year = new Label("Year");
            Label lblSUsers_ModuleCode = new Label("Module Code");
            Label lblSLocationSlider = new Label("Location");
            Label lblSUsers_preferredPrice = new Label("Price");
            Label lblSUsers_Type = new Label("Type");
            //Styling all objects that need to go on our sign up student view 
            lblStudentProf.setTextFill(Color.RED);
            lblStudentProf.setStyle("-fx-font-size: 20;");
            btnSignUpSReal.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            btnBack.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: white; -fx-text-fill: #ef5350; -fx-font-weight: bold ; -fx-border-color:#ef5350; -fx-border-radius: 20px;");
            mainPicView.setFill(new ImagePattern(mainImage));
            SlocationSlider.setShowTickMarks(true);
            SlocationSlider.setShowTickLabels(true);
            SlocationSlider.setMajorTickUnit(1.0f);
            txtSPreferredPrice.setEditable(false);
            btnBack.setOnAction(s->{
               setSignUpScreen(); 
            });
            btnSignUpSReal.setOnAction(r-> {
            //Calling the function to add or sign up a new user to the database 
              StudentSignUp();
            });
            StypeComboBox.setOnAction(t->{
                Student_Type = StypeComboBox.getValue().toString();
                if (null == Student_Type){
                    txtSPreferredPrice.setText("");
                } else switch (Student_Type) {
                    case "Single":
                        txtSPreferredPrice.setText("30.0");
                        break;
                    case "Group":
                        txtSPreferredPrice.setText("20.0");
                        break;
                    default:
                        txtSPreferredPrice.setText("");
                        break;
                }
            });
            SignUpStudentPage = new Scene(TinderTutorSwitcher.SignUpStudentView(logoView2,lblStudentProf ,mainPicView, lblSUsers_Name,txtSUsers_Name,lblSUsers_Username,txtSUsers_Username,lblSUsers_Pass,txtSUsers_Pass, loginDetails,lblSUsers_Year, txtSUsers_Year,lblSUsers_ModuleCode, txtSUsers_ModuleCode, lblSLocationSlider, SlocationSlider,  lblSUsers_Type , StypeComboBox ,lblSUsers_preferredPrice , txtSPreferredPrice , btnBack , btnSignUpSReal), 600 ,700);
            window.setScene(SignUpStudentPage);
            
        }
        
        
        
        public void setSignUpTutorScreen(){
            //Sign Up Teacher / Tutor Set Up View
            Label lblTutorProf = new Label("Tutor Profile");
            Label lblTUsers_Username = new Label("Username");
            Label lblTUsers_Pass = new Label("Password");
            Label lblTUsers_Name = new Label("Name");
            Label lblTUsers_SubjectArea= new Label("Subject_Area");
            Label lblTUsers_Qualifications = new Label("Qualifications");
            Label lblTLocationSlider = new Label("Location");
            Label lblTUsers_preferredPrice = new Label("Price");            
            Label lblTUsers_Type = new Label("Type");
            lblTutorProf.setTextFill(Color.RED);
            lblTutorProf.setStyle("-fx-font-size: 20;");
            mainPicView.setFill(new ImagePattern(mainImage));
            TlocationSlider.setShowTickMarks(true);
            TlocationSlider.setShowTickLabels(true);
            TlocationSlider.setMajorTickUnit(1.0f);
            txtTPreferredPrice.setEditable(false);
            btnSignUpTReal.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            btnBack.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: white; -fx-text-fill: #ef5350; -fx-font-weight: bold ; -fx-border-color:#ef5350; -fx-border-radius: 20px;");
             btnBack.setOnAction(s->{
               setSignUpScreen(); 
            });
            btnSignUpTReal.setOnAction(r-> {
            //Calling the function to add or sign up a new user to the database 
              TutorSignUp();
            });
             TtypeComboBox.setOnAction(t->{
                Tutor_Type = TtypeComboBox.getValue().toString();
                if (null == Tutor_Type){
                    txtTPreferredPrice.setText("");
                } else switch (Tutor_Type) {
                    case "Single":
                        txtTPreferredPrice.setText("30.0");
                        break;
                    case "Group":
                        txtTPreferredPrice.setText("20.0");
                        break;
                    default:
                        txtTPreferredPrice.setText("");
                        break;
                }
            });
            SignUpTutorPage = new Scene(TinderTutorSwitcher.SignUpTutorView(logoView2,lblTutorProf ,mainPicView, lblTUsers_Name,txtTUsers_Name,lblTUsers_Username,txtTUsers_Username,lblTUsers_Pass,txtTUsers_Pass, loginDetails,lblTUsers_SubjectArea, txtTUsers_SubjectArea,lblTUsers_Qualifications, txtTUsers_Qualifications, lblTLocationSlider, TlocationSlider,  lblTUsers_Type , TtypeComboBox, lblTUsers_preferredPrice , txtTPreferredPrice , btnBack ,  btnSignUpTReal), 600 ,700);
            window.setScene(SignUpTutorPage);
        }
        
        public void setLoginScreen(){
            //Login Set Up View
            Label lblSignIn = new Label("Sign in to your account");
            Label forgotPass = new Label("Forgot Your password ?");
            Button btnLoginReal = new Button("Login");
            lblSignIn.setTextFill(Color.RED);
            txtUsername.setMaxWidth(340);
            txtPassword.setMaxWidth(340);
            btnLoginReal.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            btnBack.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: white; -fx-text-fill: #ef5350; -fx-font-weight: bold ; -fx-border-color:#ef5350; -fx-border-radius: 20px;");
            TinderTutorSwitcher.LoginView(logoView, lblSignIn, txtUsername, txtPassword, forgotPass, btnBack, btnLoginReal).setMargin(lblSignIn , new Insets(-40 ,0 ,0,0));
            LoginRealPage = new Scene(TinderTutorSwitcher.LoginView(logoView, lblSignIn, txtUsername, txtPassword, forgotPass, btnBack, btnLoginReal) , 600 ,700);
            window.setScene(LoginRealPage);
            btnLoginReal.setOnAction(event -> {
                CheckDBLoginDetails();
            });
            btnBack.setOnAction(evt-> {
                setMainScreen();
            });
        }
        
        
        public void setWaitScreen(String User){
            //Splashscreen Set Up View
            System.out.println(SignUp);
            System.out.println(LoggedIn);
            Label lblTitle = new Label("Tinder Tutor");
            Label lblTagLine = new Label("Where students and tutors worlds collide!");
            Button btnContinue = new Button("Continue");
            lblTitle.setStyle("-fx-font-size : 30; -fx-text-fill :#ef5350 ");
            tinderTutorSplashscreen.setStyle("-fx-background-color: transparent");
            lblTagLine.setStyle("-fx-font-size: 20;");
            WaitScreen = new Scene(TinderTutorSwitcher.WaitScreenView(lblTitle, tinderTutorSplashscreen, lblTagLine, btnContinue), 600 , 700);
            window.setScene(WaitScreen);
            btnContinue.setOnAction(t-> {
                user = User;
                if(user == "Student"){
                    try {
                        setMainSwipeScreenS();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if(user == "Tutor"){
                    try {
                        //setOverviewScreen();
                        setMainSwipeScreenT();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        
        
        
        public void setMainSwipeScreenS() throws SQLException {
            //Tinder Tutor Main Swipe Page
            Button btnSettings = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,true,true)));
            Button btnChat= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnChat.png"),80,80,true,true)));
            Label lblUser_Name= new Label();
            Label lblUsers_Subject= new Label();
            Label lblUsers_Location= new Label();
            Label lblUsers_Type= new Label();
            Button btnCheckYes= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnYes.png"),90,60,true,true)));
            Button btnCheckNo = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnNo.png"),90,60,true,true)));
            Group grpBtns = new Group(btnCheckNo , btnCheckYes);
            StackPane stack = null;
            StackPane Tutor_Users = new StackPane();
            
           /*Trying to access the values to set up the secene with the rectangles for each of the tutors
            This part was hard and as such didn't get to finish it- the code below gets all the turtors into 
            a tutor card but i'm unable to cycle through them so it picks the first one and does the location
            match on him and then carries over his id so that i can message him 
            */ 

            Tutor t = new Tutor();
            ResultSet tutorData = t.TutorRetrieveAll();
            ArrayList<Integer> resultListID = new ArrayList<Integer>(9); 
            ArrayList<String> resultListName = new ArrayList<String>(9);
            ArrayList<String> resultSubjectArea = new ArrayList<String>(9);
            ArrayList<Double> resultLocation = new ArrayList<Double>(9);
            ArrayList<String> resultType =  new ArrayList<String>(9);

            while(tutorData.next()){
                 int resultID = tutorData.getInt(1);
                 String resultName = tutorData.getString(2);
                 String subjectArea = tutorData.getString(5);
                 Double location = Double.valueOf(tutorData.getString(7));
                 String type = tutorData.getString(8);
                 
                 resultListID.add(resultID);
                 resultListName.add(resultName);
                 resultSubjectArea.add(subjectArea);
                 resultLocation.add(location);
                 resultType.add(type);
                 
                 int integer;
                 String name = "";
                 String subjectA = "";
                 Double locationReal = 0.00;
                 String resultTypeReal = "";
                 
                 
                 for(int i : resultListID){
                     integer = i;
                     t.setTutorID(i);
                 }
                 
                 
                 for(String u : resultListName){
                     name = u;
                 }
                 
                 
                 for(String o : resultSubjectArea){
                     subjectA = o;
                 }
                 
                 for(Double u : resultLocation){
                     locationReal = u;
                 }
                 
                 for(String o : resultType){
                     resultTypeReal = o;
                 }
                
//                ResultSetMetaData resultSetMetaData = tutorData.getMetaData();
//                final int columnCount = resultSetMetaData.getColumnCount();
                for(int i= 1; i<= 9; i++){
                    Rectangle rect = new Rectangle(340,420 , Color.FLORALWHITE);
//                    System.out.println("Rectangle Created");
                    Circle userPicView = new Circle(300,300,100);
                    userPicView.setFill(new ImagePattern(mainImage));
                    lblUser_Name.setText(name);
                    lblUsers_Subject.setText(subjectA);
                    lblUsers_Location.setText(String.valueOf(locationReal));
                    lblUsers_Type.setText(resultTypeReal);
                    stack = new StackPane(TinderTutorSwitcher.Tutor_UsersView(rect, userPicView, lblUser_Name, lblUsers_Subject, lblUsers_Location, lblUsers_Type));
//                    Tutor_Users.getChildren().add(stack);
                }
//                Tutor_Users.getChildren().add(stack); 

                
                
            }
            
            Tutor_Users.getChildren().add(stack);
            btnSettings.setStyle("-fx-background-color: transparent;");
            btnChat.setStyle("-fx-background-color: transparent;");
            btnCheckYes.setStyle("-fx-background-color: transparent;");
            btnCheckNo.setStyle("-fx-background-color: transparent;");
            SwipePage = new Scene(TinderTutorSwitcher.SwipeView(btnSettings, logoView4, btnChat, Tutor_Users , btnCheckNo , btnCheckYes) , 600 , 700);
            window.setScene(SwipePage);
            btnSettings.setOnAction(evt-> {
                try {
                    setSettingsScreen(user);
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnChat.setOnAction(p-> { 
                setOverviewScreen(user);
            });
            btnCheckYes.setOnAction(r-> {
                Student st = new Student();
                double S_Location = st.getStudentLocation();
                double T_Location = t.getTutorLocation();
                Boolean locationCheck = checkLocationMatch(S_Location , T_Location);
//                System.out.println(locationCheck);
                if(locationCheck == true){
                  setGrindRecievedScreen();
                } else {
                    System.out.println("S_Location , T_Location");
                }
                
            });
        }
        
        public void sendMessage(String text , int S_id ,int T_id ) throws SQLException{
            try{
                DBAdapter dbadapter = new DBAdapter();
                Boolean DBData = dbadapter.sendMessage(text , S_id , T_id);
                if (DBData== true){
                    Alert LoginUser = new Alert(Alert.AlertType.INFORMATION,"Message Successfully sent");
                    LoginUser.setTitle("Update");
                    LoginUser.showAndWait();
                }
            } catch(Exception e){
             System.out.println(e);          
            }
        }
        
        
        public void setMainSwipeScreenT() throws SQLException {
            //Tinder Tutor Main Swipe Page
            Button btnSettings = new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnSettings.png"),80,80,true,true)));
            Button btnChat= new Button("", new ImageView(new Image(getClass().getResourceAsStream("Assets/btnChat.png"),80,80,true,true)));
            Label lblUser_Name= new Label();
            Label lblUsers_Qualifications= new Label();
            Label lblUsers_Type= new Label();     
            if(SignUp == true){
                    Tutor t = new Tutor();
                    ResultSet rs = t.TutorRetrieve(Tutor_Username , Tutor_Password);
                    while(rs.next()){
                        t.setTutorID(rs.getInt("TutorID"));
                        t.setTutorName(rs.getString("T_Name"));
                        t.setTutorPass(rs.getString("Tutors_Password"));
                        t.setTutorPrice(rs.getDouble("Tutor_Price"));
                        t.setTutorQualifications(rs.getString("Qualifications"));
                        t.setTutorSubjectArea(rs.getString("Subject_Area"));
                        t.setTutorType(rs.getString("Grind_Type"));
                        t.setTutorUsername(rs.getString("User_Name"));
                        t.setTutorLocation(rs.getDouble("Tutor_Location"));
                    }
                    lblUser_Name.setText(t.getTutorName());
                    lblUsers_Qualifications.setText(t.getQualifications());
                    lblUsers_Type.setText(user);
            } else if (LoggedIn == true){
                    Tutor t = new Tutor();
                    ResultSet rs = t.TutorRetrieve(Username_Logged , Password_Logged);
                    while(rs.next()){
                        t.setTutorID(rs.getInt("TutorID"));
                        t.setTutorName(rs.getString("T_Name"));
                        t.setTutorPass(rs.getString("Tutors_Password"));
                        t.setTutorPrice(rs.getDouble("Tutor_Price"));
                        t.setTutorQualifications(rs.getString("Qualifications"));
                        t.setTutorSubjectArea(rs.getString("Subject_Area"));
                        t.setTutorType(rs.getString("Grind_Type"));
                        t.setTutorUsername(rs.getString("User_Name"));
                        t.setTutorLocation(rs.getDouble("Tutor_Location"));
                    }
                    lblUser_Name.setText(t.getTutorName());
                    lblUsers_Qualifications.setText(t.getQualifications());
                    lblUsers_Type.setText(user);
            }        
            btnSettings.setStyle("-fx-background-color: transparent;");
            btnChat.setStyle("-fx-background-color: transparent;");
            userPicView.setFill(new ImagePattern(mainImage));
            SwipePage = new Scene(TinderTutorSwitcher.SwipeTView(btnSettings, logoView4, btnChat, userPicView, lblUser_Name, lblUsers_Qualifications,  lblUsers_Type) , 600 , 700);
            window.setScene(SwipePage);
            btnSettings.setOnAction(evt-> {
                try {
                    setSettingsScreen(user);
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnChat.setOnAction(p-> { 
                setOverviewScreen(user);
            });
            
        }
        
        public void setSettingsScreen(String user) throws SQLException{
            //Tinder Tutor Settings View 
            Label lblUserName = new Label();
            Label lblUsersType = new Label();
            Label lblModuleCode = new Label();
            
            /*This checks first what type of user it is to know which function to
            perform search on for users data but also in this operation you need to identify whether 
            the user is just after signing up or just logging in and pull the username and password from 
            different places accordingly and pass them as the parameters for the function to retrieve the users data
            */
            if(user == "Student"){
                if (SignUp == true){
                    Student st = new Student();
                    ResultSet rs = st.StudentRetrieve(Student_Username ,Student_Password);
                    while(rs.next()){
                        st.setStudentID(rs.getInt("StudentID"));
                        st.setStudentLocation(rs.getDouble("Student_Location"));
                        st.setStudentModule(rs.getString("College_ModuleCode"));
                        st.setStudentName(rs.getString("S_Name"));
                        st.setStudentPass(rs.getString("Students_Password"));
                        st.setStudentPrice(rs.getDouble("Student_Price"));
                        st.setStudentType(rs.getString("Grind_Type"));
                        st.setStudentUsername(rs.getString("User_Name"));
                        st.setStudentYear(rs.getString("College_Year"));
                    }
                    lblUserName.setText(st.getStudentName());
                    lblModuleCode.setText(st.getStudentModuleCode());
                    lblUsersType.setText(user);
                } else if (LoggedIn == true){
                    Student st = new Student();
                    ResultSet rs = st.StudentRetrieve( Username_Logged , Password_Logged );
                    while(rs.next()){
                        st.setStudentID(rs.getInt("StudentID"));
                        st.setStudentLocation(rs.getDouble("Student_Location"));
                        st.setStudentModule(rs.getString("College_ModuleCode"));
                        st.setStudentName(rs.getString("S_Name"));
                        st.setStudentPass(rs.getString("Students_Password"));
                        st.setStudentPrice(rs.getDouble("Student_Price"));
                        st.setStudentType(rs.getString("Grind_Type"));
                        st.setStudentUsername(rs.getString("User_Name"));
                        st.setStudentYear(rs.getString("College_Year"));
                    }
                    lblUserName.setText(st.getStudentName());
                    lblModuleCode.setText(st.getStudentModuleCode());
                    lblUsersType.setText(user);
                }
            } else if (user == "Tutor"){
                if(SignUp == true){
                    Tutor t = new Tutor();
                    ResultSet rs = t.TutorRetrieve(Tutor_Username , Tutor_Password);
                    while(rs.next()){
                        t.setTutorID(rs.getInt("TutorID"));
                        t.setTutorName(rs.getString("T_Name"));
                        t.setTutorPass(rs.getString("Tutors_Password"));
                        t.setTutorPrice(rs.getDouble("Tutor_Price"));
                        t.setTutorQualifications(rs.getString("Qualifications"));
                        t.setTutorSubjectArea(rs.getString("Subject_Area"));
                        t.setTutorType(rs.getString("Grind_Type"));
                        t.setTutorUsername(rs.getString("User_Name"));
                        t.setTutorLocation(rs.getDouble("Tutor_Location"));
                    }
                    lblUserName.setText(t.getTutorName());
                    lblModuleCode.setText(t.getQualifications());
                    lblUsersType.setText(user);
                } else if (LoggedIn == true){
                    Tutor t = new Tutor();
                    ResultSet rs = t.TutorRetrieve(Username_Logged , Password_Logged);
                    while(rs.next()){
                        t.setTutorID(rs.getInt("TutorID"));
                        t.setTutorName(rs.getString("T_Name"));
                        t.setTutorPass(rs.getString("Tutors_Password"));
                        t.setTutorPrice(rs.getDouble("Tutor_Price"));
                        t.setTutorQualifications(rs.getString("Qualifications"));
                        t.setTutorSubjectArea(rs.getString("Subject_Area"));
                        t.setTutorType(rs.getString("Grind_Type"));
                        t.setTutorUsername(rs.getString("User_Name"));
                        t.setTutorLocation(rs.getDouble("Tutor_Location"));
                    }
                    lblUserName.setText(t.getTutorName());
                    lblModuleCode.setText(t.getQualifications());
                    lblUsersType.setText(user);
                }
            } 
            Button btnUserProfile = new Button("My Profile");
            userPicView.setFill(new ImagePattern(mainImage));
            btnBack.setStyle("-fx-background-radius: 20px; -fx-padding: 4 70; -fx-background-color: white; -fx-text-fill: #ef5350; -fx-font-weight: bold ; -fx-border-color:#ef5350; -fx-border-radius: 20px;");
            btnUserProfile.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            SettingsPage = new Scene(TinderTutorSwitcher.SettingsView(settingsView, formatView ,userPicView , lblUserName , lblModuleCode,lblUsersType ,  btnUserProfile , btnBack ,logoPlusView), 600, 700);
            window.setScene(SettingsPage);
            btnBack.setOnAction(y->{
                if(user== "Student"){
                    try { 
                        setMainSwipeScreenS();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (user == "Tutor"){
                    try { 
                        setMainSwipeScreenT();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            btnUserProfile.setOnAction(evet -> {
                if(user == "Student"){
                    try {
                        setUpdateStudentView();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if(user == "Tutor"){
                    try {
                        setUpdateTutorView();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        
        public void setOverviewScreen(String user){
            Label grindsLabel = new Label("Matches");
            ScrollPane scrollGrinds = new ScrollPane();
            Label NearestLabel = new Label("Nearby"); 
            ScrollPane scrollNearby = new ScrollPane();
            Label grindsMessages = new Label("Messages"); 
            ScrollPane scrollMessages =  new ScrollPane();
            btnBack.setStyle("-fx-background-radius: 20px; -fx-padding: 4 70; -fx-background-color: white; -fx-text-fill: #ef5350; -fx-font-weight: bold ; -fx-border-color:#ef5350; -fx-border-radius: 20px;");
            try{
               if(user == "Student"){
                   
               } else if(user == "Tutor"){
                   
               }
               
            } catch(Exception e){
               System.out.println(e);
            }
           
           OverviewScreen = new Scene(TinderTutorSwitcher.NotificationOverviewView(chatView, formatView, grindsLabel, scrollGrinds, NearestLabel, scrollNearby, grindsMessages, scrollMessages , btnBack), 600, 700);
           window.setScene(OverviewScreen);
           btnBack.setOnAction(y->{
                if(user== "Student"){
                    try { 
                        setMainSwipeScreenS();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (user == "Tutor"){
                    try { 
                        setMainSwipeScreenT();
                    } catch (SQLException ex) {
                        Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
           
           
        }
        
        /*Based on the fact we just worked out whether the user was a tutor or a student that was logged in through
        our global variable we have updated the update my profile view so it only looks in a student table and takes 
        the username and password we entered through our other global variable and finds a record which matches the 
        conditions and then returns it in a result set which we break down and assign to our student properties for
        easy retrieval further on in the program.
        */
        public String setUpdateStudentView() throws SQLException{
            Student st = new Student();
            if(SignUp == true){
                ResultSet rs = st.StudentRetrieve(Student_Username ,Student_Password);
                while(rs.next()){
                    st.setStudentID(rs.getInt("StudentID"));
                    st.setStudentLocation(rs.getDouble("Student_Location"));
                    st.setStudentModule(rs.getString("College_ModuleCode"));
                    st.setStudentName(rs.getString("S_Name"));
                    st.setStudentPass(rs.getString("Students_Password"));
                    st.setStudentPrice(rs.getDouble("Student_Price"));
                    st.setStudentType(rs.getString("Grind_Type"));
                    st.setStudentUsername(rs.getString("User_Name"));
                    st.setStudentYear(rs.getString("College_Year"));
                }
            } else if(LoggedIn == true){
                ResultSet rs = st.StudentRetrieve(Username_Logged , Password_Logged);
                while(rs.next()){
                    st.setStudentID(rs.getInt("StudentID"));
                    st.setStudentLocation(rs.getDouble("Student_Location"));
                    st.setStudentModule(rs.getString("College_ModuleCode"));
                    st.setStudentName(rs.getString("S_Name"));
                    st.setStudentPass(rs.getString("Students_Password"));
                    st.setStudentPrice(rs.getDouble("Student_Price"));
                    st.setStudentType(rs.getString("Grind_Type"));
                    st.setStudentUsername(rs.getString("User_Name"));
                    st.setStudentYear(rs.getString("College_Year"));
                }
            }
            
            ID_LoggedIN = String.valueOf(st.getStudentID());
            btnSignUpSReal.setText("Update");
            txtSUsers_Name.setText(st.getStudentName());
            txtSUsers_Username.setText(st.getStudentUsername());
            txtSUsers_Pass.setText(st.getStudentPass());
            txtSUsers_Year.setText(st.getStudentYear());
            txtSUsers_ModuleCode.setText(st.getStudentModuleCode());
            SlocationSlider.setValue(st.getStudentLocation());
            StypeComboBox.setValue(st.getStudentType());
            txtSPreferredPrice.setText(String.valueOf(st.getStudentPrice()));
            setSignUpStudentScreen();
            btnSignUpSReal.setOnAction(t-> {
                try {
                    StudentUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnBack.setOnAction(s->{
                try { 
                    setSettingsScreen(user);
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            return ID_LoggedIN;
        }
        
        public String setUpdateTutorView() throws SQLException{
            Tutor t = new Tutor();
            if(SignUp== true){
                ResultSet rs = t.TutorRetrieve(Tutor_Username ,Tutor_Password);
                while(rs.next()){
                    t.setTutorID(rs.getInt("TutorID"));
                    t.setTutorName(rs.getString("T_Name"));
                    t.setTutorPass(rs.getString("Tutors_Password"));
                    t.setTutorPrice(rs.getDouble("Tutor_Price"));
                    t.setTutorQualifications(rs.getString("Qualifications"));
                    t.setTutorSubjectArea(rs.getString("Subject_Area"));
                    t.setTutorType(rs.getString("Grind_Type"));
                    t.setTutorUsername(rs.getString("User_Name"));
                    t.setTutorLocation(rs.getDouble("Tutor_Location"));
                }
            } else if(LoggedIn == true){
                ResultSet rs = t.TutorRetrieve(Username_Logged ,Password_Logged);
                while(rs.next()){
                    t.setTutorID(rs.getInt("TutorID"));
                    t.setTutorName(rs.getString("T_Name"));
                    t.setTutorPass(rs.getString("Tutors_Password"));
                    t.setTutorPrice(rs.getDouble("Tutor_Price"));
                    t.setTutorQualifications(rs.getString("Qualifications"));
                    t.setTutorSubjectArea(rs.getString("Subject_Area"));
                    t.setTutorType(rs.getString("Grind_Type"));
                    t.setTutorUsername(rs.getString("User_Name"));
                    t.setTutorLocation(rs.getDouble("Tutor_Location"));
                }
            }
            
            System.out.println(t.getTutorName());
            ID_LoggedIN = String.valueOf(t.getTutorID());
            btnSignUpTReal.setText("Update");
            txtTUsers_Name.setText(t.getTutorName());
            txtTUsers_Username.setText(t.getTutorUsername());
            txtTUsers_Pass.setText(t.getTutorPass());
            txtTUsers_SubjectArea.setText(t.getTutorSubjectArea());
            txtTUsers_Qualifications.setText(t.getQualifications());
            TlocationSlider.setValue(t.getTutorLocation());
            TtypeComboBox.setValue(t.getTutorType());
            txtTPreferredPrice.setText(String.valueOf(t.getTutorPrice()));
            setSignUpTutorScreen();
            btnSignUpTReal.setOnAction(l -> {
                try {
                    TutorUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnBack.setOnAction(s->{
                try { 
                    setSettingsScreen(user);
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            return ID_LoggedIN;
            
        }
        
        public void setGrindRecievedScreen(){
            //Tinder tutor grind recieved page 
            Label lblGrindRecievedConfirmation = new Label("This tutor is available for a grind with you !");
            Button btnMessageUser = new Button("Message...");
            TutorPicView.setFill(new ImagePattern(mainImage));
            StudentPicView.setFill(new ImagePattern(mainImage));
            lblGrindRecievedConfirmation.setStyle("-fx-font-size : 20;");
            GrindRecieved = new Scene(TinderTutorSwitcher.GrindRecievedView(logoView3, picGrindRecieved, StudentPicView, TutorPicView, lblGrindRecievedConfirmation, btnMessageUser), 600 ,700);
            window.setScene(GrindRecieved);
            btnMessageUser.setOnAction(o-> {
                setMessageScreen();
            });
        }
        
        public void setMessageScreen(){
            //Tinder Tutor Message View 
            Label lblUsers_NameMessage = new Label("Peter Walsh");
            Label lblInvitation = new Label("Set up a grind with Peter");
            TextArea txtMessageMainArea = new TextArea();
            Button btnSendMessage = new Button("Send Message");
            Users_Pic.setFill(new ImagePattern(mainImage_Pic));
            txtMessageMainArea.setStyle("-fx-background-radius: 20px;");
            btnSendMessage.setStyle("-fx-background-radius: 20px; -fx-padding: 4 65; -fx-background-color: #ef5350; -fx-text-fill: white; -fx-font-weight: bold");
            MessageScreen = new Scene(TinderTutorSwitcher.MainMessageView(grindsView, formatView, lblUsers_NameMessage, Users_Pic, lblInvitation, FormatBottomView, txtMessageMainArea , btnSendMessage), 600 ,700);
            window.setScene(MessageScreen);
            btnSendMessage.setOnAction(e->{
                String text = txtMessageMainArea.getText();
                Student st = new Student();
                Tutor t = new Tutor();
                int t_id = 9;
                int s_id = st.getStudentID();
                try {
                    ID_LoggedIN = setUpdateStudentView();
                    s_id = Integer.valueOf(ID_LoggedIN);
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                try {
                    sendMessage(text , t_id , s_id );
                } catch (SQLException ex) {
                    Logger.getLogger(TinderTutorMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        
        
        //This function simply clears all the textboxes and is called once the student is signed up
        public void wipesStudentDisplay(){
            txtSUsers_Name.clear();
            txtSUsers_Username.clear();
            txtSUsers_Pass.clear();
            txtSUsers_Year.clear();
            txtSUsers_ModuleCode.clear();
            txtSPreferredPrice.clear(); 
        }
        
        //This function simply clears all the textboxes and is called once the tutor is signed up
        public void wipesTutorDisplay(){
            txtTUsers_Name.clear();
            txtTUsers_Username.clear();
            txtTUsers_Pass.clear();
            txtTUsers_SubjectArea.clear();
            txtTUsers_Qualifications.clear();
            txtTPreferredPrice.clear();
        }
        
        
        //This function is going to take all the values as they are in the updated screen and update our database accordingly 
        public void StudentUpdate() throws SQLException{
            Student st = new Student();
            String Student_ID = setUpdateStudentView();
            int Student_IntID = Integer.valueOf(Student_ID);
            st.setStudentLocation(SlocationSlider.getValue());
            st.setStudentModule(txtSUsers_ModuleCode.getText());
            st.setStudentName(txtSUsers_Name.getText());
            st.setStudentPass(txtSUsers_Pass.getText());
            st.setStudentPrice(Double.valueOf(txtSPreferredPrice.getText()));
            st.setStudentType(StypeComboBox.getValue().toString());
            st.setStudentUsername(txtSUsers_Username.getText());
            st.setStudentYear(txtSUsers_Year.getText());
            
            Student_Name = st.getStudentName();
            Student_Username = st.getStudentUsername();
            Student_Password = st.getStudentPass();
            Student_Year = st.getStudentYear();
            Student_ModuleCode = st.getStudentModuleCode();
            Student_Location = st.getStudentLocation();
            Student_Type = st.getStudentType();
            Student_Price = st.getStudentPrice();
            try{
                    Boolean StudentUpdate = st.StudentUpdate(Student_IntID , Student_Name, Student_Username, Student_Password, Student_Year, Student_ModuleCode, round(Student_Location,2), Student_Type , Student_Price );
                    if(StudentUpdate){
                        Alert SuccessUser = new Alert(Alert.AlertType.CONFIRMATION,  "You've successfully updated your data");
                        SuccessUser.setTitle("Unreal");
                        SuccessUser.showAndWait();
                        System.out.println(Student_ModuleCode);
                        System.out.println(Student_IntID);
                    }
                } catch(Exception t){
                      System.out.println(t);
            }
            
        }
        
        public void TutorUpdate() throws SQLException{
            Tutor t = new Tutor();
            String Tutor_ID = setUpdateTutorView();
            int Tutor_IntID = Integer.valueOf(Tutor_ID);
            t.setTutorLocation(TlocationSlider.getValue());
            t.setTutorName(txtTUsers_Name.getText());
            t.setTutorPass(txtTUsers_Pass.getText());
            t.setTutorPrice(Double.valueOf(txtTPreferredPrice.getText()));
            t.setTutorQualifications(txtTUsers_Qualifications.getText());
            t.setTutorSubjectArea(txtTUsers_SubjectArea.getText());
            t.setTutorType(TtypeComboBox.getValue().toString());
            t.setTutorUsername(txtTUsers_Username.getText());
            
            Tutor_Name = t.getTutorName();
            Tutor_Username = t.getTutorUsername();
            Tutor_Password = t.getTutorPass();
            Tutor_SubjectArea = t.getTutorSubjectArea();
            Tutor_Qualifications = t.getQualifications();
            Tutor_Location = t.getTutorLocation();
            Tutor_Type = t.getTutorType();
            Tutor_Price = t.getTutorPrice();
            try{
                      Boolean StudentUpdate = t.TutorUpdate(Tutor_IntID , Tutor_Name, Tutor_Username, Tutor_Password, Tutor_SubjectArea, Tutor_Qualifications, round(Tutor_Location,2), Tutor_Type , Tutor_Price );
                      if(StudentUpdate){
                          Alert SuccessUser = new Alert(Alert.AlertType.CONFIRMATION,  "You've successfully updated your data");
                          SuccessUser.setTitle("Unreal");
                          SuccessUser.showAndWait();
                          System.out.println(Tutor_Qualifications);
                          System.out.println(Tutor_IntID);
                      }
                } catch(Exception u){
                      System.out.println(u);
            }
            
        }
        
        
       
        
        
        
    @Override
    public void start(Stage primaryStage) {
        
        //Setting up the primaryStage to be switchable
        window = primaryStage;
        //Calling the function to Style all our objects that need to go on Main scene
        setMainScreen();

    } 
}
