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
public class TinderTutorWaitScreen {
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
    
}
