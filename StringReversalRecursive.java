
public class StringReversalRecursive {

	String reversedString = "";

	public String reverse(String str) {
		if (str.length() == 1) {
			return str;
		} else {
			reversedString += str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
			return reversedString;
		}
	}

	public static void main(String[] args) {
		StringReversalRecursive srr = new StringReversalRecursive();
		System.out.println(srr.reverse("Whatever String You Want"));
	}

}
