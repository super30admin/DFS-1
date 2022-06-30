//*****FLOOD FILL- BFS APPROACH ****
// Time Complexity :O(m*n);
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m=image.length;
        int n=image[0].length;
        //Null case
        if(image.length==0 || image[sr][sc]==color) return image;
        
        //Directions array for going in 4 directions
                             //u    //d   //L    //R
        int[][] dirs=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        //Getting thr current color
        int currcolor=image[sr][sc];
        
        //Delaring Queue for performing BFS
        Queue<int[]> q=new LinkedList<>();
        
        //Initially add the given element position inside the queue
        
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        
        //Play with the Queue
        while(!q.isEmpty())
        {
            //Process the level
            int[] res=q.poll();
            for(int[] dir:dirs)
            {
                int nr=res[0]+dir[0];
                int nc=res[1]+dir[1];
                //Check the bounds & the condition
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==currcolor)
                {
                    q.add(new int[] {nr,nc});
                    image[nr][nc]=color;

                }
            }
            
        }
        
        return image;
            
        
    }
}
//****FLOOD FILL- DFS APPROACH*****
//Time complexity:o(m*n);
//Space complexity:o(m*n);
//Leetcode runnable:Y;
//Any doubts:N;


class Solution {
    int m;
    int n;
    int[][] dirs;
    int currcolor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        
        m=image.length;
        n=image[0].length;
        //Null case
        if(image.length==0 || image[sr][sc]==color) return image;
        
        //Directions array for going in 4 directions
                             //u    //d   //L    //R
        dirs=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        //Getting thr current color
        currcolor=image[sr][sc];
        dfs(image, sr, sc, color, m, n);
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int m, int n)
    {
        //BASE
        if(sr< 0 || sc<0 || sr==m || sc==n || image[sr][sc]!=currcolor) return;
        
        //LOGIC
        image[sr][sc]=color;
        //Iterating on all the directions
        for(int [] dir: dirs)
        {
            int nr=sr+dir[0];
            int nc=sc+dir[1];
            dfs(image, nr, nc, color, m, n);
        }
        
    }
}

//****WORD SEARCH****
//Time complexity:3^L;
//Space complexity: o(m*n);

class Solution {
    int m;
    int n;
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        //Null case
        if(board.length==0)
        {
            return true;
        }
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    if(dfs(board, word, 0, 0 , 0 ))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board, String word,int i, int j, int index)
    {
        //Base
        if(index==word.length()) return true;
        
        if(i<0 || j<0 || i==m ||j==n || board[i][j]=='#')
        {
            return false;
        }
        
        //Logic
        if(board[i][j]==word.charAt(index))
        {
            for(int[] dir: dirs)
            {
                int r=dir[0]+i;
                int c=dir[1]+j;
                //action
                board[i][j]='#';
                //recurse
                if(dfs(board, word, r, c, index+1)) return true;
                //backtrack
                board[i][j]=word.charAt(index);
            }
            
        }
        return false;
        
        
        
    }
}

//If I have found the first letter 
//Use the directions array and go for the next letter
//Backtrack if we dont find any letter further
