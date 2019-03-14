/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author adamoc
 */
public class TinderTutorSignUpTutor {
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
        
        
        
        
        return layout;

    }
    
}
