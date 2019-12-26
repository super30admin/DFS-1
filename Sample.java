/*===========================================Flood Fill =================================================*/
// Time Complexity : O(MXN) MXN matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Initially to check whether the node is already processed or not, I used boolean array. There was some issue while I ran it on LeetCode
Problem is: For the same input, The testcase is LC is run successfully and output matched the expected. But when submitted, the output didn't match then -- for the same input as test case.
Later when I thought through and changed my approach, it worked.
*/


// Your code here along with comments explaining your approach

class Solution {
    static int oldColor; /* This stores the old value so we would not lose it. */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc]; /* Storing the old value so we would not lose it. */
        helper(image, sr, sc, newColor); /* helper function to do the traversal. Using DFS */
        return image;
    }

    static void helper(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc]!=newColor) { /* This checks not redundantly enter the same node multiple times */
            image[sr][sc] = newColor; 
            /* Below directions are {+1,0}, {-1,0}, {0,+1}, {0,-1}*/
            if (sr - 1 >= 0 && image[sr-1][sc]==oldColor) { 
                helper(image, sr-1, sc, newColor);
            }
            if (sr + 1 < image.length && image[sr+1][sc]==oldColor) {
                helper(image, sr+1, sc, newColor);
            }
            if (sc - 1 >= 0 && image[sr][sc-1]==oldColor) {
                helper(image, sr, sc-1, newColor);
            }
            if (sc + 1 < image[0].length && image[sr][sc+1]==oldColor) {
                helper(image, sr, sc+1, newColor);
            }
        }
    }
}


/*===========================================Nearest Zero Matrix 01 =======================================*/

// Time Complexity : O(MXN) MXN matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        Queue<int[]> queue=new LinkedList<>(); /* This problem looks like a classic BFS problem. Queue is DS for BFS. */
        int m = matrix.length, n = matrix[0].length; /* Calculating the dimensions of the given matrix. */
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){ /* Only the '0' Nodes are added in the queue. */
                    queue.add(new int[]{i,j}); 
                }
                else{
                    matrix[i][j]=Integer.MAX_VALUE; /* To avoid these nodes while traversing. As our aim is only to find shortest path to '0' Nodes */
                }
            }
        }

        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}}; /* Left, Right, Top, Bottom directions respectively. */
        while(!queue.isEmpty()) { 
            int[] currentNode = queue.poll(); /* currentNode */
            for (int[] dir : dirs) {
                int newRow = currentNode[0]+dir[0]; 
                int newColumn = currentNode[1]+dir[1]; 
                /* matrix[newRow][newColumn] is now one of the children of currentNode */
                
                if (newRow >= 0 && newRow < m && newColumn >=0 && newColumn < n) { /* edge cases check - validation */
                        if(matrix[newRow][newColumn] > matrix[currentNode[0]][currentNode[1]]){
                        /* Only the minimum node out of all children is traversed here. Filtering the cases of both being zero */ 
                            
                            matrix[newRow][newColumn] = matrix[currentNode[0]][currentNode[1]] + 1; 
                            /* CurrentNode's shortest path = minimum path child +1*/

                            queue.add(new int[] {newRow, newColumn}); /* Adding this in the queue to traverse further */
                        }
                }

            }
        }
        return matrix;
    }
}
