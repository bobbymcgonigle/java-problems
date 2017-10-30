
public class ReverseANumber {

public static int reverseNumber(int number){
		
		int reverse = 0;
		while(number != 0)
		{
			reverse = (reverse*10)+(number%10);
			number = number/10;
		} 
		return reverse;
	}
	
	public static void main(String args[]){
		System.out.println("Result: "+ reverseNumber(17868));
	}

}
