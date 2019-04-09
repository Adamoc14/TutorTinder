/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author adamoc
 */
public class SwitchView {
    
    //The function to return the main start view to the app 
    public VBox MainView(ImageView logoView, Button btnLogin, Button btnSignUp, Button btnLinkedIn, Button btnFacebook, Button btnGooglePlus){
    // Setting the images position
       HBox imagePos = new HBox(logoView);
       imagePos.setAlignment(Pos.CENTER);
       imagePos.setMargin(logoView , new Insets(-50 ,0,0,0));
       
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
        VBox layout = new VBox(20 ,imagePos , buttonsPos , socialButtons);
        layout.setStyle("-fx-background-color: #ffffff");
        layout.setAlignment(Pos.CENTER);
        return layout;
    }

  //The function to return the login view to the app 
     public VBox LoginView(ImageView imageview ,Label lblSignIn , TextField txtUsername , PasswordField txtPassword , Label forgotPass , Button btnBack , Button btnLoginReal){
        
        VBox firstLayout = new VBox(20,imageview ,lblSignIn , txtUsername , txtPassword , forgotPass );
        firstLayout.setAlignment(Pos.CENTER);
        
        HBox secondLayout = new HBox(btnBack , btnLoginReal);
        secondLayout.setAlignment(Pos.CENTER);
        secondLayout.setSpacing(10);
         
        VBox layout = new VBox(20,firstLayout , secondLayout);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ffffff");
        
        
        return layout;

    }
     
     
   //Th function to return the sign up view to the app 
     public VBox SignUpView( Button btnBackArrow , ImageView logoView, Label lblSignUp , Label lbluserType , Button btnStudent , Button btnTeacher , Label lblStudent , Label lblTeacher){
        
        VBox VtopView = new VBox( btnBackArrow); 
        VtopView.setAlignment(Pos.TOP_LEFT);
        
         
        VBox topView = new VBox( logoView,  lblSignUp, lbluserType); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(logoView, new Insets(-10,0,0,0));
        topView.setMargin(lblSignUp, new Insets(-10,0,0,0));
        topView.setMargin(lbluserType, new Insets(30,0,0,0));
        
        HBox middleView = new HBox(btnStudent , btnTeacher);
        middleView.setAlignment(Pos.CENTER);
        middleView.setMargin(btnStudent, new Insets(10,0,0,0));
        middleView.setMargin(btnTeacher, new Insets(10,0,0,0));
        
        
        HBox bottomView = new HBox(lblStudent , lblTeacher);
        bottomView.setAlignment(Pos.BOTTOM_CENTER);
        bottomView.setSpacing(150);
        
        VBox layout = new VBox(20 , VtopView, topView , middleView , bottomView);
        
        layout.setStyle("-fx-background-color: #ffffff");
        return layout;

    }
     
    //The function to return the Student Sign up view
     public VBox SignUpStudentView( ImageView logoView2 , Label lblStudentProf , Circle mainPicView , Label lblSUsers_Name , TextField txtSUsers_Name , Label lblSUsers_Username , TextField txtSUsers_Username , Label lblSUsers_Pass , PasswordField txtSUsers_Pass , ImageView loginDetails , Label lblSUsers_Year ,  TextField txtSUsers_Year ,  Label lblSUsers_ModuleCode , TextField txtSUsers_ModuleCode ,Label lblSLocationSlider, Slider SlocationSlider ,  Label lblSUsers_Type , ComboBox StypeComboBox , Label lblSUsers_PreferredPrice , TextField txtSPreferredPrice , Button btnBack ,  Button btnSignUpSReal ){
        
        HBox topLogoView = new HBox(logoView2); 
        topLogoView.setAlignment(Pos.TOP_RIGHT);

        HBox topViewLabel = new HBox(lblStudentProf);
        topViewLabel.setAlignment(Pos.TOP_CENTER);
        topViewLabel.setMargin(lblStudentProf ,new Insets(-40,0,0,0));
        
        HBox topUserImageView = new HBox(mainPicView , lblSUsers_Name , txtSUsers_Name);
        topUserImageView.setAlignment(Pos.CENTER_LEFT);
        topUserImageView.setMargin(mainPicView,new Insets(0,20,0,30));
        topUserImageView.setMargin(lblSUsers_Name, new Insets(-20,10,0,40));
        topUserImageView.setMargin(txtSUsers_Name, new Insets(-20,10,0,5));
        
        HBox topFirstView = new HBox(lblSUsers_Username ,txtSUsers_Username);
        topFirstView.setMargin(lblSUsers_Username, new Insets(-65,12,0,10));
        topFirstView.setMargin(txtSUsers_Username, new Insets(-65,12,0,5));
        topFirstView.setAlignment(Pos.CENTER);
        
        HBox topSecondView = new HBox(lblSUsers_Pass ,txtSUsers_Pass);
        topSecondView.setMargin(lblSUsers_Pass, new Insets(-20,18,0,-10));
        topSecondView.setMargin(txtSUsers_Pass, new Insets(-20,20,0,0));
        topSecondView.setAlignment(Pos.CENTER);
        
        
        HBox topThirdView = new HBox(loginDetails);
        topThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFirstView = new HBox(lblSUsers_Year,txtSUsers_Year );
        topSecondView.setMargin(lblSUsers_Year, new Insets(0,18,0,10));
        topSecondView.setMargin(txtSUsers_Year, new Insets(0,20,0,5));
        middleFirstView.setAlignment(Pos.CENTER);
        
        HBox middleThirdView = new HBox(lblSUsers_ModuleCode , txtSUsers_ModuleCode );
        middleThirdView.setMargin(lblSUsers_ModuleCode, new Insets(0,18,0,-20));
        middleThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFourthView = new HBox(lblSLocationSlider , SlocationSlider );
        middleFourthView.setMargin(lblSLocationSlider , new Insets(0,18,0,-80));
        middleFourthView.setAlignment(Pos.CENTER);
        
        HBox middleFifthView = new HBox(lblSUsers_Type , StypeComboBox);
        middleFifthView.setMargin(lblSUsers_Type, new Insets(0,18,0,-20));
        middleFifthView.setAlignment(Pos.CENTER);
        
        HBox middleSixthView = new HBox(lblSUsers_PreferredPrice, txtSPreferredPrice );
        middleSixthView.setMargin(lblSUsers_PreferredPrice, new Insets(0,18,0,-20));
        middleSixthView.setAlignment(Pos.CENTER);
                
        HBox middleLastView = new HBox(btnBack, btnSignUpSReal);
        middleLastView.setAlignment(Pos.CENTER);
        middleLastView.setSpacing(10);
        
        
        VBox layout = new VBox(20 ,topLogoView , topViewLabel ,topUserImageView,topFirstView, topSecondView , topThirdView , middleFirstView , middleThirdView, middleFourthView, middleFifthView , middleSixthView , middleLastView );
        
        
        layout.setStyle("-fx-background-color: #ffffff");
        
        return layout;

    }
     
    //The function to return the Tutor Sign up view
      public VBox SignUpTutorView( ImageView logoView2 , Label lblTutorProf , Circle mainPicView , Label lblTUsers_Name , TextField txtTUsers_Name , Label lblTUsers_Username , TextField txtTUsers_Username , Label lblTUsers_Pass , PasswordField txtTUsers_Pass , ImageView loginDetails , Label lblTUsers_SubjectArea ,  TextField txtTUsers_SubjectArea , Label lblTUsers_Qualifications , TextField txtTUsers_Qualifications , Label lblTLocationSlider, Slider TlocationSlider ,  Label lblTUsers_Type , ComboBox TtypeComboBox , Label lblTUsers_PreferredPrice , TextField txtTPreferredPrice , Button btnBack ,  Button btnSignUpTReal ){
        
        HBox topLogoView = new HBox(logoView2); 
        topLogoView.setAlignment(Pos.TOP_RIGHT);

        HBox topViewLabel = new HBox(lblTutorProf);
        topViewLabel.setAlignment(Pos.TOP_CENTER);
        topViewLabel.setMargin(lblTutorProf ,new Insets(-40,0,0,0));
        
        HBox topUserImageView = new HBox(mainPicView , lblTUsers_Name , txtTUsers_Name);
        topUserImageView.setAlignment(Pos.CENTER_LEFT);
        topUserImageView.setMargin(mainPicView,new Insets(0,20,0,30));
        topUserImageView.setMargin(lblTUsers_Name, new Insets(-20,10,0,40));
        topUserImageView.setMargin(txtTUsers_Name, new Insets(-20,10,0,5));
        
        HBox topFirstView = new HBox(lblTUsers_Username ,txtTUsers_Username);
        topFirstView.setMargin(lblTUsers_Username, new Insets(-65,12,0,10));
        topFirstView.setMargin(txtTUsers_Username, new Insets(-65,12,0,5));
        topFirstView.setAlignment(Pos.CENTER);
        
        HBox topSecondView = new HBox(lblTUsers_Pass ,txtTUsers_Pass);
        topSecondView.setMargin(lblTUsers_Pass, new Insets(-20,18,0,-10));
        topSecondView.setMargin(txtTUsers_Pass, new Insets(-20,20,0,0));
        topSecondView.setAlignment(Pos.CENTER);
        
        
        HBox topThirdView = new HBox(loginDetails);
        topThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFirstView = new HBox(lblTUsers_SubjectArea,txtTUsers_SubjectArea );
        topSecondView.setMargin(lblTUsers_SubjectArea, new Insets(0,18,0,10));
        topSecondView.setMargin(txtTUsers_SubjectArea, new Insets(0,20,0,5));
        middleFirstView.setAlignment(Pos.CENTER);
        
        HBox middleSecondView = new HBox(lblTUsers_Qualifications , txtTUsers_Qualifications);
        middleSecondView.setMargin(lblTUsers_Qualifications, new Insets(0,18,0,-10));
        middleSecondView.setMargin(txtTUsers_Qualifications, new Insets(0,20,0,10));
        middleSecondView.setAlignment(Pos.CENTER);
        
        
        HBox middleFourthView = new HBox(lblTLocationSlider , TlocationSlider );
        middleFourthView.setMargin(lblTLocationSlider , new Insets(0,18,0,-80));
        middleFourthView.setAlignment(Pos.CENTER);
        
        HBox middleFifthView = new HBox(lblTUsers_Type , TtypeComboBox);
        middleFifthView.setMargin(lblTUsers_Type, new Insets(0,18,0,-20));
        middleFifthView.setAlignment(Pos.CENTER);
        
        HBox middleSixthView = new HBox(lblTUsers_PreferredPrice, txtTPreferredPrice );
        middleSixthView.setMargin(lblTUsers_PreferredPrice, new Insets(0,18,0,-20));
        middleSixthView.setAlignment(Pos.CENTER);
        
        HBox middleLastView = new HBox(btnBack , btnSignUpTReal);
        middleLastView.setAlignment(Pos.CENTER);
        middleLastView.setSpacing(10);
        
        
        
        VBox layout = new VBox(20 ,topLogoView , topViewLabel ,topUserImageView,topFirstView, topSecondView , topThirdView , middleFirstView ,middleSecondView, middleFourthView, middleFifthView , middleSixthView , middleLastView );
        
        
        layout.setStyle("-fx-background-color: #ffffff");
        
        return layout;

    }
      
    //The function to return the Splashscreen Set Up view 
    public VBox WaitScreenView(Label lblTitle , ImageView tinderTutorSplashscreen , Label lblTagLine , Button btnContinue){
        
        HBox topView = new HBox(lblTitle);
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(lblTitle , new Insets(60 , 0,0,0));
        
        HBox middleView = new HBox(tinderTutorSplashscreen);
        middleView.setAlignment(Pos.CENTER);
        middleView.setMargin(tinderTutorSplashscreen , new Insets(50 , 0,0,0));
        
        HBox bottomView = new HBox(lblTagLine);
        bottomView.setAlignment(Pos.BOTTOM_CENTER);
        bottomView.setMargin(lblTagLine , new Insets(30 , 0,0,0));
        
        HBox lastView = new HBox(btnContinue);
        lastView.setAlignment(Pos.BOTTOM_CENTER);
        lastView.setMargin(btnContinue , new Insets(50 , 0,0,0));
        
        
        VBox overallLayout = new VBox(topView , middleView , bottomView , lastView);
        overallLayout.setStyle("-fx-background-color: #ffffff");
        
        return overallLayout;
        
    }
    
    public StackPane Tutor_UsersView(Rectangle rect , Circle userPicView , Label lblUser_Name , Label  lblUsers_Subject , Label lblUsers_Location , Label lblUsers_Type ){
            
            
            VBox userPicViewLayout = new VBox(userPicView);
            userPicViewLayout.setAlignment(Pos.BOTTOM_CENTER);
            userPicViewLayout.setMargin(userPicView, new Insets(0,0,20,0));

            VBox labelsView = new VBox(lblUser_Name, lblUsers_Subject , lblUsers_Location , lblUsers_Type);
            labelsView.setAlignment(Pos.BOTTOM_CENTER);
            
            VBox OverallLayout = new VBox(userPicViewLayout , labelsView);
            labelsView.setAlignment(Pos.CENTER);
            
            StackPane stack = new StackPane(rect , OverallLayout);
            
            
            return stack;
    }
    
    //The function to return the main swipe page 
    public VBox SwipeView(Button btnSettings , ImageView logoView4 , Button btnChat , StackPane Tutor_Users ,   Button btnCheckNo, Button btnCheckYes  ){
        HBox topSwipeView = new HBox(btnSettings , logoView4 , btnChat); 
        topSwipeView.setMargin(btnSettings, new Insets(10,80,0,0));
        topSwipeView.setMargin(btnChat, new Insets(12,0,0,80));
        topSwipeView.setAlignment(Pos.TOP_CENTER);

        
        VBox middleSwipeView = new VBox(Tutor_Users);
        middleSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        middleSwipeView.setMargin(Tutor_Users, new Insets(0,0,20,0));

        
        HBox bottomSwipeView = new HBox( btnCheckNo , btnCheckYes );
        bottomSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        bottomSwipeView.setStyle("-fx-background-image: url('Assets/FormattingMain.png')");
        bottomSwipeView.setMargin(btnCheckYes, new Insets(30,0,0,10));
        bottomSwipeView.setMargin(btnCheckNo, new Insets(30,10,0,0));
       
        
        VBox overallLayout = new VBox(5, topSwipeView , middleSwipeView , bottomSwipeView);
        overallLayout.setStyle("-fx-background-color: #ffffff");
        
     return overallLayout;   
        
    }
    public VBox SwipeTView(Button btnSettings , ImageView logoView4 , Button btnChat , Circle userPicView , Label lblUser_Name , Label lblQualifications, Label lblUsers_Type ){
        HBox topSwipeView = new HBox(btnSettings , logoView4 , btnChat);
        topSwipeView.setMargin(btnSettings, new Insets(10,80,0,0));
        topSwipeView.setMargin(btnChat, new Insets(12,0,0,80));
        topSwipeView.setAlignment(Pos.TOP_CENTER);
        
        VBox middleSwipeView = new VBox(userPicView);
        middleSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        middleSwipeView.setMargin(userPicView, new Insets(0,0,20,0));
        
        VBox labelsView = new VBox(lblUser_Name, lblQualifications , lblUsers_Type);
        labelsView.setAlignment(Pos.BOTTOM_CENTER);
        
        VBox overallLayout = new VBox(5, topSwipeView , middleSwipeView , labelsView );
        overallLayout.setStyle("-fx-background-color: #ffffff");
        
     return overallLayout;   
        
    }
    
    public VBox NotificationOverviewView(ImageView chatView, ImageView formatView , Label grindsLabel , ScrollPane scrollGrinds , Label NearestLabel , ScrollPane scrollNearby , Label grindsMessages , ScrollPane scrollMessages , Button btnBack ){
        VBox topView = new VBox(chatView); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(chatView , new Insets(20, 0,0,0));
        
        HBox middleView = new HBox(formatView);
        middleView.setAlignment(Pos.TOP_LEFT);
        middleView.setMargin(formatView, new Insets(-80,0,-60,-25));
        
        HBox thirdView = new HBox(grindsLabel);
        thirdView.setAlignment(Pos.TOP_LEFT);
        
        HBox fourthView = new HBox(scrollGrinds);
        fourthView.setAlignment(Pos.CENTER_LEFT);
        
        HBox fifthView = new HBox(NearestLabel);
        fifthView.setAlignment(Pos.CENTER_LEFT);
        
        HBox sixthView = new HBox(scrollNearby);
        sixthView.setAlignment(Pos.BOTTOM_LEFT);
        
        HBox seventhView = new HBox(grindsMessages);
        seventhView.setAlignment(Pos.BOTTOM_LEFT);
        
        HBox eigthView = new HBox(scrollMessages);
        eigthView.setAlignment(Pos.BASELINE_LEFT);
        
        HBox ninthView = new HBox(btnBack);
        ninthView.setAlignment(Pos.BASELINE_CENTER);
        
        
        VBox ovLayout= new VBox(20, topView , middleView , thirdView , fourthView , fifthView , sixthView , seventhView , eigthView , ninthView );
        ovLayout.setStyle("-fx-background-color: #ffffff");
        return ovLayout;
        
    }
    
    //the function to return the Grind Recieved View 
    public VBox GrindRecievedView( ImageView logoView3 , ImageView picGrindRecieved , Circle StudentPicView ,  Circle TutorPicView , Label lblGrindRecievedConfirmation , Button btnMessageUser ){
        
        HBox firstHBox = new HBox(logoView3);
        firstHBox.setAlignment(Pos.TOP_CENTER);
        
        HBox secondHBox = new HBox(picGrindRecieved);
        secondHBox.setAlignment(Pos.CENTER);
        
        HBox thirdHBox = new HBox(StudentPicView , TutorPicView);
        thirdHBox.setAlignment(Pos.BOTTOM_CENTER);
        thirdHBox.setMargin(StudentPicView , new Insets(0,30,0,30));
        thirdHBox.setMargin(TutorPicView , new Insets(0,30,0,30));
        
        VBox fourthHBox = new VBox(lblGrindRecievedConfirmation);
        fourthHBox.setAlignment(Pos.CENTER);
        fourthHBox.setMargin(lblGrindRecievedConfirmation , new Insets(70 , 0 , 0 , 0));
        
        HBox fifthHBox = new HBox(btnMessageUser);
        fifthHBox.setAlignment(Pos.BASELINE_CENTER);
        fifthHBox.setMargin(btnMessageUser , new Insets(30 , 0 , 0 , 0));
        
        
        
        VBox ovLayout= new VBox(20, firstHBox ,secondHBox , thirdHBox , fourthHBox , fifthHBox);
        ovLayout.setStyle("-fx-background-color: #ffffff");
        return ovLayout;
    }
    
    //The function to return the Settings View 
    public VBox SettingsView( ImageView settingsView, ImageView formatView , Circle userPicView , Label lblUserName , Label lblModuleCode, Label lblUsersType , Button btnUserProfile , Button btnBack , ImageView logoPlusView){
        
        VBox topView = new VBox(settingsView); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(settingsView , new Insets(20, 0,0,0));
        
        HBox middleView = new HBox(formatView);
        middleView.setAlignment(Pos.TOP_LEFT);
        middleView.setMargin(formatView, new Insets(-80,0,-60,-25));
        
        
        VBox bottomView = new VBox(userPicView , lblUserName,lblModuleCode,lblUsersType, btnUserProfile, btnBack , logoPlusView );
        bottomView.setMargin(lblUserName, new Insets(10 ,0,0,0));
        bottomView.setAlignment(Pos.BOTTOM_CENTER);
        bottomView.setSpacing(5);
        
        VBox layout = new VBox(20 ,topView , middleView , bottomView);
        
        
        layout.setStyle("-fx-background-color: #ffffff");
        
        return layout;

    }
    //The function to return the Message View
    public VBox MainMessageView(ImageView grindsView , ImageView formatView , Label lblUsers_NameMessage , Circle Users_Pic , Label lblInvitation , ImageView FormatBottomView , TextArea txtMessageMainArea , Button btnSendMessage){
        
         VBox topView = new VBox(grindsView); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(grindsView , new Insets(20, 0,0,0));
        
        HBox middleView = new HBox(formatView);
        middleView.setAlignment(Pos.TOP_LEFT);
        middleView.setMargin(formatView, new Insets(-80,0,-60,-25));
        
        VBox thirdView = new VBox(lblUsers_NameMessage , Users_Pic , lblInvitation );
        thirdView.setAlignment(Pos.CENTER);
        thirdView.setMargin(lblUsers_NameMessage , new Insets(10,0,0,0));
        thirdView.setMargin(Users_Pic , new Insets(10,0,0,0));
        thirdView.setMargin(lblInvitation , new Insets(10,0,0,0));
        
        HBox fourthView = new HBox(FormatBottomView);
        fourthView.setAlignment(Pos.BOTTOM_CENTER);
        
        HBox fifthView = new HBox(txtMessageMainArea);
        fifthView.setAlignment(Pos.BASELINE_CENTER);
        fifthView.setMargin(txtMessageMainArea , new Insets(20,0,0,0));
        
        
        HBox sixthView = new HBox(btnSendMessage);
        sixthView.setAlignment(Pos.BASELINE_CENTER);
        sixthView.setMargin(btnSendMessage , new Insets(20,0,0,0));
        
        
        VBox layout = new VBox(topView, middleView , thirdView , fourthView , fifthView , sixthView);
        layout.setStyle("-fx-background-color: #ffffff");
        return layout; 
    }
    
}
