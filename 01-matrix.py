# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat or not mat[0]:
            return []
        m, n = len(mat), len(mat[0])
        res = [[float('inf')] * n for _ in range(m)]
        queue = deque()
        
        # Initialize queue with all 0s and set their distance to 0
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    res[i][j] = 0
                    queue.append((i, j))
        
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        while queue:
            x, y = queue.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    if res[nx][ny] > res[x][y] + 1:
                        res[nx][ny] = res[x][y] + 1
                        queue.append((nx, ny))
        return res
        