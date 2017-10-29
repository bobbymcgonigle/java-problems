//Write a program to reverse a string using recursive methods.

public class StringReversalRecursive {

	String reversedString = "";
		
	public String reverse(String str)
	{
		if(str.length() == 1){
            return str;
        } 
		else
        {
			//return string = return string + character at length-1 + call(reverse of index 0-length-1
            reversedString += str.charAt(str.length()-1) +reverse(str.substring(0,str.length()-1));
            return reversedString;
        }
	}
	
	public static void main(String[] args) {
		StringReversalRecursive srr = new StringReversalRecursive();
        System.out.println(srr.reverse("Whatever String You Want"));
	}

}
