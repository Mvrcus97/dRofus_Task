/* This class is made to represent an item.
* String name - name of itemMap
* int price - price of item.
*/

public class Item {

  private String name;
  private int price;

  public Item(String name, int price){
    this.name = name;
    this.price = price;
  }

  public String getName() {return this.name;}
  public int getPrice() {return this.price;}


}
