    /**
     *
     *  Time Complexity: O(M*N) Where N is the number of rows and M is number of columns.
     *  Space Complexity: O(M*N) Where N is the number of rows and M is number of columns.
     *
     *  Did this code successfully run on Leetcode : Yes
     *  Any problem you faced while coding this : None
     *
     *  Explanation: This problem can be solved either by DFS or BFS approach. In BFS approach we first iterate over the matrix and all the indexes with zero to a queue. Now for each level in the queue, we poll the element and check its neighbous if it is 1, if so we add that to the queue and mark the element as -1 in the matrix. In the result matrix, for every polled index in the queue we mark the value as level-1. We continue this till all the elements are removed from the queue.
     */

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return matrix;
        }
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    queue.add(new Integer[]{i,j});
                }
            }
        }
        int level=1;
        int dirs[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int result[][] = new int[matrix.length][matrix[0].length];
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                Integer[] node = queue.poll();
                result[node[0]][node[1]]=level-1;
                for(int[] dir: dirs){
                    int r =node[0]+dir[0], c=node[1]+dir[1];
                    
                    if(r<0 || c<0 || r>=matrix.length || c>=matrix[0].length || matrix[r][c]==0 || matrix[r][c]==-1){
                        continue;
                    }
                    queue.offer(new Integer[]{r,c});
                    matrix[r][c]=-1;
                }
                size--;
            }
            level++;
        }
        return result;
    }
}
