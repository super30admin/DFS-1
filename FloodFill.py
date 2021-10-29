
#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor or image ==None:
            return image
        self.dfs(image, sr, sc, image[sr][sc], newColor)
        return image
    def dfs(self, image,r,c,initial,newColor):
        if r<0 or r>=len(image) or c<0 or c>= len(image[0]) or image[r][c] != initial:
            return
        image[r][c] = newColor
        self.dfs(image, r-1, c, initial, newColor)
        self.dfs(image, r+1, c, initial, newColor)
        self.dfs(image, r, c-1, initial, newColor)
        self.dfs(image, r, c+1, initial, newColor)
        
