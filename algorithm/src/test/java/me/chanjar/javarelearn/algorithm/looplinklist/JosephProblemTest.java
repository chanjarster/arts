package me.chanjar.javarelearn.algorithm.looplinklist;

import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static me.chanjar.javarelearn.algorithm.looplinklist.JosephProblem.solve;
import static me.chanjar.javarelearn.algorithm.looplinklist.Node.create;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class JosephProblemTest {

  @Test
  public void testSolve() {
    Node head = create(new String[] { "A", "B", "C", "D", "E", "F", "G" });
    /*
     .: initial
     x: delete

     round 1: A B C D E F G
              .   x
     round 2: A B   D E F G
                    .   x
     round 3: A B   D E   G
                x         .
     round 3: A     D E   G
                    .     x
     round 4: A     D E
              .       x
     round 4: A     D
              .
              x
     */
    List<Node> result = solve(head, 2);
    String[] resultValues = result.stream().map(Node::getValue).collect(toList()).toArray(new String[0]);
    assertArrayEquals(new String[] { "C", "F", "B", "G", "E", "A" }, resultValues);

  }

  @Test
  public void testSolveSingleNode() {
    Node head = create(new String[] { "A" });
    List<Node> result = solve(head, 2);
    assertEquals(0, result.size());
  }
}
