"""
Time Complexity : floodFill_BFS() - O(mn)
                  floodFill_DFS() - O(mn)
Space Complexity : floodFill_BFS - O(mn)
                   floodFill_DFS() - O(1)  [O(mn) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

from queue import Queue
class Solution:
    dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    def floodFill_BFS(self, image, sr, sc, newColor):
        m = len(image)
        n = len(image[0])
        if not image or m == 0 or image[sr][sc] == newColor:
            return image
    
        old_color = image[sr][sc]
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = Queue()
        q.put([sr,sc])
        image[sr][sc] = newColor
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                neighbor = q.get()
                for d in dirs:
                    r = neighbor[0] + d[0]
                    c = neighbor[1] + d[1]
                    if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == old_color:
                        image[r][c] = newColor
                        q.put([r, c])
                        
        return image
    
    def floodFill_DFS(self, image, sr, sc, newColor):
        if not image or len(image) == 0 or image[sr][sc] == newColor:
            return image  
        oldColor = image[sr][sc]
        self.dfs(image, sr, sc, oldColor, newColor)
        return image
         
    def dfs(self, image, r, c, oldColor, newColor):
        # base case
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != oldColor:
            return
        # recursive case
        image[r][c] = newColor
        for d in self.dirs:
            new_r = r + d[0]
            new_c = c + d[1]
            self.dfs(image, new_r, new_c, oldColor, newColor)
                
        
        