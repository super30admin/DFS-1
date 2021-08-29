"""
//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #DFS APPRCh
        #T.C = O(m*n)
        #S.C = O(m*n)
        if len(image)== 0:
            return image
        if newColor == image[sr][sc]:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        self.color = image[sr][sc]
        self.dfs(image,sr,sc,newColor)
        return image
    def dfs(self,image,row,col,newColor):
        #base
        if(row<0 or row == self.m or col<0 or col ==self.n or image[row][col]!=self.color):
            return
                                                                    
        
        #logic
        image[row][col] = newColor
        for d in self.dirs:
            r = row + d[0]
            c = col + d[1]
            self.dfs(image,r,c,newColor)
        
        #T.C = O(m*n)
        #S.C = O(m*n)
#         BFS approach
#         if len(image)== 0:
#             return image
#         if newColor == image[sr][sc]:
#             return image
#         m = len(image)
#         n = len(image[0])
#         dirs = [[0,1],[0,-1],[1,0],[-1,0]]
#         from collections import deque
#         color = image[sr][sc]
#         q = deque()
#         q.append([sr,sc])
#         image[sr][sc] = newColor
#         while q:
#             curr = q.popleft()
#             for d in dirs:
#                 r = curr[0] + d[0]
#                 c = curr[1] + d[1]
#                 if (r>=0 and r<m and c>=0 and c<n and image[r][c]==color):
#                     image[r][c] = newColor

#                     q.append([r,c])
#         return image
                
        