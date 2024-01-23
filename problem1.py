#Time Complexity :O(m * n)
#Space Complexity :O(m * n)
#Did this code successfully run on Leetcode : yes
#Method: DFS


from ast import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        initColor = image[sr][sc]
        result = [row[:] for row in image]  # Create a copy of the original image
        dirc = [(0, -1), (0, 1), (-1, 0), (1, 0)]
        self.dfs_helper(sr, sc, result, image, newColor, initColor, dirc)
        return result

    def dfs_helper(self, row, col, result, image, newColor, initColor, dirc):
        result[row][col] = newColor
        m = len(image)
        n = len(image[0])
        for i in range(4):
            nrow = row + dirc[i][0]
            ncol = col + dirc[i][1]
            if 0 <= nrow < m and 0 <= ncol < n and image[nrow][ncol] == initColor and result[nrow][ncol] != newColor:
                self.dfs_helper(nrow, ncol, result, image, newColor, initColor, dirc)