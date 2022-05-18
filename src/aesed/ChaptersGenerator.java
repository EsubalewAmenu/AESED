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
public class ChaptersGenerator {
        public static void main(String[] args) {

    String filePath = "";
//    String filePath = "Class 11\\";

String rootFolder = "C:\\Users\\Esubalew\\Desktop\\Class 11\\Urdu\\Nai Awaz\\kuna1dd";
    int subjectId = 204;

            listOfChapterNames(rootFolder+filePath, subjectId);
        }
    
public static void listOfChapterNames(final String parentFolder, int subjectId) {
String chaterName = "";    
final File folder = new File(parentFolder);
    for (final File fileEntry : folder.listFiles()) {
chaterName = "";
        if (fileEntry.isDirectory()) {
//            listOfChapterNames(fileEntry.getAbsolutePath()+"\\", id, prefix);
        } else {
String _endsChars = (fileEntry.getName()).substring((fileEntry.getName().length()-2));

            if(_endsChars.endsWith("ps"))
                chaterName = "Table of Content";
            else if(_endsChars.endsWith("an"))
                chaterName = "Answers";
            else if(_endsChars.endsWith("sm"))
                chaterName = "SUPPLEMENTARY MATERIAL";
            else if(_endsChars.endsWith("a1"))
                chaterName = "Appendix 1";
            else if(_endsChars.endsWith("a2"))
                chaterName = "Appendix 2";
            else if(_endsChars.endsWith("gl"))
                chaterName = "Glossary";
            else if(_endsChars.endsWith("BL"))
                chaterName = "BIBLIOGRAPHY";
            else if(_endsChars.endsWith("ax"))
                chaterName = "Annexure";
            else if(_endsChars.endsWith("in"))
                chaterName = "Index";
            else if(_endsChars.endsWith("fm"))
                chaterName = "FM";
            else if(_endsChars.endsWith("sp"))
                chaterName = "SP";
            else if(_endsChars.endsWith("on"))
                chaterName = "Conclusion";
            else if(_endsChars.endsWith("st"))
                chaterName = "Prisist";

            else if(fileEntry.getName().endsWith("01") || fileEntry.getName().endsWith("02") || fileEntry.getName().endsWith("03") || fileEntry.getName().endsWith("04") || fileEntry.getName().endsWith("05") || fileEntry.getName().endsWith("06") || fileEntry.getName().endsWith("07") || fileEntry.getName().endsWith("08") || fileEntry.getName().endsWith("09") || fileEntry.getName().endsWith("10") || fileEntry.getName().endsWith("11") || fileEntry.getName().endsWith("12") || fileEntry.getName().endsWith("13") || fileEntry.getName().endsWith("14") || 
fileEntry.getName().endsWith("15") || fileEntry.getName().endsWith("16") || fileEntry.getName().endsWith("17") || fileEntry.getName().endsWith("18") || fileEntry.getName().endsWith("19") || fileEntry.getName().endsWith("20") || fileEntry.getName().endsWith("21") || fileEntry.getName().endsWith("22") || fileEntry.getName().endsWith("23") || fileEntry.getName().endsWith("24") || fileEntry.getName().endsWith("25") || fileEntry.getName().endsWith("26") || fileEntry.getName().endsWith("27") || fileEntry.getName().endsWith("28") || fileEntry.getName().endsWith("29")
 || fileEntry.getName().endsWith("30") || fileEntry.getName().endsWith("31") || fileEntry.getName().endsWith("32") || fileEntry.getName().endsWith("33") || fileEntry.getName().endsWith("34") || fileEntry.getName().endsWith("35") || fileEntry.getName().endsWith("36") || fileEntry.getName().endsWith("37") || fileEntry.getName().endsWith("38") || fileEntry.getName().endsWith("39"))
                chaterName = "Chapter "+(fileEntry.getName()).substring((fileEntry.getName().length()-2));

            else System.out.println("Chapter " + (fileEntry.getName()).substring(fileEntry.getName().length()-5, (fileEntry.getName().length()-4)));

System.out.println("INSERT INTO \"main\".\"chapters\"(\"subject_id\",\"chaptername\",\"filename\") VALUES (\""+subjectId+"\",\""+chaterName+"\",\""+fileEntry.getName()+"\");");

        }
    }
}

}
