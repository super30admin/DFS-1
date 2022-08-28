"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :

Problem1 (https://leetcode.com/problems/flood-fill/)
Your code here along with comments explaining your approach
"""

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        """
        Using BFS, taking queue to proceses each cell at a time
        Time Complexity: O(M * N), M=no of rows; N = No.of cols
        Space Complexity:O(M * N)
        """
        m = len(image)
        n = len(image[0])
        
        # checking if the given pixel is already in new color or not, if it is then we will return
        if (image[sr][sc]==color): return image
        # cretaing an empty queue to process  cells in all directions
        q = []
        q.append((sr,sc))
        
        # initialising the direction : left, right, top, up
        dirs = [(1,0),(0,1), (-1,0), (0, -1)]
        # Since we will not change the cell value at the time of pop, we will do it at the time of insert
        old_color = image[sr][sc]
        image[sr][sc] = color
        while q:
            curr = q.pop()
            
            image[curr[0]][curr[1]] == color
            for d in dirs:
                nr = d[0] + curr[0]
                nc = d[1] + curr[1]
                
                if (nr >= 0 and nr < m) and (nc >= 0 and nc < n) and image[nr][nc] == old_color:
                    q.append((nr, nc))
                    image[nr][nc] = color
        return image
        

# Approach - 2
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        """
        Using DFS Recursively
        Time Complexity:O(M * N), M=no of rows; N = No.of cols
        Space Complexity:O(M * N)
        """
        
        # checking if the given pixel is already in new color or not, if it is then we will return
        if (image[sr][sc]==color): return image
        # cretaing an empty queue to process  cells in all directions
        q = []
        q.append((sr,sc))
        
        # initialising the direction : left, right, top, up
        dirs = [(1,0),(0,1), (-1,0), (0, -1)]
        # Since we will not change the cell value at the time of pop, we will do it at the time of insert
        old_color = image[sr][sc]
        #image[sr][sc] = color
        
        def dfs_helper(image, sr, sc, color, old_color):
            # base case
            if (sr < 0 or sr == len(image)) or (sc < 0 or sc == len(image[0])) or image[sr][sc] != old_color:
                return


            # Logic
            image[sr][sc] = color
            for d in dirs:
                
                nr = d[0] + sr
                nc = d[1] + sc
                dfs_helper(image, nr, nc, color, old_color)
        
        dfs_helper(image, sr, sc, color, old_color)
        return image
        