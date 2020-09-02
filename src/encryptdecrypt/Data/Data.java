package encryptdecrypt.Data;

import encryptdecrypt.Interfaces.DataInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Data implements DataInterface {
    final File file = new File("");

    public String getDataFromFile(String in) {
        File data = new File(file.getPath() + in);

        try {
            Scanner scannerFromFile = new Scanner(data);
            String s = scannerFromFile.nextLine();
            scannerFromFile.close();
            return s;
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return "";
    }

    public void saveDataInFile(String out, String data) {
        File output = new File(file.getPath() + out);
        try {
            FileWriter writer = new FileWriter(output);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
