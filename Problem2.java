//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else matrix[i][j]=-1;
            }
        }
        int lvl=1;
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}}; 
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int r= curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r<m && r>=0 && c<n && c>=0 && matrix[r][c]==-1){
                        matrix[r][c]=lvl;
                        q.add(new int[]{r,c});
                    }
                }
            }
            lvl++;
        }



        return matrix;
    }
} 