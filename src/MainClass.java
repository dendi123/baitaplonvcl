import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class MainClass {

    public static void main(String[] args) throws Exception,IOException
    {
        String fileName = "C:\\Users\\Mangosteen\\Documents\\GitHub\\baitaplonvcl\\src\\test\\Circle.java";
        ArrayList className = getClassName(readFile(fileName));
        ArrayList b = getMethodName(readFile(fileName));
        ArrayList c = getAttributeName(readFile(fileName));
        for(int i = 0; i < className.size(); i++){
            System.out.println(className.get(i));
        }
        System.out.println("Method: " + "\n");
        for(int i = 0; i < b.size(); i++){
            System.out.println(b.get(i));
        }
        System.out.println("\n");
        System.out.println("Attribute: " + "\n");
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

    public static ArrayList getMethodName(String method) throws Exception {
        String[] methodName = stringToArray(method);
        int countOpen = 0;
        ArrayList arrayMethodName = new ArrayList();
        for (int i = 0; i < methodName.length; i++) {
            if (methodName[i].contains("public") || methodName[i].contains("private") || methodName[i].contains("protected")) {
                if (methodName[i + 1].contains("double") || methodName[i + 1].contains("int") || methodName[i + 1].contains("String") || methodName[i + 1].contains("void")) {
                    if (methodName[i + 2].contains("(")) {
                        if (methodName[i + 3].contains("int") || methodName[i + 3].contains("String") || methodName[i + 3].contains("float") || methodName[i + 3].contains("double")) {

                            arrayMethodName.add("" + methodName[i + 2] + " " + methodName[i + 3] + " ");


                        } else {
                            if (methodName[i + 4].contains(",")) {
                                if (methodName[i + 5].contains("int") || methodName[i + 5].contains("String") || methodName[i + 5].contains("float") || methodName[i + 5].contains("double")) {
                                    arrayMethodName.add("" +methodName[i+2]+" "+methodName[i+3]+" "+ methodName[i + 4] +" " + methodName[i + 5] +" "+methodName[i+6]);

                                }
                            }
                            else {
                                arrayMethodName.add("" + methodName[i + 2] + methodName[i + 3]);
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
                        arrayAttributeName.add("" + attributeName[i + 3]);
                    }
                }
                else{
                    if(!attributeName[i + 2].contains("(")){
                        arrayAttributeName.add("" + attributeName[i + 2]);
                    }
                }
            }
        }
        return arrayAttributeName;
    }
}
