from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # Test Case I missed: When neighbour pixel is already in newColor.
        
        
        # Idea: Use the BFS to traverse the four direction and process it in FIFO fashion. Update the color of that pixel before adding to queue
        
        # Time Complexity: O(N)
        # Space Complexity: O(1) Ignoring the space taken my new image. Here I have update the input image in place.
        
        directions = [(1,0),(0,1),(-1,0),(0,-1)]
        nrows = len(image)-1
        ncols = len(image[0])-1
        queue = deque()
        queue.append((sr,sc))
        starting_pixel_color = image[sr][sc]
        image[sr][sc] = newColor
        while len(queue) > 0:
            popped_val = queue.popleft()
            curr_row,curr_col = popped_val[0],popped_val[1]
            for direction in directions:
                new_row = curr_row + direction[0]
                new_col = curr_col + direction[1]
                if new_row < 0 or new_row > nrows or new_col < 0 or new_col > ncols or image[new_row][new_col]!= starting_pixel_color or image[new_row][new_col] == newColor:
                    continue
                image[new_row][new_col] = newColor
                queue.append((new_row,new_col))
        return image
            
            
        
        
