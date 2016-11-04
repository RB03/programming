package codevita2016;

import java.util.*;

class Pri
{
    public static void main(String ar[]) {
    Scanner scanner = new Scanner(System.in);
        long num= scanner.nextLong();
        long val=2;
        int count=0;
        long sum = 0;
        while(val < num){
            long next= nextPrime(val);
            long s= sum+val+next;
            if (s>num){break;}
            if (isPrime(s)){
//                System.out.printf("prime %d\n", sum+val+next);
                count++;
            }
            sum= sum+val;
            val=next;
//            System.out.printf("sum %d next %d\n", sum, next );

        }
        System.out.print(count);
    }

     private static long nextPrime(long n) {
        boolean isPrime = false;
        int start = 2;
        while (!isPrime) {
            n += 1;
            int m = (int) Math.ceil(Math.sqrt(n));
            isPrime = true;
            for (int i = start; i <= m; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return n;
    }

     static boolean isPrime(long num){
        if ( num > 2 && num%2 == 0 ) {
            return false;
        }
        int top = (int)Math.sqrt(num) + 1;
        for(int i = 3; i < top; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}