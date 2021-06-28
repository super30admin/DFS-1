"""
Approach: If the given color is not same as the new color, move in BFS/ DFS traversal and keep updating the cells with
same old color else skip cell.

TC: O(m*n)
SC: O(m*n)
"""
from collections import deque
class Solution:
    # approach 1: DFS
    """
    def __init__(self):
        self.m = 0
        self.n = 0
        self.color = 0
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.m = len(image)
        self.n = len(image[0])
        self.color = image[sr][sc]
        if self.color != newColor:
            self.dfs(image, sr, sc, newColor)
        return image

    def dfs(self, image, r , c, newcolor):

        #base
        if r < 0 or r == self.m or c < 0 or c == self.n or image[r][c] != self.color:
            return

        #logic
        image[r][c] = newcolor
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        for nr, nc in dirs:
            newr = r + nr
            newc = c + nc
            self.dfs(image, newr, newc, newcolor)
    """

    # approach2: BFS
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        m = len(image)
        n = len(image[0])
        color = image[sr][sc]
        if color == newColor:
            return image
        q = deque()
        q.append((sr, sc))
        while q:
            r, c = q.popleft()
            image[r][c] = newColor
            for nr, nc in dirs:
                newr = r + nr
                newc = c + nc
                if 0 <= newr < m and 0 <= newc < n and image[newr][newc] == color:
                    q.append((newr, newc))
        return image