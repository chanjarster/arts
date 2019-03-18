package me.chanjar.javarelearn.algorithm.search;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class SquareRootTest {

  SquareRoot squareRoot = new SquareRoot();

  @Test
  public void solve() {
    test(0);
    test(1);
    test(1.5);
    test(2);
    test(3);
    test(4);
    test(5);
    test(6);
    test(7);
    test(8);
    test(9);
    test(10);
    test(11);
    test(12);
    test(13);
    test(14);
    test(15);
    test(16);
  }

  private void test(double num) {
    BigDecimal val = BigDecimal.valueOf(squareRoot.solve(num));
    System.out.println(val.toPlainString());
    assertEquals(
        BigDecimal.valueOf(Math.sqrt(num)).setScale(6, RoundingMode.DOWN)
            .compareTo(val),
        0
    );

  }
}
