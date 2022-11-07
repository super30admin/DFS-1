"""
TC - O(MxN) where m is the number of rows and n is the number of cols of the input matrix
    This is because we are iterating through all the elements of the matrix.
SC - O(MxN) where m is the number of rows and n is the number of cols of the input matrix
    This is because the recursive stack can contain all the elements from the input matix.

Approach --
BFS - Using 2 queues - rows queue and cols queue
1. Use rows and cols queue to process current row and column and its elements in 4 dirctions - U-L-R-D
2. Statrt with [sr][sc] cell
3. We will process one row+ol at a time based on 2 conditions -
a. The color of the cell being processed is same as the current row+col old color
b. add one row+col in queue at a time

To apply the DFS,
1. Performed the dfs in all the directions of the source cell.
2. Base condition will be the bound check and checking if the source cell has the same color as the oldColor.
3. Logic is to change the color of the cell to the newColor and perform dfs in the all 4-directions of the source cell.
"""
class Solution:
    def dfs(self, image, sr, sc, directions, oldColor, color, rows, cols):
        # base
        if sr < 0 or sc < 0 or sr == rows or sc == cols or image[sr][sc] != oldColor:
            return

        # logic
        image[sr][sc] = color
        for dire in directions:
            nr = dire[0] + sr
            nc = dire[1] + sc
            self.dfs(image, nr, nc, directions, oldColor, color, rows, cols)

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if len(image) == 0 or image[sr][sc] == color:
            return image
        rows = len(image)
        cols = len(image[0])
        oldColor = image[sr][sc]
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        self.dfs(image, sr, sc, directions, oldColor, color, rows, cols)
        return image