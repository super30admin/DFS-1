"""
Time Complexity : O(m*n) where m is the number of rows and n is the number of cols of the input matrix
                  This is because we are iterating through all the elements of the matrix.
Space Complexity : O(m*n) where m is the number of rows and n is the number of cols of the input matrix
                   This is because the recursive stack can contain all the elements from the input matix.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We can use bfs or dfs here as it is a connected component's problem. So connected component's means for every color change we have to again make sure to change the color if the neibour's of lastly changed cell memebers are also same as the old color.

To apply the DFS,
1. Performed the dfs in all the directions of the source cell.
2. Base condition will be the bound check and checking if the source cell has the same color as the oldColor.
3. Logic is to change the color of the cell to the newColor and perform dfs in the all 4-directions of the source cell.
"""
class Solution:
    def dfs(self, image, sr, sc, directions, oldColor, color, rows, cols):
        #base
        if sr < 0 or sc < 0 or sr == rows or sc == cols or image[sr][sc] != oldColor:
            return
        
        #logic
        image[sr][sc] = color
        for dire in directions:
            nr = dire[0] + sr
            nc = dire[1] + sc
            self.dfs(image,nr,nc,directions,oldColor, color, rows, cols)
            
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if len(image) == 0 or image[sr][sc] == color:
            return image
        rows = len(image)
        cols = len(image[0])
        oldColor = image[sr][sc]
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        
        self.dfs(image, sr, sc, directions, oldColor, color, rows, cols)
        return image