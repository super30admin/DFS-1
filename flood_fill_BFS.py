from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
         
        if not image or len(image) < 1 or len(image[0]) < 1:
            return
            
       
        rows = len(image)
        cols = len(image[0])
        start_color = image[sr][sc]
        
        if start_color == newColor:
            return image
        
        queue = deque()
        queue.append((sr,sc))
        image[sr][sc] = newColor
        
        dirs = [(0,-1),(0,1),(1,0),(-1,0)]
        while queue:
            
            cur_x, cur_y = queue.popleft()
            for dir_x, dir_y in dirs:
                new_x = cur_x + dir_x
                new_y = cur_y + dir_y
                if new_x >=0 and new_x < rows and new_y >= 0 and new_y < cols and image[new_x][new_y] == start_color:
                    image[new_x][new_y] = newColor
                    queue.append((new_x, new_y))
                    
        return image