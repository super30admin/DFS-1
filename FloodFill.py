# DFS Appraoch
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        # DFS Appraoch
        
        old_color = image[sr][sc]
        
        if old_color == color:
            return image
        
        
        directions = [[0,1], [0, -1], [1,0], [-1,0]]
        row = len(image)
        col = len(image[0])
        
        def dfs(r,c):
            if image[r][c] == old_color:
                image[r][c] = color
                
                if r>=1: 
                    dfs(r-1, c) # go up
                
                if r < row - 1:
                    dfs(r+1, c) # go down
                
                if c >=1:
                    dfs(r, c -1) # go left
                    
                if c<col - 1:
                    dfs(r, c+1) # go right
                    
                
        dfs(sr,sc)
        
        return image
    
    # Cleaner code
    # Time Complexity: O(m x n) where m and n are rows and cols respectively
    # Space Complexity: O(m x n) because queue will have all the elements of the image matrix

# BFS appraoch
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        old_color = image[sr][sc]
        
        if old_color == color:
            return image
        
        image[sr][sc] = color
        
        queue = collections.deque()
        queue.append([sr, sc])
        directions = [[-1,0], [1,0], [0,-1], [0,1]]
        
        m = len(image)
        n = len(image[0])
        
        while queue:
            row, col = queue.popleft()
                
            for direction in directions:
                nr = direction[0] + row
                nc = direction[1] + col
                
                if (nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == old_color):
                    image[nr][nc] = color
                    queue.append([nr,nc])
                    
        return image
            
    # TIME COMPLEXITY: O(M x N) where they are no of row and col respectively
    # SPACE COMPLEXITY: O(M x N)