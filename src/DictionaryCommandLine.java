/**
 * Java Dictionary v1.5
 * @author TehCoesy Nguyễn Minh Khôi
 * @author Cat Nguyễn Quý Thịnh
 * @since 28/09/2018
 * @version v1.5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandLine {
    private static DictionaryManagement m_dictionary = new DictionaryManagement();
    private static List<String> ls_command = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static int commandParse(String input) {
        for (String element : ls_command) {
            if (element.compareTo(input) == 0) {
                switch(ls_command.indexOf(element)) {
                    case 0: m_dictionary.sayHello();  break;
                    case 1: printHelp(); break;
                    case 2: showAllWord(); break;
                    case 3: dictionaryBasic(); break;
                    case 4: dictionaryAdvanced(); break;
                    case 5: dictionaryLookup(); break;
                }
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        init();
        String commandLine ;

        System.out.println("Java Dictionary English-Vietnamese v1.2");
        System.out.println("'help' for available commands");
        boolean m_Loop = true;
        while (m_Loop) {
            System.out.print("> ");
            commandLine = scanner.nextLine();
            if (commandLine.compareTo("exit") == 0) {
                m_Loop = false;
                break;
            } else if (commandParse(commandLine) == 1){

            } else {
                System.out.println("No such command.");
            }
        }
    }

    public static void init() {
        ls_command.add("sayHello");
        ls_command.add("help");
        ls_command.add("listAll");
        ls_command.add("basic");
        ls_command.add("advanced");
        ls_command.add("lookUp");
    }

    //Commands
    public static void printHelp() {
        System.out.println("List of available commands: ");
        System.out.println("'exit' | Exit the program.");
        System.out.println("'sayHello' | Self-explanatory");
        System.out.println("'basic' | Add a new word and list all words in the dictionary.");
        System.out.println("'advanced' | Advanced functions.");
        System.out.println("'listAll' | List all words in the dictionary.");
        System.out.println("'lookUp' | Find a word.");
    }

    public static void dictionaryBasic() {
        m_dictionary.insertFromCommandLine();
        showAllWord();
    }

    public static void dictionaryAdvanced() {
        m_dictionary.insertFromFile("dictionary.txt");
        showAllWord();
        dictionaryLookup();
    }

    public static void showAllWord() {
        m_dictionary.listAll();
    }

    public static void dictionaryLookup() {
        m_dictionary.lookUp();
    }
}
