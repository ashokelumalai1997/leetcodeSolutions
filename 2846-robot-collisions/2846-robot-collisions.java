class Solution {
    class PositionHealthPair {
        int position;
        int health;
        char direction;
        public PositionHealthPair(int pos, int health, char dir){
            this.position = pos;
            this.health = health;
            this.direction = dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<PositionHealthPair> st = new Stack<>();
        List<PositionHealthPair> lt = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> rank = new HashMap<>();
        
        int n = positions.length;
        
        for(int i = 0; i < n; i++) {
            rank.put(positions[i], i);
            lt.add(new PositionHealthPair(positions[i], healths[i], directions.charAt(i)));
        }
        Collections.sort(lt, (a,b) -> a.position - b.position);
        for(int i = 0; i < n; i++) { 
            PositionHealthPair current = lt.get(i);
            if(!st.isEmpty() && current.direction == 'L' && st.peek().direction == 'R') {
                PositionHealthPair currentInStack = st.peek();
                if(current.health > currentInStack.health) {
                    st.pop();
                    current.health -= 1;
                    i-=1;
                } else if(current.health < currentInStack.health) {
                    st.pop();
                    currentInStack.health -= 1;
                    st.push(currentInStack);
                } else {
                    st.pop();
                }
                continue;
            }
            st.push(current);
        }
        List<PositionHealthPair> ltn = new ArrayList<>(st);
        Collections.sort(ltn, (a,b) -> rank.get(a.position) - rank.get(b.position));
        int i = 0;
        while(i < ltn.size()) {
            result.add(ltn.get(i).health);
            i++;
        }
        return result;
    }
}