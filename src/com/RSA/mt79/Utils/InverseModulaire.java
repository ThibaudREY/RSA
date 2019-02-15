package com.RSA.mt79.Utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class InverseModulaire {

    /**
     * Implémentation de l'algorithme d'inverse modulaire
     * @param a BigInteger
     * @param n BigInteger
     * @return BigInteger
     * @throws \Exception
     */
    public static BigInteger compute(BigInteger a, BigInteger n) throws Exception {
        ArrayList<BigInteger> euclide = EuclideEtendu.compute(a, n);
        if (!euclide.get(EuclideEtendu.R).equals(BigInteger.ONE)) {
            throw new Exception("Inverse modulaire impossible ");
        }
        return euclide.get(EuclideEtendu.U).mod(n);
    }

}
