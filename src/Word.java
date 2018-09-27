public class Word {
    private String word_target, word_explain,word_type;

    //Constructor
    Word(String word_target, String word_explain, String word_type) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.word_type = word_type;
    }

    Word() {
        this.word_target = "Default";
        this.word_explain = "Mặc định";
        this.word_type = "NIL";
    }

    public String getTarget() {
        return word_target;
    }

    public void setTarget(String word_target) {
        this.word_target = word_target;
    }

    public String getExplain() {
        return word_explain;
    }

    public void setExplain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getType() {
        return word_type;
    }

    public void setWord_type(String word_type) {
        this.word_type = word_type;
    }
}
