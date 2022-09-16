// TC:O(mxn)
// SC:O(mxn)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int []> q= new LinkedList<>();
        int m= mat.length;
        int n= mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j]=-1;
            }
        }

        int level=0;
        int[][] dirs= new int[][]{{0,-1},{-1,0},{1,0},{0,1}};

        while(!q.isEmpty()){
            int size= q.size();
            level++;

            while(size-- >0){
                int []curr= q.poll();
                for(int [] dir:dirs){
                    int r= dir[0]+curr[0];
                    int c= dir[1]+curr[1];

                    if(r<0 || c<0 ||r==m ||c==n ||mat[r][c]!=-1) continue;

                    mat[r][c]=level;
                    q.add(new int[]{r,c});
                }
            }

        }
        return mat;

    }
}