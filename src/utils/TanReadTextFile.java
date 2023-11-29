/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author SEAL
 */
public class TanReadTextFile {

    private File file;
    BufferedReader br;
    FileReader fr;

    public TanReadTextFile(String filename) throws IOException {
        file = new File(filename);
        boolean checkfile = file.exists();
        if (checkfile == false) {
            file.createNewFile();
        }
        fr = new FileReader(file);
        br = new BufferedReader(fr);
    }

    public String readLine() throws IOException{
        return br.readLine();
    }
    
    public void inputClose() throws IOException {
        br.close();
        fr.close();
    }
}
