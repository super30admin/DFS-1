# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        if len(image) == 0:
            return image

        if image[sr][sc] == newColor:
            return image

        self.dfs(image, sr, sc, newColor, image[sr][sc])
        return image

    def dfs(self, image, r, c, new, old):
        # base
        if r < 0 or r > len(image) - 1 or c < 0 or c > len(image[0]) - 1 or image[r][c] != old:
            return

        # logic
        image[r][c] = new
        # directions to keep track of
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        for i in dirs:
            cr = r + i[0]
            cc = c + i[1]
            self.dfs(image, cr, cc, new, old)
