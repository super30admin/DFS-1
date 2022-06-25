
# // Time Complexity : O(M*N)
# // Space Complexity : O(M*N)
class Solution:
    def floodFillBFS(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image:
            return [[]]
        rows = len(image)
        cols = len(image[0])
        originalColor = image[sr][sc]
        if originalColor == color:
            return image
        queue = collections.deque([(sr, sc)])

        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]

        while queue:
            curr = queue.popleft()
            image[curr[0]][curr[1]] = color
            for r, c in directions:
                nr = curr[0] + r
                nc = curr[1] + c
                if 0 <= nr < rows and 0 <= nc < cols and image[nr][nc] == originalColor:
                    queue.append((nr, nc))
        return image

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image:
            return [[]]
        if image[sr][sc] == color:
            return image
        originalColor = image[sr][sc]
        directions = [(0,1),(0,-1),(1,0),(-1,0)]
        self.dfs(image, directions,len(image),len(image[0]), sr,sc, originalColor,color)
        return image
    def dfs(self,image, directions,r,c,i,j,originalColor, color):
        if 0> i or  i == r or 0>j or j == c or image[i][j] != originalColor:
            return
        image[i][j] = color
        for x,y in directions:
            nx = x+i
            ny = y+j
            self.dfs(image, directions,r,c,nx,ny,originalColor,color)
        return image