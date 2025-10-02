# Space Complexity : O(m*n)
# Time Complexity: O(m*n)


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        org = image[sr][sc]

        dirs = [(-1,0), (0,-1), (1,0), (0,1)]
        def dfs(i,j):
            if i < 0 or j < 0 or i >= len(image) or j >= len(image[0]) or image[i][j] != org:
                return 
            if color == org: 
                return
            image[i][j] = color
            for dx, dy in dirs: 
                nx = i + dx
                ny = j + dy
                dfs(nx,ny)  
        dfs(sr,sc)

        return image


                        
