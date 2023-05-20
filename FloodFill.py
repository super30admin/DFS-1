## Problem1 (https://leetcode.com/problems/flood-fill/)

# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: Yes
# Approach: DFS

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[
        List[int]]:
        if not image:
            return image
        if image[sr][sc] == newColor:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.color = image[sr][sc]
        self.dfs(image, sr, sc, newColor)
        return image

    def dfs(self, image, r, c, newColor):
        # base
        if r < 0 or r == self.m or c < 0 or c == self.n or image[r][c] != self.color:
            return

        # logic
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        image[r][c] = newColor
        for d in dirs:
            nr = r + d[0]
            nc = c + d[1]
            self.dfs(image, nr, nc, newColor)