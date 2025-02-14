class ProductOfNumbers {

    List<Integer> li;
    int lastZeroInd;

    public ProductOfNumbers() {
        this.li = new LinkedList<>();
        lastZeroInd = -1;
    }
    
    public void add(int num) {
        int last = 1;
        if(li.size() != 0) {
            last = li.get(li.size() - 1);
            if(last == 0) {
                lastZeroInd = li.size()-1;
                last = 1;
            }
        }
        li.add(last*num);
    }
    
    public int getProduct(int k) {
        int prevProd = 1;
        if(li.size() > k) prevProd = li.get(li.size()-1-k);
        if(prevProd == 0) prevProd=1;
        if(lastZeroInd >= li.size()-k) return 0;
        return li.get(li.size()-1)/prevProd;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */