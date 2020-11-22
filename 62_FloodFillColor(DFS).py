# accepted on leetcode(733)
# time - O(M*N) , space - O(1)
# Maintain a directions array and change the oldcolor to newcolor in all the four directions from start directions.
class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        color = image[sr][sc]  # initial color at given position
        if color != newColor:  # check if given color is not same as oldcolor
            self.dfs(image, sr, sc, color, newColor)  # then call helper function
        return image

    def dfs(self, image, sr, sc, oldColor, newColor):
        # Base case
        # check if all the row and column calculated are within the matrix range and color at that place is same as old color , if not then return
        if sr < 0 or sc < 0 or sr >= len(image) or sc >= len(image[0]) or image[sr][sc] != oldColor: return

        image[sr][sc] = newColor
        # directions array
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        # loop through dirs array to call dfs multiple times.
        for dir in dirs:
            i = dir[0] + sr  # new row
            j = dir[1] + sc  # new column
            self.dfs(image, i, j, oldColor, newColor)  # recurse