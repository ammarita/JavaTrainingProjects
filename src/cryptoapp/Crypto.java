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

    //method encrypts input by Caesar cipher
    public String caesarify(String input, int key) {
        String result = "";
        char current;
        for(int i = 0; i < input.length(); i++) {
            current = (char) (input.charAt(i) + key);
            result += current;
        }
        return result;
    }
}
