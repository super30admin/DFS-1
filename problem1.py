'''
Iterative:
Time Complexity: O(m*n) row*column
Space Complexity: O(m*n)
Did this code successfully run on Leetcode : Yes
Explanation: Use DFS to implement, iterate through 2D find if color == src color which are to be colored, so we implement
dfs and mark the color as the src color.
'''


class Solution:
    def visit(self, image: List[List[int]], srcColor: int, row: int, col: int, newColor: int):
        # visit

        image[row][col] = newColor
        # iterate through neighbors

        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        for i in range(0, 4):
            x = row + dx[i]
            y = col + dy[i]

            if (self.isValid(image, x, y) and image[x][y] == srcColor):
                self.visit(image, srcColor, x, y, newColor)

    def isValid(self, image, row, col):
        return row >= 0 and row < len(image) and col >= 0 and col < len(image[0])

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        if image == None:
            return image

        m = len(image)

        if m == 0:
            return image

        n = len(image[0])

        if newColor == image[sr][sc]:
            return image

        self.visit(image, image[sr][sc], sr, sc, newColor)

        return image

