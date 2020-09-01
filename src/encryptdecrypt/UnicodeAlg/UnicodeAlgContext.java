package encryptdecrypt.UnicodeAlg;

import encryptdecrypt.Interfaces.KeyAlg;

public class UnicodeAlgContext {
    KeyAlg algorithm;

    public void set(KeyAlg keyAlgorithm) {
        this.algorithm = keyAlgorithm;
    }

    public String code(int key, String text) {
        return algorithm.code(key, text);
    }

}
