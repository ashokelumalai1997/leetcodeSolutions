class TimeMap { 

	static class Entry {
		int tstamp;
		String value;
		public Entry(String value, int timestamp) {
			this.tstamp = timestamp;
			this.value = value;
}
}
	
	Map<String, List<Entry>> map;
	
public TimeMap() { 
	this.map = new HashMap<>();
} 

public void set(String key, String value, int timestamp) {
	this.map.putIfAbsent(key, new ArrayList<>());
	this.map.get(key).add(new Entry(value, timestamp));
} 

public String get(String key, int timestamp) {
	if(!this.map.containsKey(key)) return "";
	List<Entry> valueList = this.map.get(key);
	int left = 0;
	int right = valueList.size() - 1;

	String recent = "";

	while(left <= right) {
		int mid = left + (right - left)/2;

		Entry current = valueList.get(mid);
		
		if(timestamp == current.tstamp) {
			return current.value;
}

if(timestamp < current.tstamp) {
	right = mid - 1;
} else {
	recent = current.value;
	left = mid+1;
}
}

return recent;
} 
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */