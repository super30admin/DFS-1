# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(n)
# Logic:

from collections import deque
#DFS Solution
class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        if image[sr][sc] == newColor:
            return image
        self.dfs(image, sr, sc, image[sr][sc], newColor)
        return image

    def dfs(self, image, r, c, currColor, newColor):
        rows = len(image)
        cols = len(image[0])
        if r < 0 or r >= rows or c < 0 or c >= cols or image[r][c] != currColor:
            return
        # if image[r][c] == currColor:
        image[r][c] = newColor
        direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        for d in direction:
            row = r + d[0]
            col = c + d[1]
            self.dfs(image, row, col, currColor, newColor)

#BFS Solution
class Solution_1:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        queue = deque()
        rows = len(image)
        cols = len(image[0])
        d = [[0,1], [0,-1], [1,0], [-1,0]]
        queue.append((sr,sc))
        value = image[sr][sc]
        if newColor == value:
            return image
        while queue:
            size = len(queue)
            r, c = queue.popleft()
            for di in d:
                row = r + di[0]
                col = c + di[1]
                if row >= 0 and row < rows and col >= 0 and col < cols and image[row][col] == value:
                    image[row][col] = newColor
                    queue.append((row, col))
        image[sr][sc] = newColor
        return image
