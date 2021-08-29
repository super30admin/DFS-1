"""
Time Complexity : O(mxn) m is no. of row and n is no. of cols
Space Complexity : O(mxn) m is no. of row and n is no. of cols
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat) == 0:
            return mat
        m = len(mat)
        n = len(mat[0])
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        q = deque()
        # Find all 0 and add it ot he queue and turn all 1 to -1
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        # Traverse through the queue
        while q:
            size = len(q)
            # Maintain size varibale to know the levels
            for i in range(size):
                curr = q.popleft()
                # Find the neighbor rows and cols with the help of firs list
                for item in dirs:
                    nr = curr[0] + item[0]
                    nc = curr[1] + item[1]
                    # If the new row and cols are within bounds and equals -1 then 
                    # append it to the queue and increment the level or distance
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        q.append([nr,nc])
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1
        return mat
                        