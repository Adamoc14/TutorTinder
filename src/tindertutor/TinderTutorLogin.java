/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor;



import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author adamoc
 */
public class TinderTutorLogin  {

    public VBox LoginView(ImageView imageview ,Label lblSignIn , TextField txtUsername , PasswordField txtPassword , Label forgotPass , Button btnLoginReal){
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(imageview ,lblSignIn , txtUsername , txtPassword , forgotPass ,btnLoginReal);
        layout.setStyle("-fx-background-color: #ffffff");
        
        
        return layout;

    }
    
    
    
}
