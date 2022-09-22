// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Perform BFS, add all values=0 in matrix to the queue and mark all 1s as -1
At each level increase the distance and if value in matrix is -1 then assign distance to that row and col val
add the changed value to queue.
*/
class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0) return new int[][]{};
        int[][] dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int[]> queue= new ArrayDeque<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }

        int dist=1;

        while(!queue.isEmpty()){
            int qs= queue.size();
            for(int i=0;i<qs;i++){
                int[] coord= queue.poll();
                for(int[] dir: dirs){
                    int x=coord[0]+dir[0];
                    int y=coord[1]+dir[1];
                    if(x<0 || y<0 || x>mat.length-1 || y>mat[0].length-1 || mat[x][y]!=-1) continue;
                    mat[x][y]= dist;
                    queue.offer(new int[]{x,y});
                }
            }
            dist++;
        }

        return mat;
    }

}