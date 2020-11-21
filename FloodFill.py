# // Time Complexity : O(mn)
# // Space Complexity : O(mn) ?(height of the tree: worst case whole matrix)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 
# 
# use DFS
# if color of current node is color then change the color ro newColor
# go in all directions using the directions array

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        def dfs(r,c):
            #base
            if r<0 or r>= row or c<0 or c>=col or image[r][c] != color:
                return 
            
            image[r][c] = newColor
                
            #Logic
            for dir in directions:
                rd = dir[0] + r
                cd = dir[1] + c
                dfs(rd, cd)
                
                
        row = len(image)
        col = len(image[0])
        directions = [(0,1),(1,0),(0,-1),(-1,0)]
        color = image[sr][sc]
        if color == newColor:
            return image
        dfs(sr,sc)
        return image  