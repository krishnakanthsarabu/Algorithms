package code.leetcode.easy;

public class HexadecimalConverter233 {
 /*
              * 233 - Hexadecimal Converter
            Given a positive integer (including 0), convert it to its hexadecimal representation
            
            Input: n (Integer)
            Output: Str (Hex representation)
            Example:
            0 => '0'
            1 => '1'
            2 => '2'
            3 => '3'
            
            9 => '9'
            10 => 'a'
            11 => 'b'
            
            15 => 'f'
            16 => '10'
            
            30 => '1e'
            31 => '1f'
            32 => '20'
            
            255 => 'ff'
            256 => '100'
            Constraints
            Time Complexity: O(log(N))
            
            Space Complexity: O(log(N))
  * 
  * ***********************************************************************
  * 0123456789a  b  c  d  e  f
  * 012345678910 11 12 13 14 15
  * 16 = 10
  * 32%16=20
  * 30%16 = 14 => 1e
  * 
  * 
  * ************************************************************************
  * psuedoCode
  * 
  * function(num)
  *     remainder = num%16;
  *     quotient  = num/16;
  *     hexa= [0,1,2,3,4,5,6,7,8,9,a,  b,  c,  d,  e,  f]
  *     if(quotient>16)
  *      quotient = function(quotient);
  *     
  *     return quotient+""+hexa[remainder];
  * 
  * 
  * 
  * 
  */
    public static void main(String[] args) {
        
        System.out.println(hexa(2560*10));


    }
    public static String hexa(int num){
        String[] hexa= {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        int quotient = num/16;
        String quo=""+quotient;
        int remainder = num%16;
        if(quotient>9)
        quo= hexa(quotient);
        
       if(!quo.equals("0"))
        return quo+hexa[remainder];
       else
        return hexa[remainder];
    }
    
    
}
