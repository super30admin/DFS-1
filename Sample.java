//flodd fill
// Time Complexity :0(m*n) image size
// Space Complexity :0(n) the sizr of the stack in dfs
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null ||image.length==0||image[0].length==0||image[sr][sc]==newColor){
            return image;
        }
        recurr(image,sr,sc,image[sr][sc],newColor);
         return image;
    }
   private void recurr(int[][] image, int i, int j, int oldcolor, int newColor)
{
    image[i][j]=newColor;
    
    for(int[] directions: dirs)
    {
        int r= i+ directions[0];
        int c=j+directions[1];
        if(r>=0 && r<image.length&& c>=0 && c<image[0].length&& image[r][c]==oldcolor)
    {
        recurr(image,r,c,oldcolor,newColor);
    }
    }
    
    
}

}
//01 matrix
// Time Complexity :0(m*n)
// Space Complexity :0(m*n)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 ||matrix[0].length==0)
        {
            return matrix;
        }
       int n=matrix.length;
        int m=matrix[0].length;
        Queue<int[]> queue= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0)
                    queue.add(new int[]{i,j});
                else
                    matrix[i][j]=Integer.MAX_VALUE;
                
            }
        }
            int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
            while(!queue.isEmpty()){
                int[] front=queue.poll();
                int i=front[0];
                int j= front[1];
                for(int[] directions: dirs){
                    int r=i+directions[0];
                    int c=j+directions[1];
                    if(r>=0 && r<n && c>=0 && c<m && (matrix[i][j]+1<matrix[r][c]))
                    {
                        matrix[r][c]=matrix[i][j] +1;
                        queue.add(new int[]{r,c});
                    }
                }
            }
            return matrix;
        }
        
    }

