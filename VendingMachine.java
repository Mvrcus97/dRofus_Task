import java.util.ArrayList;
import java.util.HashMap;

/* This class is used to represent a vending machine.
* Includes functions and attributes for a regular Vending Machine.
*
* HashMap<Item> - Map of all items.
* int credit: current credit.
* (Note, can change to double if currency supports fractions)
*/
public class VendingMachine{

  private HashMap<String,Item> itemMap = new HashMap<String,Item>();
  private int credit;

  public VendingMachine() {
    //Create a VendingMachine, add 10 items.
    itemMap.put("coke", new Item("Coke", 22));
    itemMap.put("fanta", new Item("Fanta", 22));
    itemMap.put("sprite", new Item("Sprite", 22));
    itemMap.put("redbull",new Item("RedBull", 20));
    itemMap.put("milkshake", new Item("Milkshake", 20));
    itemMap.put("chocolate", new Item("Chocolate", 20));
    itemMap.put("candy bar", new Item("Candy Bar", 12));
    itemMap.put("sandwich", new Item("Sandwich", 35));
    itemMap.put("smash", new Item("Smash", 30));
    itemMap.put("ice cream", new Item("Ice Cream", 15));

    this.credit = 0;
  }


  //Method of adding credit.
  public void insert(int credit) {
    this.credit += credit;
    System.out.println("Current credit is " + this.credit);
  }

  //Delete credit
  public void recall() {
    System.out.println("Giving out " + this.credit + " credit. ");
    this.credit = 0;
  }

  //Order a product:  check balance and give feedback accordingly.
  public void orderProduct(String name) {
    name = name.toLowerCase();
    Item ordered = itemMap.get(name);
    if(ordered == null){
      System.out.println("Item " + name + " does not exist.");
      return;
    }

    if (this.credit >= ordered.getPrice()){
      //Enough credit
        this.credit -= ordered.getPrice();
        System.out.println("Giving out " + ordered.getName()+ ". Giving back change of " + this.credit);
        this.credit = 0;
        return;
      }
      //not enough credit
      int difference = ordered.getPrice() - this.credit;
      System.out.println("Not enough credit. Need " + difference + " more credit. ");

  }

  //List all products.
  public void list() {
    System.out.println("---Vending Machine---");
    System.out.println("Current credit: " + this.credit);

    itemMap.forEach((k,v) -> {
      //This is a LambdaExpression, for each Item in itemMap
      System.out.println(v.getName() + " cost: " + v.getPrice());
    });
  }

  public int getCredit() {return this.credit;}

}// end VendingMachine
