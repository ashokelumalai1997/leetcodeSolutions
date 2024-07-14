class Solution {
    private List<String> getProcessedKeys(String formula){
        List<String> result = new ArrayList<>();
        if(formula.equals("")) return result;
        int n = formula.length();
        for(int i = 0; i < n; i ++) {
            Character key = formula.charAt(i);
            StringBuilder sb = new StringBuilder();
            if(key >= '0' && key <= '9') {
                
                while(i < n && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                    sb.append(formula.charAt(i));
                    System.out.println(sb.toString());
                    i++;
                }
                
                if(i < n) i-=1;
                
            } else if(key >= 'A' && key <= 'Z') {
                sb.append(formula.charAt(i));
                i++;
                while(i < n && Character.isLowerCase(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                if(i < n) i-=1;
                
            } else {
                sb.append(formula.charAt(i));
                i++;
                if(i < n) i-=1;
            }
            result.add(sb.toString());
        }
        for(String s : result) System.out.println(s);
        return result;
    }
    public String countOfAtoms(String formula) {
        List<String> processedKeys = getProcessedKeys(formula);
        Stack<Integer> multiplier = new Stack<>();
        multiplier.push(1);
        int n = processedKeys.size();
        // for(String p : processedKeys) System.out.println(p);
        Map<String, Integer> sToI = new TreeMap<>();
        for(int i = n-1; i >= 0; i--) {
            String currentString = processedKeys.get(i);
            char key = currentString.charAt(0);
            if( key >= '0' && key <= '9' ) {
                multiplier.push(multiplier.peek()*Integer.valueOf(currentString));
            } else if (key >= 'A' && key <= 'Z') {
                // System.out.println(currentString);
                // if(multiplier.peek() != 1)
                    // processedKeys.set(i, currentString + String.valueOf(multiplier.peek()));
                    // sToI.putIfAbsent(currentString, 0);
                    sToI.put(currentString, sToI.getOrDefault(currentString, 0) + multiplier.peek());
                if(i < n-1) {
                    char nextKey = processedKeys.get(i+1).charAt(0);
                    if('0' <= nextKey && '9' >= nextKey) {
                        multiplier.pop();
                    }
                }
            } else if (key == '(') {
                // System.out.println(multiplier.peek());
                multiplier.pop();
            } else if(key == ')') {
                if(i < n-1) {
                    char nextKey = processedKeys.get(i+1).charAt(0);
                    if(!('0' <= nextKey && '9' >= nextKey)) {
                        multiplier.push(multiplier.peek());
                    }
                } else {
                    multiplier.push(multiplier.peek());
                }
            }
        }
        StringBuilder result = new StringBuilder();
        // Map<String, Integer> sToI = new HashMap<>();
        for(Map.Entry<String, Integer> s : sToI.entrySet()) {
            result.append(s.getKey());
            if(s.getValue() != 1)
                result.append(String.valueOf(s.getValue()));
        }
        return result.toString();
    }
}

/*


"H" "2" "0"

"Mg", "(", "O", "H", ")", "2"

Identify atoms
    traverse
    if current char is upper, go on till finding number or ( or )
    form the atom string, update it with value 0

traverse from right to left
    if current is number, move left till not finding a number and form the multiplier

    
track multiplier

when current char is number
    get the number
    multiply with multiplier
    when going out of the (), remove the last multiplier

when current char is lower
    prepend it to the current atom
when current char is upper
    prepend it to the current atom
    for the string and multiply it with the multiplier, update the map



*/