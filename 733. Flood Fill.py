#USING BFS
# TC O(m*n) and SC O(m*n)
from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])
        dirs = [[-1,0],[1,0],[0,-1],[0,1]] #U D L R
        rowq = Queue()
        colq = Queue()
        oldcolor = image[sr][sc]
        rowq.put(sr)
        colq.put(sc)
        image[sr][sc] = color
        while not rowq.empty():
            cr = rowq.get()
            cc = colq.get()
            for dir in dirs:
                nr = cr + dir[0]
                nc = cc + dir[1]
                if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == oldcolor:
                    image[nr][nc] = color
                    rowq.put(nr)
                    colq.put(nc)
        return image




#USING DFS
# TC O(m*n) and SC O(m*n)
from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]] #U D L R
        self.oldcolor = image[sr][sc]
        self.dfs(image, sr, sc, color)
        return image

    def dfs(self, image: List[List[int]], row: int, col: int, color: int) -> None:
        if row < 0 or row == self.m or col < 0 or col == self.n or image[row][col] != self.oldcolor:
            return

        image[row][col] = color
        for Dir in self.dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            self.dfs(image,nr,nc,color)


        

        
        


        

        


        
        