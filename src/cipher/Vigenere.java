package cipher;

public class Vigenere {
        private static final char[][] TABULA_RECTA = {
                        { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                                        'T', 'U', 'V', 'W', 'X', 'Y', 'Z' },
                        { 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                                        'U', 'V', 'W', 'X', 'Y', 'Z', 'A' },
                        { 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                                        'V', 'W', 'X', 'Y', 'Z', 'A', 'B' },
                        { 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                                        'W', 'X', 'Y', 'Z', 'A', 'B', 'C' },
                        { 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                                        'X', 'Y', 'Z', 'A', 'B', 'C', 'D' },
                        { 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                        'Y', 'Z', 'A', 'B', 'C', 'D', 'E' },
                        { 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                                        'Z', 'A', 'B', 'C', 'D', 'E', 'F' },
                        { 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                                        'A', 'B', 'C', 'D', 'E', 'F', 'G' },
                        { 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A',
                                        'B', 'C', 'D', 'E', 'F', 'G', 'H' },
                        { 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B',
                                        'C', 'D', 'E', 'F', 'G', 'H', 'I' },
                        { 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C',
                                        'D', 'E', 'F', 'G', 'H', 'I', 'J' },
                        { 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D',
                                        'E', 'F', 'G', 'H', 'I', 'J', 'K' },
                        { 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E',
                                        'F', 'G', 'H', 'I', 'J', 'K', 'L' },
                        { 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F',
                                        'G', 'H', 'I', 'J', 'K', 'L', 'M' },
                        { 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                        'H', 'I', 'J', 'K', 'L', 'M', 'N' },
                        { 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                        'I', 'J', 'K', 'L', 'M', 'N', 'O' },
                        { 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                                        'J', 'K', 'L', 'M', 'N', 'O', 'P' },
                        { 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                                        'K', 'L', 'M', 'N', 'O', 'P', 'Q' },
                        { 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                                        'L', 'M', 'N', 'O', 'P', 'Q', 'R' },
                        { 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                                        'M', 'N', 'O', 'P', 'Q', 'R', 'S' },
                        { 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                        'N', 'O', 'P', 'Q', 'R', 'S', 'T' },
                        { 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                        'O', 'P', 'Q', 'R', 'S', 'T', 'U' },
                        { 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                                        'P', 'Q', 'R', 'S', 'T', 'U', 'V' },
                        { 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                        'Q', 'R', 'S', 'T', 'U', 'V', 'W' },
                        { 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                                        'R', 'S', 'T', 'U', 'V', 'W', 'X' },
                        { 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                                        'S', 'T', 'U', 'V', 'W', 'X', 'Y' }
        };

        public static String sanitiseEncryptionKey(String encryptionKey) {
                return encryptionKey.replaceAll("[^a-zA-Z]", "");
        }

        // **********
        // Encryption
        // **********

        public static char encrypt(char unencrypted, char encryptionKey) {
                char output = unencrypted;

                for (int row = 0; row < TABULA_RECTA.length; row++) {
                        // uppercase key
                        if (encryptionKey == TABULA_RECTA[row][0]) {
                                for (int col = 0; col < TABULA_RECTA[row].length; col++) {
                                        // uppercase input
                                        if (unencrypted == TABULA_RECTA[0][col])
                                                output = TABULA_RECTA[row][col];
                                        // lowercase input
                                        else if (unencrypted == Character.toLowerCase(TABULA_RECTA[0][col]))
                                                output = Character.toLowerCase(TABULA_RECTA[row][col]);

                                }
                        }
                        // lowercase key
                        else if (encryptionKey == Character.toLowerCase(TABULA_RECTA[row][0])) {
                                for (int col = 0; col < TABULA_RECTA[row].length; col++) {
                                        // uppercase input
                                        if (unencrypted == TABULA_RECTA[0][col])
                                                output = TABULA_RECTA[row][col];
                                        // lowercase input
                                        else if (unencrypted == Character.toLowerCase(TABULA_RECTA[0][col]))
                                                output = Character.toLowerCase(TABULA_RECTA[row][col]);

                                }
                        }
                }

                return output;

        }

        public static String encrypt(String unencrypted, String encryptionKey) {
                StringBuilder output = new StringBuilder();

                String sanitisedKey = sanitiseEncryptionKey(encryptionKey);
                int sanitisedKeyLength = sanitisedKey.length();

                for (int i = 0; i < unencrypted.length(); i++) {
                        char unencryptedChar = unencrypted.charAt(i);
                        char sanitisedKeyChar = sanitisedKey.charAt(i % sanitisedKeyLength);
                        output.append(encrypt(unencryptedChar, sanitisedKeyChar));
                }

                return output.toString();
        }

        // **********
        // Decryption
        // **********

        public static char decrypt(char encrypted, char encryptionKey) {
                char output = encrypted;

                for (int col = 0; col < TABULA_RECTA[0].length; col++) {
                        // uppercase key
                        if (encryptionKey == TABULA_RECTA[0][col]) {
                                for (int row = 0; row < TABULA_RECTA.length; row++) {
                                        // uppercase input
                                        if (encrypted == TABULA_RECTA[row][col])
                                                output = TABULA_RECTA[row][0];
                                        // lowercase input
                                        else if (encrypted == Character.toLowerCase(TABULA_RECTA[row][col]))
                                                output = Character.toLowerCase(TABULA_RECTA[row][0]);

                                }
                        }
                        // lowercase key
                        else if (encryptionKey == Character.toLowerCase(TABULA_RECTA[0][col])) {
                                for (int row = 0; row < TABULA_RECTA.length; row++) {
                                        // uppercase input
                                        if (encrypted == TABULA_RECTA[row][col])
                                                output = TABULA_RECTA[row][0];
                                        // lowercase input
                                        else if (encrypted == Character.toLowerCase(TABULA_RECTA[row][col]))
                                                output = Character.toLowerCase(TABULA_RECTA[row][0]);

                                }
                        }
                }

                return output;
        }

        public static String decrypt(String encrypted, String encryptionKey) {
                StringBuilder output = new StringBuilder();

                String sanitisedKey = sanitiseEncryptionKey(encryptionKey);
                int sanitisedKeyLength = sanitisedKey.length();

                for (int i = 0; i < encrypted.length(); i++) {
                        char encryptedChar = encrypted.charAt(i);
                        char sanitisedKeyChar = sanitisedKey.charAt(i % sanitisedKeyLength);
                        output.append(decrypt(encryptedChar, sanitisedKeyChar));
                }

                return output.toString();
        }
}
