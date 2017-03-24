import java.util.HashMap;
import java.util.Map;

public class ParseHtmlSymbols implements ParseHtml{
    public String parseHtml(String htmlDocument) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("&quot;", "\"");
        map.put("&amp;", "&");
        map.put("&lt;", "<");
        map.put("&gt;", ">");
        map.put("&nbsp;", " ");
        map.put("&ndash;", "–");
        map.put("&mdash;", "—");
        map.put("&lsquo;", "‘");
        map.put("&rsquo;", "’");
        map.put("&sbquo;", "‚");
        map.put("&ldquo;", "“");
        map.put("&laquo;", "[");
        map.put("&raquo;", "]");
        map.put("&rdquo;", "”");
        map.put("&bdquo;", "„");
        map.put("&frac14;", "1/4");
        map.put("&frac12;", "1/2");
        map.put("&frac34;", "3/4");
        map.put("&copy;", "©");
        map.put("&bull;", ".");
        map.put("&#8209;", "-");
        map.put("&#171;","'");
        map.put("&#187;","'");


        for (Map.Entry<String, String> item : map.entrySet()) {
            htmlDocument = htmlDocument.replace(item.getKey(), item.getValue());
        }
        return htmlDocument;
    }
}
