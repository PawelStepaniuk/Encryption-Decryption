package encryptdecrypt.UnicodeAlg;


import encryptdecrypt.Interfaces.Unicode;

public class DecodeWithUnicodeAlg implements Unicode {
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
