package encryptdecrypt;

public class Main {


    public static void main(String[] args) {
        new Menu().menu(args);
    }




/*
    static String encryptWithKey(String text, int key) {
        char[] before = text.toCharArray();
        int[] after = new int[before.length];
        for (int i = 0; i < before.length; i++) {
            if ((before[i] >= a && before[i] <= z)) {
                if (before[i] + key > z) {
                    after[i] = a - 1 + key - (z - before[i]);
                } else
                    after[i] = before[i] + key;
            } else if (before[i] == 32) {
                after[i] = before[i];
            } else after[i] = before[i];
        }

        for (int i = 0; i < after.length; i++) {
            before[i] = (char) after[i];
        }
        return String.valueOf(before);
    }

*/
}

