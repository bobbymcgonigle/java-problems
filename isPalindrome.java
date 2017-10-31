
public class isPalindrome {
		public static boolean isPalindrom(char[] word)
		{
			//if String passed in just use toCharArray() function
		    int forwardsIndex = 0;
		    int backwardsIndex = word.length - 1;
		    while (backwardsIndex > forwardsIndex) 
		    {
		        if (word[forwardsIndex] != word[backwardsIndex]) 
		        {
		            return false;
		        }
		        forwardsIndex++;
		        backwardsIndex--;
		    }
		    return true;
		}
}
