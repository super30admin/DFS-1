// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//this is the solution using a boolean array .The slution is correct but its giving TLE for some test cases.
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        boolean[][] track=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=dfs(matrix,i,j,track);
                }
            }
        }
        return matrix;
    }
    
    private int dfs(int[][] matrix,int i,int j,boolean[][] track){
        if(i<0 ||i>=matrix.length ||j<0 ||j>=matrix[0].length|| track[i][j]){
            return 9999;
        }
        if(matrix[i][j]==0){
            return 0;
        }
        track[i][j]=true;
        int left=dfs(matrix,i,j-1,track)+1;
        int right=dfs(matrix,i,j+1,track)+1;
        int top=dfs(matrix,i-1,j,track)+1;
        int bottom=dfs(matrix,i+1,j,track)+1;
        track[i][j]=false;
        
        return Math.min(Math.min(left,right),Math.min(left,right));
    }
}


//
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //boolean[][] track=new boolean[matrix.length][matrix[0].length];
        Queue<int[]> qu=new LinkedList<int[]>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    qu.add(new int[]{i,j});
                }else{
                    matrix[i][j]=-1;
                }
            }
        }
        int level=0;
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        while(!qu.isEmpty()){
            int size=qu.size();
            level=level+1;
            for(int i=0;i<size;i++){
                int[] cur=qu.remove();
                for(int[] dir:dirs){
                    int row=cur[0]+dir[0];
                    int col=cur[1]+dir[1];
                    if(row>=0 && col>=0 && row<matrix.length && col <matrix[0].length && matrix[row][col]==-1){
                        qu.add(new int[]{row,col});
                        matrix[row][col]=level;
                    }
                }
            }
        }
        return matrix;
    }
}