"""
Time Complexity : O(m*n)- as will be visiting all the nodes
Space Complexity : O(m*n)- size of recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
can be done with both DFS and BFS. Here, I am doing it with DFS. We will change the color of the current
node to new color and call recursive method on all its neighbors. For BFS, we can put its neighbors in the queue
and process them one by one.
"""


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor:
            return image
        clr = image[sr][sc]
        self.dfs(image, sr, sc, newColor, clr)
        return image

    def dfs(self, image, r, c, color, clr):
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != clr:
            return
        image[r][c] = color
        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        for d in dirs:
            i = r+d[0]
            j = c+d[1]
            self.dfs(image, i, j, color, clr)
