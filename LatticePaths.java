package code.leetcode.easy;

public class LatticePaths {
    /*
    *  Problem: Lattice Paths - Pure Recursion
    *
    *  Prompt:  Count the number of unique paths to travel from the top left
    *           corder to the bottom right corner of a lattice of M x N squares.
    *
    *           When moving through the lattice, one can only travel to the adjacent
    *           corner on the right or down.
    *
    *  Input:   m {Integer} - rows of squares
    *  Input:   n {Integer} - column of squares
    *  Output:  {Integer}
    *
    *  Example: input: (2, 3)
    *
    *           (2 x 3 lattice of squares)
    *            __ __ __
    *           |__|__|__|
    *           |__|__|__|
    *
    *           output: 10 (number of unique paths from top left corner to bottom right)
    *
    *  Resource: https://projecteuler.net/problem=15
    *
    *            __ __ __
    *           |__|__|__|
    *           |__|__|__|
    *
    *                         (0, 0)
    *                       /        \
    *                    (1,0)        (0,1)
    *                    /   \        /   \
    *                 (2,0)  (1,1) (1,1)   (0,2)
    *                 /   \   /  \  /  \    /  \
    *           X(3,0)(2,1)(2,1) (1,2)
    *
    *base case
    * 1) x>row y>column
    * 2) final outcome is (rows,columns)
    **********************************************************************************************
    *pseudo code
    * 
    * function(rows,columns)
    *   result=0
    *   resurse();
    *   
    *   
    *   recurse(rows,columns, row,column,result)
    *    if(row>rows or column>columns)
    *     return;
    *     else if( rows=row and column ==  columns)
    *     result++;
    *     return result;
    *     
    *       recurse(rows,columns, row+1,column,result);
    *       recurse(rows,columns, row,column+1,result);
    *   
    *   
    *   
    *   
    * 
    *
    *
    *
    *
    */

    public static void main(String[] args) {
        beanResult br = new beanResult(0);
        recurse(2,2, 0,0,br);
        System.out.println(br.result);
        
    }
    
    public static void recurse(int rows, int columns,int row,int column,beanResult br) {
        
        if(row>rows || column>columns)
            return;
        else if(row==rows && columns == column){
            br.result++;
            return;
        }
        
        recurse(rows,columns, row+1,column,br);
        recurse(rows,columns, row,column+1,br);

    }
    
    
}

 class beanResult{
    int result=0; 
     beanResult(int result){
         this.result=result;
     }
    
    
}


