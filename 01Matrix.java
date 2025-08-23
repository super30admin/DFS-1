// This approach uses BFS where we add all the 0's cells into the queue and traverse layer by layer increasing the distance by 1 at every layer processing. We need to mark the 1's as -1 at the initial stage to prevent re processing of cells
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList();
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==0) queue.add(new int[]{i, j});
                else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int distance = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] coOrdinate = queue.poll();
                for(int[] dir:dirs) {
                    int row = coOrdinate[0]+dir[0];
                    int col = coOrdinate[1]+dir[1];
                    if(row<0 || col<0 || row==mat.length || col==mat[0].length) continue;
                    if(mat[row][col]==-1) {
                         mat[row][col] = distance; 
                         queue.add(new int[]{row,col});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}
