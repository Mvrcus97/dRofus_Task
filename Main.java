import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

  /* AUTHOR: Marcus Tierney
  * Language: Java
  * 3 classes:
  *     - Main
  *     - VendingMachine
  *     - Item
  *
  */

  /* Main class - Create and Operate the vending machine.
  *
  *  VendingMachine machine  - the vending machine
  *  Scanner in  - used to track user input.
  */
public class Main {
  public static void main(String[] args) {

    VendingMachine machine = new VendingMachine();
    System.out.println("Welcome to a Digital Vending Machine!");
    System.out.println("Avaible Commands:\n\nlist\ninsert [amount]\nrecall\norder [Item]\nexit");
    Scanner in = new Scanner(System.in);

    while(true) {
      System.out.println("\nPlease enter a command.\nCredit: [" + machine.getCredit() + "]");
      String cmd = in.nextLine();

      if ( cmd.equals("list")) machine.list();

      else if (cmd.equals("recall"))  machine.recall();

      else if( cmd.equals("exit")) return;

      else if (cmd.substring(0,6).equals("insert")) {
        int amount = Integer.parseInt(cmd.substring(7));
        machine.insert(amount);
      }
     else if (cmd.substring(0,5).equals("order")) {
        String name = cmd.substring(6);
        machine.orderProduct(name);
      }
      else
      System.out.println("Sorry, command not recognized, try again.");
    } //end while

  } // end public static void main(..)
} //end main
