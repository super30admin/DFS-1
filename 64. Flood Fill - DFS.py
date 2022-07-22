class Solution:
    m, n = 0, 0
    ogColor = 0
    dirs = []

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == color:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.ogColor = image[sr][sc]
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        self.dfs(image, sr, sc, color)
        return image

    def dfs(self, image, sr, sc, color):
        if sr < 0 or sc < 0 or sr == self.m or sc == self.n or image[sr][sc] != self.ogColor:
            return

        image[sr][sc] = color

        for d in self.dirs:
            nr = sr + d[0]
            nc = sc + d[1]
            self.dfs(image, nr, nc, color)

# BFS
# Time complexity : O(m * n)
# Space complexity : O(m * n)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No
