# Time complexity and space complexity is O(N)
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        
        R = len(image)
        C = len(image[0])
        color = image[sr][sc]
        
        if color == newColor:
            return image
                
        def dfs(r, c):
            if image[r][c]==color:
                image[r][c] = newColor               
                if r>=1:
                    dfs(r-1, c)
                if r+1<R:
                    dfs(r+1, c)
                if c>=1:
                    dfs(r, c-1)
                if c+1<C:
                    dfs(r, c+1)        
        dfs(sr, sc)
        return image