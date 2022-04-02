// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS
class Solution {
    int[][] directions;
    int originalColor;
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if(image == null && image[sr][sc] == newColor)   return image;
    directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
    
    int m = image.length;
    int n = image[0].length;
    
    originalColor = image[sr][sc]; // Starting point in image's color will be original color
    
    Queue<int []> queue = new LinkedList<>();
    queue.add(new int[]{sr,sc}); //add pair of starting point's indices in queue
    image[sr][sc] = newColor; //Change the color of starting point - cell
    
    while(!queue.isEmpty()){
        int[] temp = queue.poll(); // Traversing neighbours of all cells of queue
        for(int[] d : directions){
            int i = temp[0] + d[0];
            int j = temp[0] + d[1];
            if(i >= 0 && j >= 0 && i < m && j < n && image[i][j] == originalColor){ // if color is originalColor -> update the color with newcolor
                image[i][j] = newColor;
                queue.add(new int[]{i,j}); //Add indices in the queue
            }
        }    
    }
    
    return image;
}
}

//DFS
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*
class Solution {
int[][] directions;
int originalColor;
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    
    if(image == null && image[sr][sc] == newColor)   return image;
    directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
    
    int m = image.length;
    int n = image[0].length;
    
    originalColor = image[sr][sc]; // Starting point in image's color will be original color
    
    
    helper(image, sr, sc, newColor, m, n); // Starting DFS from indices given
        
    return image;
    
}
public void helper(int[][] image, int sr, int sc, int newColor, int m, int n){
    if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != originalColor)    return;
    
    image[sr][sc] = newColor; //First update the cell with new Color
    
    for(int[] d : directions){
        int i = sr + d[0];
        int j = sc + d[1];
        
        helper(image, i, j, newColor, m, n); // FOR 4 Neighbours of current cell, call DFS function
    }
}
}


*/