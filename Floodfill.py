'''
# Time complexity: O(m*n) ; m = no of rows and c = no of columns
# Space complexity: O(m*n)
'''from collections import deque

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if not image or newColor == image[sr][sc]:
            return image
        color = image[sr][sc]
        queue = deque()
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        queue.append([sr,sc])
        image[sr][sc] = newColor
        while queue:
            temp = queue.popleft()
            for d in dirs:
                r = temp[0] + d[0]
                c = temp[1] + d[1]
                if r>= 0 and r< len(image) and c>=0 and c<len(image[0]) and color == image[r][c]:
                    image[r][c] = newColor
                    queue.append([r,c])
                    
        return image
                    
        
        
'''
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if not image or newColor == image[sr][sc]:
            return image
        self.color = image[sr][sc]
        self.dfs(image, sr, sc, newColor)
        
        return image
    
    def dfs(self, image, sr, sc, newColor):
        
        if sr <0 or  sr>=len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] !=  self.color:
            return 
        
        image[sr][sc] = newColor
        
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        
        for d in dirs:
            r = sr + d[0]
            c = sc + d[1]
            self.dfs(image, r, c, newColor)

'''          
            
        

    
        