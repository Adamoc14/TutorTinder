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
import javafx.scene.shape.Circle;

/**
 *
 * @author adamoc
 */
public class TinderTutorGrindRecieved {
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
}
