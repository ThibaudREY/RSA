package com.RSA.mt79.test.java;

import com.RSA.mt79.Utils.ExponentiationModulaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class ExponentiationModulaireTests {

    @Test
    public void HundredSeventyHeightThousandSevenHundredEightySix_FourHundredFiftySix_NintyEight() {
        final BigInteger expected = BigInteger.valueOf(64);
        final BigInteger actual = ExponentiationModulaire.compute(BigInteger.valueOf(178786), BigInteger.valueOf(456), BigInteger.valueOf(98));

        Assertions.assertEquals(expected, actual);
    }

}
