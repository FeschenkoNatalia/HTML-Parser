  import java.util.Stack;

    public class ParseHtmlTags implements ParseHtml {
        public String parseHtml(String htmlDocument) {
            StringBuilder resultedDocument = new StringBuilder();
            Stack<Tags> tag = new Stack<>();
            tag.push(Tags.TEXT_BETWEEN_TAGS);
            char temp, firstTagLetter, secondTagLetter, thirdTagLetter;
            for (int i = 0; i < htmlDocument.length(); i++) {
                temp = htmlDocument.charAt(i);
                firstTagLetter = htmlDocument.charAt(i + 1);
                secondTagLetter = htmlDocument.charAt(i + 2);
                thirdTagLetter = htmlDocument.charAt(i + 3);
                if (temp == '<' && firstTagLetter == 's' && secondTagLetter == 'c' &&
                        thirdTagLetter == 'r') {
                    tag.push(Tags.SCRIPT_TAG);
                    continue;
                }
                if (temp == '<' && firstTagLetter == '/' && secondTagLetter == 's'
                        && thirdTagLetter == 'c') {
                    tag.pop();
                    i = i + 8;
                    continue;
                }
                if (tag.peek() == Tags.SCRIPT_TAG) {
                    continue;
                }
                if (temp == '<' && firstTagLetter == 's' && secondTagLetter == 't' &&
                        thirdTagLetter == 'y') {
                    tag.push(Tags.STYLE_TAG);
                    continue;
                }
                if (temp == '<' && firstTagLetter == '/' && secondTagLetter == 's' &&
                        thirdTagLetter == 't') {
                    tag.pop();
                    i = i+ 7;
                    continue;
                }
                if (tag.peek() == Tags.STYLE_TAG) {
                    continue;
                }
                if (temp == '<' && (tag.peek() != Tags.SCRIPT_TAG || tag.peek() != Tags.STYLE_TAG)) {
                    tag.push(Tags.OTHER_TAG);
                    continue;
                }
                if (temp == '>' && tag.peek() == Tags.OTHER_TAG) {
                    tag.pop();
                    continue;
                }
                if (tag.peek() == Tags.TEXT_BETWEEN_TAGS) resultedDocument.append(temp);
            }
            return (resultedDocument.toString().replaceAll("[\\s]{2,}", " "));
        }
    }