package code.leetcode.easy;

import java.util.HashSet;
import java.util.Stack;

public class MatrixTraverse {



/*
 *
 *
 * function shortest(matrix) {
  let visited = new Set();
  let queue = []; // fake queue
  queue.push({
    x: 0,
    y: 0,
    steps: 0
  })
  visited.add("0_0");

  while (queue.length > 0) {
    let current = queue.shift();
    console.log(current);
    let currX = current.x;
    let currY = current.y;
    let currSteps = current.steps;

    if (matrix[currY][currX] === 9) {
      return currSteps;
    }

    // north
    travel(currX, currY-1, matrix, visited, queue, currSteps);
    // south
    travel(currX, currY+1, matrix, visited, queue, currSteps);
    // east
    travel(currX+1, currY, matrix, visited, queue, currSteps);
    // west
    travel(currX-1, currY, matrix, visited, queue, currSteps);


  }

  return Infinity;
}

function travel(x, y, matrix, visited, queue, currSteps) {
  let key = x + '_' + y;
  if (x < 0 || y < 0 || x >= matrix[0].length || y >= matrix.length) {
    return false;
  } else if (matrix[y][x] === '1') {
    return false;
  } else if (visited.has(key)) {
    return false;
  }
  queue.push({
    "x": x,
    "y": y,
    steps: currSteps + 1
  })
  visited.add(x + '_' + y);
  return true;
}


let matrix = [
  [0,0,1,1,0],
  [1,0,0,0,0],
  [0,0,1,1,0],
  [0,1,1,9,0],
  [0,0,0,0,1]
];


console.log(shortest(matrix));
 *
 *
 */

    
    public static void main(String[] args){
        
        int[][] matrix= {
  {0,0,1,1,0},
               {1,0,0,0,0},
               {0,0,1,1,0},
               {0,1,1,1,0},
               {0,0,0,0,1}
};
        System.out.println(shortest(matrix));
    }


    private static int shortest(int[][] matrix) {
        HashSet<String> visited= new HashSet<String>();
        Stack<StackElement> stq= new Stack<StackElement>();
        stq.push(new StackElement(0,0,0));
        
        while(!stq.empty()){
            StackElement currEle=stq.pop();
            
            if(matrix[currEle.X][currEle.Y] == 9){
                return currEle.Steps;
            }
            //up
            travel( new StackElement(currEle.X,currEle.Y-1,currEle.Steps+1), visited,stq, matrix  );
            //down
            travel( new StackElement(currEle.X,currEle.Y+1,currEle.Steps+1), visited,stq, matrix  );
            //right
            travel( new StackElement(currEle.X+1,currEle.Y,currEle.Steps+1),visited,stq, matrix  );
            //left
            travel( new StackElement(currEle.X-1,currEle.Y,currEle.Steps+1),visited, stq, matrix  );
        }
        return 0;
    }
    
    private static Boolean travel(StackElement currEle,HashSet<String> visited,Stack<StackElement> stq,int[][] matrix  ){
        String key=currEle.X+"_"+currEle.Y;
        if(currEle.X<0||currEle.Y<0||currEle.X >= matrix[0].length || currEle.Y >= matrix.length||matrix[currEle.X][currEle.X] == '1'||visited.contains(key) )
            return false;
        
        stq.push(currEle);
        visited.add(key);
        
    
    
    return true;
    }
}

class StackElement{
    
    int X;
    int Y;
    int Steps;

    StackElement(int X, int Y, int Steps) {
        this.X = X;
        this.Y = Y;
        this.Steps = Steps;
    }


   
}
