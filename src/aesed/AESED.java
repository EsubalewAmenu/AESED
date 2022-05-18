/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesed;

/**
 *
 * @author Toshiiba
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.spec.KeySpec;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESED {


    public boolean enc(String fileFolder, String fileName, String password) throws Exception {
        // file to be encrypted
    // password to encrypt the file
//    String password = generateRandomStringByUUIDNoDash();
//    
//System.out.println("Password is = '" + password + "'");
//
//password = passwordPrifix+password;

    FileInputStream inFile = new FileInputStream(fileFolder+fileName);

        // encrypted file
        FileOutputStream outFile = new FileOutputStream(fileFolder+fileName.substring(0, fileName.length()-3));
        byte[] salt = {69, 121, 101, 45, 62, 118, 101, 114, 69, 121, 101, 45, 62, 118, 101, 114};

        SecretKeyFactory factory = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA1");
        KeySpec keySpec = new PBEKeySpec((password+fileName).toCharArray(), salt, 65536,
                256);
        System.out.println("enc full Password is " + password+fileName);
        SecretKey secretKey = factory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        //
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        
IvParameterSpec ivspec = new IvParameterSpec(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        cipher.init(Cipher.ENCRYPT_MODE, secret, ivspec);
        
        byte[] input = new byte[64];
        int bytesRead;

        while ((bytesRead = inFile.read(input)) != -1) {
            byte[] output = cipher.update(input, 0, bytesRead);
            if (output != null)
                outFile.write(output);
        }

        byte[] output = cipher.doFinal();
        if (output != null)
            outFile.write(output);

        inFile.close();
        outFile.flush();
        outFile.close();

        System.out.println("File Encrypted.");
return true;
    }
    public void dec(String filefolder, String fileName, String key) throws Exception {
    byte[] salt = {69, 121, 101, 45, 62, 118, 101, 114, 69, 121, 101, 45, 62, 118, 101, 114};

        SecretKeyFactory factory = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA1");
        String fullPassword = key+fileName+".pdf";
        System.out.println("full Password is " + fullPassword);
        KeySpec keySpec = new PBEKeySpec(fullPassword.toCharArray(), salt, 65536,
                256);
        SecretKey tmp = factory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        // file decryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        
IvParameterSpec ivspec = new IvParameterSpec(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
    cipher.init(Cipher.DECRYPT_MODE, secret, ivspec);
    System.out.println(fileName.substring(0, fileName.length()-3));
        FileInputStream fis = new FileInputStream(filefolder+fileName);
        FileOutputStream fos = new FileOutputStream(filefolder+fileName+"nor.pdf");
        byte[] in = new byte[64];
        int read;
        while ((read = fis.read(in)) != -1) {
            byte[] output = cipher.update(in, 0, read);
            if (output != null)
                fos.write(output);
        }

        byte[] output = cipher.doFinal();
        if (output != null)
            fos.write(output);
        fis.close();
        fos.flush();
        fos.close();
        System.out.println("File Decrypted.");
        
    }

    public static String generateRandomStringByUUIDNoDash() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}