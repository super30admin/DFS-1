from queue import Queue

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        # BFS
        if color == image[sr][sc]:
            return image
        
        m = len(image)
        n = len(image[0])
        q = Queue()
        q.put((sr, sc))
        sameColor = image[sr][sc]
        image[sr][sc] = color
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] #UpDownLeftRight
        
        while not q.empty():
            curr = q.get()
            for dir in directions:
                nr = curr[0] + dir[0]
                nc = curr[1] + dir[1]
                if nr >=0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == sameColor:
                    image[nr][nc] = color
                    q.put((nr, nc))
                    
        return image
             
        # DFS
        if color == image[sr][sc]:
            return image

        self.m = len(image)
        self.n = len(image[0])
        self.sameColor = image[sr][sc]
        self.directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] #UpDownLeftRight
        
        def dfs(r, c):
            if r >=0 and r < self.m and c >= 0 and c < self.n and image[r][c] == self.sameColor:
                image[r][c] = color
            else:
                # To stop the recursion for coordinates which are out of bounds
                return
            
            for dir in self.directions:
                dfs(r + dir[0], c + dir[1])
            
        dfs(sr, sc)
        return image       
