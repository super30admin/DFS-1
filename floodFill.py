class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        copy_image = image
        row = len(image) - 1 
        col = len(image[0]) - 1 
        visited = set()
        direction = [(-1, 0) , (1, 0), (0, -1), (0, 1)]
        color = image[sr][sc]
        def dfs( sr , sc   ):
            if (sr, sc) in visited:
                return False
            visited.add( (sr, sc) )
            for i , j in direction:
                if 0 <= sr+i <= row and 0 <= sc+j <= col and image[sr+i][sc+j] == color:
                    image[sr+i][sc+j] = newColor
                    newSR = sr + i
                    newSC = sc + j 
                    dfs( newSR, newSC )
        image[sr][sc] = newColor 
        dfs( sr, sc  )
        return image
    
