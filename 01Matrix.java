// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{0,-1}, {-1, 0}, {0,1},{1,0}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    // putting all the zeros to the queue first
                    q.add(new Pair(i,j));
                }
                if(mat[i][j] == 1) {
                    // making all the ones to some other value to distinguish at each level when we update distance
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.poll();
            for(int[] dir: dirs) {
                int row = dir[0]+curr.getKey();
                int col = dir[1]+curr.getValue();
                if(row>=0 && col>=0 && row<m && col<n && mat[row][col] == -1) {
                    // level by level we update value to prev +1
                    mat[row][col] = mat[curr.getKey()][curr.getValue()] +1;
                    // we are going each node only once
                    q.add(new Pair(row, col));
                }
            }
        }
        return mat;
    }
}