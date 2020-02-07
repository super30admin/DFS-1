// S30 Big N Problem #63 {Medium}
// 542. 01 Matrix
// Time Complexity :O(m*n)
// Space Complexity :O(m*n) {indexes stored in queue}
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// BFS Solution
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //bfs solution
        int m=matrix.length;
        if(m==0) return matrix;
        int n=matrix[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                    //System.out.println(q.size());
                }
            }
        }
        
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int dist=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int [] elem=q.poll();
                for(int [] dir:dirs){
                    int r=elem[0]+dir[0];
                    int c=elem[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c]==1){
                        q.add(new int[] {r,c});
                        matrix[r][c]=-dist;
                        //System.out.println(matrix[r][c]);
                    }
                }
            }
            dist++; 
        }
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=-1*matrix[i][j];
            }
        }
        return matrix;
    }
}