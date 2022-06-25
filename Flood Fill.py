# time complexity is o(mn), where m,n is the number of rows and columns in the input respectively
# space complexity is o(mn), where m,n is the number of rows and columns in the input respectively
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
#         bfs
        oriclr = image[sr][sc]
        if(oriclr == color):
            return image
        m = len(image)
        n = len(image[0])
        oriclr = image[sr][sc]
        direc = [[-1, 0], [1,0], [0, 1], [0, -1]]
        from collections import deque
        q = deque()
        q.append([sr,sc])
        image[sr][sc] = color
        while(len(q) != 0):
            curr = q.popleft() 
            for d in direc:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]
                if(nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == oriclr):
                    q.append([nr, nc])
                    image[nr][nc] = color 
        return image
        
#         dfs
#         m = len(image)
#         n = len(image[0])
#         oriclr = image[sr][sc]
#         if(oriclr == color):
#             return image
#         direc = [[-1, 0], [1,0], [0, 1], [0, -1]]
#         self.dfs(image ,sr, sc, m ,n, oriclr, color, direc)
#         return image
        
#     def dfs(self, image, r, c, m, n, oriclr, color, direc):
#         #base
#         if(r < 0 or c < 0 or r == m or c == n or image[r][c] != oriclr):
#             return
#         #logic
#         image[r][c] = color
#         for d in direc:
#             nr = r + d[0]
#             nc = c + d[1]
#             if(nr >= 0 and nc >=0 and nr < m and nc < n and image[nr][nc] == oriclr):
#                 self.dfs(image, nr, nc, m, n, oriclr, color, direc)

        
        
        
        

                    
            
            