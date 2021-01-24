package guiProject;

 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;

 

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

 

/**
 * A tester for the CryptoUtils class.
 * 
 * @author www.codejava.net
 *
 */
public class Crypt {
    static byte[] encrypted;

 

    public static void main(String[] args) {
        String key = "Mary5has4a3cat12";

 

        // SecretKey key;
        try {

 

            byte[] cryptedHello = encrypt("name: GitHub\r\n"
            		+ "email: name@gmail.com\r\n"
            		+ "username: NameIT\r\n"
            		+ "password: flower67\r\n"
            		+ "link: https://github.com/\r\n"
            		+ "name: Pinterest\r\n"
            		+ "email: name567@abv.bg\r\n"
            		+ "username: Name98\r\n"
            		+ "password: catsname\r\n"
            		+ "link: https://www.pinterest.com/\r\n"
            		+ "name: Gmail\r\n"
            		+ "email: name@gmail.com\r\n"
            		+ "username: Name4567\r\n"
            		+ "password: smth345267\r\n"
            		+ "link: https://mail.google.com/mail/u/0/", key);
            System.out.println(cryptedHello);
            String fileName = "cryppt.txt";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            outputStream.write(cryptedHello);
            outputStream.close();

 

            File inputFile = new File(fileName);
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            String decryptedHello = decrypt(inputBytes, key);
            System.out.println(decryptedHello);
            inputStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

 

    public static byte[] encrypt(String strClearText, String strKey) throws Exception {
        String strData = "";
        byte[] encrypted;
        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            encrypted = cipher.doFinal(strClearText.getBytes("UTF-8"));
            // System.out.print(encrypted);
            strData = encrypted.toString();
            byte[] array = strData.getBytes();
            System.out.println(encrypted.length + " " + strData.length() + " " + array.length);

 

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return encrypted;
    }

 

    public static String decrypt(byte[] encrypted, String strKey) throws Exception {
        String strData = "";

 

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);

 

            byte[] decrypted = cipher.doFinal(encrypted);
            strData = new String(decrypted);

 

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }
}