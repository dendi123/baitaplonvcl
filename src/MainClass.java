import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.Arrays;

public class MainClass extends SimpleFileVisitor<Path> {
    public ArrayList< Class> list = new ArrayList<>();
    public MainClass( String path) {
        try {
            arrayListToString( path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  ArrayList testString(String test) throws Exception
    {
        String[] stringTest = stringToArray(test);
        ArrayList stringtester = new ArrayList();
        for(int i=0;i<stringTest.length;i++)
        {
            if(stringTest[i].contains("public")
                    || stringTest[i].contains("private")
                    || stringTest[i].contains("protected"))
            {
                if(stringTest[i+1].contains("double")
                        || stringTest[i+1].contains("int")
                        || stringTest[i+1].contains("String")
                        || stringTest[i+1].contains("void"))
                {
                   if(stringTest[i+2].contains("("))
                   {
                       if(stringTest[i+3].contains(")"))
                       {
                           stringtester.add(stringTest[i] + " " + stringTest[i+1] + " " +  stringTest[i+2] + " "+stringTest[i+3] + "<br>");
                       }
                       else
                       {
                          if(!stringTest[i+4].contains(","))
                          {
                              stringtester.add(stringTest[i] + " " + stringTest[i+1] + " " +  stringTest[i+2] + "<br>");
                          }
                          else
                          {
                              while (!stringTest[i].contains("{"))
                              {
                                  stringtester.add(stringTest[i]+ " ");
                                  i++;
                              }
                              stringtester.add("<br>");
                          }

                       }
                   }
                }
            }
        }
        return stringtester;
    }

    public String readFile(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
        String st;
        String tmp = "";
        while ((st = br.readLine()) != null) {
            st = st.replaceAll("//(.*)", " ");
            st = st.replaceAll("/\\*(.|[\\r\\n])*\\*/"," ");
            st = st.replaceAll(",+"," , ");
//            st = st.replaceAll("\\)\\s?\\{","{");
            st = st.replaceAll("\\s+", " ");
            tmp += st;
            tmp = tmp.replaceAll("\\s+", " ");
        }
        return tmp;
    }

    public String[] stringToArray(String s) throws Exception {
        String[] array = s.split("\\s");
        return array;
    }

    public ArrayList getClassName(String s) throws Exception {
        String[] className = stringToArray(s);
        ArrayList arrayClassName = new ArrayList();
        for (int i = 0; i < className.length; i++) {
            if (className[i].contains("class")) {
                if (className[i + 2].contains("extends")) {
                    arrayClassName.add("Class: " + className[i + 1] + " extends: " + className[i + 3] );
                } else {
                    arrayClassName.add("Class: " + className[i + 1] );
                }
            }
        }
        return arrayClassName;
    }

    public ArrayList getAttributeName(String s) throws Exception {
        String[] attributeName = stringToArray(s);
        ArrayList arrayAttributeName = new ArrayList();
        for (int i = 0; i < attributeName.length; i++) {
            if ((attributeName[i].contains("public") || attributeName[i].contains("private") || attributeName[i].contains("protected")) && !attributeName[i + 1].contains("class")) {
                if ((attributeName[i + 1].contains("final") || attributeName[i + 1].contains("static")) && !attributeName[i + 1].contains("(")) {
                    if(attributeName[i + 2].contains("double") || attributeName[i + 2].contains("int") || attributeName[i + 2].contains("String") || attributeName[i + 2].contains("float") || attributeName[i + 2].contains("boolean")){
                        if (!attributeName[i + 3].contains("(")) {
                            arrayAttributeName.add( attributeName[i + 3] + "<br>");
                        }
                    }
                }
                else {
                    if((attributeName[i + 1].contains("double") || attributeName[i + 1].contains("int") || attributeName[i + 1].contains("String") || attributeName[i + 1].contains("float") || attributeName[i + 1].contains("boolean")) && !attributeName[i + 1].contains("(")){
                        if (!attributeName[i + 2].contains("{") && !attributeName[i + 2].contains("(")) {
                            arrayAttributeName.add( attributeName[i + 2] + "<br>");
                        }
                    }
                }
            }
        }
        return arrayAttributeName;
    }

    public void arrayListToString(String filePath) throws Exception{
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();
        ArrayList filesList = new ArrayList();
        for(File file : listOfFiles)
        {
            if(file.isFile())
            {
                for(int i = 0;i < listOfFiles.length;i++)
                {
                    ArrayList b = getClassName(readFile(file.getPath()));
                    Object[] classList = b.toArray();
                    String[] classString =  Arrays.copyOf(classList,classList.length,String[].class);
                    //
                    Class A = new Class();
                    A.className = "<html>";
                    for(int j = 0; j < classString.length; j++){
                        A.className +=classString[j];
                    }
                    //
                    ArrayList c = getAttributeName(readFile(file.getPath()));
                    Object[] attributeList = c.toArray();
                    String[] attributeString =  Arrays.copyOf(attributeList,attributeList.length,String[].class);
                    A.attributesName = "<html>";

                    for(int j = 0; j < attributeString.length; j++){
                        A.attributesName += attributeString[j];
                    }
                    //

                    ArrayList a = testString(readFile(file.getPath()));
                    Object[] methodList = a.toArray();
                    String[] methodString =  Arrays.copyOf(methodList,methodList.length,String[].class);
                    A.methodsName = "<html>";
                    for(int j = 0 ; j < methodString.length; j++)
                    {
                        A.methodsName += methodString[j];
                    }
                    list.add( A);
                    break;
                }
            }
        }
    }
}