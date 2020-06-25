package LeetCode_June_Challenge.Week_4;

public class Unique_Binary_search_Trees {
	
	// recursively
	public int numTrees(int n) {
		return numTrees(n, new int[n+1]);
	}
	
	public int numTrees(int n, int[] strg) {
	  if(n < 2)
	      return 1;
	  if(strg[n] != 0)
	      return strg[n];
	  int count = 0;
	  for(int i = 1; i<=n; i++){
	      count += (numTrees(i-1, strg) * numTrees(n-i, strg));
	  }
	  strg[n] = count;
	  return count;
	}
	
	// Iteratively
	public int numTrees1(int n){
	 if(n<2) return 1;
	 int[] strg = new int[n+1];
	 strg[0] = 1; strg[1] = 1;
	 for(int i = 2; i<=n; i++){
	     for(int j = 0; j<i; j++){
	         strg[i] += strg[j] * strg[i-j-1];
	     }
	 }
	 return strg[n];
}

	
}
