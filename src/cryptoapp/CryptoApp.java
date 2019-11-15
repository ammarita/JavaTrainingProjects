package cryptoapp;
/*
Project contains methods for encrypting and decrypting text
 */

public class CryptoApp {
    public static void main(String[] args) {
        Crypto crypto = new Crypto();

        String input = "This is some \"really\" great. (Text)!?";
        crypto.normalizeText(input);
        System.out.println(crypto.getInput());
        System.out.println(crypto.caesarify(crypto.getInput(), -2));

    }
}
