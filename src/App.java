import cipher.Caeser;
import cipher.Vigenere;

public class App {
    public static void main(String[] args) throws Exception {
        // String encryptMe = "It is imperative that you STOP all war IMMEDIATELY, and
        // come home for tea and cakes!";
        // String encryptMe = "Hello, please could you tell everyone to stop fighting.
        // It's getting ridiculus!";
        String encryptMe = "Whyyyyyyyyyyyyyyyyyyyyyyyyyyy";

        // Caeser
        int encryptionShift = -5;
        String encryptedCaeser = Caeser.encrypt(encryptMe, encryptionShift);
        String decryptedCaeser = Caeser.decrypt(encryptedCaeser, encryptionShift);

        // Vignere
        String encryptionKey = "War! Huh! What is it good for?";
        String encryptedVigenere = Vigenere.encrypt(encryptMe, encryptionKey);
        String decryptedVigenere = Vigenere.decrypt(encryptedVigenere, encryptionKey);

        // Print Results
        System.out.println();
        System.out.println("Plain Text:\t\t" + encryptMe);

        System.out.println();
        System.out.println("Caeser Shift:\t\t" + encryptionShift);
        System.out.println("Caeser Encrypted:\t" + encryptedCaeser);
        System.out.println("Caeser Decrypted:\t" + decryptedCaeser);

        System.out.println();
        System.out.println("Vignere Key:\t\t" + encryptionKey);
        System.out.println("Vignere Key Sanitised:\t" + Vigenere.sanitiseEncryptionKey(encryptionKey));
        System.out.println("Vignere Encrypted:\t" + encryptedVigenere);
        System.out.println("Vignere Decrypted:\t" + decryptedVigenere);
    }
}
