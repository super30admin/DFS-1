//Problem : 65 - 01 Matrix
// Time Complexity : O(m*n), m stands for matrix rows and n stands for matrix columns
// Space Complexity : O(m*n), , as we are growing exponentially that is inserting all neighbors of elements in the queue while iterating over queue. | Otherwise think that if all are 0 except 1 element that will addd all (m*n-1) elements into queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
  As there are connected components so either BFS or DFS
  1) As we have to find distance from nearest 0, this means 0 is independent node i.e start from 0; Insert all 0 elements coordinates in the queue and make all 1 elemnts as -1. Here we are making -1 so that we don't have to create new matrix for keeping track of the visited nodes.
  2) Initialise a distance variable with 1.
  3) Then while traversing over queue, just update the adjacent elements to distance.
  4) On changing the level increment the distance;  
*/

//Note: Here DFS will be cumbersome just like Rotten Oranges, as its going to have lot of conditions

import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        //TC: O(m*n) | SC:O(m*n), as we are growing exponentially that is inserting all neighbors of elements in the queue while iterating over queue. | Otherwise think that if all are 0 except 1 element that will addd all (m*n-1) elements into queue.
        //Checking visited so that we won't come again to those elements which we have visited or have changed to 1
        //As we have to find distance from nearest 0, this means 0 is independent node i.e start from 0;
        
        //edge case
        if(matrix==null || matrix.length==0) return matrix;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==0){
                   q.offer(new int[]{i,j});
               }else{
                   matrix[i][j] = -1;
               }
           }    
        }
        
        int dist = 1;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //assume u r at 0,0
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                
                for(int[] dir:dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if(r>=0 && c>=0 && r<matrix.length && c<matrix[0].length && matrix[r][c]==-1){
                        matrix[r][c] = dist;
                        q.offer(new int[]{r,c});
                    }
                    
                }
            }
            dist++;
        }
        
        return matrix;
        
    }
}

/* DFS
class Solution {
    private int m;
    private int n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        // edge case
        if(matrix == null || m == 0) return matrix;
        n= matrix[0].length;
        int [][] result = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = dfs(matrix,result, i, j);
            }
        }
        return result;
    }
    private int dfs(int[][] matrix, int [][] result,int i, int j){
        // base case
        if(i < 0 || i >= m || j < 0 || j >= n) return 9999;
        if(matrix[i][j] == 0) return 0;
        if(i > 0 && matrix[i-1][j] == 0) return 1;
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        if(i < m - 1 && matrix[i+1][j] == 0) return 1;
        if(j < n-1 && matrix[i][j+1] == 0) return 1;
        // Don't have any neighboring zero'
        int top, left, right, bottom;
        top = left = 9999; // Declare them as infinity
        if(i > 0 && result[i-1][j] != 0){
            top = result[i-1][j];
        }
        if(j > 0 && result[i][j-1] != 0){
            left = result[i][j-1];
        }
        bottom = dfs(matrix, result, i+1, j);
        right = dfs(matrix, result, i, j+1 );
        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
    }
}*/