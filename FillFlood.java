//Time complexity: O(m*n*4)
//Space complexity: O(m*n)
//Executed on leetcode

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while(!queue.isEmpty())
        {
            int[] index = queue.poll();
            int color = image[index[0]][index[1]];      //Add the first given index to queue.
             if(color==newColor)
                continue;                               //Then check if any neighbour has similar pixel, if so add to queue and change the particular index to new color do not add if the index has new color already .
            int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
            for(int[] dir: directions)
            {
                int i = index[0]+dir[0];        //Repeate the untill queue is empty.
                int j = index[1]+dir[1];
                if(i>=0 && i< m && j>=0 && j<n && image[i][j]!=newColor && image[index[0]][index[1]]==image[i][j])
                {
                    queue.add(new int[]{i,j});
                }
            }
            image[index[0]][index[1]] = newColor;
        }
        
        return image;
    }
}