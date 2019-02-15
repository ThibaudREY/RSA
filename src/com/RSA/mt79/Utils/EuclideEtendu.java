package com.RSA.mt79.Utils;

import java.math.BigInteger;
import java.util.ArrayList;


public class EuclideEtendu {

    public static final int R = 0;
    public static final int U = 1;
    public static final int V = 2;

    /**
     * Implementation de l'algorithme d'Euclide étendu
     * @param a BigInteger
     * @param b BigInteger
     * @return ArrayList<BigInteger>
     */
    public static ArrayList<BigInteger> compute(BigInteger a, BigInteger b) {

        BigInteger r1 = a;
        BigInteger r2 = b;
        BigInteger u1 = BigInteger.ONE;
        BigInteger v1 = BigInteger.ZERO;
        BigInteger u2 = BigInteger.ZERO;
        BigInteger v2 = BigInteger.ONE;
        BigInteger q;
        BigInteger rs;
        BigInteger us;
        BigInteger vs;

        while (r2.abs().compareTo(BigInteger.ZERO) >= 1) {
            q = r1.divide(r2);
            rs = r1;
            us = u1;
            vs = v1;
            r1 = r2;
            u1 = u2;
            v1 = v2;
            r2 = rs.subtract(q.multiply(r2));
            u2 = us.subtract(q.multiply(u2));
            v2 = vs.subtract(q.multiply(v2));
        }

        ArrayList<BigInteger> result = new ArrayList<>();
        result.add(r1);
        result.add(u1);
        result.add(v1);

        return result;
    }

}