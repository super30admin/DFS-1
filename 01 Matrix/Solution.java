//Time Comlpexity: O(m*n)
// Space Complexity: O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][]dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}};
        if(mat==null || mat.length==0) return null;
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
            if(mat[i][j]==0) q.add(new int []{i,j});
            else mat[i][j]=-1;
        }
        }
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []curr = q.poll();
                for(int[] dir : dirs){
                    int a = curr[0] + dir[0];
                    int b = curr[1] + dir[1];
                    if(a>=0 && b>=0 && a<mat.length && b<mat[0].length && mat[a][b]==-1){
       mat[a][b]=dist+1;
                        q.add(new int []{a,b});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
