"""
## Problem1 (https://leetcode.com/problems/flood-fill/)
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:

Input:

image = [[1,1,1],[1,1,0],[1,0,1]]

sr = 1, sc = 1, newColor = 2

TIME - O(nm)
SPACE - O(nm)
LEETCODE- yes


we will start changing the source pixel to new colour and use directions array to check all 4 sides of it

"""


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        m = len(image)
        n = len(image[0])

        self.dfs(image, sr, sc, newColor, image[sr][sc])
        return image

def dfs(self, image, i, j, newColor, srColor):
    directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]   # directions array to move top down left and right
    image[i][j] = newColor                            #  change the color to new color
    for direct in directions:                        # check all 4 directions
        r = i + direct[0]
        c = j + direct[1]
        if r < len(image) and r >= 0 and c < len(image[0]) and c >= 0 and image[r][c] == srColor:
            self.dfs(image, r, c, newColor, srColor)


"""


Three Line Explanation BFS`

Add the starting cell to the queue.
Poll a cell out of queue. Keep putting all the valid neighbors in the queue.
We can maintain a visited matrix to optimize the code to O(mn) as
we might end up pushing few nodes in the queue that are already present in the queue. Although
it would be a valid solution but the code will not be optimized.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        Queue <int[]> q = new LinkedList <>();
        int color = image[sr][sc];
        boolean [][] visited = new boolean [image.length][image[0].length];
        // put your starting cell in the queue
        q.add(new int [] {sr, sc});
        visited[sr][sc] = true;
        // Good practice to have dirs array to avoid
        int [][] dirs = new int [][]{{0,1},{1,0}, {-1,0},{0,-1}};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            image[curr[0]][curr[1]] = newColor;
            // iterate on all posiible directions
            for(int [] dir : dirs){
                int i = dir[0] + curr[0];
                int j = dir[1] + curr[1];
                if(i>= 0 && i < image.length &&
                   j >=0 && j < image[0].length
                   && image[i][j] == color
                   && !visited[i][j]
                  ) {
                        q.add(new int[] {i,j});
                        // Mark Visited
                        visited[i][j] =  true;
                    }  
            }
        }
        return image;
    }
}

"""