package pl.sda;

import java.util.Scanner;

public class ViginereCipher {

    private static final int ALPHABET_LENGTH = 26;
    private static final char[][] VIGINERE_MATRIX = new char[ALPHABET_LENGTH][ALPHABET_LENGTH];

    public static void main(String[] args) {
        String plainText = getInputText();

        final String key = generteKey(plainText);
        generateMatrix();
        printMatrix();
        String encrptedText = encrypt(plainText, key);
        System.out.println("\nencrptedText: " + encrptedText);

        String decrptedText = decrypt(encrptedText, key);
        System.out.println("decrptedText: " + decrptedText);
    }

    private static String generteKey(String plainText) {
        String initKey = "BREAK";
        StringBuilder key = new StringBuilder(initKey);

        if (plainText.length() <= key.length()) {
            return initKey;
        }

        for (int i = 0; i < plainText.length() - initKey.length(); i++) {
            key.append(initKey.charAt(i % initKey.length()));
        }
        return key.toString();
    }

    private static void generateMatrix() {
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            for (int j = 0; j < ALPHABET_LENGTH; j++) {
                VIGINERE_MATRIX[i][j] = (char) ('A' + (i + j) % ALPHABET_LENGTH);
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            System.out.println();
            for (int j = 0; j < ALPHABET_LENGTH; j++) {
                System.out.print(VIGINERE_MATRIX[i][j] + " ");
            }
        }
    }

    private static String encrypt(String plainText, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            result.append(VIGINERE_MATRIX[plainText.charAt(i)-'A'][key.charAt(i)-'A']);
        }
        return result.toString();
    }

    private static String decrypt(String encryptedText, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            result.append(
                    VIGINERE_MATRIX[('A' - encryptedText.charAt(i))%ALPHABET_LENGTH]
                            [('A' - key.charAt(i))%ALPHABET_LENGTH]);
        }
        return result.toString();
    }

    private static String getInputText() {
        System.out.println("Podaj tekst do zaszyfrowania: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
