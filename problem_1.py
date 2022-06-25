# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# BFS
from collections import deque


class Solution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        queue = deque()
        queue.append((sr, sc))
        initial = image[sr][sc]
        image[sr][sc] = color
        while queue:
            pop = queue.popleft()
            for x in dirs:
                nr = x[0] + pop[0]
                nc = x[1] + pop[1]
                if 0 <= nr < len(image) and 0 <= nc < len(image[-1]) and image[nr][nc] != color and image[nr][nc] == initial:
                    image[nr][nc] = color
                    queue.append((nr, nc))
        return image


print(Solution().floodFill([[2, 1, 1], [0, 1, 1], [1, 0, 1]], 1, 1, 2))


# DFS
# TC: O(m*n); Auxiliary SC: O(1), recursive stack space: O(m*n)
# class Solution:
#     def dfs(self, image, sr, sc, color):
#         # base
#         if image[sr][sc] != self.initial or image[sr][sc] == color:
#             return
#         # logic
#         if image[sr][sc] == self.initial and image[sr][sc] != color:
#             image[sr][sc] = color
#         for x in self.dirs:
#             nr = x[0] + sr
#             nc = x[1] + sc
#             if 0 <= nr < self.m and 0 <= nc < self.n:
#                 self.dfs(image, nr, nc, color)
#
#     def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
#         self.dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
#         self.m = len(image)
#         self.n = len(image[-1])
#         self.initial = image[sr][sc]
#         self.dfs(image, sr, sc, color)
#         return image
#
#
# print(Solution().floodFill([[2, 1, 1], [0, 1, 1], [1, 0, 1]], 1, 1, 2))
