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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author adamoc
 */
public class TinderTutorMainMessageView {
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
