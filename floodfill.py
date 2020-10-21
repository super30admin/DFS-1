// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        maxRow = len(image)
        maxColumn = len(image[0])
        color = image[sr][sc]
        if color == newColor: return image
       
        def dfs(row, column):
            if image[row][column]  == color:
                image[row][column] = newColor
                if row >= 1 : dfs(row-1, column)
                if row + 1 < maxRow:dfs(row+1, column)
                if column >= 1:dfs (row, column-1)
                if column+1 < maxColumn:dfs (row, column+1)
        dfs(sr,sc)

        return image