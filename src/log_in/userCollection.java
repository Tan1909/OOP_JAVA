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
import Data.dealers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Data.Validation;
import Data.DealearsCollection;
public class userCollection extends ArrayList<user> implements I_user {
        user u = new user();


    @Override
    public boolean loadFromUserFile(String filenameU) {
        String username, password, role, status;
        try {
            FileReader fr = new FileReader(filenameU);
            BufferedReader br = new BufferedReader(fr);
            String[] arr;
            String test = br.readLine();
            while (test != null) {

                arr = test.split("\\|");
                username = arr[0].trim();
                password = arr[1].trim();
                role = arr[2].trim();
                status = arr[3].trim();

                this.add(new user(username, password, role, status));
                test = br.readLine();
            }
            br.close();
            fr.close();
            return true;
        } catch (IOException ex) {
            System.out.println("IO");

        }
        return false;
    }

    @Override
    public int searchUser (String username) {
           for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getUsername().trim().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int searchPassWord (String password) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPassword().trim().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int searchRole (String role) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getRole().trim().equals(role)) {
                return i;
            }
        }
        return -1;
    }
    
     @Override
    public void login() {
        int count1 = 0;
        int count2 = 0;
        int count3;
        String role;
        String password;
        String username;
        String roleCheck;
        String askYN = "";
        boolean count = false;
        DealearsCollection us = new DealearsCollection();

        do {
            
            username = Validation.inputStr("ENTER USERNAME:").trim();

            count1 = this.searchUser (username);

            password = Validation.inputStr("ENTER PASSWORD: ").trim();
            count2 = this.searchPassWord (password);

            role = Validation.inputStr("ENTER ROLE").trim().toUpperCase();
            count3 = this.searchRole (role);
            if (count1 <= 0 || count2 <= 0 || count3 <= 0) {
                System.err.println("USERNAME, PASSWORD OR ROLE IS INCORRECT!");
            } else if (count1 != count2 || count1 != count3 || count2 != count3) {
                System.err.println("USERNAME, PASSWORD OR ROLE IS INCORRECT!");
            } else {
                System.out.println("LOGIN SUCCESSFULLY");
            }

        } while (count1 < 0 || count2 < 0 || count3 < 0);
        if (role.toUpperCase().trim().equals("R001")) {

        } else if (role.toUpperCase().trim().equals("R002")) {
            System.err.println("EMPTY LIST!");
            askYN = Validation.inputStr("DO YOU WANT TO BACK TO LOGIN? (Y/N): ");
            if (askYN.toUpperCase().equals("Y")) {
                login();
            } else if (askYN.toUpperCase().trim().equals("N")) {
                System.exit(0);
            }

        } else if (role.toUpperCase().trim().equals("ADMIN")) {
            System.err.println("EMPTY LIST!");

                askYN = Validation.inputStr("YOU WANT TO LOGOUT? (Y/N): ");
                   if (askYN.toUpperCase().equals("Y")) {
                       login();
                   }else if (askYN.toUpperCase().trim().equals("N")) {
                       System.exit(0);
                   }
        }
    }

}
