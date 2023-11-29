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
public class dealers {
    public static final String ID_FORMAT = "D\\d{3}";
    public static final String PHONE_FORMAT = "\\d{9}|\\d{11}"; 
     String ID;
     String Name;
     String Address;
     String Phone;
     String Status;

    public dealers() {
    }

    public dealers(String ID, String Name, String Address, String Phone, String Status) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Status = Status;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
public String toString() {
        return ID + ", " + Name + ", " + Address + ", " + Phone + ", "
                + Status;
}
    public String Show() {
        return "dealers{" + "ID= " + ID + ", Name= " + Name + ", Address= " + Address + ", Phone= " + Phone + ", Enabled= " + Status + '}';
    }
    
}
