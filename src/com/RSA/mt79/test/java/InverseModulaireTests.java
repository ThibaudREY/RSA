package com.RSA.mt79.test.java;

import com.RSA.mt79.Utils.InverseModulaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class InverseModulaireTests {

    @Test
    public void EightHundredFiftyFive_HundredTwentyThree_FourThousandFiveHundredSixtySeven() {
        final BigInteger expected = BigInteger.valueOf(854);
        try {
            final BigInteger actual = InverseModulaire.compute(BigInteger.valueOf(123), BigInteger.valueOf(4567));
            Assertions.assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Exo7Examaple() {
        final BigInteger expected = BigInteger.valueOf(8743);
        try {
            final BigInteger actual = InverseModulaire.compute(BigInteger.valueOf(7), BigInteger.valueOf(10200));
            Assertions.assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
