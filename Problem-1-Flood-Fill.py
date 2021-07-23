class Solution:

    def __init__(self):
        self.m = None
        self.n = None
        self.color = None

    def floodFill(self, image, sr, sc, newColor):
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        self.color = image[sr][sc]
        self.m = len(image)
        self.n = len(image[0])

        self.dfs(image, sr, sc, newColor)
        return image

    def dfs(self, image, r, c, newColor):

        if r == self.m or c == self.n or c < 0 or r < 0 or image[r][c] != self.color:
            return
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        image[r][c] = newColor

        for dir in dirs:
            row = dir[0] + r
            col = dir[1] + c

            self.dfs(image, row, col, newColor)
