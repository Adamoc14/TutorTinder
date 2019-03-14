/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author adamoc
 */
public class TinderTutorSignUp {
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
        
        
        
        
        return layout;

    }
    
}
