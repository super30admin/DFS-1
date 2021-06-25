from typing import List

# BFS Solution
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or len(image[0]) == 0 or image[sr][sc] == newColor:
            return image
        color = image[sr][sc]
        queue = []
        queue.append(sr)
        queue.append(sc)
        image[sr][sc] = newColor
        m = len(image)
        n = len(image[0])
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        while len(queue) != 0:
            r = queue.pop(0)
            c = queue.pop(0)
            for dir in dirs:
                nr = r + dir[0]
                nc = c + dir[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == color:
                    queue.append(nr)
                    queue.append(nc)
                    image[nr][nc] = newColor
        return image

# DFS Solution
# class Solution:
#     def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
#         if image == None or len(image) == 0 or len(image[0]) == 0 or image[sr][sc] == newColor:
#             return image
#         self.color = image[sr][sc]
#         self.m = len(image)
#         self.n = len(image[0])
#         self.dirs = [[1,0], [-1,0], [0,1], [0,-1]]
#         self.dfs(image, sr, sc, newColor) 
#         return image
    
#     def dfs(self, image: List[List[int]], r: int, c: int, newColor: int) -> None:
#         if r < 0 or c < 0 or r == self.m or c == self.n or image[r][c] != self.color:
#             return
        
#         image[r][c] = newColor
#         for dir in self.dirs:
#             nr = r + dir[0]
#             nc = c + dir[1]
#             self.dfs(image, nr, nc, newColor)

obj = Solution()
print(obj.floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2))
print(obj.floodFill([[0,0,0],[0,0,0]],0,0,2))

# Time Complexity : O( m * n) where m = rows and n = columns
# Space Complexity : O( m * n) where m = rows and n = columns