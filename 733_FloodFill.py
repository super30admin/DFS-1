"""
Leetcode- https://leetcode.com/problems/flood-fill/ (submitted)
TC- O(N), SC-O(1) auxiliary DFS
Challenge- NA
Lecture- https://youtu.be/L8y3-JZNEhM
FAQ-


An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the
pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of
 the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same
 color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.


Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.


Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
"""

from collections import deque


class Solution:
    """
    Iteration- DFS O(N) time and O(N) auxiliary space

    Do DFS from given position and process it if its color is old color and is in boundaries. Change its color to the
    new color. Doing so, we will not have to maintain a visited matrix, and we will only have to visit each node only
    once.
    """

    def floodFill(self, image, sr, sc, color):
        if len(image) == 0 or image[sr][sc] == color:
            return image
        self.oldColor = image[sr][sc]
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.dfs(image, sr, sc, color)
        return image

    def dfs(self, image, i, j, color):
        # no base condition required because all the undesired corner cases are handled by below if statement
        # logic
        image[i][j] = color
        for dir in self.dirs:
            nr = i + dir[0]
            nc = j + dir[1]
            if 0 <= nr < len(image) and 0 <= nc < len(image[0]) and image[nr][nc] == self.oldColor:
                self.dfs(image, nr, nc, color)

    """
    Ideation- BFS O(N) time and O(1) space
    
    Repeat the same strategy as DFS
    """

    def floodFill1(self, image, sr, sc, color):
        if len(image) == 0 or image[sr][sc] == color:
            return image
        oldColor = image[sr][sc]
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = deque()
        q.append([sr, sc])

        while q:
            [r, c] = q.popleft()
            image[r][c] = color
            for dir in dirs:
                nr, nc = r + dir[0], c + dir[1]
                if 0 <= nr < len(image) and 0 <= nc < len(image[0]) and image[nr][nc] == oldColor:
                    q.append([nr, nc])

        return image


result = Solution().floodFill1([[1, 1, 1], [1, 1, 0], [1, 0, 1]], 1, 1, 2)
print(result)
