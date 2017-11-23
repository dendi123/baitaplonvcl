import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MainClass extends SimpleFileVisitor<Path>
{

    public static void main(String[] args) throws Exception, IOException
    {
        String fileName = "C:\\Users\\Mangosteen\\Documents\\GitHub\\baitaplonvcl\\src\\test\\Circle.java";
        ArrayList className = getClassName(readFile(fileName));
        ArrayList c = getAttributeName(readFile(fileName));
//       { for(int i = 0; i < className.size(); i++){
//            System.out.println(className.get(i));
//        }
//            System.out.println("Method: " + "\n");
//            for(int i = 0; i < b.size(); i++){
//                System.out.println(b.get(i));
//            }
//            System.out.println("\n");
//            System.out.println("Attribute: " + "\n");
//            for(int i = 0; i < c.size(); i++)
//            System.out.println(c.get(i));
//       }
//        Files.walkFileTree(Paths.get("C:\\Users\\Mangosteen\\Documents\\GitHub\\baitaplonvcl\\src\\test"), new MainClass());
        File folder = new File("C:\\Users\\Mangosteen\\Documents\\GitHub\\baitaplonvcl\\src\\test");
        File[] listOfFiles = folder.listFiles();
        ArrayList filesList = new ArrayList();

        for(File file : listOfFiles)
        {
            if(file.isFile())
            {
                System.out.println(file.getName());
                for(int i=0;i<listOfFiles.length;i++)
                {
                    ArrayList d = testString(readFile(file.getPath()));
                    for(int j=0 ; j < d.size() ; j++)
                    {
                        System.out.print(d.get(j));
                    }
                    break;
                }
            }
            System.out.println("--------------" + "\n");
        }
    }


    public static ArrayList testString(String test) throws Exception
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
                           stringtester.add(stringTest[i] + " " + stringTest[i+1] + " " +  stringTest[i+2] + " "+stringTest[i+3] + "\n");
                       }
                       else
                       {
                          if(!stringTest[i+4].contains(","))
                          {
                              stringtester.add(stringTest[i] + " " + stringTest[i+1] + " " +  stringTest[i+2] + "\n");
                          }
                          else
                          {
                              while (!stringTest[i].contains("{"))
                              {
                                  stringtester.add(stringTest[i]+ " ");
                                  i++;
                              }
                              stringtester.add("\n");
                          }

                       }
                   }
                }
            }
        }
        return stringtester;
    }

    public static String readFile(String fileName) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
        String st;
        String tmp = "";
        while ((st = br.readLine()) != null) {
            st = st.replaceAll("//(.*)", " ");
            st = st.replaceAll(",+"," , ");
            st = st.replaceAll("\\s+", " ");
            tmp += st;
            tmp = tmp.replaceAll("\\s+", " ");
        }
        return tmp;
    }

    public static String[] stringToArray(String s) throws Exception, IOException {
        String[] array = s.split("\\s");
        return array;
    }

    public static ArrayList getClassName(String s) throws Exception, IOException {
        String[] className = stringToArray(s);
        ArrayList arrayClassName = new ArrayList();
        for (int i = 0; i < className.length; i++) {
            if (className[i].contains("class")) {
                if (className[i + 2].contains("extends")) {
                    arrayClassName.add("Class: " + className[i + 1] + " extends: " + className[i + 3] + "\n");
                } else {
                    arrayClassName.add("Class: " + className[i + 1] + "\n");
                }
            }
        }
        return arrayClassName;
    }

    public static ArrayList getAttributeName(String attribute) throws Exception {
        String[] attributeName = stringToArray(attribute);
        ArrayList arrayAttributeName = new ArrayList();
        for (int i = 0; i < attributeName.length; i++) {
            if ((attributeName[i].contains("public") || attributeName[i].contains("private") || attributeName[i].contains("protected")) && !attributeName[i + 1].contains("class")) {
                if (attributeName[i + 1].contains("final") || attributeName[i + 1].contains("static")) {
                    if (!attributeName[i + 3].contains("(")) {
                        arrayAttributeName.add("" + attributeName[i + 3]);
                    }
                } else {
                    if (!attributeName[i + 2].contains("(")) {
                        arrayAttributeName.add("" + attributeName[i + 2]);
                    }
                }
            }
        }
        return arrayAttributeName;
    }


}

