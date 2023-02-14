/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public class Scoreboard {
  private OrderedDoublyLinkedList<GameEntry> board = new OrderedDoublyLinkedList<>(OrderedDoublyLinkedList.Direction.DESCENDING);
  private int capacity;

  public Scoreboard(int capacity) {
    this.capacity = capacity;
  }

  public void add(GameEntry entry) {
    board.insert(entry);
    if (board.size() > capacity) {
      board.removeLast();
    }
  }
  public void print() {
    System.out.println("HIGHEST " + capacity + " SCORES");
    board.print("%s\n");
  }
}
