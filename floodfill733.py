"""
Approach 1 - BFS
TC - O(m*n) - O(V+E)- since traverses all elements in the matrix in the worst case
SC - O(m*n) - O(V) - for the queue
"""

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if (len(image) == 0 or image is None or image[sr][sc] == newColor):
            print("Returning")
            return image
        
        rows = len(image)
        columns = len(image[0])
        
        color = image[sr][sc]
        print("Color: ", color)
        image[sr][sc] = newColor
        
        queue = []
        queue. append(sr)
        queue.append(sc)
        
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        
        while queue:
            c = queue.pop()
            r = queue.pop()
            
            for direct in directions:
                dr = r + direct[0]
                dc = c + direct[1]
                
                if (dr >= 0 and dr < rows and dc >= 0 and dc < columns and image[dr][dc] == color):
                    image[dr][dc] = newColor
                    queue.append(dr)
                    queue.append(dc)
        
        return image
 
""" 
Approach 2 - DFS
TC - O(m*n)
SC - O(m*n) recursive stack space else O(1)

"""
class Solution:
    def __dfs(self, image: list[list[int]], sr: int, sc: int, newColor: int):
        
        # base
        if (sr < 0 or sc < 0 or sr == self.rows or sc == self.columns or image[sr][sc] != self.color):
            return
        
        # Setting the new Color
        image[sr][sc] = newColor
        # up, down, right, left
        directions = [(0,-1), (0,1), (1,0), (-1,0)]
        for direct in directions:
            r = sr + direct[0]
            c = sc + direct[1]
            self.__dfs(image, r, c, newColor)
                    
        
         
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if (not image or len(image) == 0 or image[sr][sc] == newColor):
            return image
        
        self.rows = len(image)
        self.columns = len(image[0])
        
        self.color = image[sr][sc]
        
       # image[sr][sc] = newColor
        
        self.__dfs(image, sr, sc, newColor)
        return image
    
        
