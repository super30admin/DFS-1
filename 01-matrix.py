"""
Runtime Complexity:
O(m*n) - we traverse the matrix of 'm' rows and 'n' columns to compute our solution. We do it by using the queue data structure, we add
all the independent nodes to it and turn the 1's to negative 1. Then we poll from the queue and check the directions and compute the required output.
SPace Complexity:
O(m*n) - dirs array and the queue data structure. In the worst case queue might endup storing m*n
Yes, the code worked on leetcode.
"""

from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat or len(mat)==0:
            return mat
        m = len(mat)
        n = len(mat[0])
        q = []
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        
        while q:
            curr = q.pop(0)
            for d in dirs:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]
                if (nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc] ==-1):
                    q.append([nr,nc])
                    mat[nr][nc] = 1+ mat[curr[0]][curr[1]]
        return mat
            
        