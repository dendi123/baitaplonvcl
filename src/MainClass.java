import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class MainClass {

    public static void main(String[] args) throws Exception,IOException
    {
        String fileName = "D:\\baitaplonvcl\\src\\test\\Circle.java";
        ArrayList className = getClassName(readFile(fileName));
        ArrayList b = getMethodName(readFile(fileName));
        ArrayList c = getAttributeName(readFile(fileName));
        for(int i = 0; i < className.size(); i++){
            System.out.println(className.get(i));
        }
        for(int i = 0; i < b.size(); i++){
            System.out.println(b.get(i));
        }
        for(int i = 0; i < c.size(); i++){
            System.out.println(c.get(i));
        }
    }

    public static String readFile(String fileName) throws Exception,IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
        String st;
        String tmp = "";
        while((st = br.readLine()) != null){
            st = st.replaceAll("//(.*)"," ");
            st = st.replaceAll("\\s+"," ");
            tmp += st;
            tmp = tmp.replaceAll("\\s+"," ");
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
            if(className[i].contains("class")){
                if(className[i + 2].contains("extends")){
                    arrayClassName.add("Class: " + className[i + 1] + " extends: " + className[i + 3] + "\n");
                }
                else{
                    arrayClassName.add("Class: " + className[i + 1] + "\n");
                }
            }
        }
        return arrayClassName;
    }

    public static ArrayList getMethodName(String method) throws Exception{
        String[] methodName = stringToArray(method);
        int countOpen = 0;
        ArrayList arrayMethodName = new ArrayList();
        for(int i = 0; i < methodName.length; i++){
            if(methodName[i].contains("public") || methodName[i].contains("private") || methodName[i].contains("protected")){
                if(methodName[i + 1].contains("double") || methodName[i + 1].contains("int") || methodName[i + 1].contains("String") || methodName[i + 1].contains("void")){
                    if(methodName[i + 2].contains("(")) {
                        for (int j = 0; j < methodName.length; j++) {
                            if (methodName[j] == "(") {
                                for (int k = j; k < methodName.length; k++) {
                                    if (methodName[k] == ")") {
                                        arrayMethodName.add("Method: " + methodName[k + j] + " \n");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayMethodName;
    }

    public static ArrayList getAttributeName(String attribute) throws Exception{
        String[] attributeName = stringToArray(attribute);
        ArrayList arrayAttributeName = new ArrayList();
        for(int i = 0; i < attributeName.length; i++){
            if((attributeName[i].contains("public") || attributeName[i].contains("private") || attributeName[i].contains("protected")) && !attributeName[i + 1].contains("class")){
                if(attributeName[i + 1].contains("final") || attributeName[i + 1].contains("static") ){
                    if(!attributeName[i + 3].contains("(")){
                        arrayAttributeName.add("Attribute: " + attributeName[i + 3] + " \n");
                    }
                }
                else{
                    if(!attributeName[i + 2].contains("(")){
                        arrayAttributeName.add("Attribute: " + attributeName[i + 2] + " \n");
                    }
                }
            }
        }
        return arrayAttributeName;
    }
}
