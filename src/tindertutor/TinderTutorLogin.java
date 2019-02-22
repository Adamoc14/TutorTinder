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
import javax.swing.JOptionPane;

/**
 *
 * @author adamoc
 */
public class TinderTutorLogin  {

    public VBox LoginView(ImageView imageview ,Label lblSignIn , TextField txtUsername , PasswordField txtPassword , Label forgotPass , Button btnLogin){
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(imageview ,lblSignIn , txtUsername , txtPassword , forgotPass ,btnLogin);
        
        btnLogin.setOnAction(e-> {
            if(txtUsername.getText().equals("Adam")&& txtPassword.getText().equals("1234")){
                System.out.println("Well you are now allowed log in");
            } else {
               JOptionPane.showMessageDialog(null, 
                              "Please enter your correct details", 
                              "Error", 
                              JOptionPane.WARNING_MESSAGE);
            }
        });
        
        
        return layout;

    }
    
    
    
}
