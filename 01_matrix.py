# Time Complexity: O(m*n) as we would be going through each element in the matrix
# Space Complexity: O(m*n) as we would be storing the elements in the queue and the visited set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The problem asks us to update the matrix such that the distance of the nearest 0 is calculated. 
We create a visited set and a queue in which all the 0s are added. Then we iterate through the q 
until it exists to check for the neighbours of its elements. If they haven't been visited before 
we assign them the value of current + 1. Finally the matrix is returned once the q is empty.
"""

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0: return mat

        visited = set()
        q = deque()
        m = len(mat)
        n = len(mat[0])
        directions = [[-1,0], [1,0], [0,-1], [0,1]]

        for row in range(m):
            for col in range(n):
                if mat[row][col] == 0:
                    visited.add((row, col))
                    q.append((row, col))
        
        while q:
            size = len(q)
            for _ in range(size):
                cr, cc = q.popleft()
                for direction in directions:
                    nr, nc = cr + direction[0], cc + direction[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and (nr,nc) not in visited:
                        mat[nr][nc] = mat[cr][cc] + 1
                        visited.add((nr, nc))
                        q.append((nr,nc))

        return mat