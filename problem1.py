# time: O(m*n)
# space: O(m*n) size of stack
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        row, col = len(image), len(image[0])
        srcColor = image[sr][sc]

        def dfs(r,c):
            if r<0 or r>=row or c<0 or c>=col or image[r][c]!=srcColor:
                return

            image[r][c]=color
            
            dfs(r+1, c)
            dfs(r,c+1)
            dfs(r-1, c)
            dfs(r, c-1)

        if srcColor == color:
            return image

        dfs(sr,sc)
        return image
        