/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesed;

import java.io.File;
import java.util.UUID;

/**
 *
 * @author Toshiiba
 */
public class BookEncryptDec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
String rootFolder = "C:\\Users\\Esubalew\\Desktop\\";

    String filePath = "Class 11\\";
    
String password = generateRandomStringByUUIDNoDash();
//password = "6036e6c8a57d44198a7ed279d2f5cfd5";//12
password = "c96a6242bd1b484cb636e46a801d1647";//11
System.out.println("Password is = '" + password + "'");

          listFilesForFolder(rootFolder+filePath, "e", password);
//      listFilesForFolder(rootFolder+filePath, "d", password);

//String sLoc = "D:\\All\\Documents\\Ethiopian 9-12 text books -arranged\\teachers guide\\11\\mat\\MathTGG11";
//    try { new AESED().dec(sLoc+"\\", "tg11match6", "93e5886cd42b478ab6372f7d852f75b4");} catch (Exception e) {e.printStackTrace();}
////    try {new AESED().enc(rootFolder+filePath, passwordPrifix);} catch (Exception e) {e.printStackTrace();}
            
System.out.println("Done!");
                        
    }
    
    public static void listFilesForFolder(final String parentFolder, String encDec, String key) {
    
final File folder = new File(parentFolder);
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry.getAbsolutePath()+"\\", encDec, key);
        } else {

//            System.out.println(fileEntry.getName()+" Started!!");   
            System.out.println(parentFolder+" "+ fileEntry.getName());            

            if(encDec.equalsIgnoreCase("e"))
                try {new AESED().enc(parentFolder, fileEntry.getName(), key);} catch (Exception e) {e.printStackTrace();}
 
                else if(encDec.equalsIgnoreCase("d"))
            
            try { new AESED().dec(parentFolder, fileEntry.getName(), key);} catch (Exception e) {e.printStackTrace();}

//            pdfRenderer(parentFolder, fileEntry.getName());
        }
    }
}

        public static String generateRandomStringByUUIDNoDash() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
