class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        :TC:O(m*n) 
        """
        
        # if currnet color euaual to the given color, no need to make changes
        
        if image[sr][sc]==newColor:
            return image
        # store current color as source
        source, rows, cols = image[sr][sc], len(image), len(image[0])
        # if currnet color is not euaual to the given color, perform DFS
        if source != newColor: 
            self.dfs(sr, sc, newColor, image, source, rows, cols )
        return image
    
    def dfs(self,i, j,newColor, image, old, m, n):
            image[i][j] = newColor
            for x, y in ((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)):
                if 0 <= x < m and 0 <= y < n and image[x][y] == old:
                    self.dfs(x, y, newColor, image, old, m, n)