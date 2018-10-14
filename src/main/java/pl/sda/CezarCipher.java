package pl.sda;

import java.util.Scanner;

public class CezarCipher {

    private static final int ALPHABET_LENTH = 26;

    public static void main(String[] args) {
        String plainText = getInputText();

        final int shift = 3;
        String encriptedText = encrypt(plainText, shift, true);
        String decryptedText = encrypt(encriptedText, shift, false);

        System.out.println("encriptedText: " + encriptedText);
        System.out.println("decryptedText: " + decryptedText);
    }

    private static String getInputText() {
        System.out.println("Podaj tekst do zaszyfrowania: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String encrypt(String text, int shift, boolean isEncrypt) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(getShiftedChar(text.charAt(i), shift, isEncrypt));
        }
        return result.toString();
    }

    private static char getShiftedChar(char cipherChar, int shift, boolean isEncript) {
        int charValue = (int)cipherChar;

        if (cipherChar == ' ') {
            return ' ';
        }

        if (isEncript) {
            return (char) (((charValue + shift - 'A') % ALPHABET_LENTH) + 'A');
        }
        return (char) (((charValue - shift + 'A') % ALPHABET_LENTH) + 'A');
    }
}
