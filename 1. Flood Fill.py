# DFS Approach
class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        # Time Complexity - O(m*n)
        # Space Complexity - O(m*n)
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image

        m = len(image)
        n = len(image[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        color = image[sr][sc]

        def dfs(image, sr, sc, newColor):
            # Base
            if sr < 0 or sc < 0 or sr == m or sc == n or image[sr][sc] != color:
                return

            # Logic
            image[sr][sc] = newColor
            for direction in dirs:
                new_row = sr + direction[0]
                new_col = sc + direction[1]
                dfs(image, new_row, new_col, newColor)

        dfs(image, sr, sc, newColor)
        return image


# BFS Approach
from collections import deque
class Solution:
    def floodFill(self, image, sr, sc, newColor):
        # Time Complexity - O(m*n)
        # Space Complexity - O(m*n)
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image

        m = len(image)
        n = len(image[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        color = image[sr][sc]
        image[sr][sc] = newColor

        rows = deque()
        cols = deque()
        rows.append(sr)
        cols.append(sc)
        while rows:
            r = rows.popleft()
            c = cols.popleft()
            for direction in dirs:
                new_row = r + direction[0]
                new_col = c + direction[1]
                if new_row >= 0 and new_row < m and new_col < n and image[new_row][new_col] == color:
                    image[new_row][new_col] = newColor
                    rows.append(new_row)
                    cols.append(new_col)

        return image
