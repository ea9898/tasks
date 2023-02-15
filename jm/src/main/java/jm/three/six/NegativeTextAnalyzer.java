package jm.three.six;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private final String[] keywords = {":(", "=(", ":|"};

    public NegativeTextAnalyzer() {
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
