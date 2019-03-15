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
public class TinderTutorMainSwipe{
    
    public VBox SwipeView(Button btnSettings , ImageView logoView , Button btnChat , Circle mainPicView , Label lblUsers_Name , Label lblUsers_Qualification , Label lblUsers_Subject , Label lblUsers_Location , Label lblUsers_Price ,  Button btnCheckNo, Button btnCheckYes  ){
        HBox topSwipeView = new HBox(btnSettings , logoView , btnChat);
        topSwipeView.setMargin(btnSettings, new Insets(10,80,0,0));
        topSwipeView.setMargin(btnChat, new Insets(12,0,0,80));
        topSwipeView.setAlignment(Pos.TOP_CENTER);
        
        VBox middleSwipeView = new VBox(mainPicView);
        middleSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        middleSwipeView.setMargin(mainPicView, new Insets(0,0,20,0));
        
        VBox labelsView = new VBox(lblUsers_Name, lblUsers_Qualification , lblUsers_Subject , lblUsers_Location , lblUsers_Price);
        labelsView.setAlignment(Pos.BOTTOM_CENTER);
        labelsView.setMargin(lblUsers_Name , new Insets(0,0,0,-100));
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

    /**
     * @param args the command line arguments
     */
}
