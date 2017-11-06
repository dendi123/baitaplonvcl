import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
//    public static final String FILENAME = "C:/Users/Mangosteen/Desktop/Project/src";
    public static String javaFile = "C:\\Users\\Mangosteen\\Desktop\\Project\\src\\listFilesForFolder.java";

    public static void main(String[] args) throws Exception,IOException
    {
//        System.out.println("Java files in your folder: \n");
//        final File folder = new File(FILENAME);
//        listFilesForFolder.listFilesForFolder(folder);
        ArrayList a = getClassName(readFile(javaFile));
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
    public static String readFile(String fileName) throws Exception,IOException {
        File fileToRead = new File(fileName);
        BufferedReader br = new BufferedReader(fileToRead);
        String st;
        String tmp = "";
        while((st = br.readLine()) != null){
            st = st.replaceAll("//(.*)","");
            st = st.replaceAll("\\s+"," ");
            tmp += st;
            tmp = tmp.replaceAll("\\s+"," ");
            System.out.print(st);
        }
        return tmp;
    }

    public static String[] stringToArray(String s) throws Exception,IOException{
        String[] array = s.split("\\s");
        return array;
    }

    public static ArrayList getClassName(String s) throws Exception,IOException{
        String[] className = stringToArray(s);
        ArrayList arrayClassName = new ArrayList();
        for(int i = 0; i < className.length; i++){
            if(className[i].equals("class")){
                if(className[i + 2].equals("extends")){
                    arrayClassName.add(" " + className[i + 1] + " " + className[i + 2] + " " + className[i + 3]);
                }
                else{
                    arrayClassName.add(" " + className[i + 1]);
                }
            }
        }
        return arrayClassName;
    }
}
