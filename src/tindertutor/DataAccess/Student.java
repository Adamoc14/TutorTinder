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
public class Student {
    
   private String   s_name , s_pass , s_username , s_modulecode ,  s_type , s_year ;
   private double  s_price , s_location;
   private int s_id;
   
   public int getStudentID(){
      return this.s_id;
   }
   
   public String getStudentName(){
      return this.s_name;
   }
   
   public String getStudentPass() {
       return this.s_pass;
   }
   
   public String getStudentUsername() {
       return this.s_username;
   }
   
   public String getStudentModuleCode() {
       return this.s_modulecode;
   }
   
   public String getStudentType() {
       return this.s_type;
   }
   
   public String getStudentYear() {
       return this.s_year;
   }
    
   public double getStudentPrice() {
        return this.s_price;
   }
   
   public double getStudentLocation() {
        return this.s_location;
   }
   
   public void setStudentID(int id){
       s_id = id;
   }
   
   public void setStudentName(String name){
       s_name = name;
   }
   public void setStudentPass(String password){
       s_pass = password;
   }
   public void setStudentUsername(String username){
       s_username = username;
   }
   public void setStudentModule(String modulecode){
       s_modulecode = modulecode;
   }

   public void setStudentType(String type){
       s_type = type;
   }
   public void setStudentYear(String year){
       s_year = year;
   }
   public void setStudentPrice(double price){
       s_price = price;
   }
   public void setStudentLocation(double location){
       s_location = location;
   }
   
   public void Student(){
       
   }
   
   public void Student(String Name , String Username , String Password , String Year , String ModuleCode ,  double Location , double Price , String Type ){
       this.s_name = Name;
       this.s_username = Username;
       this.s_pass = Password;
       this.s_year = Year;
       this.s_modulecode = ModuleCode;
       this.s_location = Location;
       this.s_price = Price;
       this.s_type = Type;
   }
   
   public Boolean StudentPost(String Name , String Username , String S_Password , String Year , String ModuleCode , double Location ,  String Type , double Price  ) throws Exception{
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement insert = c.prepareStatement("INSERT INTO Student_Users(S_Name,User_Name,Students_Password,College_Year,College_ModuleCode,Student_Location,Grind_Type, Student_Price)VALUES('" + Name + "' ,'" + Username + "','" + S_Password + "','" + Year + "','" + ModuleCode + "','" + Location + "','" + Type + "','" + Price + "')");
            insert.executeUpdate();
            return true;
        } catch (Exception exc){
            System.out.println(exc);
        }
        return null;
    }
   
   public Boolean StudentUpdate(int ID , String Name , String Username , String S_Password , String Year , String ModuleCode , double Location ,  String Type , double Price  ) throws Exception{
        try{
            DBAdapter dbadapter = new DBAdapter();
            Connection c = dbadapter.getConnection();
            PreparedStatement insert = c.prepareStatement("UPDATE Student_Users SET S_Name = '" + Name + "' , User_Name = '" + Username + "' , Students_Password = '" + S_Password + "' , College_Year = '" + Year + "' , College_ModuleCode = '" + ModuleCode + "' , Student_Location = '" + Location + "' , Grind_Type = '" + Type + "' , Student_Price = '" + Price + "' WHERE StudentID = '" + ID + "';" );
            insert.executeUpdate();
            return true;
        } catch (Exception exc){
            System.out.println(exc);
        }
        return null;
    }
   
   
   public ResultSet StudentRetrieve(String Username  , String Password){
       try{
           DBAdapter dbadapter = new DBAdapter();
           Connection c = dbadapter.getConnection();
           PreparedStatement retrieve = c.prepareStatement("Select * From Student_Users WHERE User_Name = '"+ Username + "' AND Students_Password = '"+ Password +"' ;");
           ResultSet rs = retrieve.executeQuery();
           return rs;
           
       } catch(Exception e){
           System.out.println(e);
       }
       return null;
   }
   
   
   @Override
   public String toString() {
       return s_name + "," + s_username + "," + s_pass + "," + s_year + ","  + s_modulecode + "," + s_location + "," + s_price + "," + s_type;
   }
   
   
    
   
}
