package com.RSA.mt79.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    /**
     * Facteurs premiers d'un nombre
     * @param n BigInteger
     * @return List
     */
    public static List<BigInteger> primeFactors(BigInteger n) {

        ArrayList<BigInteger> res = new ArrayList<>();

        while (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            res.add(BigInteger.TWO);
            n = n.divide(BigInteger.TWO);
        }

        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(n.sqrt()) < 0; i = i.add(BigInteger.TWO))  {

            while (n.mod(i).equals(BigInteger.ZERO)) {
                res.add(i);
                n = n.divide(i);
            }

            if (res.size() == 2)
                break;
        }

        if (res.size() < 2)
            res.add(n);

        return res;
    }

}
