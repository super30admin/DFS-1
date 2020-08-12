# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we do a dfs on all 4 direction in the matrix from the source cell
# and in each recurse we will check if the elements in bounds, and current cell color is equal or not equal to newColor

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        color = image[sr][sc]

        if color != newColor:
            self.dfs(image, sr, sc, color, newColor)

        return image

    def dfs(self, image, r, c, color, newColor):

        # base
        if r < 0 or c < 0 or r >= len(image) or c >= len(image[0]) or image[r][c] != color:
            return

        # logic
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        image[r][c] = newColor

        for direction in dirs:
            self.dfs(image, r + direction[0], c + direction[1], color, newColor)



