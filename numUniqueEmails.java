package code.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class numUniqueEmails {
    public static void main(String args[]){
        
        Solution sol= new Solution();
        int result = sol.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        System.out.println("result"+result);
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
   
        Set<String> set = new HashSet<String>();
        int counter=0;
        for (int i=0;i<emails.length;i++){
            String email1 = emails[i].substring(0,emails[i].indexOf("@"));
            String email2 = emails[i].substring(emails[i].indexOf("@"));
            email1 = email1.substring(0,email1.indexOf("+")).replace(".","");
            System.out.println("email2"+email2);
            if(!set.contains(email1+"@"+email2))  {
               set.add(email1+"@"+email2);
                counter++;
            }  
            
            
        }
        
        return counter;
        
    }
}
