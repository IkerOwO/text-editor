package main.java.text_editor.functions;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritter {
    public FileWriter writeFile(String Filename) throws IOException {
        return new FileWriter(Filename+".txt");
    }
}
