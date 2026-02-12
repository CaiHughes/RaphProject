import javax.lang.model.type.NullType;

class Stock{
    Integer price;
    Integer quantity;
    Integer addr;
    public static boolean MissP = false;

    public Stock(Integer price, Integer quantity){
        this.price = price;
        this.quantity = quantity;
        this.addr =  (price * quantity);

}
}
class NullStock {
        Integer price;
        Integer quantity;
        Integer addr;
         public static Integer count = 0;
        public static boolean MissP = false;
        
        public NullStock(Integer price, Integer quantity){
        
        if(price == null) {
            MissP = true;
            addr =  quantity;
            count++;
            }
        /*else if(quantity == null) {
            boolean MissQ = true;
            portfolio =  price;
        }*/
}
}
  




public class Main{
    public static void main(String[] args){
        Stock Google = new Stock(322, 31630000);
        Stock Microsoft = new Stock(401, 32290000);
        NullStock Apple = new NullStock(null, 48800000);

        Integer Total_amount = Google.addr + Microsoft.addr + Apple.addr;
        String portfolio = "$" + Total_amount;
        
        if ( NullStock.MissP == true){
        System.out.println("Missing Price of "+ NullStock.count + " stock(s), price is at a minimum " + portfolio);
        }
        else {
        System.out.println("Portfolio size: " + portfolio);
        }

    }

}

