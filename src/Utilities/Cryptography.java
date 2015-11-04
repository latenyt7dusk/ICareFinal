/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Kelvin Nakpil
 */
public class Cryptography {
    
    public static void main(String args[]){
        System.out.println(base64encode("admin"));
        System.out.println(base64decode("YWRtaW4="));
    }
    
    
    //<editor-fold defaultstate="collapsed" desc=" File Crypto Block">  
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    public static final String KEYPASS = "dWr2rUfD7EzJfUcK";

    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public static void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    private static void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }

    public static class CryptoException extends Exception {

        public CryptoException() {
        }

        public CryptoException(String message, Throwable throwable) {
            super(message, throwable);
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" String Crypto Block"> 
    public static String xorMessage(String message, String key) {
        try {
            if (message == null || key == null) {
                return null;
            }

            char[] keys = key.toCharArray();
            char[] mesg = message.toCharArray();

            int ml = mesg.length;
            int kl = keys.length;
            char[] newmsg = new char[ml];

            for (int i = 0; i < ml; i++) {
                newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
            }//for i
            mesg = null;
            keys = null;
            return new String(newmsg);
        } catch (Exception e) {
            return null;
        }
    }//xorMessage

    public static final String DEFAULT_ENCODING = "UTF-8";
        
    public static String base64encode(String text) {
        try {
            String rez = Base64.getEncoder().encodeToString(text.getBytes(DEFAULT_ENCODING));
            return rez;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }//base64encode

    public static String base64decode(String text) {

        try {
            return new String(Base64.getDecoder().decode(text), DEFAULT_ENCODING);
        } catch (IOException e) {
            return null;
        }

    }//base64decode

    public static String EncryptText(String text, String key) {
        return base64encode(xorMessage(text, key));
    }

    public static String DecryptText(String text, String key) {
        return xorMessage(base64decode(text), key);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" UUID Code Block">  
    public static String getNewID(String hd) {
        try {
            Calendar cal = Calendar.getInstance();            
            String temp[] = cal.getTime().toString().split("[: ]");
            String e = hd+ cal.get(Calendar.YEAR) + "" + (((cal.get(Calendar.MONTH)+1) < 10)? "0"+(cal.get(Calendar.MONTH)+1):(cal.get(Calendar.MONTH)+1)) + "" + cal.get(Calendar.DAY_OF_MONTH) + "-" + temp[3] + temp[4] + temp[5];
            return e;
        } catch (Exception er) {
            System.out.println(er);
            return null;
        }
    }
    //</editor-fold>

    
    
}
