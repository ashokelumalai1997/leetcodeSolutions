class Solution {
    public String addBinary(String num1, String num2) {
        int carry = 0;
        int n1 = num1.length();
        int n2 = num2.length();

        int n = Math.max(n1, n2);

        int n1Pointer = n1-1;
        int n2Pointer = n2-1;

        StringBuilder res = new StringBuilder();

        for(int i = n-1; i >= 0 ; i--) {
            int int1 = 0;
            int int2 = 0;
            if(n1Pointer >= 0) {
                int1 = num1.charAt(n1Pointer) - '0';
                n1Pointer--;
            }

            if(n2Pointer >= 0) {
                int2 = num2.charAt(n2Pointer) - '0';
                n2Pointer--;
            }

            int newInt = (carry + int1 + int2);

            if(newInt == 2) {
                newInt = 0;
                carry = 1;
            } else if (newInt == 3) {
                newInt = 1;
                carry = 1;
            } else {
                carry = 0;
            }



            res.insert(0, String.valueOf(newInt));

        }
        if(carry != 0) res.insert(0, String.valueOf(carry));

        return res.toString();
    }
}