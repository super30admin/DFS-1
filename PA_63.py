#LC 733 - Flood Fill
#Time Complexity - O(m*n)
#Space Complexity - O(m*n)
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if not image or image[sr][sc] == newColor:
            return image
        oldColor = image[sr][sc]
        def dfs(image,sr,sc):
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != oldColor:
                return
            image[sr][sc] = newColor
            dfs(image,sr-1,sc)
            dfs(image,sr+1,sc)
            dfs(image,sr,sc-1)
            dfs(image,sr,sc+1)
        dfs(image,sr,sc)
        return image