
package models;

/**
 *
 * @author mhame
 */
public class AccountService {
    
    String username1 = "abe";
    String username2 = "barb";
    String password = "password";
    
    public void AccountService(){   
    }
     
    public String getUsername1(){
        return this.username1;
    }
    
    public String getUsername2(){
        return this.username2;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String login(String username, String password){
       String valid;
       
       if (this.password.equals(password) && this.username1.equals(username) || this.username2.equals(username)){
           valid = "valid";
           return valid;
       }
       else{
           valid = "invalid";
           return valid;
       }
    }
    
}
