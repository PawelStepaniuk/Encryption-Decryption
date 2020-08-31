package encryptdecrypt.UnicodeAlg;

import encryptdecrypt.Interfaces.Unicode;

public class EncodeWithUnicodeAlg implements Unicode {
    final int a = 'a';
    final int z = 'z';
    final int A = 'A';
    final int Z = 'Z';

    @Override
    public String code(String text) {
        char[] before = text.toCharArray();
        int[] after = new int[before.length];
        for (int i = 0; i < before.length; i++) {
            if ((before[i] >= a && before[i] <= z && before[i] != 32)) {

                after[i] = z - (before[i] - a);
            } else {
                after[i] = before[i];
            }
        }
        for (int i = 0; i < after.length; i++) {
            before[i] = (char) after[i];
        }
        return String.valueOf(before);

    }
}
