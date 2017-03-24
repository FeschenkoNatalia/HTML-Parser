import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlHandler handler = new HtmlHandler();
        StringBuilder htmlDocument = handler.handleWebPage("https://eda.ru/recepty/osnovnye-blyuda/kurica-pikasso-25902");
        ParseHtml parseHtmlSymbols = new ParseHtmlSymbols();
        String resultedDocument = parseHtmlSymbols.parseHtml(htmlDocument.toString());
        ParseHtml parseHtmlTags = new ParseHtmlTags();
        System.out.println(parseHtmlTags.parseHtml(resultedDocument));
       }
}
