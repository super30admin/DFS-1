'''
    Time Complexity:
        O(mn) (where m = number of rows of image, n = number of columns of image)

    Space Complexity:
        O(mn) (where m = number of rows of image, n = number of columns of image)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        DFS approach.
        Perform DFS from the given start coordinates.
        Don't perform DFS at a cell if:
            -> the color at that cell is not equal to the original color, or
            -> the color at that cell is equal to the new color already.
'''
class Solution:
    def __init__(self):
        self.org_color = -1
        self.new_color = -1
        self.image = []

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.image = image
        self.org_color = self.image[sr][sc]
        self.new_color = newColor

        self.dfs(sr, sc)

        return self.image

    def dfs(self, i, j):
        if i not in range(0, len(self.image)):
            return

        if j not in range(0, len(self.image[i])):
            return

        if self.image[i][j] != self.org_color:
            return

        if self.image[i][j] == self.new_color:
            return

        self.image[i][j] = self.new_color
        self.dfs(i + 1, j)
        self.dfs(i - 1, j)
        self.dfs(i, j + 1)
        self.dfs(i, j - 1)
