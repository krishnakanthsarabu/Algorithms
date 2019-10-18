package code.leetcode.easy;

public class JewelsAndStones {
    public JewelsAndStones() {
        super();
    }
    
    public static void main(String args[]){
        
        Solution sol= new Solution();
        int result = sol.numJewelsInStones("Aaf", "sdkjhdsAafjkfdsAafepoewoAafewAaf");
        System.out.println("result"+result);
    }
    
    
    
}


class Solution {
    public int numJewelsInStones(String J, String S) {
       
     //j has jewels 
     //s has stones list
        int counter=0;
        for(int i=0;i<S.length();i++){
            if(J.contains(S.charAt(i)+"")){
                counter++;
            }
            
            
        }
        return counter;    
        
        
    }
}
