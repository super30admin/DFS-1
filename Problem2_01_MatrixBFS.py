class Solution(object):
    def updateMatrix(self, mat):
        """
        #BFSS Approach
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        https://leetcode.com/problems/01-matrix/
        Time Complexity: O(m*n)
        Space Complexity: O(m*n)
        """
        rows, cols = len(mat), len(mat[0])
        from collections import deque
        queue = deque()
        result = [[float('inf')] * cols for _ in range(rows)]
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r, c))
                    result[r][c] = 0
        
        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols:
                    if result[nr][nc] > result[r][c] + 1:
                        result[nr][nc] = result[r][c] + 1
                        queue.append((nr, nc))
        return result
        