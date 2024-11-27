"Time Complexity is O(N)"
"Space Complexity is O(N)"

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])

        oldcolor = image[sr][sc]

        if oldcolor == color:
            return image

        direction_array = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(r, c):
            if (r>=0 and c>=0 and r<m and c<n and image[r][c]==oldcolor):
                image[r][c] = color

                for dx, dy in direction_array:
                    nr = r + dx
                    nc = c + dy

                    dfs(nr, nc)
        
        dfs(sr, sc)
        return image


