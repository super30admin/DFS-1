// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> rows = new LinkedList<>(); 
        Queue<Integer> cols = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        //adding all the zero elements
        for(int i = 0 ; i< m ; i++ ){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int r,c;
        //checking all the rest 
        while(!rows.isEmpty()){
            int nr = rows.remove();
            int nc = cols.remove();
            for(int[] dir : dirs){
                r=nr+dir[0];
                c=nc+dir[1];
                if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==-1){
                    mat[r][c]=mat[nr][nc]+1;
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        return mat;
    }
} 01Mat {
    
}
