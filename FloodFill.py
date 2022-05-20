# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        rows = len(image)
        cols = len(image[0])
        source_color = image[sr][sc]
        visited = set()
        directions = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        def fillColor(row, col):
            if image[row][col] != source_color:
                return
            image[row][col] = newColor
            visited.add((row, col))

            for pos in directions:
                n_row = row + pos[0]
                n_col = col + pos[1]
                if (n_row >= 0 and n_row < rows) and (n_col >= 0 and n_col < cols):
                    if (n_row, n_col) not in visited:
                        fillColor(n_row, n_col)
        fillColor(sr, sc)
        return image
