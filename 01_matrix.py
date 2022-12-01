class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        ## BFS Solution
        ## T.C = O(m.n)
        ## S.C = O(m.n)
        
        ROWS, COLS = len(mat), len(mat[0])
        queue = []
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        
        for i in range(ROWS):
            for j in range(COLS):
                if mat[i][j] == 1:
                    mat[i][j] *= -1
                if mat[i][j] == 0:
                    queue.append([i,j])
        lvl = 0
        
        while queue:
             
            lvl += 1
            for i in range(len(queue)):
                x, y = queue.pop(0)
                for p, q in dirs:
                    if x+p in range(ROWS) and y+q in range(COLS) and mat[x+p][y+q] == -1:
                        mat[x+p][y+q] = lvl
                        queue.append([x+p, y+q])
        
        return mat