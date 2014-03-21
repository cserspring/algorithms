package uncategorized;

public class ValidNumber {
	public static boolean isNumber(String s) {
		return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("."));
	}

}
