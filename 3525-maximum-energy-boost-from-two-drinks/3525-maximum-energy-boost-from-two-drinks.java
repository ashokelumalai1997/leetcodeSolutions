class Solution {
    private long calculateMaxEnergy(long[][] dp, int index, int[] A, int[] B, boolean takeFromA) {
        if(index == A.length) return 0;
        if(dp[index][takeFromA == true? 1 : 0] != -1) return dp[index][takeFromA == true? 1 : 0];
        long switched = calculateMaxEnergy(dp, index + 1, A, B, takeFromA == true ? false : true);
        long notSwitched = 0;
        if(takeFromA) {
            notSwitched += A[index];
        } else {
            notSwitched += B[index];
        }
        notSwitched += calculateMaxEnergy(dp, index + 1, A, B, takeFromA);
        return dp[index][takeFromA == true? 1 : 0] = Math.max(switched, notSwitched);
    }
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long result = 0;
        result = Math.max(calculateMaxEnergy(dp, 0, energyDrinkA, energyDrinkB, true), 
                          calculateMaxEnergy(dp, 0, energyDrinkA, energyDrinkB, false));
        return result;
    }
}