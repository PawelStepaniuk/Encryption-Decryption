package encryptdecrypt.Interfaces;

public interface DataInterface {
    String getDataFromFile(String in);

    void saveDataInFile(String out, String data);
}
