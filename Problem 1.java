//Time Complexity: O(M * N) where M is the number of rows and N is the number of columns
//Space Complexity: O(M * N)

//Successfully runs on leetcode: 1 ms

//Approach: Here, we are using BFS traversal along with size variable to keep a track of neighbours of the starting 
//element at a given index and if the neighbours have the same color as the color at the starting index, we update their
//color to the new color, add them in the queue and perform BFS similarly to color all the possible neighbours.



class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int[] curr = queue.poll();
                for(int[] dir: dirs)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if(r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color )
                    {
                        image[r][c] = newColor;
                        queue.add(new int[]{r,c});
                    }
                }
            }
        }
        return image;
    }
}