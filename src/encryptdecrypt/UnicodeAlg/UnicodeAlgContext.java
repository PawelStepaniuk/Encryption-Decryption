package encryptdecrypt.UnicodeAlg;

import encryptdecrypt.Interfaces.Unicode;

public class UnicodeAlgContext {
    Unicode algorithm;

    public void set(Unicode unicode) {
        this.algorithm = unicode;
    }

    public String code(int key, String text) {
        return algorithm.code(key, text);
    }

}
