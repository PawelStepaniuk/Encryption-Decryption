package encryptdecrypt;

import encryptdecrypt.Data.Data;
import encryptdecrypt.Interfaces.DataInterface;
import encryptdecrypt.KeyAlg.DecodeWithKeyAlg;
import encryptdecrypt.KeyAlg.EncodeWithKeyAlg;
import encryptdecrypt.KeyAlg.KeyAlgContext;
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
        UnicodeAlgContext unicodeAlgContext = new UnicodeAlgContext();
        KeyAlgContext keyAlgContext = new KeyAlgContext();
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
            file.saveDataInFile(out, unicodeAlgContext.code(file.getDataFromFile(in)));
        } else {
            if (mode.equals("enc")) {
                keyAlgContext.set(new EncodeWithKeyAlg());
            } else {
                keyAlgContext.set(new DecodeWithKeyAlg());
            }
            file.saveDataInFile(out, keyAlgContext.code(key, file.getDataFromFile(in)));
        }
        //  work(mode, key, data, out, in);
    }


/*
   private void work(String mode, int key, String text, String out, String in) {
        KeyAlgContext context = new KeyAlgContext();
        DataInterface data = new Data();
        String output = "";
        if (text.isEmpty()) {
            text = data.getDataFromFile(in);
        }
        if (mode.equals("dec")) {
            context.setKeyAlgorithm(new decodeWithKeyAlg());
        } else {
            context.setKeyAlgorithm(new encodeWithKeyAlg());
        }
        output = context.code(key, text);
        if (!out.isEmpty()) {
            data.saveDataInFile(out, output);
        }
        System.out.println(output);
    }
*/
}

