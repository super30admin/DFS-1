# Time Complexity : O(M*N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: [[int]], sr: int, sc: int, newColor: int):
        color = image[sr][sc]
        if color != newColor:
            self.dfs(image, sr, sc, color, newColor)
        return image

    def dfs(self, image, r, c, color, newColor):

        # edge case
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != color:
            return
        image[r][c] = newColor

        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        for dir in dirs:
            new_r = dir[0] + r
            new_c = dir[1] + c
            self.dfs(image, new_r, new_c, color, newColor)
