package com.RSA.mt79.test.java;

import com.RSA.mt79.Utils.GenerationExposants;
import com.RSA.mt79.Utils.RSA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class RSATests {

    @Test
    public void CodeDecode() {

        try {
            BigInteger p = BigInteger.valueOf(103);
            BigInteger q = BigInteger.valueOf(101);

            // Clé publique
            BigInteger c = GenerationExposants.compute(p, q).get(GenerationExposants.C);
            BigInteger n = GenerationExposants.compute(p, q).get(GenerationExposants.N);

            // Clé privée
            BigInteger d = GenerationExposants.compute(p, q).get(GenerationExposants.D);

            Assertions.assertEquals(BigInteger.valueOf(10403), n);
            Assertions.assertEquals(BigInteger.valueOf(7), c);
            Assertions.assertEquals(BigInteger.valueOf(8743), d);

            BigInteger message = BigInteger.valueOf(1234);

            Assertions.assertEquals(message.compareTo(n), -1);

            BigInteger mc = RSA.chiffrement(message, n, c);

            Assertions.assertEquals(message, RSA.dechiffrement(mc, n, d));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void BruteForce() {
        try {
            Assertions.assertEquals(RSA.bruteForce("LHRZNS", BigInteger.valueOf(211582871), BigInteger.valueOf(127)), "RETI");
            Assertions.assertEquals(RSA.bruteForce("AYMRNCI", BigInteger.valueOf(844991843), BigInteger.valueOf(349837)), "RUIZ");
            Assertions.assertEquals(RSA.bruteForce("IVWTRM.FPL", new BigInteger("202899206548601"), BigInteger.valueOf(39898535)), "SICILIENNE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
