package encryptdecrypt;

import encryptdecrypt.Data.Data;
import encryptdecrypt.Interfaces.DataInterface;
import encryptdecrypt.ShiftAlg.DecodeWithShiftAlg;
import encryptdecrypt.ShiftAlg.EncodeWithShiftAlg;
import encryptdecrypt.ShiftAlg.ShiftAlgContext;
import encryptdecrypt.UnicodeAlg.DecodeWithUnicodeAlg;
import encryptdecrypt.UnicodeAlg.EncodeWithUnicodeAlg;
import encryptdecrypt.UnicodeAlg.UnicodeAlgContext;

public class Menu {
    private static String mode = "";
    private static int key = 0;
    private static String data = "";
    private static String in = "";
    private static String out = "";
    private static String alg = "";

    void menu(String[] args) {
        ShiftAlgContext shiftAlgContext = new ShiftAlgContext();
        UnicodeAlgContext unicodeAlgContext = new UnicodeAlgContext();
        DataInterface file = new Data();
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-mode":
                        if (args[i + 1].equals("dec")) {
                            mode = "dec";
                        } else mode = "enc";
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        data = args[i + 1];
                        break;
                    case "-in":
                        in = args[i + 1];
                        break;
                    case "-out":
                        out = args[i + 1];
                        break;
                    case "-alg":
                        alg = args[i + 1];
                        break;
                }
            }
            if (!data.isEmpty() && !in.isEmpty()) {
                System.out.println("prefer data");
            } else if (data.isEmpty() && in.isEmpty()) {
                data = "";
            }

        } catch (IllegalStateException e) {
            System.out.println("ERROR");
        }

        if (alg.equals("unicode")) {
            if (mode.equals("enc")) {
                unicodeAlgContext.set(new EncodeWithUnicodeAlg());
            } else {
                unicodeAlgContext.set(new DecodeWithUnicodeAlg());
            }
            data = unicodeAlgContext.code(key, file.getDataFromFile(in));
        } else {
            if (mode.equals("enc")) {
                shiftAlgContext.set(new EncodeWithShiftAlg());
            } else {
                shiftAlgContext.set(new DecodeWithShiftAlg());
            }

            data = shiftAlgContext.code(key, file.getDataFromFile(in));
        }

        file.saveDataInFile(out, data);
    }

}

