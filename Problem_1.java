// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null) return image;
        if(image[sr][sc]==newColor) return image;
        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> qu=new LinkedList<int[]>();
        qu.add(new int[]{sr,sc});
        int prevColor=image[sr][sc];
        image[sr][sc]=newColor;
        while(!qu.isEmpty()){
            int[] curr=qu.remove();
            for(int[] dir:dirs){
                int row=curr[0]+dir[0];
                int col=curr[1]+dir[1];
                if(row>=0 && col>=0 && row<image.length && col<image[0].length && image[row][col]==prevColor){
                    image[row][col]=newColor;
                    qu.add(new int[]{row,col});
                }
            }
        }
        return image;
    }
   
}


//the dfs solution
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null) return image;
        if(image[sr][sc]==newColor) return image;
        boolean[][] track=new boolean[image.length][image[0].length];
        int prevColor=image[sr][sc];
        dfs(image,sr,sc,track,prevColor,newColor);
        return image;
    }
    
    public void dfs(int[][] image,int i,int j,boolean[][] track,int prevColor,int newColor){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || track[i][j] ||image[i][j]!=prevColor){
            return;
        }
        track[i][j]=true;
        image[i][j]=newColor;
        dfs(image,i,j+1,track,prevColor,newColor);
        dfs(image,i,j-1,track,prevColor,newColor);
        dfs(image,i-1,j,track,prevColor,newColor);
        dfs(image,i+1,j,track,prevColor,newColor);
    }
   
}