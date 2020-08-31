package encryptdecrypt.KeyAlg;

import encryptdecrypt.Interfaces.KeyAlg;

public class DecodeWithKeyAlg implements KeyAlg {
    @Override
    public String code(int key, String text) {

        char[] before = text.toCharArray();
        int[] after = new int[before.length];

        for (int i = 0; i < before.length; i++) {
            after[i] = before[i] - key;
        }

        for (int i = 0; i < after.length; i++) {
            before[i] = (char) after[i];
        }
        return String.valueOf(before);

    }
}
