import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private static List<Word> word_list = new ArrayList<>();

    public static void add(Word newWord) {
        word_list.add(newWord);
    }

    public static void addS(String word_target, String word_explain, String word_type) {
        word_list.add(new Word(word_target,word_explain,word_type));
    }

    public int getSize() {
        return word_list.size();
    }

    public Word getWord(int index) {
        return word_list.get(index);
    }

    public String getWordS(int index) {
        Word get = word_list.get(index);
        String output = String.format("%15s | %15s  <%s>",get.getTarget(),get.getExplain(),get.getType());
        return output;
    }
}
