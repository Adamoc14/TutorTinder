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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author adamoc
 */
public class SwitchView {
  //The function to return the login view to the app 
     public VBox LoginView(ImageView imageview ,Label lblSignIn , TextField txtUsername , PasswordField txtPassword , Label forgotPass , Button btnLoginReal){
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(imageview ,lblSignIn , txtUsername , txtPassword , forgotPass ,btnLoginReal);
        layout.setStyle("-fx-background-color: #ffffff");
        
        
        return layout;

    }
     
     
   //Th function to return the sign up view to the app 
     public VBox SignUpView( ImageView logoView, Label lblSignUp , Label lbluserType , Button btnStudent , Button btnTeacher , Label lblStudent , Label lblTeacher){
        
        VBox topView = new VBox( logoView,  lblSignUp, lbluserType); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(lbluserType, new Insets(70,0,0,0));
        
        HBox middleView = new HBox(btnStudent , btnTeacher);
        middleView.setAlignment(Pos.CENTER);
        middleView.setMargin(btnStudent, new Insets(10,0,0,0));
        middleView.setMargin(btnTeacher, new Insets(10,0,0,0));
        
        
        HBox bottomView = new HBox(lblStudent , lblTeacher);
        bottomView.setAlignment(Pos.BOTTOM_CENTER);
        bottomView.setSpacing(150);
        
        VBox layout = new VBox(20 ,topView , middleView , bottomView);
        
        
        
        layout.setStyle("-fx-background-color: #ffffff");
        return layout;

    }
     
    //The function to return the Student Sign up view
     public VBox SignUpStudentView( ImageView logoView2 , Label lblStudentProf , Circle mainPicView , Label lblUsers_Name , TextField txtUsers_Name , Label lblUsers_Email , TextField txtUsers_Email , Label lblUsers_Pass , PasswordField txtUsers_Pass , ImageView loginDetails , Label lblUsers_Year ,  TextField txtUsers_Year , Label lblUsers_Course , TextField txtUsers_Course , Label lblUsers_Module , TextField txtUsers_Module ,Label lblLocationSlider, Slider locationSlider , Label lblUsers_PreferredPrice , ComboBox priceComboBox , Label lblUsers_Type , RadioButton button1 , RadioButton button2 ,  Button btnSignUpReal ){
        
        HBox topLogoView = new HBox(logoView2); 
        topLogoView.setAlignment(Pos.TOP_RIGHT);

        HBox topViewLabel = new HBox(lblStudentProf);
        topViewLabel.setAlignment(Pos.TOP_CENTER);
        topViewLabel.setMargin(lblStudentProf ,new Insets(-40,0,0,0));
        
        HBox topUserImageView = new HBox(mainPicView , lblUsers_Name , txtUsers_Name);
        topUserImageView.setAlignment(Pos.CENTER_LEFT);
        topUserImageView.setMargin(mainPicView,new Insets(0,20,0,30));
        topUserImageView.setMargin(lblUsers_Name, new Insets(-20,10,0,40));
        topUserImageView.setMargin(txtUsers_Name, new Insets(-20,10,0,5));
        
        HBox topFirstView = new HBox(lblUsers_Email ,txtUsers_Email);
        topFirstView.setMargin(lblUsers_Email, new Insets(-65,12,0,10));
        topFirstView.setMargin(txtUsers_Email, new Insets(-65,12,0,5));
        topFirstView.setAlignment(Pos.CENTER);
        
        HBox topSecondView = new HBox(lblUsers_Pass ,txtUsers_Pass);
        topSecondView.setMargin(lblUsers_Pass, new Insets(-20,18,0,-10));
        topSecondView.setMargin(txtUsers_Pass, new Insets(-20,20,0,0));
        topSecondView.setAlignment(Pos.CENTER);
        
        
        HBox topThirdView = new HBox(loginDetails);
        topThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFirstView = new HBox(lblUsers_Year,txtUsers_Year );
        topSecondView.setMargin(lblUsers_Year, new Insets(0,18,0,10));
        topSecondView.setMargin(txtUsers_Year, new Insets(0,20,0,5));
        middleFirstView.setAlignment(Pos.CENTER);
        
        HBox middleSecondView = new HBox(lblUsers_Course , txtUsers_Course);
        middleSecondView.setMargin(lblUsers_Course, new Insets(0,18,0,-10));
        middleSecondView.setMargin(txtUsers_Course, new Insets(0,20,0,10));
        middleSecondView.setAlignment(Pos.CENTER);
        
        HBox middleThirdView = new HBox(lblUsers_Module , txtUsers_Module );
        middleThirdView.setMargin(lblUsers_Module, new Insets(0,18,0,-20));
        middleThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFourthView = new HBox(lblLocationSlider , locationSlider );
        middleFourthView.setMargin(lblLocationSlider , new Insets(0,18,0,-80));
        middleFourthView.setAlignment(Pos.CENTER);
        
        HBox middleFifthView = new HBox(lblUsers_PreferredPrice, priceComboBox );
        middleFifthView.setMargin(lblUsers_PreferredPrice, new Insets(0,18,0,-20));
        middleFifthView.setAlignment(Pos.CENTER);
        
        HBox middleSixthView = new HBox(lblUsers_Type , button1 , button2);
        
        middleSixthView.setAlignment(Pos.CENTER);
        
        HBox middleLastView = new HBox(btnSignUpReal);
        middleLastView.setAlignment(Pos.CENTER);
        
        
        
        VBox layout = new VBox(20 ,topLogoView , topViewLabel ,topUserImageView,topFirstView, topSecondView , topThirdView , middleFirstView ,middleSecondView, middleThirdView, middleFourthView, middleFifthView , middleSixthView , middleLastView );
        
        
        layout.setStyle("-fx-background-color: #ffffff");
        
        return layout;

    }
     
    //The function to return the Tutor Sign up view
      public VBox SignUpTutorView( ImageView logoView2 , Label lblTutorProf , Circle mainPicView , Label lblUsers_Name , TextField txtUsers_Name , Label lblUsers_Email , TextField txtUsers_Email , Label lblUsers_Pass , PasswordField txtUsers_Pass , ImageView loginDetails , Label lblUsers_RLinks ,  TextField txtUsers_RLinks , Label lblUsers_Qualifications , TextField txtUsers_Qualifications , Label lblUsers_Description , TextField txtUsers_Description ,Label lblLocationSlider, Slider locationSlider , Label lblUsers_PreferredPrice , ComboBox priceComboBox , Label lblUsers_Type , RadioButton button1 , RadioButton button2 ,  Button btnSignUpReal ){
        
        HBox topLogoView = new HBox(logoView2); 
        topLogoView.setAlignment(Pos.TOP_RIGHT);

        HBox topViewLabel = new HBox(lblTutorProf);
        topViewLabel.setAlignment(Pos.TOP_CENTER);
        topViewLabel.setMargin(lblTutorProf ,new Insets(-40,0,0,0));
        
        HBox topUserImageView = new HBox(mainPicView , lblUsers_Name , txtUsers_Name);
        topUserImageView.setAlignment(Pos.CENTER_LEFT);
        topUserImageView.setMargin(mainPicView,new Insets(0,20,0,30));
        topUserImageView.setMargin(lblUsers_Name, new Insets(-20,10,0,40));
        topUserImageView.setMargin(txtUsers_Name, new Insets(-20,10,0,5));
        
        HBox topFirstView = new HBox(lblUsers_Email ,txtUsers_Email);
        topFirstView.setMargin(lblUsers_Email, new Insets(-65,12,0,10));
        topFirstView.setMargin(txtUsers_Email, new Insets(-65,12,0,5));
        topFirstView.setAlignment(Pos.CENTER);
        
        HBox topSecondView = new HBox(lblUsers_Pass ,txtUsers_Pass);
        topSecondView.setMargin(lblUsers_Pass, new Insets(-20,18,0,-10));
        topSecondView.setMargin(txtUsers_Pass, new Insets(-20,20,0,0));
        topSecondView.setAlignment(Pos.CENTER);
        
        
        HBox topThirdView = new HBox(loginDetails);
        topThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFirstView = new HBox(lblUsers_RLinks,txtUsers_RLinks );
        topSecondView.setMargin(lblUsers_RLinks, new Insets(0,18,0,10));
        topSecondView.setMargin(txtUsers_RLinks, new Insets(0,20,0,5));
        middleFirstView.setAlignment(Pos.CENTER);
        
        HBox middleSecondView = new HBox(lblUsers_Qualifications , txtUsers_Qualifications);
        middleSecondView.setMargin(lblUsers_Qualifications, new Insets(0,18,0,-10));
        middleSecondView.setMargin(txtUsers_Qualifications, new Insets(0,20,0,10));
        middleSecondView.setAlignment(Pos.CENTER);
        
        HBox middleThirdView = new HBox(lblUsers_Description , txtUsers_Description );
        middleThirdView.setMargin(lblUsers_Description, new Insets(0,18,0,-20));
        middleThirdView.setAlignment(Pos.CENTER);
        
        HBox middleFourthView = new HBox(lblLocationSlider , locationSlider );
        middleFourthView.setMargin(lblLocationSlider , new Insets(0,18,0,-80));
        middleFourthView.setAlignment(Pos.CENTER);
        
        HBox middleFifthView = new HBox(lblUsers_PreferredPrice, priceComboBox );
        middleFifthView.setMargin(lblUsers_PreferredPrice, new Insets(0,18,0,-20));
        middleFifthView.setAlignment(Pos.CENTER);
        
        HBox middleSixthView = new HBox(lblUsers_Type , button1 , button2);
        
        middleSixthView.setAlignment(Pos.CENTER);
        
        HBox middleLastView = new HBox(btnSignUpReal);
        middleLastView.setAlignment(Pos.CENTER);
        
        
        
        VBox layout = new VBox(20 ,topLogoView , topViewLabel ,topUserImageView,topFirstView, topSecondView , topThirdView , middleFirstView ,middleSecondView, middleThirdView, middleFourthView, middleFifthView , middleSixthView , middleLastView );
        
        
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
    
    //The function to return the main swipe page 
    public VBox SwipeView(Button btnSettings , ImageView logoView4 , Button btnChat , Circle userPicView , Label lblUser_Name , Label lblUsers_Qualification , Label lblUsers_Subject , Label lblUsers_Location , Label lblUsers_Price ,  Button btnCheckNo, Button btnCheckYes  ){
        HBox topSwipeView = new HBox(btnSettings , logoView4 , btnChat);
        topSwipeView.setMargin(btnSettings, new Insets(10,80,0,0));
        topSwipeView.setMargin(btnChat, new Insets(12,0,0,80));
        topSwipeView.setAlignment(Pos.TOP_CENTER);
        
        VBox middleSwipeView = new VBox(userPicView);
        middleSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        middleSwipeView.setMargin(userPicView, new Insets(0,0,20,0));
        
        VBox labelsView = new VBox(lblUser_Name, lblUsers_Qualification , lblUsers_Subject , lblUsers_Location , lblUsers_Price);
        labelsView.setAlignment(Pos.BOTTOM_CENTER);
        labelsView.setMargin(lblUser_Name , new Insets(0,0,0,-100));
        labelsView.setMargin(lblUsers_Qualification , new Insets(0,0,0,-100));
        labelsView.setMargin(lblUsers_Subject , new Insets(0,0,0,-100));
        labelsView.setMargin(lblUsers_Location , new Insets(0,0,0,-100));
        labelsView.setMargin(lblUsers_Price , new Insets(0,0,0,-100));
        
        
        HBox bottomSwipeView = new HBox( btnCheckNo , btnCheckYes );
        bottomSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        bottomSwipeView.setStyle("-fx-background-image: url('Assets/FormattingMain.png')");
        bottomSwipeView.setMargin(btnCheckYes, new Insets(30,0,0,10));
        bottomSwipeView.setMargin(btnCheckNo, new Insets(30,10,0,0));
       
        
        VBox overallLayout = new VBox(5, topSwipeView , middleSwipeView , labelsView , bottomSwipeView);
        overallLayout.setStyle("-fx-background-color: #ffffff");
        
     return overallLayout;   
        
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
    public VBox SettingsView( ImageView settingsView, ImageView formatView , Circle userPicView , Label lblUserName , Label lblUsersType , Label lblUniName,  Button btnUserProfile , ImageView logoPlusView){
        
        VBox topView = new VBox(settingsView); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(settingsView , new Insets(20, 0,0,0));
        
        HBox middleView = new HBox(formatView);
        middleView.setAlignment(Pos.TOP_LEFT);
        middleView.setMargin(formatView, new Insets(-80,0,-60,-25));
        
        
        VBox bottomView = new VBox(userPicView , lblUserName,lblUsersType,lblUniName,btnUserProfile,logoPlusView );
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
