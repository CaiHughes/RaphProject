import javax.lang.model.type.NullType;

class Stock{
    int price;
    int quantity;
    int portfolio;

    public Stock(int price, int quantity){
        this.price = price;
        this.quantity = quantity;
        this.portfolio = price * quantity;

    }
}


public class Main{
    public static void main(String[] args){
         if (args[0] == null) {
            System.out.println("Minimum Price is " + args[1]);
        }
        if (args[1] == null) {
            System.out.println("Minimum Price is " + args[0]);
        }

        Stock Google = new Stock(322, 31630000);
        Stock Microsoft = new Stock(401, 32290000);
        Stock Apple = new Stock(null, 48800000);
        System.out.println(Google.portfolio);
        System.out.println(Microsoft.portfolio);
        System.out.println(Apple.portfolio);

        //System.out.println(Apple.portfolio);

    }
}

