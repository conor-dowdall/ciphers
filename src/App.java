import cipher.Caesar;
import cipher.Vigenere;

public class App {
    public static void main(String[] args) throws Exception {
        // String encryptMe = "It is imperative that you STOP all war IMMEDIATELY, and
        // come home for tea and cakes!";
        // String encryptMe = "Hello, please could you tell everyone to stop fighting.
        // It's getting ridiculous!";
        String encryptMe = "Whyyyyyyyyyyyyyyyyyyyyyyyyyyy";

        // Caesar
        int encryptionShift = -5;
        String encryptedCaesar = Caesar.encrypt(encryptMe, encryptionShift);
        String decryptedCaesar = Caesar.decrypt(encryptedCaesar, encryptionShift);

        // Vigenere
        String encryptionKey = "War! Huh! What is it good for?";
        String encryptedVigenere = Vigenere.encrypt(encryptMe, encryptionKey);
        String decryptedVigenere = Vigenere.decrypt(encryptedVigenere, encryptionKey);

        // Print Results
        System.out.println();
        System.out.println("Plain Text:\t\t" + encryptMe);

        System.out.println();
        System.out.println("Caesar Shift:\t\t" + encryptionShift);
        System.out.println("Caesar Encrypted:\t" + encryptedCaesar);
        System.out.println("Caesar Decrypted:\t" + decryptedCaesar);

        System.out.println();
        System.out.println("Vigenere Key:\t\t" + encryptionKey);
        System.out.println("Vigenere Key Sanitised:\t" + Vigenere.sanitiseEncryptionKey(encryptionKey));
        System.out.println("Vigenere Encrypted:\t" + encryptedVigenere);
        System.out.println("Vigenere Decrypted:\t" + decryptedVigenere);
    }
}
