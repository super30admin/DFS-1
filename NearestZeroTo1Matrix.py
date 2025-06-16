# // Time Complexity : bfs from 0 o(m*n)
# // Space Complexity : o(m*n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : intuition of courseschedule for bfs


# // Your code here along with comments explaining your approach
#  4approaches every approach bfs approach with all 0 in queue will find distance of nearest 1s in first pass since 
from typing import List
import collections
# class Solution:
#     def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
#         m ,n, q= len(mat),len(mat[0]),collections.deque()
#         for i in range(m):
#             for j in range(n):
#                 if mat[i][j] == 1:
#                     mat[i][j] = -1
#                 if mat[i][j] == 0:
#                     q.append((i,j))
#         dist = 1
#         dir = [[1,0],[0,1],[-1,0],[0,-1]]
#         while q:
#             size = len(q)
#             for i in range(size):
#                 r,c = q.popleft()
#                 for x,y in dir:
#                     nr = r+x
#                     nc = c+y
#                     if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]== -1:
#                         q.append((nr,nc))
#                         mat[nr][nc] = dist
#             dist+=1
#         return mat
# without size:
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m ,n, q= len(mat),len(mat[0]),collections.deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                if mat[i][j] == 0:
                    q.append((i,j))
        dist = 1
        dir = [[1,0],[0,1],[-1,0],[0,-1]]
        while q:
            r,c = q.popleft()
            for x,y in dir:
                nr = r+x
                nc = c+y
                if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]== -1:
                    q.append((nr,nc))
                    mat[nr][nc] = mat[r][c]+1
        return mat
                    
                
        


