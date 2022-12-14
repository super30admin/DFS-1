class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        ## DFS Solution
        ## T.C = O(m.n)
        ## S.C = O(m.n)
    
        if image[sr][sc] == color:
            return image
        
        oc = image[sr][sc]
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        ROWS, COLS = len(image), len(image[0])
        image[sr][sc] = color

        def dfs(image, sr, sc, color, oc, dirs, ROWS, COLS):

            image[sr][sc] = color
            for i, j in dirs:
                if sr+i in range(ROWS) and sc+j in range(COLS) and image[sr+i][sc+j] == oc:
                    dfs(image, sr+i, sc+j, color, oc, dirs, ROWS, COLS)

        dfs(image, sr, sc, color, oc, dirs, ROWS, COLS)
        return image
        ###################################################################
        
        ## BFS Solution
        ## T.C = O(m.n)
        ## S.C = O(m.n)

        if image[sr][sc] == color:
            return image

        oc = image[sr][sc]
        queue = [[sr, sc]]
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        ROWS, COLS = len(image), len(image[0])
        image[sr][sc] = color


        while queue:
            x, y = queue.pop(0)

            for i, j in dirs:
                p, q = x+i, y+j
                if p in range(ROWS) and q in range(COLS) and image[p][q] == oc:
                    image[p][q] = color
                    queue.append([p,q])

           
        return image