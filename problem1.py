'''
733. Flood Fill

APPROACH 1: BFS
TIME COMPLEXITY: M*N
SPACE COMPLEXITY: min(m, n)
LEETCODE: Yes
DIFFICULTIES: Nope, after the class

APPROACH 2: DFS
TIME COMPLEXITY: M*N
SPACE COMPLEXITY: M*N
LEETCODE: Yes
DIFFICULTIES: Nope, after the class

'''
from collections import deque
class Solution:
    def floodFill(self, pre_image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        global image, dirs
        image = pre_image
        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        
        # BFS
        def approach1(sr, sc, color):
            q = deque()
            q.append((sr, sc))
            m = len(image)
            n = len(image[0])
            
            fc = image[sr][sc]
            image[sr][sc] = color
            
            while len(q) != 0:
                sz = len(q)
                for l in range(0, sz):
                    i, j = q.popleft()
                    
                    for dirr, dirc in dirs:
                        nr = dirr + i
                        nc = dirc + j
                        
                        if nr >=0 and nr < m and nc >=0 and nc < n and image[nr][nc] == fc and image[nr][nc] != color:
                            image[nr][nc] = color
                            q.append((nr, nc))
        
        # DFS
        def approach2(sr, sc, ncolor):
            global fc, color
            color = ncolor
            fc = image[sr][sc]
            m = len(image)
            n = len(image[0])
            
            def dfs(r, c):
                global fc
                # base
                if r<0 or r>=m or c<0 or c>=n:
                    return
                if image[r][c] != fc or image[r][c] == color:
                    return
                
                # logic
                image[r][c] = color
                for dirr, dirc in dirs:
                    nr = dirr + r
                    nc = dirc + c
                    dfs(nr, nc)
                
            dfs(sr, sc)
            
            
        # approach2(sr, sc, color)
        approach1(sr, sc, color)
        
        return image
        
