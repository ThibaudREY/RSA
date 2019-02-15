package com.RSA.mt79.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerationExposants {

    public static final int C = 0;
    public static final int D = 1;
    public static final int N = 2;

    /**
     * Exposants des clés privées et publiques
     * @param p BigInteger
     * @param q BigInteger
     * @return HashMap
     */
    public static HashMap<Integer, BigInteger> compute(BigInteger p, BigInteger q) throws Exception {

        HashMap<Integer, BigInteger> result = new HashMap<>();

        BigInteger c = GenerationExposants.clePublique(p, q);
        HashMap<Integer, BigInteger> nd = GenerationExposants.clePrivee(p, q, c);

        result.put(GenerationExposants.C, c);
        result.put(GenerationExposants.D, nd.get(GenerationExposants.D));
        result.put(GenerationExposants.N, nd.get(GenerationExposants.N));

        return result;

    }


    /**
     * Exposants pour la clée privée
     * @param p BigInteger
     * @param q BigInteger
     * @param c BigInteger
     * @return HashMap
     * @throws \Exception
     */
    private static HashMap<Integer, BigInteger> clePrivee(BigInteger p, BigInteger q, BigInteger c) throws Exception {
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        ArrayList<BigInteger> euclide = EuclideEtendu.compute(c, phi);

        HashMap<Integer, BigInteger> result = new HashMap<>();

        result.put(GenerationExposants.C, euclide.get(EuclideEtendu.R));
        result.put(GenerationExposants.D, InverseModulaire.compute(c, phi));
        result.put(GenerationExposants.N, n);

        return result;
    }

    /**
     * Exposants pour la clée publique
     * @param p BigInteger
     * @param q BigInteger
     * @return HashMap
     * @throws \Exception
     */
    private static BigInteger clePublique(BigInteger p, BigInteger q) {

        BigInteger c = BigInteger.TWO;
        BigInteger pmoqmo = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        while (!BigInteger.ONE.equals(EuclideEtendu.compute(c, pmoqmo).get(EuclideEtendu.R)) && c.compareTo(phi.divide(BigInteger.TWO)) < 0) {
            c = c.add(BigInteger.ONE);
        }

        return c;

    }

}
