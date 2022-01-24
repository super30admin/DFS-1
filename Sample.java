// Time Complexity :O(mn) m-rows and n-columns
// Space Complexity :O(mn) m-rows and n-columns
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Used BFS to process level by level from source row and source column
//Using dirs array found the same color from sr & sc and mutated with the new color added the row and column index into the queue.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //if the source row and column is equal to new color we no need to perform any action
        if(image == null || image[sr][sc] == newColor) return image;
        Queue<Integer> q = new LinkedList();
        int [][] dirs = new int [][]{{1,0},{-1,0},{0,1},{0,-1}}; 
        int color = image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
        int cr = q.poll();
        int cc = q.poll();
            for(int [] dir : dirs){
                int r = cr +dir[0];
                int c = cc+ dir[1];
                if(r>=0 && c >=0 && r<image.length&&
                   c<image[0].length&&image[r][c] == color){
                image[r][c] =newColor;
                     q.add(r);
                     q.add(c);
            }
                
               
            }
            
        }
        return image;
    }
}

// Time Complexity :O(mn) m-rows and n-columns
// Space Complexity :O(mn) m-rows and n-columns
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//in this problem the independent nodes are 0's so started with identifying the inndependent nodes
//The reason behind choosing independent nodes is they don't have any dependencies to look through
//Mutated the 1's with -1 as the value and distance is same in this problem
//iterate 4 direction of 0's using dirs array to find nearest -1's(as we mutated 1 to -1) changed the value to distance.
//processed levvel by level in 1st level the distance is going to be 1 after that for each level will increase the distance
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        Queue<int []> q = new LinkedList<>();
        int [][] dirs = new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i =0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.add(new int [] {i,j});
                }else
                    mat[i][j] = -1;
            }
        }
        int distance = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] curr = q.poll();
                for(int [] dir : dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr >=0 && nc>= 0&& nr< mat.length&&nc< mat[0].length&& mat[nr][nc] == -1){
                        mat[nr][nc] = distance;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}
