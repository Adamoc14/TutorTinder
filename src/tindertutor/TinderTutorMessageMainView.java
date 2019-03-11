/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author sophiewalker
 */
public class TinderTutorMessageMainView {
    public VBox MessageView(ImageView messageView, ImageView formatView ,  Label lblUserName, Circle userPicView , Label lblInvitation, ImageView formatLineView, TextField txtMainMessageField, Button btnMessageSend){
        
        VBox topImageView = new VBox(messageView); 
        topImageView.setAlignment(Pos.TOP_CENTER);
        topImageView.setMargin(messageView , new Insets(20, 0,0,0));
        
        HBox topLineView = new HBox(formatView);
        topLineView.setAlignment(Pos.TOP_LEFT);
        topLineView.setMargin(formatView, new Insets(-80,0,-60,-25));
        
        VBox middleMessageView = new VBox(lblUserName , userPicView , lblInvitation);
//        topSwipeView.setMargin(btnSettings, new Insets(10,80,0,0));
//        topSwipeView.setMargin(btnChat, new Insets(12,0,0,80));
        middleMessageView.setAlignment(Pos.TOP_CENTER);
        
        HBox middleMessageLineView = new HBox(formatLineView);
        middleMessageLineView.setAlignment(Pos.BOTTOM_CENTER);
//        middleSwipeView.setMargin(mainPicView, new Insets(0,0,20,0));
        
        HBox bottomMessageView = new HBox(txtMainMessageField ,btnMessageSend );
        bottomMessageView.setAlignment(Pos.BOTTOM_CENTER);
//        labelsView.setMargin(lblUsers_Name , new Insets(0,0,0,-100));
//        labelsView.setMargin(lblUsers_Qualification , new Insets(0,0,0,-100));
//        labelsView.setMargin(lblUsers_Subject , new Insets(0,0,0,-100));
//        labelsView.setMargin(lblUsers_Location , new Insets(0,0,0,-100));
//        labelsView.setMargin(lblUsers_Price , new Insets(0,0,0,-100));
        
        
        VBox overallLayout = new VBox(5,topImageView,topLineView , middleMessageView , middleMessageLineView , bottomMessageView);
        
        
     return overallLayout;   
    
    }
}