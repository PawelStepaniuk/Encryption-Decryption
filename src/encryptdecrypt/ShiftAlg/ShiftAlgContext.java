package encryptdecrypt.ShiftAlg;

import encryptdecrypt.Interfaces.ShiftAlg;

public class ShiftAlgContext {
    private ShiftAlg alg;

    public void set(ShiftAlg alg) {
        this.alg = alg;
    }

    public String code(int key, String text) {
        return alg.code(key, text);
    }
}
