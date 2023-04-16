# TC: O(n) where n is the number of pixels in image
# SC: O(n) where n is the number of pixels. Queue and visted both require n space.

from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0:
            return None

        old_color = image[sr][sc]
        q = Queue()
        q.put([sr,sc])
        visited = set([(sr, sc)])

        while not q.empty():
            x, y = q.get()
            if 0 <= x < len(image) and 0 <= y < len(image[0]) and image[x][y] == old_color:
                image[x][y] = color
                for new_x, new_y in [(-1,0), (0,-1), (0,1), (1,0)]:
                    nr = x + new_x
                    nc = y + new_y
                    if (nr, nc) not in visited:
                        q.put([nr,nc])
                        visited.add((nr,nc))

        return image