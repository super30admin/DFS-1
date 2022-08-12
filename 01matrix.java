// Time Complexity : o(m*n) 
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q= new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int distance=1;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] temp=q.poll();
                for(int[] dir:dirs){
                    int nr=dir[0]+temp[0];
                    int nc=dir[1]+temp[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        mat[nr][nc]=distance;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}