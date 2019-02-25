package x.y.z;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoopClient {

    public static final Pattern REGEX_INCLUDE_FILE = Pattern
            .compile("<<LoopClient \\$ou\\.t(\\.docx|\\.doc)??\\$>>", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        
        System.out.println("q.w.e.r".replaceAll("\\.", "\\\\."));
        
        Matcher matcher = REGEX_INCLUDE_FILE.matcher("<<LoopClient $ou.t$>>");
        
        System.out.println(matcher.matches());
        String includeFileName = matcher.group(1);
        System.out.println(includeFileName);

    }
}
