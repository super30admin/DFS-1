//TC: O(M*N)
//SC: O(M*N) all elements are added to the queue(if all are zeros)

//We find the position of zeros and update the queue. We then update all 1s in the path. 
//The elements other than zero are made -x to show they are not visited.
//Everytime we visit a node, we update the distence from zero and put into queue. 
//Visited nodes are not visited again.

import java.util.*;

public class MinDistMatrix {
    public static int[][] updateMatrix(int[][] matrix) {
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int[] dir : directions){
                
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                
                if(r >=0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == -1){
                    matrix[r][c] = matrix[cur[0]][cur[1]] + 1;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return matrix;
    }

    public static void main(String[] args){
        int[][] image = {{1,0,1},{1,1,1}};
        int[][] res = updateMatrix(image);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j <res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
