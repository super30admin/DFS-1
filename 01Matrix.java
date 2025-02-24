// Time Complexity : O(m*n) - matrix rows and col
// Space Complexity : O(m*n) - queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BFS
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                }
                else
                    mat[i][j]=-1;
            }
        }

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        int dist=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] coordinate=queue.poll();
                int cr=coordinate[0];
                int cc=coordinate[1];
                for(int[] dir:dirs){
                    int nr=cr+dir[0];
                    int nc=cc+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                        queue.add(new int[]{nr,nc});
                        mat[nr][nc]=dist;
                    }
                }
            }
            dist++;
        }

        return mat;
    }
}
