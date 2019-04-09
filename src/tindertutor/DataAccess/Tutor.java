/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tindertutor.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tindertutor.Controller.DBAdapter;

/**
 *
 * @author adamoc
 */
public class Tutor {
    
    private String t_name , t_pass , t_username , t_subjectArea ,  t_type , t_qualifications ;
   private double  t_price , t_location;
   private int t_id;
   
   
   public void Tutor(){
       
   }
   
   public void setTutorID(int id){
       t_id = id;
   }
   
   public void setTutorName(String name){
       t_name = name;
   }
   public void setTutorPass(String password){
       t_pass = password;
   }
   public void setTutorUsername(String username){
       t_username = username;
   }
   public void setTutorSubjectArea(String subjectArea){
       t_subjectArea = subjectArea;
   }

   public void setTutorType(String type){
       t_type = type;
   }
   public void setTutorQualifications(String qualifications){
       t_qualifications = qualifications;
   }
   public void setTutorPrice(double price){
       t_price = price;
   }
   public void setTutorLocation(double location){
       t_location = location;
   }
   
   public int getTutorID(){
      return this.t_id;
   }

   public String getTutorName(){
      return this.t_name;
   }
   
   public String getTutorPass() {
       return this.t_pass;
   }
   
   public String getTutorUsername() {
       return this.t_username;
   }
   
   public String getTutorSubjectArea() {
       return this.t_subjectArea;
   }
   
   public String getTutorType() {
       return this.t_type;
   }
   
   public String getQualifications() {
       return this.t_qualifications;
   }
   
    
   public double getTutorPrice() {
        return this.t_price;
   }
   
   public double getTutorLocation() {
        return this.t_location;
   }
   
   public Boolean TutorUpdate(int ID , String Name , String Username , String T_Password , String Subject_Area , String Qualifications , double Location ,  String Type , double Price  ) throws Exception{
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement insert = c.prepareStatement("UPDATE Tutor_Users SET T_Name = '" + Name + "' , User_Name = '" + Username + "' , Tutors_Password = '" + T_Password + "' , Subject_Area = '" + Subject_Area + "' , Qualifications = '" + Qualifications + "' , Tutor_Location = '" + Location + "' , Grind_Type = '" + Type + "' , Tutor_Price = '" + Price + "' WHERE TutorID = '" + ID + "';" );
            insert.executeUpdate();
            return true;
        } catch (Exception exc){
            System.out.println(exc);
        }
        return null;
    }
   
   

    
    public Boolean TutorPost(String Name , String Username , String T_Password , String Subject_Area , String Qualifications , double Location, String Type , double Price  ) throws Exception{
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement insert = c.prepareStatement("INSERT INTO Tutor_Users(T_Name,User_Name,Tutors_Password,Subject_Area,Qualifications, Tutor_Location, Grind_Type , Tutor_Price)VALUES('" + Name + "' ,'" + Username + "','" + T_Password + "','" + Subject_Area + "','" + Qualifications + "','" + Location + "','" + Type + "','" + Price + "')");
            insert.executeUpdate();
            return true;
        } catch (Exception exc){
            System.out.println(exc);
        }
        return null;
    }
    
    /* Function To retrieve the tutors data according to their login details or sign up details to display on the
        settingsView and the update user profile view 
    */ 
    
    public ResultSet TutorRetrieve(String Username  , String Password){
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement retrieve = c.prepareStatement("SELECT * FROM Tutor_Users WHERE User_Name = '"+ Username + "' AND Tutors_Password = '"+ Password +"' ;");
            ResultSet success = retrieve.executeQuery();
            return success;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    /* Function to retrieve all the tutors_Data to display as cards to cycle through on the stackpane and then 
       pick to match with
    */
    
    public ResultSet TutorRetrieveAll(){
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement retrieve = c.prepareStatement("SELECT * FROM Tutor_Users;");
            ResultSet success = retrieve.executeQuery();
            return success;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
}
