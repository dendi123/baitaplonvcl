import java.io.*;
import java.io.File;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readFile {
    public static String readFile(String File) throws Exception {
        File file = new File(File);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String tmp = "";
        while((st = br.readLine()) != null){
            st = st.replaceAll("//(.*)","");
            st = st.replaceAll("\\s+"," ");
            tmp += st;
            tmp = tmp.replaceAll("\\s+"," ");
            System.out.print(st);
        }
        System.out.print(st);
        return(st);
    }

    public static String[] stringToArray(String s) throws Exception{
        String[] array = s.split("\\s");
        return array;
    }

    public static ArrayList getClassName(String s) throws Exception{
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