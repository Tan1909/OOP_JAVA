/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author SEAL
 */
public class TanReadBinFile {

    private FileInputStream fis;
    private ObjectInputStream ois;
//    private FileOutputStream fos;
//    private ObjectOutputStream oos;
    private File file;
    public TanReadBinFile(String fileName) throws IOException {
        file = new File(fileName);
        boolean checkfile = file.exists();
        if (checkfile == false) {
            file.createNewFile();
        }
        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);
    }


    public Object readObj() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public int available() throws IOException {
        return fis.available();
    }

    public void inputClose() throws IOException {
        ois.close();
        fis.close();
    }
}
