/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
*/

//DFS Solution
// T: O(M * N))
// S: O(1)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if (image[sr][sc] == newColor) return image;
        
        int colored = image[sr][sc];
        fillArray(image, sr, sc, newColor, colored);
        
        return image;
       
    }
    
    public void fillArray(int[][] image, int sr, int sc, int newColor, int colored){
        
         if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != colored) return;
        
        image[sr][sc] = newColor;
        
        fillArray(image, sr - 1, sc, newColor, colored);
        fillArray(image, sr + 1, sc, newColor, colored);
        fillArray(image, sr, sc + 1, newColor, colored);
        fillArray(image, sr, sc - 1, newColor, colored);
    }
}

// BFS Solution

// T: O(M * N)
// S: O(M * N)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int[] directions = new int[]{0, 1, 0, -1, 0};
        int colored = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        boolean[][] visited = new boolean[image.length][image[0].length];
        
        q.add(new int[]{sr, sc});
        
        while(!q.isEmpty()){
            
            int[] a = q.poll();
            int r = a[0];
            int c = a[1];
            
            image[r][c] = newColor;
            visited[r][c] = true;
            
            for(int i = 0; i < directions.length - 1; i++){
                
                int newRow = directions[i];
                int newCol = directions[i + 1];
                
                newRow = r + newRow;
                newCol = c + newCol;
                
                if(newRow < 0 || newCol < 0 || newRow >= image.length || newCol >= image[0].length || image[newRow][newCol] != colored || visited[newRow][newCol]) continue;
                
                image[newRow][newCol] = newColor;
                q.offer(new int[]{newRow, newCol});
                
            }
        }
        
        return image;
    }
}