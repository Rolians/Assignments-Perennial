package Assignment;
import java.util.Scanner;
public class PrimeNo {
    int start,end;
    static int div = 2;
    //Constructor for initializing
    public PrimeNo(int first_num,int last_num){
        this.start = first_num;
        this.end = last_num;
    }
    private void prime(){
        //Check if start or end is negative
        if((start < 0 )||( end < 0)){
            System.out.println("Prime no cannot be negative");
            System.exit(0);
        }
        //1 is not prime,so increment start
        if(start == 1)
            start++;
        div = 2;//Initialize div = 2 every time
        if(start <= end ){
            isPrime(start);
            start ++;
            prime();
        }
    }
    private void isPrime(int start){
        if(div <= start/2){
            if(start % div == 0) {
               //System.out.println(start+" is non prime number");
               return ;
            }
            else {
                div++;
                isPrime(start);
            }
        }
        //If no is not divisible for every no less than it
        // then print as prime
        else{
            System.out.print(start + " ");
            return ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first_num,last_num;
        System.out.println("Enter the range for prime numbers");
        System.out.print("From : ");
        first_num = sc.nextInt();
        System.out.print("To : ");
        last_num = sc.nextInt();
        PrimeNo n1 = new PrimeNo(first_num,last_num);
        System.out.println("Prime no's in the given range are");
        n1.prime();

    }
}
