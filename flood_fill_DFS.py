# Time Complexity : Add - O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''

1. DFS is performed from the starting coordinates, descendent with color equal to the start color are explored
2. As the element is explored its color is changed to the new color
3. When recusrion stops we are done with the coloring
'''

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
         
        if not image or len(image) < 1 or len(image[0]) < 1:
            return
            
       
        rows = len(image)
        cols = len(image[0])
        start_color = image[sr][sc]
        
        if start_color == newColor:
            return image
        
        self._dfs(image, sr, sc, start_color, newColor)
        
        return image
        
        
    def _dfs(self, image, cur_x, cur_y, start_color, newColor):
        dirs = [(0,-1),(0,1),(1,0),(-1,0)]
        
        if cur_x < 0 or cur_x >= len(image) or cur_y < 0 or cur_y >= len(image[0]) or image[cur_x][cur_y] != start_color:
            return
        
        
        image[cur_x][cur_y] = newColor
        for dir_x, dir_y in dirs:
            new_x = cur_x + dir_x
            new_y = cur_y + dir_y
            self._dfs(image, new_x, new_y, start_color, newColor)

            