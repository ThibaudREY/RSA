package com.RSA.mt79.Utils;

import math.StringIntegerBijection;

import java.math.BigInteger;
import java.util.List;

public class RSA {

    /**
     * chiffrement RSA
     * @param message BigInteger
     * @param n BigInteger
     * @param c BigInteger
     * @return BigInteger
     */
    public static BigInteger chiffrement(BigInteger message, BigInteger n, BigInteger c) {
        return ExponentiationModulaire.compute(message, c, n);
    }

    /**
     * dechiffrement RSA
     * @param message BigInteger
     * @param n BigInteger
     * @param d BigInteger
     * @return BigInteger
     */
    public static BigInteger dechiffrement(BigInteger message, BigInteger n, BigInteger d) {
        return ExponentiationModulaire.compute(message, d, n);
    }

    /**
     * Bruteforce RSA
     * @param message String
     * @param n BigInteger
     * @param c BigInteger
     * @return String
     * @throws \Exception
     */
    public static String bruteForce(String message, BigInteger n, BigInteger c) throws Exception {
        List<BigInteger> primes = PrimeFactors.primeFactors(n);

        BigInteger q = primes.get(0);
        BigInteger p = primes.get(1);

        BigInteger d = InverseModulaire.compute(c, (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));

        BigInteger Imessage = StringIntegerBijection.StringToInteger(message);

        return StringIntegerBijection.IntegerToString(ExponentiationModulaire.compute(Imessage, d, n));
    }
}