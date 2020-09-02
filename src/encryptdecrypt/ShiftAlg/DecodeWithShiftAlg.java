package encryptdecrypt.ShiftAlg;

import encryptdecrypt.Interfaces.ShiftAlg;

public class DecodeWithShiftAlg implements ShiftAlg {
    final int a = 'a';
    final int z = 'z';
    final int A = 'A';
    final int Z = 'Z';


    @Override
    public String code(int key, String text) {
        char[] before = text.toCharArray();
        int[] after = new int[before.length];
        for (int i = 0; i < before.length; i++) {
            if ((before[i] >= a && before[i] <= z && before[i] != 32)) {
                if ((before[i] - key) < a) {
                    after[i] = z - (key - (before[i] - a) - 1);
                } else {
                    after[i] = before[i] - key;
                }
            } else {
                after[i] = before[i];
            }
        }
        for (int i = 0; i < after.length; i++) {
            before[i] = (char) after[i];
        }
        System.out.println(String.valueOf(before));
        return String.valueOf(before);

    }
}
