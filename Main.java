import javax.lang.model.type.NullType;

public final class Main{

    public static void main(final String[] args){
        Stock Google = new Stock(new PositiveInteger32(322), new PositiveInteger32(31630000));
        Stock Microsoft = new Stock(new PositiveInteger32(401),new PositiveInteger32( 32290000));
        NullPriceStock Apple = new NullPriceStock(new PositiveInteger32(48800000));

        int Total_amount = Google.totalValue() + Microsoft.totalValue() + Apple.totalValue().value();        
        
        String portfolio = "$" + Total_amount;
        
        if(NullPriceStock.MissP){
        System.out.println("Missing Price of "+ NullPriceStock.count + " stock(s), price is at a minimum " + portfolio);
        }
        else{
        System.out.println("Portfolio size: " + portfolio);
        }

    }

}

