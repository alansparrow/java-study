import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Note that we have to use \\ because we need a literal \
        // and Java uses a single \ as an escape character
        String pStr = "\\d"; // A numeric digit
        String text = "Apollo 13";
        Pattern p = Pattern.compile(pStr);
        Matcher m = p.matcher(text);
        System.out.print(pStr + " matches " + text + "? " + m.find());
        System.out.println(" ; match: " + m.group());
        
        pStr = "[a..zA..Z]"; //Any letter
        p = Pattern.compile(pStr);
        m = p.matcher(text);
        System.out.print(pStr + " matches " + text + "? " + m.find());
        System.out.println(" ; match: " + m.group());

        // Any number of letters, which must all be in the range 'a' to 'j'
        // but can be upper- or lowercase
        pStr = "([a..jA..J]*)";
        p = Pattern.compile(pStr);
        m = p.matcher(text);
        System.out.print(pStr + " matches " + text + "? " + m.find());
        System.out.println(" ; match: " + m.group());
        text = "abacab";

        // 'a' followed by any four characters, followed by 'b'
        pStr = "a....b";
        p = Pattern.compile(pStr);
        m = p.matcher(text);
        System.out.print(pStr + " matches " + text + "? " + m.find());
        System.out.println(" ; match: " + m.group());
    }
}
