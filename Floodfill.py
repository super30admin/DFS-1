from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])

        oldcolor = image[sr][sc]
        dirs = [[-1,0], [1,0], [0,-1], [0,1]] # U D L R
        image[sr][sc] = color
        q = Queue()
        q.put([sr, sc])
        while(not q.empty()):
            curr = q.get()
            for Dir in dirs:
                nr = Dir[0] + curr[0]
                nc = Dir[1] + curr[1]
                if nr >=0 and nr < m and nc>=0  and nc < n and image[nr][nc] == oldcolor:
                    image[nr][nc] = color
                    q.put([nr, nc])
        return image

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.oldColor = image[sr][sc]
        self.dirs = [[-1,0], [1,0], [0,-1], [0,1]] # U D L R
        self.dfs(sr, sc, image, color)
        return image

    def dfs(self, row: int, col: int, image: List[List[int]], color: int) -> None:
        # base
        if

        # logic
        image[row][col] = color
        for Dir in self.Dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            self.dfs(nr, nc, image, color)        