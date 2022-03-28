// Time Complexity : O(m * n) where m and n are no. or rows and colums in the matrix
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Add all the zeros to a queue and mark all other cells as -1
//Now till is not empty visit all neibhors and mark its distance if they are -1
//We will do this in stages using a supplimentary queue and keep incrementing the distance values
//Next we will have a result matrix and we will return it

class Solution {
    int[][] directions = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    int[] x ={i,j};
                    q.add(x);
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int dis = 1;
        while(!q.isEmpty()){
        Queue<int[]> nextQ = new LinkedList<>();
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int[] dir: directions){
                int newx = pos[0] + dir[0];
                int newy = pos[1] + dir[1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n && mat[newx][newy] == -1){
                    mat[newx][newy] = dis;
                    nextQ.add(new int[]{newx, newy});
                }
            }
        }
        dis++;
        q = nextQ;
        }
        return mat;
    }
}