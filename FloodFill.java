
// Time Complexity: O(mn)..Because in the worst case we might have to process each cell in in the input 2D matrix.. This is linear time complexity with respect to input
//Space Complexity: O(mn).. For recursive stack..in the worst case for each of the mn cell we might have to call dfs()..hence space complexity is O(mn)
//Leetcode: 733. Flood Fill
// Using DFS
class Solution {
    int oldColor;
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m=image.length;
        n=image[0].length;
        
        dirs=new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        oldColor=image[sr][sc];
        
        dfs(image,sr,sc,newColor);
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int newColor)
    {
        if(image[r][c]==newColor)
            return;
        
        image[r][c]=newColor;
        int  row,col;
        for(int[] dir: dirs)
        {
            row=dir[0]+r;
            col=dir[1]+c;
            if(row>=0 && col >= 0 && row< m && col<n && image[row][col]==oldColor)
            {
                dfs(image,row,col,newColor);
            }
            
            
        }
    }
}


/*
// Time Complexity: O(mn)..Because in the worst case we might have to process each cell in in the input 2D matrix.. This is linear time complexity with respect to input
//Space Complexity: O(mn) ..Since we are using a queue
// Using BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor=image[sr][sc];
    int[][] dirs= new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int  m=image.length;
     int n=image[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        int[] startCell=new int[]{sr,sc};
        q.add(startCell);
        int[] curr;
        int r,c;
        while(!q.isEmpty())
        {
            curr=q.poll();
            if(image[curr[0]][curr[1]]==newColor)
                continue;
            image[curr[0]][curr[1]]=newColor;
            for(int[] dir: dirs)
            {
                r=dir[0]+curr[0];
                c=dir[1]+curr[1];
                
                if(r >= 0 && c >= 0 && r < m && c< n && image[r][c]==oldColor)
                {
                    q.add(new int[]{r,c});
                }
            }
            
        }
        
        return image;
    }
}
*/
