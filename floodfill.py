# Time Complexity : O(m*n)
# Space Complexity : O(m*n) Recusion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.baseColor = image[sr][sc] 
        return self.helper(image, sr, sc, newColor)
    
    def helper(self, image, sr, sc, newColor):
        if sr < 0 or sr > len(image) -1 or sc < 0 or sc > len(image[0]) -1 or image[sr][sc] == newColor or image[sr][sc] != self.baseColor:
            return image
        if image[sr][sc] == self.baseColor:
            image[sr][sc] = newColor
        self.helper(image, sr+1, sc, newColor)
        self.helper(image, sr-1, sc, newColor)
        self.helper(image, sr, sc+1, newColor)
        self.helper(image, sr, sc-1, newColor)
        return image