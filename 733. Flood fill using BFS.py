# Using BFS
# Time and Space Complexity = O(mxn)
from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0:
            return image
        orig = image[sr][sc]
        if orig == color:
            return image
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        q= Queue()
        q.put([sr,sc])
        image[sr][sc] = color
        while not q.empty():
            curr = q.get()
            for dir in dirs:
                nr = curr[0]+dir[0]
                nc = curr[1]+dir[1]
                if(nr>=0 and nc >=0 and nr<len(image) and nc <len(image[0]) and image[nr][nc] == orig):
                    q.put([nr,nc])
                    image[nr][nc] = color
        return image
        