package org.wesome.dsalgo;

public class CheckPrime {
    public static boolean checkPrime(int prime) {
        /* prime numbers are positive integers greater than 1 that are only divisible by 1 and themselves, therefore, they cannot be negative  */
        if (prime <= 1) {
            System.out.println("numbers greater then 1 are candidate for prime number");
            return false;
        }
        /*  Factors will always be less than the square root of the number, This optimization reduces the number of iterations. */
        var sqrt = Math.sqrt(prime);
        for (int i = 2; i <= sqrt; i++) {
            /*   If prime is divisible by any of the numbers in the loop, it means prime has a divisor other than 1 and itself, so the method returns false.    */
            if (prime % i == 0) {
                System.out.println("CheckPrime.checkPrime:- the number " + prime + " is divisible by " + i);
                return false;
            }
        }
        /*  If the loop completes without finding any divisors, the method returns true, indicating that prime is indeed a prime number.    */
        return true;
    }
}