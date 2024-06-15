class Solution {
    class Pair {
        private int capital;
        private int profit;
        public Pair(int c, int p){
            this.capital = c;
            this.profit = p;
        }
        // @Override
        // public int compareTo(Pair p){
        //     return this.capital - p.capital;
        // }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> sortByCapital = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<Pair> sortByProfit = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        for(int i = 0; i < profits.length; i ++) {
            sortByCapital.offer(new Pair(capital[i], profits[i]));
        }
        int maximumCapitalFetchedSoFar = w;
        int numberOfProjectsDoneSoFar = 0;
        while(numberOfProjectsDoneSoFar != k) {
            while(!sortByCapital.isEmpty() && sortByCapital.peek().capital <= maximumCapitalFetchedSoFar) {
                sortByProfit.offer(sortByCapital.poll());
            }
            if(!sortByProfit.isEmpty())
                maximumCapitalFetchedSoFar += sortByProfit.poll().profit;
            numberOfProjectsDoneSoFar++;
        }
        return maximumCapitalFetchedSoFar;
    }
}