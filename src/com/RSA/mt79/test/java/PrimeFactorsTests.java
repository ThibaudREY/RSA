package com.RSA.mt79.test.java;

import com.RSA.mt79.Utils.PrimeFactors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

public class PrimeFactorsTests {
    @Test
    public void eleven() {
        final List<BigInteger> actual = PrimeFactors.primeFactors(BigInteger.valueOf(66));

        Assertions.assertEquals(actual.get(0), BigInteger.TWO);
    }
}
