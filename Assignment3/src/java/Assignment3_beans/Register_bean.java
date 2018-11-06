/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_beans;

/**
 *
 * @author Jianzhi
 */
public class Register_bean {
    private String firstname,lastname,username,password;
    
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
