// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] result = new int [m][n];
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               result[i][j]=Integer.MAX_VALUE;
                if(matrix[i][j]==0){
                    result[i][j]=0;
                    queue.add(new Pair(i,j));
                }
            }
        }
        while(!queue.isEmpty()){
            Pair node=queue.poll();
            for(int k=0;k<4;k++){
                int x=node.x+dx[k];
                int y=node.y+dy[k];
                
                if(x>=0 && x<m && y<n && y>=0){
                    if(result[node.x][node.y]+1 < result[x][y]){
                        result[x][y]= result[node.x][node.y]+1;
                        queue.add(new Pair(x,y));
                    }
                }
            }
        }
        return result;
    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}