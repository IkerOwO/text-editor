package main.java.text_editor.functions;
import java.io.*;

public class FileCreator extends ReadFile{
    public static void createFileCreator(String FileName) throws IOException{
        File file = new File(FileName+".txt");
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            /*
                   IMPLEMENT LOGIC IF THE FILE ALREADY EXISTS
            */

            System.out.println("File already exists.");
        }
    }
}
