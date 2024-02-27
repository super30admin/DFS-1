# Time Complexity : O(Mx N) where M is number of rows and N is number of cols
# Space Complexity : O(M x N) stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, with DFS one bug at line 30. Fixed it later.


# Your code here along with comments explaining your approach

# Approach : Start with index given and start updating every cell in the direction if it matches
# with old color, else don't move forward anymore and traverse other direction.
# Using DFS we will be able to fill the whole island with new color.

from typing import List


class Solution:
    dir_x = [0, -1, 1, 0]
    dir_y = [-1, 0, 0, 1]

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        old_color = image[sr][sc]
        image[sr][sc] = color
        self.dfs(image, sr, sc, old_color, color)
        return image

    def dfs(self, image, row, col, old_color, new_color):

        for index in range(4):
            new_row = row + self.dir_x[index]
            new_col = col + self.dir_y[index]
            if new_row < 0 or new_col < 0 or new_row >= len(image) or new_col >= len(image[0]):
                continue
            if image[new_row][new_col] == new_color:
                continue
            if image[new_row][new_col] == old_color:
                image[new_row][new_col] = new_color
                self.dfs(image, new_row, new_col, old_color, new_color)

