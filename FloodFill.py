# Time Complexity : O(m*n)
# Space Complexity :O(m*n)

# DFS Approach

class Solution:
    def __init__(self):
        self.m = None
        self.n = None
        self.color = None

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        self.color = image[sr][sc]
        self.m = len(image)
        self.n = len(image[0])
        self.dfs(image, sr, sc, newColor)
        return image

    def dfs(self, image, r, c, newColor):
        if r < 0 or c < 0 or r == self.m or c == self.n or image[r][c] != self.color:
            return
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        image[r][c] = newColor
        for d in dirs:
            nr = r + d[0]
            nc = c + d[1]
            self.dfs(image, nr, nc, newColor)

# BFS Approach

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        color = image[sr][sc]
        m = len(image)
        n = len(image[0])
        q = deque()
        q.append(sr)
        q.append(sc)
        image[sr][sc] = newColor
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        while q:
            r = q.popleft()
            c = q.popleft()
            for d in dirs:
                nr = d[0] + r
                nc = d[1] + c
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == color:
                    image[nr][nc] = newColor
                    q.append(nr)
                    q.append(nc)

        return image