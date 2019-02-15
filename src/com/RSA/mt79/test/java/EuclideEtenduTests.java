package com.RSA.mt79.test.java;

import com.RSA.mt79.Utils.EuclideEtendu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

public class EuclideEtenduTests {

    @Test
    public void HundredSeventyHeightThousandSevenHundredEightySix_FourHundredFiftySix() {
         final ArrayList<BigInteger> actual = EuclideEtendu.compute(BigInteger.valueOf(178786), BigInteger.valueOf(456));

         Assertions.assertEquals(actual.get(EuclideEtendu.R), BigInteger.TWO);
         Assertions.assertEquals(actual.get(EuclideEtendu.R), BigInteger.valueOf(178786).multiply(actual.get(EuclideEtendu.U)).add(BigInteger.valueOf(456).multiply(actual.get(EuclideEtendu.V))));
     }

}
