package x.y.z.i;

import java.util.Arrays;
import java.util.regex.Pattern;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class Example {
    public static final String EMPTY = "";

    public static final Pattern REGEX_CITYOF_SPLIT = Pattern.compile("\\bof\\b");

    public static void main(String[] args) {
        
        Example e = Example.builder().build();
        
        String[] arr = REGEX_CITYOF_SPLIT.split(null, 2);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
