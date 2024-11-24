"""
TC: O(n*m) worstcase all cells are neighbors
SP: O(n*m)

"""

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_color = image[sr][sc]
        rows, cols = len(image), len(image[0])
        seen = set()
        directions = [(-1,0), (1,0), (0,1), (0, -1)]


        def dfs(r, c):
            image[r][c]=color
            seen.add((r,c))
            for dr, dc in directions:
                nr, nc = dr+r, dc+c
                if (0 <=nr < rows and 0<=nc< cols) and (nr,nc) not in seen and  image[nr][nc] == original_color:
                    dfs(nr, nc)
        dfs(sr,sc)
        return image
        