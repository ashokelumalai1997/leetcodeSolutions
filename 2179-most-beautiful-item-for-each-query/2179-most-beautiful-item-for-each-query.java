class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        /*

        price should be ordered 


sort the price beauty mapping in increasing order of prices

each price can be mapped to max beauty possible at that price. This can be refered to select max beauty available for all above prices

sort the query price from low to high

if query price is lower than minimum price, ans is 0

if not we need to find the floor of that price available and the return appropriate b


        */
        Arrays.sort(items, (a,b) -> a[0] - b[0]);

        TreeMap<Integer, Integer> priceToBeauty = new TreeMap<>();

        int maxB = items[0][1];
        int minP = items[0][0];


        for(int[] item : items) {
            priceToBeauty.putIfAbsent(item[0], 0);
            maxB = Math.max(maxB, item[1]);
            // int currentB = priceToBeauty.get(item[0]);
            priceToBeauty.put(item[0], maxB);
        }

        int n = queries.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            if(queries[i] < minP) res[i] = 0;
            else res[i] = priceToBeauty.get(priceToBeauty.floorKey(queries[i]));
        }

        return res;


    }
}


// Input :

// int[][] items

// item : [price, beauty]


// queries int[]

// Output:

// maximum beauty of an item whose price is less than or equal to queries[i]
// If no such item exists, then answer is 0


