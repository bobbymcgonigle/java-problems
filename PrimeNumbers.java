
public class PrimeNumbers {

    private static boolean isPrimeNumber(int number){
        
        for(int i=2; i<=number/2; i++){
            if(number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
         
        int index = 2; // 1 & 0 arn't prime numbers
        int primeCount = 0;
        int sum = 0;
        
        while(primeCount < 3900)
        {
            if(isPrimeNumber(index)){
                sum += index;
                primeCount++;
            }
            index++;
        }
        System.out.println(sum);
    }
}

