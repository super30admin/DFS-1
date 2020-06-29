from collections import deque
class Solution(object):
    # Time Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Space Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a dfs where every neighbour is also recursively called on.
    # only the neighbors withing bounds and have the same color as the starting
    # (old color) are processed again and their colors are changed to the newColor
    def __init__(self):
        self.dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        self.image = None
        self.newColor = None
        self.oldColor = None
        self.n, self.m = 0, 0

    def floodFillDFS(self, image, sr, sc, newColor):
        if not image or image[sr][sc] == newColor:
            return image
        # saving all variables to be used by recursive function in global scope
        self.oldColor = image[sr][sc]
        self.newColor = newColor
        self.image = image
        self.n, self.m = len(image), len(image[0])
        # recursive call on source cell
        self.dfs(sr, sc)
        return self.image

    def dfs(self, sr, sc):
        # bounds check and if not oldColor
        if sr < 0 or sc < 0 or sr >= self.n or sc >= self.m or self.image[sr][sc] != self.oldColor:
            return
        # visiting all 4 neighbors and calling DFS
        self.image[sr][sc] = self.newColor
        for dir in self.dirs:
            r = sr + dir[0]
            c = sc + dir[1]
            self.dfs(r, c)

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Space Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a BFS where neighbors are processed in levels and if they have
    # the old color are processed and their color is changed to be the newColor. The colors
    # are changed from the source up until all neighbors with the old color are processed.
    def floodFillBFS(self, image, sr, sc, newColor):
        if not image or image[sr][sc] == newColor:
            return image
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        oldColor = image[sr][sc]
        n, m = len(image), len(image[0])
        # queue init
        q = deque()
        q.appendleft((sr, sc))
        image[sr][sc] = newColor

        while len(q) != 0:
            curr = q.pop()
            for dir in dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]

                if 0 <= r < n and 0 <= c < m and image[r][c] == oldColor:
                    q.appendleft((r, c))
                    image[r][c] = newColor
        return image
