"""
I used dfs approach to solve this question as it ask us to go deep and then perform action, so keeping the boundary conditions, we change the particular cell into the start tcolor
and move ahead and then follow the same for all 4 directions. This way everything is covered and we can return the final image.
TC is O(m x n) and SC is also O(m x n)
"""

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        rows, cols = len(image), len(image[0])
        start = image[sr][sc]

        if start == color:
            return image

        def dfs(r, c):

            if (r < 0 or r >= rows or 
                c < 0 or c >= cols or
                image[r][c] != start):
                return

            image[r][c] = color

            dfs(r - 1, c)
            dfs(r, c - 1)
            dfs(r + 1, c)
            dfs(r, c + 1)

        dfs(sr, sc)
        return image