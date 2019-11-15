package cryptoapp;

public class Crypto {
    private String input;

    public Crypto() {
    }

    public String getInput() {
        return input;
    }

    //method removes all the spaces and punctuation and returns new uppercase string
    public String normalizeText(String input) {
        return this.input = input.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
    }

    //method adds OB in front of every vowel (including y) in the normalized text
    private String obify(String input) {
        return input;
    }

    //method encrypts input by Caesar cipher
    public String caesarify(String input, int key) {
        String result = "";
        char current;
        for(int i = 0; i < input.length(); i++) {
            current = (char) (input.charAt(i) + key % 26);
            result += current;
        }
        return this.input = result;
    }

    //method breaks encrypted method to equal-length chunks
    public String groupify(String input, int groupSize) {
        return input;
    }

    //method encrypts input
    public String encryptString(String input, int shiftValue, int groupSize) {
        normalizeText(input);
        caesarify(this.input, shiftValue);
        groupify(this.input, groupSize);
        return input;
    }

    //methods removes whitespaces and added characters from encrypted and grouped string
    public String ungroupify(String input) {

        return input;
    }

    //method decrypts the message and returns normalized text
    public String decryptString(String encrypted, int shiftValue) {

        return encrypted;
    }
}
