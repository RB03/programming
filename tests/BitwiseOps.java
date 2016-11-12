package tests;

/* package whatever; // don't place package name! */

import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class BitwiseOps
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int x= 4, y=5, N=100;
        long  a;

        System.out.printf("multiplication \t%d\n", (5 << 1));
        System.out.printf("mod pow of 2 \t%d\n", 5 & ((1<<2)-1) );
        System.out.printf("Even? \t\t\t%s\n",   (x & 1)==0);
        System.out.printf("is power of 2? \t%s\n", (x & (x&(x-1)))==0);
        System.out.printf("division \t\t%d \n", x >> 2);
        System.out.printf("... \t\t\t%d\n\n", (1<<x)&9);

        long time = System.nanoTime();
        for (int i = 1; i <= N; i++) {
            a = (90000000000L - i) >> 2;
        }
        System.out.printf("Div time taken w/ shifts %d ns \n",System.nanoTime() - time);

        time = System.nanoTime();
        for (int i = 1; i <= N; i++) {
            a = (90000000000L - i) / 4;
        }
        System.out.printf("Div tme taken w/o shifts %d ns\n\n",System.nanoTime() - time);

        time = System.nanoTime();
        for (int i = 1; i <= N; i++) {
            a = (90000000000L - i) << 2;
        }
        System.out.printf("Mul time taken w/ shifts %d ns \n",System.nanoTime() - time);

        time = System.nanoTime();
        for (int i = 1; i <= N; i++) {
            a = (90000000000L - i) * 4;
        }
        System.out.printf("Mul tme taken w/o shifts %d ns\n\n",System.nanoTime() - time);

        time =System.nanoTime();
        for (int i = 1; i <= N; i++) {
            a = (90000000011L-i) &((1L<<1)-1L);
        }
        System.out.printf("Mod time taken w/  shifts %d ns\n",System.nanoTime() - time);

        time =System.nanoTime();
        for (int i = 1; i <= N; i++) {
            a = (90000000011L-i) % 2;
        }
        System.out.printf("Mod time taken w/o shifts %d ns\n",System.nanoTime() - time);
    }
}