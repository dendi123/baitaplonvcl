import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) throws Exception,IOException
    {
        String fileName = "D:\\baitaplonvcl\\src\\listFilesForFolder.java";
        ArrayList a = getClassName(readFile(fileName));
        ArrayList b = getMethodName(readFile(fileName));
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
//        for(int i = 0; i < b.size(); i++){
//            System.out.println(b.get(i) + " \n");
//        }
    }
    public static String readFile(String fileName) throws Exception,IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
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
                    arrayClassName.add(" " + className[i + 1]);
                }
                else{
                    arrayClassName.add(" " + className[i + 1] + " ");
                }
            }
        }
        return arrayClassName;
    }

    public static ArrayList getMethodName(String method) throws Exception{
        String[] methodName = stringToArray(method);
        ArrayList arrayMethodName = new ArrayList();
        for(int i = 0; i < methodName.length; i++){
            if((methodName[i].equals("int") || methodName[i].equals("double") || methodName[i].equals("String") || methodName[i].equals("void")) && methodName[i + 2].equals("(")){
                arrayMethodName.add("" + methodName[i + 1]);
            }
        }
        return arrayMethodName;
    }
}
