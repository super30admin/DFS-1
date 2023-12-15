class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        row = len(image)
        col = len(image[0])


        currcolor = image[sr][sc]
        if currcolor == color:
            return image

        def dfs(r,c):

            if image[r][c]==currcolor:
                image[r][c] = color
                if r>=1:
                    dfs(r-1,c)
                if r<row-1:
                    dfs(r+1,c)
                if c>=1:
                    dfs(r,c-1)
                if c<col-1:
                    dfs(r,c+1)

        dfs(sr,sc)
        return image