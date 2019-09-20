#Problem: Flood Fill

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        origColor = image[sr][sc]
        image[sr][sc] = newColor
        
        
        visited = [[False] * len(image[0]) for i in range(len(image))]
        visited[sr][sc] = True
        
        
        queue = []
        queue.append((sr, sc))
        while len(queue) != 0:
            pixel_x, pixel_y = queue.pop(0)
            for i,j in [(pixel_x+1, pixel_y), (pixel_x,pixel_y+1), (pixel_x-1,pixel_y), (pixel_x, pixel_y-1)]:
                if 0 <= i < len(image) and 0 <= j < len(image[0]) and not visited[i][j] :
                    if image[i][j] == origColor:
                        image[i][j] = newColor
                        queue.append((i,j))
                        visited[i][j] = True
                        
        return image
            
                
# Time Complexity: O(m*n) where m is rows and n is columns of image
#
# Space Complexity: O(m*n) where m is rows and n is columns of image
#
# Approach: Start from the source pixel and do a BFS for all matching pixels.