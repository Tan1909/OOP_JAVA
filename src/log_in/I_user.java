/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_in;

/**
 *
 * @author ASUS
 */
public interface I_user {
    public boolean loadFromUserFile(String filenameU);

    public void login();

    public int searchUser(String username);

    public int searchPassWord(String password);

    public int searchRole(String role);
}
