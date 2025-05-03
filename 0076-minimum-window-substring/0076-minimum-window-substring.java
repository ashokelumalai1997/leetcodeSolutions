class Solution {
	public String minWindow(String s, String t) {
		char[] sArr = s.toCharArray();
		int[] flag = new int[100];
		for(char c : t.toCharArray()) {
			flag[c - 'A']++;
}

int l = 0;
int r = 0;

int[] wFlag = new int[100];

int n = s.length();

int minL = Integer.MAX_VALUE;
int start = 0;

while(r < n) {
	wFlag[sArr[r] - 'A']++;
    while(l <= r && !doesntMatch(flag, wFlag)) {
        if(minL > r-l+1) {
            minL = r-l+1;
            start = l;
        }
        wFlag[sArr[l] - 'A']--;
        l++;
    }
    r++;
}

if(minL == Integer.MAX_VALUE) return "";


return s.substring(start, start + minL);
}
public boolean doesntMatch(int[] flag, int[] wFlag) {
	for(int i = 0; i < 100; i++) {
		if(wFlag[i] < flag[i]) return true;
}

return false;
}

}
