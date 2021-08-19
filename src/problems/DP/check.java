package problems.DP;

public class check {
    public static void main(String args[]){
        int number=56;
        for(int i = 2; i< number; i++) {
            if(isPrime(i) && number%i==0){
                System.out.println(i);
                number=number/i;
            }
        }
    
        //System.out.println(number);
    }
    
    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
