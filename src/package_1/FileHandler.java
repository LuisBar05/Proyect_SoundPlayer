/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

public class FileHandler {

    private int idFile;
    private File myFile;

    public FileHandler(String nameFile) {
        myFile = new File(nameFile);

        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException ioe) {
                System.out.println("Error al crear el archivo " + myFile.getName());
                ioe.printStackTrace();
            }
        }
    }

    public static void copyFile(File newSong) {
        try {
            Path originPath = Paths.get(newSong.getPath());
            Path destinyPath = Paths.get("src\\music\\".concat(newSong.getName()));
            Files.copy(originPath, destinyPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList readFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));

        } catch (IOException e) {
            System.out.println("Ocurrió un error en la lectura del archivo " + myFile);
        }

        return null;
    }

}
