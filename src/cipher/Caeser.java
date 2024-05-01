package cipher;

public class Caeser {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // **********
    // Encryption
    // **********

    public static int getEncryptedIndex(int unencryptedIndex, int encryptionShift) {
        // add 26000 to allow for large negative encryption shifts - why not!
        return (unencryptedIndex + encryptionShift + 26000) % 26;
    }

    public static char encrypt(char unencrypted, int encryptionShift) {
        char output = unencrypted;

        int unencryptedIndex = LOWERCASE.indexOf(unencrypted);
        int encryptedIndex = getEncryptedIndex(unencryptedIndex, encryptionShift);
        if (unencryptedIndex != -1)
            output = LOWERCASE.charAt(encryptedIndex);
        else {
            unencryptedIndex = UPPERCASE.indexOf(unencrypted);
            encryptedIndex = getEncryptedIndex(unencryptedIndex, encryptionShift);
            if (unencryptedIndex != -1)
                output = UPPERCASE.charAt(encryptedIndex);
        }

        return output;
    }

    public static String encrypt(String unencrypted, int encryptionShift) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < unencrypted.length(); i++) {
            char unencryptedChar = unencrypted.charAt(i);
            output.append(encrypt(unencryptedChar, encryptionShift));
        }

        return output.toString();
    }

    // **********
    // Decryption
    // **********

    public static int getDecryptedIndex(int encryptedIndex, int encryptionShift) {
        return getEncryptedIndex(encryptedIndex, encryptionShift);
    }

    public static char decrypt(char encrypted, int encryptionShift) {
        int negativeOfShift = encryptionShift * -1;
        return encrypt(encrypted, negativeOfShift);
    }

    public static String decrypt(String encrypted, int encryptionShift) {
        int negativeOfShift = encryptionShift * -1;
        return encrypt(encrypted, negativeOfShift);
    }
}
