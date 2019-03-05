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
public class TinderTutorSettings {
     public VBox SettingsView( ImageView settingsView, ImageView formatView , Circle userPicView , Label lblUserName , Label lblUserType , Label lblUniName,  Button btnUserProfile , ImageView logoPlusView){
        
        VBox topView = new VBox(settingsView); 
        topView.setAlignment(Pos.TOP_CENTER);
        topView.setMargin(settingsView , new Insets(20, 0,0,0));
        
        HBox middleView = new HBox(formatView);
        middleView.setAlignment(Pos.TOP_LEFT);
        middleView.setMargin(formatView, new Insets(-80,0,-60,-25));
        
        
        VBox bottomView = new VBox(userPicView , lblUserName,lblUserType,lblUniName,btnUserProfile,logoPlusView );
        bottomView.setMargin(lblUserName, new Insets(10 ,0,0,0));
        bottomView.setAlignment(Pos.BOTTOM_CENTER);
        bottomView.setSpacing(5);
        
        VBox layout = new VBox(20 ,topView , middleView , bottomView);
        
        
        
        
        return layout;

    }
    
}
