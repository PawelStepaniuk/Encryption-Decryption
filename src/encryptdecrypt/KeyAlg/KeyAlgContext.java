package encryptdecrypt.KeyAlg;

import encryptdecrypt.Interfaces.KeyAlg;

public class KeyAlgContext {
    KeyAlg algorithm;

    public void set(KeyAlg keyAlgorithm) {
        this.algorithm = keyAlgorithm;
    }

    public String code(int key, String text) {
        return algorithm.code(key, text);
    }

}
