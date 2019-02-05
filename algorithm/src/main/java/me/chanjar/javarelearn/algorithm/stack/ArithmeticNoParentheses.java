package me.chanjar.javarelearn.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://time.geekbang.org/column/article/41222">极客时间 - 数据结构与算法之美 - 08 | 栈：如何实现浏览器的前进和后退功能？</a>
 * <p>
 * 四则运算（不支持括号）
 * </p>
 */
public class ArithmeticNoParentheses {

  private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
  private static final Pattern OPERATOR_PATTERN = Pattern.compile("^[\\+\\-\\*/]$");

  private Stack operand = new Stack();
  private Stack operator = new Stack();

  public int solve(String formula) {
    return solve(tokenize(formula));
  }

  protected String[] tokenize(String formula) {

    List<String> result = new ArrayList<>();

    char[] chars = formula.toCharArray();

    StringBuilder token = new StringBuilder();
    for (char aChar : chars) {
      if ('0' <= aChar && aChar <= '9') {
        token.append(aChar);
        continue;
      }
      if (aChar == '+' || aChar == '-' || aChar == '*' || aChar == '/') {
        if (token.length() > 0) {
          result.add(token.toString());
          token = new StringBuilder();
        }
        result.add(String.valueOf(aChar));
        continue;
      }

      if (aChar == ' ') {
        continue;
      }
      throw new IllegalArgumentException("无法识别的字符: " + aChar);
    }
    if (token.length() > 0) {
      result.add(token.toString());
    }
    return result.toArray(new String[0]);

  }

  /**
   * 例如公式：3 + 5 * 8 - 6,
   * <p>
   * ["3", "+", "5", "*", "8", "-", "6"]
   * </p>
   *
   * @param tokens
   * @return
   */
  public int solve(String[] tokens) {

    for (String token : tokens) {

      if (isNumber(token)) {
        operand.push(token);
        continue;
      }

      if (isOperator(token)) {

        String optorPeek = operator.peek();

        // 拿出operand顶部两个元素，operator顶部一个元素，将计算结果push到operand中。
        // 直到operator没有元素，或者operator顶部元素优先级高于当前word
        while (optorPeek != null && compareOperator(token, optorPeek) <= 0) {
          calculateTop();
          optorPeek = operator.peek();
        }

        operator.push(token);
        continue;
      }

      throw new IllegalArgumentException("无法识别：" + token);
    }

    // 将operator和operand的元素全部都消费完，获得计算结果
    while (operator.size() > 0) {
      calculateTop();
    }
    return Integer.valueOf(operand.pop());
  }

  protected boolean isNumber(String word) {
    Matcher matcher = NUMBER_PATTERN.matcher(word);
    return matcher.matches();
  }

  protected boolean isOperator(String word) {
    Matcher matcher = OPERATOR_PATTERN.matcher(word);
    return matcher.matches();
  }

  protected int compareOperator(String op1, String op2) {
    if ("+".equals(op1) || "-".equals(op1)) {
      if ("+".equals(op2) || "-".equals(op2)) {
        return 0;
      }
      return -1;
    }

    if ("+".equals(op2) || "-".equals(op2)) {
      return 1;
    }
    return 0;
  }

  protected void calculateTop() {
    String r = operand.pop();
    String l = operand.pop();
    int tmp = calculate(l, r, operator.pop());
    operand.push(String.valueOf(tmp));
  }

  protected int calculate(String lOperand, String rOperand, String operator) {
    int l = Integer.valueOf(lOperand);
    int r = Integer.valueOf(rOperand);
    if ("+".equals(operator)) {
      return l + r;
    }
    if ("-".equals(operator)) {
      return l - r;
    }
    if ("*".equals(operator)) {
      return l * r;
    }
    if ("/".equals(operator)) {
      return l / r;
    }
    throw new IllegalArgumentException("无法识别：" + operator);
  }

}

