# BFS
# Time Complexity: O(mn)
# Space Complexity: O(mn)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # Null condition check
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        # Obtaining the length of col and rows
        m = len(image)
        n = len(image[0])
        
        # Store the orignial color in color
        # Change the element at sr and sc to newColor
        color = image[sr][sc]
        image[sr][sc] = newColor
        
        # Initialize queue and append sr, sc as an array (Can be done seperately as well)
        q = deque()
        q.append([sr, sc])
        
        # dirs array initialization for 4 directions
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        
        
        while q:
            curr = q.popleft()

            for dir in dirs:
                nr = dir[0] + curr[0]
                nc = dir[1] + curr[1]
                
                # Check the boundary conditions and if the color is old color, change to new color and append in the stack
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == color:
                    q.append([nr,nc])
                    image[nr][nc] = newColor
                
        return image


# DFS
# Time Complexity: O(mn)
# Space Complexity: O(mn)
class Solution:
    # Define color as a global variable 
    def __init__(self):
        self.color = 0
    
    # Function for DFS call
    def dfs(self, image, sr, sc, newColor):
        # Obtaining the number of columns and rows
        m = len(image)
        n = len(image[0])

        # Declare the dirs array to traverse in all the four directions
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        # Find the new row and column with dirs array and the sr and sc
        for dir in dirs:
            nr = dir[0] + sr
            nc = dir[1] + sc
            # Check the boundary conditions and 
            # Change the color to new color if we have the color at new position as the old color
            # Recursively call dfs on the new position in the image
            if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == self.color:
                image[nr][nc] = newColor
                self.dfs(image, nr, nc, newColor)
            
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # Null condition check:
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        # Store the color of the image at sr and sc
        # Initially make the color at sr and sc equal to the newColor
        # Recursively call dfs and return the modified image
        self.color = image[sr][sc]
        image[sr][sc] = newColor
        self.dfs(image, sr, sc, newColor)
        return image
        