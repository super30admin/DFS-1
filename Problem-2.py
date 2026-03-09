# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# The code computes the minimum distance from each cell to the nearest 0 using two passes over the matrix.
# First pass goes top-left to bottom-right updating distances using top and left neighbors.
# Second pass goes bottom-right to top-left updating distances using bottom and right neighbors.
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])
        
        result = [[float('inf')] * m for _ in range(n)]
        
        for r in range(n):
            for c in range(m):
                if mat[r][c] == 0:
                    result[r][c] = 0
        
        for r in range(n):
            for c in range(m):
                if result[r][c] != 0:
                    if r > 0:
                        result[r][c] = min(result[r][c], result[r-1][c] + 1)
                    if c > 0:
                        result[r][c] = min(result[r][c], result[r][c-1] + 1)
        
        for r in range(n-1, -1, -1):
            for c in range(m-1, -1, -1):
                if r < n-1:
                    result[r][c] = min(result[r][c], result[r+1][c] + 1)
                if c < m-1:
                    result[r][c] = min(result[r][c], result[r][c+1] + 1)
        
        return result