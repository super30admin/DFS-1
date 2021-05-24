# TC: O(M x N) where M is the number of rows of the image and N is the number of columns.
# SC: O(M x N) since for every Mth node, we will be processing N nodes.

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or len(image) == 0 or len(image[0]) == 0 or image[sr][sc] == newColor:
            return image
        
        rows = len(image)
        cols = len(image[0])
        queue = collections.deque()
        color = image[sr][sc]
        queue.append((sr,sc))
        image[sr][sc] = newColor
        while queue:
            curr_x, curr_y = queue.popleft()
            dirs = [(0,1),(0,-1),(1,0),(-1,0)]
            for x, y in dirs:
                new_x = curr_x + x
                new_y = curr_y + y
                if new_x >= 0 and new_x < rows and new_y >= 0 and new_y < cols and image[new_x][new_y] == color:
                    image[new_x][new_y] = newColor
                    queue.append((new_x, new_y))
        
        return image
