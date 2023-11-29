package Data;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import utils.TanWriteTextFile;
import Data.dealers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
public class DealearsCollection extends ArrayList<dealers>  implements I_Dealers {
    private final String dealersFileName ="dealers.csv";
    private int numOfReadFileDealers = 0;


           private boolean updateFile(String fileName, ArrayList thi) {
        try {
            TanWriteTextFile file = new TanWriteTextFile(fileName);
            for (Object object : thi) {
                file.writeLine(object);
            }
            file.outputClose();
            return true;
        } catch (Exception e) {
            System.out.println("Error in File IO");
            return false;
        }
    } 
        private boolean managerMode = false;
        private boolean checkMode(boolean mode) {
        if (managerMode == mode) {
            return true;
        } else {
            if (mode == false) {
                System.out.println("You must be R001 to use this feature");
            } else {
                System.out.println("You must be R002 to use this feature");
            }
            return false;
        }
    }
  public boolean readDealersFile(String filename) {
         String id, name, address, phone, status;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String[] arr;
            String test = br.readLine();
            while (test != null) {
                
                arr = test.split("\\|");
                id = arr[0].trim();
                name = arr[1].trim();
                address = arr[2].trim();
                phone = arr[3].trim();
                status = arr[4].trim();
                this.add(new dealers(id, name, address, phone, status));
                test = br.readLine();
            
            }
            br.close();
            fr.close();
            numOfReadFileDealers = 1;
            return true;
        } catch (IOException ex) {
            System.out.println("IO");
        }
        return false;
  }
        boolean idDuplicated = false;
    private boolean isIdDuplicated(String ID) {
        ID = ID.trim().toUpperCase();
        return search(ID) != null;
    }

     public dealers search(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equals(ID)) {
                return this.get(i);
            }
        }
        return null;

    }
     
    @Override
    public void add() {
      if (numOfReadFileDealers == 0) 
          this.readDealersFile(dealersFileName);
         String nId, nName, nAddress, nPhone, nStatus;

        do {
            nId = Validation.inputPatternForId("INPUT ID OF DEALERS TO ADD: ", "FOLLOW FORMAT D\\d{3}");
            idDuplicated = isIdDuplicated(nId);
            if (idDuplicated) {
                System.out.println("ID DUPLICATED");
            }
        } while (idDuplicated == true);
        nName = Validation.inputStr("DEALER NAME: ");
        nAddress = Validation.inputStr("ADDRESS OF DEALERS: ");
        nPhone = Validation.inputStr("PHONE OF DEALERS: ");

        nStatus = Validation.inputStr("STATUS(ENABLED OR DISABLED) OF DEALERS: ");
        System.out.println("\n");
        System.out.println("DEALERS!" + nId + " HAS BEEN ADDED SUCCESSFULLY " );
        dealers added = new dealers(nId, nName, nAddress, nPhone, nStatus);
        this.add(added);
    }
    public dealers searchN(String NAME) {
        NAME = NAME.trim();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().equals(NAME)) {
                return this.get(i);
            }
        }
        return null;

    }
    @Override
    public void search() {
        if (this.isEmpty()) {
            System.err.println("EMPTY LIST!");
        } else {
            String sName = Validation.inputStr("ENTER NMAE DEALER FOR SEARCH: ");
            dealers st = this.searchN(sName);
            if (st == null) {
                System.out.println("DEALER: " + sName + " DOESN'T EXIST!");
            } else {
                System.out.println("INFORMATION OF DEALERS: " + st);
            }
        }
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST!");
        } else {
            String rId = Validation.inputStr("ENTER ID FOR REMOVING: ");
            dealers st = this.search(rId);
            if (st == null) {
                System.out.println("ID OF DEALERS " + rId + " DOESN'T EXIST!");
            } else {
                this.remove(st);
                System.out.println("ID OF DEALERS " + rId + " HAS BEEN REMOVED");
            }
        }
    }

    @Override
    public void update() {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST");
        } else {
            String sId = Validation.inputStr("ENTER ID DEALERS FOR UPDATE: ");
            dealers st = this.search(sId);
            if (st == null) {
                System.out.println("ID DEALDER " + sId + " doesn't existed!");
            } else {
                String oldId = st.getID();
                String UTD;
                do {
                    UTD = "OLD ID DEALERS " + oldId + ", NEW ID DEALERS: ";

                    String newUid = Validation.inputPatternForId(UTD, "D\\{3}");
                    idDuplicated = isIdDuplicated(newUid);
                    if (idDuplicated) {
                        System.out.println("ID DUPLICATED!");
                    }
                    st.setID(newUid);
                } while (idDuplicated == true);

                String oldName = st.getName();
                UTD = "OLD NAME " + oldName + ", NEW NAME: ";
                String newUName = Validation.inputNonBankStr(UTD);
                st.setName(newUName);
                String oldUAddress = st.getAddress();
                UTD = "OLD ADDRESS " + oldUAddress + ", NEW ADDRESS: ";
                String newUAddress = Validation.inputNonBankStr(UTD);
                st.setAddress(newUAddress);
                String oldUPhone = st.getPhone();
                UTD = "OLD PHONE " + oldUPhone + ", NEW PHONE: ";
                String newUPhone = Validation.inputNonBankStr(UTD);
                st.setPhone(newUPhone);
                String oldUStatus = st.getStatus();
                UTD = "OLD STATUS " + oldUStatus + ", NEW STATUS: ";
                String newUStatus = Validation.inputNonBankStr(UTD);
                st.setStatus(newUStatus);
                System.out.println("OLD ID OF DEALERS"+oldId+ "HAS BEEN UPDATE NEW INFORMATION SUCCESSLLY");
            }
        }
    }

    @Override
    public void printAllDealer() {
         if (this.isEmpty() == true) {
            System.out.println("EMPTY LIST!"); 
            return;
            } else {
          for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
    }
   
    @Override
    public boolean SaveToFile() {
        try {
            File f = new File(dealersFileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (dealers x : this) {
                System.out.println("\n");
                pw.println(x.getID() + " | " + x.getName() + " | " + x.getAddress() + " | " + x.getPhone() + " | " + x.getStatus());
            }
            pw.close();
            System.out.println("SAVE TO FILE DEALERS SUCCESSFULLY!");
            return true;
   }    catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    }
  

      
    

