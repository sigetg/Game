/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public class GameEntry implements Comparable<GameEntry> {
  private String name;
  private int score;
  public GameEntry(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public int compareTo(GameEntry other) {
    return this.score - other.score;
  }
  public String toString() {
    return name + " - " + score;
  }
}
