# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image) == 0 or len(image[0]) == 0:
            return image
        
        oldColor = image[sr][sc]
        if newColor == oldColor:
            return image
        
        self.dfs(image, sr, sc, newColor, oldColor)
        return image
        
    def dfs(self, image, sr, sc, newColor, oldColor):
        print(sr, sc)
        if sr < 0 or sc < 0 or sr >= len(image) or sc >= len(image[0]) or image[sr][sc] != oldColor:
            return
        image[sr][sc] = newColor
        nei = [(1,0), (0,1), (-1,0), (0,-1)]
        
        for i in nei:
            r = sr+i[0]
            c = sc+i[1]
            self.dfs(image, r, c, newColor, oldColor)