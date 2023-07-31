// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Queue to store the elements which needs to be processed
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        //Count variable to keep count of the processed elements
        int count = 0;
        //Going through all the elements to get 0's and add it in the queue and also to change 1 to -1 so that we won't need a visited array
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                    //mat[i][j] == -2;
                    count++;
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        //If there are no 1's, return the matrix
        if(count == (m*n)) return mat;
        //Direction array to go in 4 directions of a certain elements
        int[][] dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
        
        int dist = 0;
        //Keep running till we process all elements
        while(q.peek() != null){
            dist++;
            //Process elements of each level by keeping track of size
            int size = q.size();
            //While processing, store the distance and add the neighboring elements to queue if they are not processed yet
            for(int i=0; i<size; i++){
                int[] cord = q.remove();
                for(int[] dir: dirs){
                    int j = cord[0] + dir[0];
                    int k = cord[1] + dir[1];
                    if(j>=0 && j<m && k>=0 && k<n && mat[j][k] == -1){
                        mat[j][k] = dist;
                        q.add(new int[]{j,k});
                        count++;
                    }
                }
            }
            if(count == (m*n)) return mat;
        }
        return mat;
    }
}