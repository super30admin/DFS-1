'''
DFS-1

Problem1 (https://leetcode.com/problems/flood-fill/)
'''

from queue import Queue

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]: # type: ignore
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image

        m = len(image)
        n = len(image[0])
        oldColor = image[sr][sc]
        dirs = [[-1,0], [0,-1], [1,0], [0,1]] 
        rows = Queue()
        cols = Queue()
        rows.put(sr)
        cols.put(sc)
        image[sr][sc] = color
        while not rows.empty():
            cr = rows.get()
            cc = cols.get()
            for Dir in dirs:
                nr = cr + Dir[0]
                nc = cc + Dir[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == oldColor:
                    rows.put(nr)
                    cols.put(nc)
                    image[nr][nc] = color
        return image                