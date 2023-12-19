package com.example.sdu_newmenews;

import java.io.IOException;
import java.util.EmptyStackException;

public class CheckField {
    private String recUsername;
    private String recEmail;
    private String recPassword;

    void setRegUsername(String username){
        this.recUsername = username;
    }
    void setRegEmail(String email){
        this.recEmail = email;
    }
    void setRegPassword(String password){
        this.recPassword = password;
    }

    void setRegisterUsername(String recUsername) throws Exception {
        if(!(recUsername.length()>0)){
            throw new IOException("Username name should not be empty!");
        }
        String temp="";
        int r=0;
        for(int i =0; i<recUsername.length(); i++){
            char ch = recUsername.charAt(i);
            if(Character.isDigit(ch) || Character.isLowerCase(ch) || Character.isUpperCase(ch)){

            } else {
                temp+=ch;
                r++;
            }
        }
        if(r!=0)
            throw new IOException("You use such symbols: "+temp+",\n" +
                    "the username must contain only words and numbers.");
        if(this.recUsername.equals(this.recPassword)){
            throw new IOException("Username and password should not be similar!");
        }

        if(!(this.recUsername.length()>=5 && this.recUsername.length()<=9)){
            throw new IOException("The username length should be form 5 to 9.\nYou have the length: "+this.recUsername.length());
        }


    }
    void setRegisterEmail(String recEmail) throws Exception{
        if(!(recEmail.length()>0)){
            throw new Exception("Email should not be empty!");
        }
        this.recEmail = recEmail;
        int r =0;
        for(int i =0;i<recEmail.length(); i++){
            if(recEmail.charAt(i)=='@'){
                r++;
            }
        }
        if(r!=1)
            throw new IOException("Enter the correct email");
        if(recEmail.equals(this.recPassword)){
            throw new IOException("Email and password should not be similar!");
        }

    }
    void setRegisterPassword(String registerPassword) throws Exception{
        if(!(registerPassword.length()>0)){
            throw new IOException("Password should not be empty!");
        }
        this.recPassword = registerPassword;
        if(!(registerPassword.length()>=5 && registerPassword.length()<=9)){
            throw new IOException("The password length should be from 5 to 9.\nYou have the length: "+registerPassword.length());
        }
    }

    void setLoginUsername(String username){
        this.recUsername = username;
    }
    void setLoginPassword(String password){
        this.recPassword = password;
    }


    void setAdminUsername(String name) throws Exception{
        if(!(name.length()>0)){
            throw new IOException("The Email should not be empty!");
        }
    }
    void setAdminPassword(String password) throws Exception{
        if(!(password.length()>0)){
            throw new IOException("The password should not be empty!");
        }
    }
}
