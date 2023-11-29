/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author SEAL
 */
public class TanWriteBinFile {

    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private File file;
    public TanWriteBinFile(String fileName) throws IOException {
        file = new File(fileName);
        boolean checkfile = file.exists();
        if (checkfile == false) {
            file.createNewFile();
        }
        fos = new FileOutputStream(file);
        oos = new ObjectOutputStream(fos);
    }

    public void writeObj(Object obj) throws IOException {
        oos.writeObject(obj);
    }

    public void outputClose() throws IOException {
        fos.close();
        oos.close();
    }
}
