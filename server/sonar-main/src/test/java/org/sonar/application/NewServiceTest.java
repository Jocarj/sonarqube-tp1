package org.sonar.application;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewServiceTest {

    @Test
    public void test_sum() {
        NewService calculator = new NewService();

        assertEquals(5, calculator.sum(2, 3));

        assertEquals(0, calculator.sum(-1, 1));

        assertEquals(0, calculator.sum(0, 0));

        assertEquals(-2, calculator.sum(5, -7));
    }
}
