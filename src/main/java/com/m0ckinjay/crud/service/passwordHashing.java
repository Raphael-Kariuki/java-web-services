/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package runner;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author mo
 */
public class passwordHashing {
//    private static final SecureRandom RAND = new SecureRandom();

    /**
     * - Method to generate salt - private so that access is limited to local methods
     * @param length - supply int argument stating length of generated salt
     * @return - Salt as a string if length is greater than 0
     */
    private static Optional<String> generateSalt(final int length) {
        if (length < 1) {
            System.err.println("Error in generateSalt: length must be > 0");
            return Optional.empty();
        }
        //create a byte array that will hold the random bytes generated by secureRandom

        byte[] salt = new byte[length];
        //use of SecureRandom.getInstanceStrong() rather than SecureRandom() as it creates better randoms
        try {
            //fill the byte array with random bytes
            SecureRandom.getInstanceStrong().nextBytes(salt);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(passwordHashing.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }
    /**
     * - Method to hash password - private so that it can only be accessed by the local method 
     *
     * @param password
     * @param salt Iterations are necessary for key stretching and it greatly
     * increases the time required to perform brute-force attacks Using a large
     * salt string also hardens attacks
    *
     */
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;
    private static final String ALGORITHMN = "PBKDF2WithHmacSHA512";

    
    private static Optional<String> hashPassword(char [] password, String salt) {

        /*We work with password in the form of a char array rather than as a string
        This is because Strings are immutable, what will happen when we  
        want to discard it for security reasons, there is no way to overwrite a 
        String, with char[], we simply call Arrays.fill(char[], value_to_fill with)
         */
        //get password and turn to char array - from user
//        char[] chars = password.toCharArray();

        //get the encode salt(String) back to bytes
        byte[] bytes = salt.getBytes();

        //password based encryption - password and salt are cloned before use
        PBEKeySpec spec = new PBEKeySpec(password, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(password, Character.MIN_VALUE);

        try {
            //get algorithmn
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHMN);
            //hash plaintext password according to specifications laid out in spec
            //generateSecret() returns a secretKey object - hashedPassword
            //getEncoded() - to get as byte[]
            byte[] securePassword = secretKeyFactory.generateSecret(spec).getEncoded();
            //encode to Base64 String so that it can be stored in the db as a string without encoding issues
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.err.println("Exception encountered in hashPassword()");
            //return empty optional incase of errors
            return Optional.empty();
        } finally {
            //clear password - executed whether or not exception occurs
            spec.clearPassword();
        }

    }

    /**
     * - Method to confirm user supplied password matches with store password
     * hash
     *
     * @param password
     * @param key
     * @param salt
     * @return boolean True or False depending on the password supplied
     */
    public static boolean verifyPassword(char [] password, String key,
            String salt) {
        Optional<String> optEncrypted = hashPassword(password, salt);
        if (optEncrypted.isEmpty()) {
            return false;
        } else {
            return optEncrypted.get().equals(key);
        }
    }

    /**
     * @param password
     * @return String[] - (0 - password hash, 1 - password salt)
     * publicly accessible
     **/
    public static String[] makeHashedPassword(Optional<String> password) {
        String[] hashString = new String[2];
        if (password.isEmpty()) {
            hashString[0] =  "Error in makeHashPassword(): Empty password";
        }else if(password.isPresent() && password.get().length() <5){
            hashString[0] =  "Error in makeHashPassword(): Weak password";
        }
        else if(password.isPresent() && password.get().length() >5) {
            Optional<String> salt = generateSalt(25);
            Optional<String> hashedPassword = hashPassword(password.get().toCharArray(), salt.get());
            hashString[0] =  hashedPassword.get();
            hashString[1] =  salt.get();
            
        }
        return hashString;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Optional<String> salt = generateSalt(25);
        System.out.println("Salt: " + salt.get() + "Length: " + +salt.get().length());
        Optional<String> hashedPassword = hashPassword("Hello".toCharArray(), salt.get());
        System.out.println("Hashed password: " + hashedPassword.get() + " Length: " + hashedPassword.get().length());

        boolean match = verifyPassword("Hello".toCharArray(), hashedPassword.get(), salt.get());
        boolean match2 = verifyPassword("hello".toCharArray(), hashedPassword.get(), salt.get());

        System.out.print("Match1: " + match + "Char array length: " );
        System.out.println( (hashedPassword.get().toCharArray()).length);
        System.out.println("Match2: " + match2);
//  //Get list available algorithmns that can be used for hashing      
//        List<String> algorithms = Arrays.stream(Security.getProviders())
//  .flatMap(provider -> provider.getServices().stream())
//  .filter(service -> "Cipher".equals(service.getType()))
//  .map(Provider.Service::getAlgorithm)
//  .collect(Collectors.toList());
//        
//        algorithms.forEach(System.out::println);
    }

}
