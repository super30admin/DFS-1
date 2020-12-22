/*
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        self.color = image[sr][sc]
        self.row = len(image)
        self.col = len(image[0])
        
        self.dfs(image, sr, sc, newColor)
        
        return image
    
    def dfs(self, image, row, col, newColor):
        if row < 0 or row > self.row - 1 or col < 0 or col > self.col - 1 or image[row][col] != self.color or image[row][col] == newColor:
            return
        
        image[row][col] = newColor
        
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        
        for r,c in dirs:
            new_row = row + r
            new_col = col + c
            self.dfs(image, new_row, new_col, newColor)



class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        color = image[sr][sc]
        rows = len(image)
        cols = len(image[0])
        
        q = collections.deque()
        image[sr][sc] = newColor
        q.append((sr,sc))
        dirs = [[0,-1], [0,1], [1,0], [-1,0]]
        while len(q) > 0:
            curRow, curCol = q.popleft()
            for r,c in dirs:
                newRow = curRow + r
                newCol = curCol + c
                if newRow >=0 and newRow < rows and newCol >=0 and newCol < cols and image[newRow][newCol] == color and image[newRow][newCol] != newColor:
                    image[newRow][newCol] = newColor
                    q.append((newRow, newCol))
        
        
        return image


        
// with dfs
class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int newColor){
        if (row < 0 || row > image.length - 1 || col < 0 || col > image[0].length - 1 || image[row][col] != color || image[row][col] == newColor)
            return;
        
        image[row][col] = newColor;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        for (int[] d: dirs){
            int new_row = d[0] + row;
            int new_col = d[1] + col;
            dfs(image, new_row, new_col, newColor);
        }
    }
}

*/

// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: started with sr and sc anf then did bfs on its neighbours

class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        
        int color = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr, sc});
        
        int[][] dirs = {{0,-1}, {-1,0}, {1,0}, {0,1}};
        while (!q.isEmpty()){
            int[] d = q.poll();
            for (int[] dir:dirs){
                int new_row = dir[0] + d[0]; 
                int new_col = dir[1] + d[1];
                if (new_row >= 0 && new_row < image.length && new_col >= 0 && new_col < image[0].length && image[new_row][new_col] == color && image[new_row][new_col] != newColor){
                    image[new_row][new_col] = newColor;
                    q.add(new int[] {new_row, new_col});
                }
            }
        }
        
        
        return image;
    }
    
    
}