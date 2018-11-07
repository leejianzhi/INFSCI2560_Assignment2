/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_beans;

/**
 *
 * @author leedz
 */
public class Register_bean {
    private String email;
    private String username;
    private String password;
 
 public String getUsername() {
    return username;
 }
 public void setUsername(String username) {
    this.username = username;
 }
 public String getPassword() {
    return password;
 }
 public void setPassword(String password) {
    this.password = password;
 }
 public void setEmailAddress(String email) {
    this.email = email;
 }
 public String getEmailAddress() {
    return email;
 }   
}
