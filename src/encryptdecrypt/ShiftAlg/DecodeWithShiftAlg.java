package encryptdecrypt.ShiftAlg;

import encryptdecrypt.Interfaces.Unicode;

public class DecodeWithShiftAlg implements Unicode {
    final int a = 'a';
    final int z = 'z';
    final int A = 'A';
    final int Z = 'Z';

    @Override
    public String code(String text) {
        return "decodeWithUnicodeAlg";
    }
}
