package com.example.prichat.Models;

public class Users {

    String profilepic , username , email , passsword , userid , lastmessage ;

    public Users(String profilepic, String username, String email, String passsword, String userid, String lastmessage) {
        this.profilepic = profilepic;
        this.username = username;
        this.email = email;
        this.passsword = passsword;
        this.userid = userid;
        this.lastmessage = lastmessage;
    }

    // Sign Up Constructor

    public Users(String username, String email, String passsword) {
        this.username = username;
        this.email = email;
        this.passsword = passsword;
    }

    public Users(){

    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getUserid(String key) {
        return userid;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLastmessage() {
        return lastmessage;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }
}
