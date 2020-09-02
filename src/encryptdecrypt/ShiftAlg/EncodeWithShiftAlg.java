package encryptdecrypt.ShiftAlg;

import encryptdecrypt.Interfaces.ShiftAlg;


public class EncodeWithShiftAlg implements ShiftAlg {
    private final int a = 'a';
    private final int z = 'z';
    private final int A = 'A';
    private final int Z = 'Z';

    @Override
    public String code(int key, String text) {
        char[] before = text.toCharArray();
        int[] after = new int[before.length];
        for (int i = 0; i < before.length; i++) {
            if ((before[i] >= a && before[i] <= z && before[i] != 32)) {
                if ((before[i] + key) > z)
                    after[i] = a + (key - (z - before[i])) - 1;
                else {
                    after[i] = before[i] + key;
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
