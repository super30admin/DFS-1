# Time Complexity: O(n^2)
# Space Complexity: O(n^2)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        start_color = image[sr][sc]
        if start_color == color:
            return image
        dirs = [(0,0), (-1,0), (0,1), (1,0), (0,-1)]
        (row, col) = (len(image), len(image[0]))
        def dfs(x, y):
            for (dx, dy) in dirs:
                (new_x, new_y) = (x + dx, y + dy)
                if (0 <= new_x < row) and (0 <= new_y < col) and (image[new_x][new_y] == start_color):
                    image[new_x][new_y] = color
                    dfs(new_x, new_y)
            return image
        return dfs(sr, sc)