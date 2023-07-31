//Problem 1: Flood Fill
// Time Complexity : O(mn)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//]-> check for immediate neighbors and if old color, turn to new color, do this for whole matrix and return the matrix
class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        //bfs approach
        int m=image.length;
        int n=image[0].length;
        int oldColor= image[sr][sc];
        if(image==null || image.length==0) return image;
        if(image[sr][sc]==newcolor) return image; // if source is already newcolor, all adjacent edges and their adjacent edges will also be new color, so eventually return current matrix 
        dirs= new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
    //     Queue<Integer> q= new LinkedList<>();
    //     image[sr][sc]=newcolor;
    //     q.add(sr);
    //     q.add(sc);

    //     while(!q.isEmpty()){
    //         int curR=q.poll();
    //         int curC=q.poll();
    //         for(int[] dir: dirs){
    //             int neighborRow= dir[0]+curR;
    //             int neighborCol= dir[1]+curC;

    //             if(neighborRow>=0 && neighborCol>=0 && neighborRow<m && neighborCol<n
    //             && image[neighborRow][neighborCol]==oldColor){
    //                 image[neighborRow][neighborCol]=newcolor;
    //                 q.add(neighborRow);
    //                 q.add(neighborCol);
    //             }
    //         }
    //     }
    // return image;

    //dfs approach
    dfs(image);
    return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor, int oldColor){
        //base

        //logic
        image[r][c]=newColor;
        for(int[] dir: dirs){
                int neighborRow= dir[0]+r;
                int neighborCol= dir[1]+c;

                if(neighborRow>=0 && neighborCol>=0 && neighborRow<m && neighborCol<n
                && image[neighborRow][neighborCol]==oldColor){
        }
    }
}
    
//Problem 2: 01 Matrix
// Time Complexity : O(mn)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
    
//Approach-> add all 0s in the queue and do a bfs traversal on them, new wave will be 1+distance of old wave to nearest zero. Overwrite the matrix elements with wave distances from nearest zeros. return matrix
class Solution {
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs= new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> que=new LinkedList<>();
        //matrix traversal for 
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(mat[i][j]==0)
                    que.add(new int[]{i,j});
                else
                    mat[i][j]=-1;
        while(!que.isEmpty()){
            int size=que.size();
            while(size>0){
                int[] cur=que.poll();
                for(int[] dir: dirs){
                    int neighborRow= dir[0]+cur[0];
                    int neighborCol= dir[1]+cur[1];
                    if(neighborRow>=0 && neighborCol>=0 && neighborRow<m && neighborCol<n && mat[neighborRow][neighborCol]==-1){
                        que.add(new int[]{neighborRow,neighborCol});
                        mat[neighborRow][neighborCol]=1+ mat[cur[0]][cur[1]];
                    }//if 
                }//for
                size--;
            }//while
        }
        return mat;

        //dp approach
        // int[][] result=new int[m][n];
        // for(int i=0;i<m;i++)
        //     for(int j=0;j<n;j++)
        //         if(mat[i][j]==1)
        //             mat[i][j]=-1;
        // for(int i=0;i<m;i++)
        //     for(int j=0;j<n;j++)
        //         if(mat[i][j]==-1)
        //             result[i][j]=dfs(mat, i, j, result);

        // return result;
    }

    // private int dfs(int[][] mat, int i, int j, int[][] result){
    //     //base
    //     if(mat[i][j]==0) return 0;
    //     //logic
    //     int top=Integer.MAX_VALUE, bottom=Integer.MAX_VALUE, left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
    //     //top check
    //     if(i>0){
    //         top=result[i-1][j];
            
    //     }
    //     //left check
    //     if(j>0)
    //         left=result[i][j-1];
    //     //right check
    //     if(j<mat[0].length-1){
    //         if(result[i][j+1]==0){
    //             result[i][j+1]=dfs(mat, i, j+1, result);
    //         }
    //         right=result[i][j+1];
    //     }
    //     //bottom check
    //     if(i<mat.length-1){
    //         if(result[i+1][j]==0)
    //             result[i+1][j]=dfs(mat, i+1, j, result);
    //         bottom=result[i+1][j];
    //     }
    //     return Math.min(right, Math.min(left, Math.min(top, bottom)));
    // }
}