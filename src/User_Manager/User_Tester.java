/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Manager;

/**
 *
 * @author ASUS
 */
import Data.dealers;
import Data.DealearsCollection;
import Data.I_Dealers;
import Data.Validation;
import log_in.I_user;
import log_in.user;
import log_in.userCollection;

public class User_Tester {
     public static void main(String[] args) {
        userCollection user = new userCollection();
        DealearsCollection dealer = new DealearsCollection();
        String fileDealer = "dealers.csv";
        String filenameUser = "users.csv";
        boolean changed = true;
        int choiceL = 0;
        int choiceC = 0;
        user.loadFromUserFile(filenameUser);
        changed = true;
        dealer.readDealersFile(fileDealer);
        changed = true;

        System.out.println("----PLEASE LOG IN TO SYSTEM----");
        String[] login = {"LOGIN", "QUIT"};
        String[] options = {"ADD NEW DEALER", "SEARCH A DEALER BY NAME", "REMOVE DEALER BY ID", "UPDATE DEALER", "PRINT ALL DEALER", "SAVE ALL TO FILE", "LOGOUT","EXIT"};
        choiceL = Validation.getChoice(login);
        backpoint:
        do {
            switch (choiceL) {

                case 1:

                    user.login();

                    do {
                        switch (choiceC = Validation.getChoice(options)) {

                            case 1:
                                dealer.add();

                                break;

                            case 2:
                                dealer.search();
                                break;
                            case 3:
                                dealer.remove();
                                break;
                            case 4:
                                dealer.update();
                                break;
                            case 5:
                                dealer.printAllDealer();
                                break;
                            case 6:
                                dealer.SaveToFile();
                                break;
                            case 7:
                                continue backpoint;
                            case 8:
                                System.out.println("Good bye!!!");
                         System.exit(0);
                default: System.out.println("Error choice: Please choice again!!!!");
                        }
                    } while (choiceC > 0 && choiceC < (choiceC + 1));
                    break;
                case 2:
                    System.exit(0);

            }

        } while (choiceL > 0 && choiceL < (choiceL + 1));
    }
}
