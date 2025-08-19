package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}

interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();
    abstract protected Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword))
                return getLabel();
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label;
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
        label = Label.SPAM;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label;
    public NegativeTextAnalyzer() {
        this.keywords = new String[3];
        this.keywords[0] = ":(";
        this.keywords[1] = "=(";
        this.keywords[2] = ":|";
        label = Label.NEGATIVE_TEXT;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }

}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength)
            return Label.TOO_LONG;
        return Label.OK;
    }

}

public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    for(TextAnalyzer analyzer: analyzers) {
        if(analyzer.processText(text) != Label.OK) return analyzer.processText(text);
    }
    return Label.OK;
}