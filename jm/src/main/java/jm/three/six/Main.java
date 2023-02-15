package jm.three.six;

public class Main {
    public static void main(String[] args) {

    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text) != Label.OK) {
                return  analyzer.processText(text);
            }
        }
        return Label.OK;
    }
}
