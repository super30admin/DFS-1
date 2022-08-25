# Time Complexity : O(M * N) //It runs the array length
#  Space Complexity : O(1) //The space by array
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        #Base case
        if not image or image[sr][sc] == color:
            return image
        
        #Declare row and col to get the length
        m = len(image)
        n = len(image[0])
        #DFS
        dirs = ((-1,0),(1,0), (0,-1), (0,1))
        
        #Store the original color
        oldColor = image[sr][sc]
        
        #DFS function to recursively traverse the matrix and replace the color
        def dfs(row,col,image,color,oldColor):
            if row < 0 or col < 0 or row == m or col == n or image[row][col] != oldColor:
                return
            image[row][col] = color
            for dr,dc in dirs:
                nr = row + dr
                nc = col + dc
                dfs(nr,nc,image,color,oldColor)
        
        dfs(sr,sc,image,color,oldColor)
        return image