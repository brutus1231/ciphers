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
        encrypt(plainText, key);
    }

    private static String generteKey(String plainText) {
        String initKey = "ALAMAKOTA";
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
                VIGINERE_MATRIX[i][j] = (char)('A' + (i + j) % ALPHABET_LENGTH);
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

    private static void encrypt(String plainText, String key) {

    }

    private static String getInputText() {
        System.out.println("Podaj tekst do zaszyfrowania: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
