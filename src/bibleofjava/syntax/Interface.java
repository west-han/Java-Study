package bibleofjava.syntax;

interface Parsable {
    void parse();
}

class ParserManager {
    public static Parsable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else if (type.equals("HTML")) {
            return new HTMLParser();
        } else {
            return new Parsable() {
                @Override
                public void parse() {
                    System.out.println("Parsing JSON");
                }
            };
        }
    }
}

class XMLParser implements Parsable {

    @Override
    public void parse() {
        System.out.println("Parsing XML file");
    }
}

class HTMLParser implements Parsable {

    @Override
    public void parse() {
        System.out.println("Parsing HTML file");
    }
}

public class Interface {
    public static void main(String[] args) {
        Parsable parser = ParserManager.getParser("XML");
        parser.parse();
        parser = ParserManager.getParser("HTML");
        parser.parse();
        parser = ParserManager.getParser("JSON");
        parser.parse();
    }
}
