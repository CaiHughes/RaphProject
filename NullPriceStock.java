final class NullPriceStock{
        private final PositiveInteger32 quantity;
        public static int count = 0;
        public static boolean MissP = false;
        
        public NullPriceStock(final PositiveInteger32 quantity){
        
            MissP = true;
            count++;
            this.quantity = quantity;
    }

    public PositiveInteger32 totalValue(){
        return quantity;
    }

}
  