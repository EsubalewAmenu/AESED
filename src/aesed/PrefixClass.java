/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesed;

import java.io.File;

/**
 *
 * @author Root
 */
public class PrefixClass {
        public static void main(String[] args) {
String rootFolder = "C:\\Users\\Esubalew\\Desktop\\";

    String filePath = "Class 11\\";
    int id = 5;
    String prefix = "i11";

    listFilesForFolder(rootFolder+filePath, id, prefix);
            listOfChapterNames(rootFolder+filePath, id, prefix);
        }
            public static void listFilesForFolder(final String parentFolder, int id, String prefix) {
    
final File folder = new File(parentFolder);
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
//            listFilesForFolder(fileEntry.getAbsolutePath(), encDec, key);
        } else {
            
            File newFile = new File(parentFolder+prefix+fileEntry.getName());
            fileEntry.renameTo(newFile);
//            System.out.println("(1, '"+id+"', 'Chapter "+id+",' '" +prefix+fileEntry.getName()+"'),");
            System.out.println(prefix+(fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)));            
        }
    }
}
            
            public static void listOfChapterNames(final String parentFolder, int id, String prefix) {
    
final File folder = new File(parentFolder);
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry.getAbsolutePath()+"\\", id, prefix);
            listOfChapterNames(fileEntry.getAbsolutePath()+"\\", id, prefix);
//            listFilesForFolder(fileEntry.getAbsolutePath(), encDec, key);
        } else {
            if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("ps"))
                System.out.println("Table of Content");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("an"))
                System.out.println("Answers");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("sm"))
                System.out.println("SUPPLEMENTARY MATERIAL");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("a1"))
                System.out.println("Appendix 1");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("a2"))
                System.out.println("Appendix 2");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("gl"))
                System.out.println("Glossary");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("cc"))
                System.out.println("");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("BL"))
                System.out.println("BIBLIOGRAPHY");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("ax"))
                System.out.println("Annexure");
            else if((fileEntry.getName()).substring(0, (fileEntry.getName().length()-4)).endsWith("in"))
                System.out.println("Index");
            else System.out.println("Chapter " + (fileEntry.getName()).substring(fileEntry.getName().length()-5, (fileEntry.getName().length()-4)));

        }
    }
}

}
