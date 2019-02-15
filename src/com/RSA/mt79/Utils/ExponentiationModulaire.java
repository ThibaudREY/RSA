package com.RSA.mt79.Utils;

import java.math.BigInteger;

public class ExponentiationModulaire {

    /**
     * Implementation de l'algorithme d'xponentiation modulaire
     * @param base BigInteger
     * @param exposant BigInteger
     * @param modulo BigInteger
     * @return BigInteger
     */
    public static BigInteger compute(BigInteger base, BigInteger exposant, BigInteger modulo) {
        if (modulo.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }

        BigInteger result = BigInteger.valueOf(1);
        base = base.mod(modulo);

        while (exposant.compareTo(BigInteger.ZERO) == 1) {
            if (exposant.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = result.multiply(base).mod(modulo);
            }

            exposant = exposant.shiftRight(1);
            base = base.pow(2).mod(modulo);
        }

        return result;
    }

}
