# Time Complexity : It is O(n) we need to iterate all the rows and columns in the matrix.
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color:
            return image
        return self.dfs(image,sr,sc,color)
    
    def dfs(self, image: List[List[int]] ,sr: int, sc:int, color:int) -> List[List[int]]:
        neighbour = [[-1,0],[1,0],[0,-1],[0,1]]
        if len(image) < sr or len(image[0]) < sc or sr < 0 or sc < 0:
            return    
        if image[sr][sc] != color:
            image[sr][sc] = color

        for neigh in neighbour:
            row = sr + neigh[0]
            col = sc + neigh[1]
            if len(image) > row and len(image[0]) > col:
                if image[row][col] == 1:# and image[sr][sc] == 1:
                    self.dfs(image,row,col,color)
        return image

obj = Solution()
print(obj.floodFill([[0,0,0],[0,0,0]],1,0,2))
#print(obj.floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2))