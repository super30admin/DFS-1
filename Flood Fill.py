#// Time Complexity : O(n) 
# // Space Complexity : O(n)in dfs if not considering stack space o(n) in BFS   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : changing the color to a new coloe after visiting it was a bit tricky.

class Solution:
    # def dfs(self,sr,sc,ans,image,ncolor,icolor,row,col):
    #   ans[sr][sc] = ncolor 
    #   for i in range(4):
    #     nrow = sr + row[i]
    #     ncol = sc + col[i]
    #     if nrow >= 0 and ncol >=0 and nrow < len(image) and ncol < len(image[0]) and image[nrow][ncol] == icolor and ans[nrow][ncol] != ncolor:
    #       self.dfs(nrow,ncol,ans,image,ncolor, icolor,row,col)

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        if image == None:
            return image 
        if image[sr][sc] == color:
            return image
        icolor = image[sr][sc]
        dx = [-1,0,1,0]
        dc = [0,1,0,-1]
        queue = []
        queue.append(sr)
        queue.append(sc)
        image[sr][sc] = color
        while queue:
            cr = queue.pop(0)
            cc = queue.pop(0)
            for i in range(4):
                nrow = dx[i] + cr
                ncol = dc[i] + cc
            
                if nrow >= 0 and ncol >= 0  and nrow <len(image) and ncol < len(image[0]) and image[nrow][ncol] == icolor:
                    queue.append(nrow)
                    queue.append(ncol)
                    image[nrow][ncol] = color
        return image
    
    #   

    #   ans =[]
    #   for i in image:
    #     ans.append(i)
    #   
    #   self.dfs(sr,sc,ans,image, color,icolor,dx,dc)
    #   return ans  


# Approach:
# 1. We can use DFS to solve this problem. We can start from the given cell and then
# check for all the adjacent cells. If the adjacent cell has the same color as the
#     given cell, then we can change the color of the adjacent cell to the new color.
# 2. We can also use BFS to solve this problem. We can start from the given cell and
# then check for all the adjacent cells. If the adjacent cell has the same color as the
#     given cell, then we can change the color of the adjacent cell to the new color.

