/*
 * Author: George Sigety - sigetyg@bc.edu
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
  private static int intInput(Scanner scanner) {
    while(true) {
      try{
        int num = scanner.nextInt();
        if (num <= 0) {
          System.out.println("Please enter a value greater than 0.");
          System.out.print("> ");
          continue;
        }
        return num;
      } catch (InputMismatchException e) {
        scanner.next();
        System.out.println("Please enter an integer.");
        System.out.print("> ");
      }
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("How many players do you wish to keep on the top-scoring scoreboard?");
    System.out.print("> ");
    int numRecord = intInput(scanner);
    Scoreboard scoreboard = new Scoreboard(numRecord);
    System.out.println("Enter player data. Enter \"quit\" to finish.");
    while (true) {
      System.out.print("Player's name: ");
      String name = scanner.next();
      if (name.equals("quit")) {
        System.out.println("");
        break;
      }
    System.out.print("Score: ");
    int score = intInput(scanner);
    scoreboard.add(new GameEntry(name, score));
  }
    scoreboard.print();
  }
}
