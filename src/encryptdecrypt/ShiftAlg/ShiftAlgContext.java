package encryptdecrypt.ShiftAlg;

import encryptdecrypt.Interfaces.Unicode;

public class ShiftAlgContext {
    private Unicode alg;

    public void set(Unicode alg) {
        this.alg = alg;
    }

    public String code(String text) {
        return alg.code(text);
    }
}
