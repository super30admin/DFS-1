//dfs
//time- o(m*n)
//space-o(m*n)
//passed in leetcode-yes

class Solution {
    
    int color;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      
        m= image.length;
        n= image[0].length;
        
        color = image[sr][sc];        
        
         if (image[sr][sc] != newColor)
         {
             dfs(image, sr, sc, newColor);
         }
        
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int newColor)
    {
        //base, if out of bounds, or pixel color not equal to old color
        if(r>=m || r<0 || c<0 || c>=n || image[r][c]!= color) return;
        
        image[r][c] = newColor;
                
        dfs(image, r, c-1, newColor);//left
        dfs(image, r-1, c, newColor);//up
        dfs(image, r, c+1, newColor);//right
        dfs(image, r+1, c, newColor);//down
        
    }
}


//bfs
//time- o(m*n)
//space-o(m*n)
//passed in leetcode-yes

/*
//bfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        Queue<int[]> q = new LinkedList<>();
       
        int m= image.length;
        int n=image[0].length;
        
         if(image[sr][sc] == newColor)//if pixel is already new color, no need to modify
         {
            return image;
         }
         
        int color = image[sr][sc];       
      
        
        //put the src pixel in the q after modifying color    
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        
        int[][] dirs ={{0,1}, {1,0}, {-1,0} , {0,-1}};
        
        while(!q.isEmpty())//O(m*n) checking neighburs
        {
            int[] curr = q.poll();
            
            for(int[] dir: dirs)//modifying neighbours 
            {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r<m && r>=0 && c>=0 && c<n && image[r][c] == color)//only if old color, we modify
                {
                     image[r][c] = newColor;
                     q.add(new int[]{r,c});
                }
            }
        }
        
      
        return image;
    }
}
  
*/