package log_in;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class user {
     String Username;
     String Password;
     String Role;
     String Status;
    public user() {
    }

    public user(String Username, String Password, String Role, String Status) {
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole() {
        return Role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "user{" + "Username=" + Username + ", Password=" + Password + ", Role=" + Role + ", Status=" + Status + '}';
    }
    

}
