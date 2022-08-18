// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    int[][] res;
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    Pair<Integer,Integer> p = new Pair(i,j);
                    q.add(p);
                }
            }
        }
        
        int distance = 0;
        while(!q.isEmpty()){
            int n1 = q.size();
            for(int k=0;k<n1;k++){
                Pair<Integer,Integer> p1 = q.poll();
                for(int[] dir: dirs){
                    int r = (int)p1.getKey() + dir[0];
                    int c = (int)p1.getValue() + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==-1){
                        mat[r][c]=distance+1;
                        q.add(new Pair<Integer,Integer>(r,c));
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}
