
## Problem2 (https://leetcode.com/problems/01-matrix/)

# Approach
# Traverse through the m*n matrix and set all 1 to -1. This is help avoid confusion whether the original value is 1 or its distance from 0 is 1
# Add the all 0's to queue. Traverse through the queue for each level. Check if it has neighbouring -1. Set these -1 to level. 
# Levels would be equivalent to its distance from 0. Return mat.

# Time Complexity: O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1

        direction = [[-1,0],[0,-1],[1,0],[0,1]]
        level = 0

        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
        
        while q:
            size = len(q)
            level += 1
            for i in range(size):
                r,c = q.popleft()
                for d in direction:
                    nr = r + d[0]
                    nc = c + d[1]
                    if (0<=nr<m and 0<= nc<n and mat[nr][nc] == -1):
                        mat[nr][nc] = level
                        q.append((nr,nc))
        return mat

        