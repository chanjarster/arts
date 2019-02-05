package me.chanjar.javarelearn.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArithmeticNoParenthesesTest {

  @Test
  public void testIsNumber() {
    ArithmeticNoParentheses calculator = new ArithmeticNoParentheses();
    assertEquals(true, calculator.isNumber("1"));
    assertEquals(true, calculator.isNumber("10"));
    assertEquals(true, calculator.isNumber("01"));

    assertEquals(false, calculator.isNumber("a"));
    assertEquals(false, calculator.isNumber("b"));

    assertEquals(false, calculator.isNumber("1a"));
    assertEquals(false, calculator.isNumber("a1"));

    assertEquals(false, calculator.isNumber("+"));
    assertEquals(false, calculator.isNumber("-"));
    assertEquals(false, calculator.isNumber("*"));
    assertEquals(false, calculator.isNumber("/"));

    assertEquals(false, calculator.isNumber("1+"));
    assertEquals(false, calculator.isNumber("+1"));

  }

  @Test
  public void testIsOperator() {
    ArithmeticNoParentheses calculator = new ArithmeticNoParentheses();

    assertEquals(false, calculator.isOperator("1"));
    assertEquals(false, calculator.isOperator("10"));
    assertEquals(false, calculator.isOperator("01"));

    assertEquals(false, calculator.isOperator("a"));
    assertEquals(false, calculator.isOperator("b"));

    assertEquals(false, calculator.isOperator("1a"));
    assertEquals(false, calculator.isOperator("a1"));

    assertEquals(true, calculator.isOperator("+"));
    assertEquals(true, calculator.isOperator("-"));
    assertEquals(true, calculator.isOperator("*"));
    assertEquals(true, calculator.isOperator("/"));

    assertEquals(false, calculator.isOperator("++"));
    assertEquals(false, calculator.isOperator("--"));
    assertEquals(false, calculator.isOperator("**"));
    assertEquals(false, calculator.isOperator("//"));

    assertEquals(false, calculator.isOperator("1+"));
    assertEquals(false, calculator.isOperator("+1"));

  }

  @Test
  public void testCompareOperator() {
    ArithmeticNoParentheses calculator = new ArithmeticNoParentheses();

    assertEquals(0, calculator.compareOperator("+", "+"));
    assertEquals(0, calculator.compareOperator("+", "-"));
    assertEquals(-1, calculator.compareOperator("+", "*"));
    assertEquals(-1, calculator.compareOperator("+", "/"));

    assertEquals(0, calculator.compareOperator("-", "+"));
    assertEquals(0, calculator.compareOperator("-", "-"));
    assertEquals(-1, calculator.compareOperator("-", "*"));
    assertEquals(-1, calculator.compareOperator("-", "/"));

    assertEquals(1, calculator.compareOperator("*", "+"));
    assertEquals(1, calculator.compareOperator("*", "-"));
    assertEquals(0, calculator.compareOperator("*", "*"));
    assertEquals(0, calculator.compareOperator("*", "/"));

    assertEquals(1, calculator.compareOperator("/", "+"));
    assertEquals(1, calculator.compareOperator("/", "-"));
    assertEquals(0, calculator.compareOperator("/", "*"));
    assertEquals(0, calculator.compareOperator("/", "/"));
  }

  @Test
  public void testCalculate() {
    ArithmeticNoParentheses calculator = new ArithmeticNoParentheses();

    assertEquals(3, calculator.calculate("1", "2", "+"));
    assertEquals(-1, calculator.calculate("1", "2", "-"));
    assertEquals(2, calculator.calculate("1", "2", "*"));
    assertEquals(4, calculator.calculate("8", "2", "/"));
  }

  @Test
  public void testTokenize() {
    ArithmeticParentheses calculator = new ArithmeticParentheses();

    String[] tokenize = calculator.tokenize("10+11-12*13/14");
    assertArrayEquals(new String[] { "10", "+", "11", "-", "12", "*", "13", "/", "14" },
        tokenize);

  }

  @Test
  public void testSolve() {
    ArithmeticNoParentheses calculator = new ArithmeticNoParentheses();

    assertEquals(1, calculator.solve(new String[] { "1" }));

    assertEquals(1, calculator.solve("1"));

    assertEquals(3, calculator.solve("1 + 2"));
    assertEquals(-1, calculator.solve("1 - 2"));
    assertEquals(2, calculator.solve("1 * 2"));
    assertEquals(4, calculator.solve("8 / 2"));

    assertEquals(6, calculator.solve("1 + 2 + 3"));
    assertEquals(0, calculator.solve("1 + 2 - 3"));
    assertEquals(7, calculator.solve("1 + 2 * 3"));
    assertEquals(3, calculator.solve("1 + 6 / 3"));

    assertEquals(2, calculator.solve("1 - 2 + 3"));
    assertEquals(-4, calculator.solve("1 - 2 - 3"));
    assertEquals(-5, calculator.solve("1 - 2 * 3"));
    assertEquals(-1, calculator.solve("1 - 6 / 3"));

    assertEquals(5, calculator.solve("1 * 2 + 3"));
    assertEquals(-1, calculator.solve("1 * 2 - 3"));
    assertEquals(6, calculator.solve("1 * 2 * 3"));
    assertEquals(2, calculator.solve("1 * 6 / 3"));

    assertEquals(6, calculator.solve("6 / 2 + 3"));
    assertEquals(0, calculator.solve("6 / 2 - 3"));
    assertEquals(9, calculator.solve("6 / 2 * 3"));
    assertEquals(1, calculator.solve("6 / 2 / 3"));

    assertEquals(37, calculator.solve("3 + 5 * 8 - 6"));
  }
}
