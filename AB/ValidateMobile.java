import java.util.regex.*;
import java.util.Scanner;
class ValidateMobile{
public static boolean isValid(String s)
{
    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
    Matcher m = p.matcher(s);
    return (m.find() && m.group().equals(s));
}
}