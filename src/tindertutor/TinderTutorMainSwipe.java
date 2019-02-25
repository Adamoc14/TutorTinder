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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author adamoc
 */
public class TinderTutorMainSwipe{
    
    public VBox SwipeView(Button btnSettings , ImageView logoView , Button btnChat , ImageView mainPicView , Label lblUsers_Name , Label lblUsers_Qualification , Label lblUsers_Subject , Label lblUsers_Location , Label lblUsers_Price , ImageView FormattingView,  Button btnCheckYes , Button btnCheckNo){
        HBox topSwipeView = new HBox(btnSettings , logoView , btnChat);
        topSwipeView.setMargin(btnSettings, new Insets(10,80,0,0));
        topSwipeView.setMargin(btnChat, new Insets(12,0,0,80));
        topSwipeView.setAlignment(Pos.TOP_CENTER);
        
        VBox middleSwipeView = new VBox(mainPicView ,lblUsers_Name, lblUsers_Qualification , lblUsers_Subject , lblUsers_Location , lblUsers_Price);
        middleSwipeView.setAlignment(Pos.BOTTOM_CENTER);
        middleSwipeView.setMargin(mainPicView, new Insets(0,0,20,0));
        
        HBox bottomSwipeView = new HBox(btnCheckNo, btnCheckYes);
        bottomSwipeView.setAlignment(Pos.TOP_CENTER);
        bottomSwipeView.setMargin(btnCheckNo, new Insets(0,80,0,0));
        bottomSwipeView.setMargin(btnCheckYes, new Insets(0,0,0,80));
        btnCheckYes.relocate(50, 100);
        
        VBox formatView = new VBox(FormattingView);
        formatView.setMargin(FormattingView, new Insets(0,0,0,0));
        formatView.setAlignment(Pos.BOTTOM_CENTER);
        
        VBox overallLayout = new VBox(20, topSwipeView , middleSwipeView , formatView, bottomSwipeView);
        
        
     return overallLayout;   
        
    }

    /**
     * @param args the command line arguments
     */
}
