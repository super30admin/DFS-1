# Time: O(n)
# Space: O(n)
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        # space complexity : O(mXn)
        visited = [[False for x in range(len(image[0]))] for y in range(len(image))]
        self.helper(image, sr, sc, newColor, image[sr][sc], visited)
        return image
    def helper(self, image, x, y, newColor, s, visited):
        visited[x][y] = True
        if image[x][y] == s:
            image[x][y] = newColor
        else:
            return
        if x-1 >=0 and visited[x-1][y] == False:
            self.helper(image, x-1, y, newColor, s, visited)
        if x+1 <len(image) and visited[x+1][y] == False:
            self.helper(image, x+1, y, newColor, s, visited)
        if y-1 >=0 and visited[x][y-1] == False:
            self.helper(image, x, y-1, newColor, s, visited)
        if y+1 <len(image[0]) and visited[x][y+1] == False:
            self.helper(image, x, y+1, newColor, s, visited)
        return
        
            
