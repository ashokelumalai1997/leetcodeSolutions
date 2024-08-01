class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail : details) {
            boolean condition = (((detail.charAt(11) - '0') == 6) && ((detail.charAt(12) - '0') > 0)) || (((detail.charAt(11) - '0') > 6) && ((detail.charAt(12) - '0') >= 0));
            count += (condition ? 1 : 0);
        }
        return count;
    }
}