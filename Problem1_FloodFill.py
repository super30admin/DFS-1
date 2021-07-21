# Time Complexity: O(mn), where m - num of rows and n - num of cols
# Space Complexity: O(mn), due to recursion stack
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # If start color is same as the newColor
        if not image or len(image) == 0 or image[sr][sc] == newColor:
            return image

        self.rows = len(image)
        self.cols = len(image[0])

        # old color to be changed
        self.color = image[sr][sc]
        # Start with the given start row and col
        self.dfs(image, sr, sc, newColor)

        return image


    def dfs(self, image: List[List[int]], row: int, col: int, newColor: int) -> None:
        # base - if row & col are out of bounds or if it is not the old color
        if row < 0 or col < 0 or row == self.rows or col == self.cols or image[row][col] != self.color:
            return

        # logic - recursively traverse through all directions and change to new color
        image[row][col] = newColor
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        for d in dirs:
            r = row + d[0]
            c = col + d[1]
            self.dfs(image, r, c, newColor)



