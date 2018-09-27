import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    private static Scanner scan = new Scanner(System.in);
    private Dictionary dictionary = new Dictionary();

    public void sayHello() {
        System.out.println("Hello!");
    }

    public void insertFromCommandLine() {
        System.out.print("English Word: ");
        String in1 = scan.nextLine();
        System.out.print("Explanation: ");
        String in2 = scan.nextLine();
        System.out.print("Word Type: ");
        String in3 = scan.nextLine();
        dictionary.addS(in1,in2,in3);
    }

    public void listAll() {
        System.out.printf("%15s | %15s\n","Word","Explanation");
        int n = dictionary.getSize();
        for (int i = 0; i < n; i++) {
            System.out.println(dictionary.getWordS(i));
        }
    }

    public void lookUp() {
        System.out.print("Target: ");
        String input = scan.nextLine();
        if (Character.isLowerCase(input.charAt(0))) {
            input = capitalize(input);
        }
        int n = dictionary.getSize();
        for (int i = 0; i < n; i++) {
            if (dictionary.getWord(i).getTarget().equals(input)) {
                System.out.printf("%15s | %15s\n","Word","Explanation");
                System.out.println(dictionary.getWordS(i));
                return;
            }
        }
        System.out.println("No such word found.");
    }

    public void insertFromFile(String file_name) {
        FileInputStream fstream;
        try {
            fstream = new FileInputStream(String.format("./Resources/%s",file_name));
        } catch (FileNotFoundException e) {
            System.out.printf("File '%s' not found.\n",file_name);
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
        String strLine = null;

        while (true) {
            try {
                strLine = reader.readLine();
            } catch (IOException e) {

            }
            if (strLine != null) {
                String[] tokens = strLine.split("   ");
                String word_target = tokens[0];
                String word_explain = tokens[1];
                String word_type = tokens[2];
                Dictionary.addS(word_target,word_explain,word_type);
            } else {
                break;
            }
        }

        System.out.printf("Input from '%s' successful.\n",file_name);
    }

    //String handling
    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
