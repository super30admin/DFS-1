public class Solution {
    int color;
    public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.Length==0 || image[sr][sc]==newColor)
        {
            return image;
        }
        
        color = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
        
        
    }
​
​
private void dfs(int[][] image,int row,int col,int newcolor)
{
    if(row <0 || col <0 || row >=image.Length || col >=image[0].Length
      || image[row][col]!=color || image[row][col]==newcolor)
    {
        return;
    }
    
    image[row][col] = newcolor;
    List<(int,int)> dirs = new List<(int,int)>(){(-1,0),(1,0),(0,-1),(0,1)}; 
    foreach(var dir in dirs)
    {
        Console.WriteLine(dir);
        int r = row + dir.Item1;;
        int c = col + dir.Item2;
        dfs(image,r,c,newcolor);
    }
}
}
