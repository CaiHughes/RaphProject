import java.util.ArrayList;
import java.util.List;

public final class Main{
    public static void main(String[] args){
        List<PortfolioValuable> holdings = new ArrayList<>();

        holdings.add(new Stock(322_00L, 31_630_000));

        holdings.add(new Stock(401_00L, 32_290_000));

        holdings.add(new UnknownPriceHolding(48_800_000));

        FinancialValue total = new KnownFinancialValue(0);
        int unknownCount = 0;

        for(PortfolioValuable holding : holdings){
            FinancialValue value = holding.getFinancialValue();

            if(value.isKnown()){
                total = total.add(value);
            }else{
                unknownCount++;
            }
        }

        String message;
        if(unknownCount > 0){
            message = "Missing price for " + unknownCount + " holding(s).\n" +
                    "Minimum known portfolio value: " + total.display();
        }else{
            message = "Portfolio value: " + total.display();
        }

        System.out.println(message);
    }
}