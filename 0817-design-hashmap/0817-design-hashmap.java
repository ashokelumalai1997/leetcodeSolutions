class MyHashMap {

    private int[] myMap;

    public MyHashMap() {
        this.myMap =  new int[(int)Math.pow(10,7)];
        for(int i=0;i<myMap.length;i++){
            myMap[i]=-1;
        }
    }
    
    public void put(int key, int value) {
        myMap[key]=value;
    }
    
    public int get(int key) {
        return myMap[key];
    }
    
    public void remove(int key) {
        myMap[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */