
from queue import Queue

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        q = Queue()
        q.put((sr,sc))
        dirs = [(-1,0),(1,0),(0,1),(0,-1)]
        startcolor = image[sr][sc]
        image[sr][sc] = newColor
        if startcolor == newColor:
            return image
        while(q.empty() != True):
            r,c = q.get()
            for k in dirs:
                row = r + k[0]
                col = c + k[1]
                if((row>=0 and row<len(image)) and (col>=0 and col<len(image[0])) and (image[row][col]==startcolor)):
                    image[row][col] = newColor
                    q.put((row,col))
        return image
