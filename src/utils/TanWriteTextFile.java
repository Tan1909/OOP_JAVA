/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author SEAL
 */
public class TanWriteTextFile {

    private File file;
    BufferedWriter bw;
    FileWriter fw;

    public TanWriteTextFile(String filename) throws IOException {
        file = new File(filename);
        boolean checkfile = file.exists();
        if (checkfile == false) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
    }

    public void writeLine(Object data) throws IOException {
        bw.write(data + "\n");
    }

    public void outputClose() throws IOException {
        bw.close();
        fw.close();
    }
}
