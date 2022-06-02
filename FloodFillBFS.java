/**
Time Complexity : Exponential
Space Complexity : O(D), D = depth of the recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        if(image == null || image.length == 0)
            return image;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int colorOriginal = image[sr][sc];
        image[sr][sc] = newColor;
        queue.add(new int[]{sr, sc});
        
        int dirs[][] = new int[][]{{1,0}, {-1,0,}, {0, -1}, {0,1}};
        
        int rowCount = image.length;
        int colCount = image[0].length;
        
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i =0 ;i <size; i++)
            {
                int current[] = queue.poll();
            
                for(int dir[]: dirs)
                {
                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];
                
                    boolean isValid = row >= 0 && row < rowCount && col >= 0 && col < colCount;
                
                    if(isValid)
                    {
                        boolean isPreviousColor = image[row][col] == colorOriginal && colorOriginal != newColor;
                        if(isPreviousColor)
                        {
                            image[row][col] = newColor;
                            queue.add(new int[]{row, col});
                        }
                    }
                }
            }
        
        }
        
        return image;
    }
}