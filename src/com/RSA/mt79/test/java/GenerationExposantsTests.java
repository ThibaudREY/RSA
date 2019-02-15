package com.RSA.mt79.test.java;

import com.RSA.mt79.Utils.EuclideEtendu;
import com.RSA.mt79.Utils.GenerationExposants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerationExposantsTests {

    @Test
    public void PrimeCheck() throws Exception {
        BigInteger expected = BigInteger.ONE;

        HashMap<Integer, BigInteger> cdn = GenerationExposants.compute(BigInteger.valueOf(178786), BigInteger.valueOf(456));

        ArrayList<BigInteger> euclide = EuclideEtendu.compute(cdn.get(GenerationExposants.C), BigInteger.valueOf(178786).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(456).subtract(BigInteger.ONE)));

        Assertions.assertEquals(euclide.get(EuclideEtendu.R), expected);
    }

    @Test
    public void InferiorityCheck() throws Exception {
        BigInteger p = BigInteger.valueOf(178786);
        BigInteger q = BigInteger.valueOf(456);
        BigInteger c = GenerationExposants.compute(p, q).get(GenerationExposants.C);

        BigInteger pmoqmo = BigInteger.valueOf(178786).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(456).subtract(BigInteger.ONE));

        Assertions.assertTrue(c.compareTo(pmoqmo) < 0);
    }

    @Test
    public void ModuloCheck() throws Exception {

        BigInteger p = BigInteger.valueOf(178786);
        BigInteger q = BigInteger.valueOf(456);
        HashMap<Integer, BigInteger> cdn = GenerationExposants.compute(p, q);
        BigInteger c = cdn.get(GenerationExposants.C);
        BigInteger d = cdn.get(GenerationExposants.D);

        BigInteger expected = BigInteger.ONE;

        BigInteger actual =  c.multiply(d).mod(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));

        Assertions.assertEquals(expected, actual);

    }

}
