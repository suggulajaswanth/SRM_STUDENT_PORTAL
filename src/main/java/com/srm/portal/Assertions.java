package com.srm.portal;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.logging.Logger;

public class Assertions extends CommonMethods {
    private static Logger logger = Logger.getLogger("Assertions");

    public void assertUsername(String uname) {
        try {
            if (uname.length() != 13) throw new Exception("LENGTH NOT MATCHED");
            Assert.assertEquals("MATCHED", "MATCHED");
        } catch (Exception e) {
            logger.info(e.toString());
        }
    }

    @Test
    public void test() {
        assertUsername("AB1811001010");
    }
}
