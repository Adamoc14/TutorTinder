/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author adamoc
 */
public class TinderTutorMainSwipe{
    
    public VBox SwipeView(Button btnSettings , ImageView logoView , Button btnChat , ImageView mainPicView , Label lblUsers_Name , Label lblUsers_Qualification , Label lblUsers_Subject , Label lblUsers_Location , Label lblUsers_Price , Button btnCheckYes , Button btnCheckNo ){
        HBox topSwipeView = new HBox(btnSettings , logoView , btnChat);
        VBox middleSwipeView = new VBox(mainPicView ,lblUsers_Name, lblUsers_Qualification , lblUsers_Subject , lblUsers_Location , lblUsers_Price );
        HBox bottomSwipeView = new HBox(btnCheckYes , btnCheckYes);
        
        VBox overallLayout = new VBox(20);
        overallLayout.getChildren().addAll(topSwipeView,middleSwipeView ,bottomSwipeView);
     return overallLayout;   
        
    }

    /**
     * @param args the command line arguments
     */
}
