class StockSpanner {
    private List<Integer> lis;
    public StockSpanner() {
        lis = new ArrayList<>();

        
    }
    
    public int next(int price) {
        lis.add(price);
        int span = 0;
        for(int i=lis.size()-1;i>=0;i--){
            if(lis.get(i)<=price){
                span++;
            }
            else{
                break;
            }
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */