class Solution(object):
    def updateMatrix(self, mat):
        """
        #DFS Approach
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        https://leetcode.com/problems/01-matrix/
        Time Complexity: O(m*n)
        Space Complexity: O(m*n)
        """
        rows, cols = len(mat), len(mat[0])
        result = [[float('inf')] * cols for _ in range(rows)]
        
        def dfs(r, c, dist):
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return
            if dist >= result[r][c]:
                return
            
            result[r][c] = dist
            
            dfs(r + 1, c, dist + 1)
            dfs(r - 1, c, dist + 1)
            dfs(r, c + 1, dist + 1)
            dfs(r, c - 1, dist + 1)
        
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    dfs(r, c, 0)
        
        return result
        