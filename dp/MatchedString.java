/*
In Java: Write a function in language of your choice that takes in two strings, 
and returns true if they match. Constraints are as follows: String 1, the text 
to match to, will be alphabets and digits. String 2, the pattern, will be 
alphabets, digits, '.' and '*'. '.' means either alphabet or digit will be 
considered as a "match". "*" means the previous character is repeat 0 or more 
# of times. For example: Text: Facebook Pattern: F.cebo*k returns true.
 */

package tst;
public class MatchedString {
    public static boolean match(String src, String dst) {
        return internal_match(src, dst, 0, 0);
    }

    private static boolean internal_match(String src, String dst, int i, int j) {
        if (i == src.length() && j == dst.length())
            return true;
        if (i == src.length() && j == dst.length()-1 && dst.charAt(j) == '*')
            return true;
        if (src.charAt(i) == dst.charAt(j) || dst.charAt(j) == '.') {
            return internal_match(src, dst, i+1, j+1);
        } else if (src.charAt(i) != dst.charAt(j) && dst.charAt(j) != '*') {
            if (dst.charAt(j+1) != '*')
                return false;
            else
                return internal_match(src, dst, i, j+2);
        } else if (dst.charAt(j) == '*') {
            if (src.charAt(i) == dst.charAt(j-1))
                return internal_match(src, dst, i+1, j);
            else
                return internal_match(src, dst, i, j+1);
        }
        return false;
    }
    public static void main(String arvg[]){
       System.out.println(match("Facebook","Fa.ebo*k"));
       System.out.print(match("Facebookk", "Facebo*k*"));
       System.out.println();
    }
}