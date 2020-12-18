# Flood Fill

# Time Complexity : O(N) where N is no of pixels i.e M*N  
# Space Complexity : O(N) where N is no of pixels i.e M*N  
# Did this code successfully run on Leetcode : Yes, with Runtime: 68 ms and Memory Usage: 14.5 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : 
"""
Using Recursive, DFS Approach and startiing from the given coordinate (sr,sc)
and checking its neighbors in four directions and updating the same and calling
recursive/helper function with updated row and column establishing base/Edge cases.

"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image)==0 or image[sr][sc]==newColor: # Edge Case
            return image
        color=image[sr][sc]
        def dfs(image,row,col,newColor):
            if row <0 or col<0 or row>=len(image) or col>=len(image[0]) or image[row][col] is not color or image[row][col]==newColor:
                return
            image[row][col]=newColor
            directions =[[1,0],[-1,0],[0,1],[0,-1]] # four directions to move 
            for direc in directions:
                    nextrow = direc[0] + row
                    nextcol = direc[1] + col
                    dfs(image,nextrow,nextcol,newColor)
        dfs(image,sr,sc,newColor)
        return image
