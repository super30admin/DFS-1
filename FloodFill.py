# // Time Complexity :  o(m*n) for bfs and dfs
# // Space Complexity :  o(m*n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : coming up with dfs


# // Your code here along with comments explaining your approach
# for bfs handle edge case when the start sr and sc are itself color then follow basic bfs to masrk the cell with new color add the cell to queue and expnad and color the adj cell with new color 
# if they were orignally the same color otherwise ignore
# 


from typing import List,Deque
import collections

# class Solution:
#     def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
#         if image[sr][sc] == color : return image
#         m,n,ic,q = len(image), len(image[0]), image[sr][sc], collections.deque()
#         q.append((sr,sc))
#         image[sr][sc] = color
#         dir = [[0,1],[0,-1],[1,0],[-1,0]]
#         while q:
#             r,c = q.popleft()
#             for x,y in dir:
#                 nr=r+x
#                 nc = c+y
#                 if nr>=0 and nc >=0 and nr<m and nc<n and image[nr][nc] == ic:
#                     q.append((nr,nc))
#                     image[nr][nc] = color
#         return image

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color : return image
        m,n,ic = len(image), len(image[0]), image[sr][sc]
        dir = [[0,1],[0,-1],[1,0],[-1,0]]
        
        def dfs(image , r,c,color , ic):
            nonlocal dir,m,n
            #base
            if r<0 or c<0 or r==m or c==n or image[r][c]!=ic: return
            #logic
            image[r][c] = color
            for x,y in dir:
                nr = r+x
                nc=c+y
                dfs(image, nr,nc, color,ic)

        dfs(image,sr,sc, color,ic)
        return image



        




        