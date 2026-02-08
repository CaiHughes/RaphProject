import javax.lang.model.type.NullType;

class Stock{
    Integer price;
    Integer quantity;
    Integer portfolio;

    public Stock(Integer price, Integer quantity){
        this.price = price;
        this.quantity = quantity;
        this.portfolio = price * quantity;


}
}
class NullStock {
        Integer price;
        Integer quantity;
        String portfolio;
        public NullStock(Integer price, Integer quantity){

        if(price == null) {
            portfolio = "Minimum Price is " + quantity;
            }
        else if(quantity == null) {
            portfolio = "Minimum Price is " + price;
        }
}
}
  




public class Main{
    public static void main(String[] args){
         

        Stock Google = new Stock(322, 31630000);
        Stock Microsoft = new Stock(401, 32290000);
        NullStock Apple = new NullStock(null, 48800000);


        
        System.out.println(Google.portfolio);
        System.out.println(Microsoft.portfolio);
        System.out.println(Apple.portfolio);


    }

}

