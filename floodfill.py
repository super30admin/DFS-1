class Solution:
    
    """
    Description: given the starting position of an item in string, flood fill the image

    Time Complexicity: O(m*n) for both DFS and BFS (each node vsitied)
    Space Complexicity: O(m*n) for both DFS and BFS
    
    Solutions ran sucessfully on leetcode: Yes

    Approach: Using BFS and DFS both:
    For BFS 
    - Use a queue to start looking for original color in all directions
    - pop the queue sucessively to check all 4 directions and change color as required
    For DFS
    - recursively change the color by calling all 4 directions from starting node
    - stop when index goes out of bound or there are no old values to change the color
    
    """
        
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
    
        if image == None or len(image) == 0 : return
        self.m = len(image); self.n = len(image[0])
        self.currColor = image[sr][sc]
        if self.currColor == newColor: return image # edge case, same colors
        
        self.image = image
        self.newColor = newColor
        self.dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        
        self.dfs(sr, sc)
        return self.image
    
    def dfs(self, i, j):

        # base
        if i < 0 or j < 0 or i == self.m or j == self.n or self.image[i][j] != self.currColor: 
            return 
        
        # logic
        self.image[i][j] = self.newColor
        for d in self.dirs:
            self.dfs(i + d[0], j + d[1])
            
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:        
        
        from collections import deque
        if image == None or len(image) == 0: return
        
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        m = len(image); n = len(image[0])
        queue = deque()
        queue.append((sr, sc))
        currColor = image[sr][sc]
        if currColor == newColor: return image
        
        while queue:
            row, col = queue.popleft()
            if image[row][col] == currColor:
                image[row][col] = newColor
            for d in dirs:
                r = row + d[0]; c = col + d[1]
                if r >= 0 and c >= 0 and r < m and c < n and image[r][c] == currColor:
                    queue.append((r, c))
                    image[r][c] = newColor
           
        return image
    
        
        
