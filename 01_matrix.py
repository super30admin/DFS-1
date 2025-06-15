from collections import deque
class BFSSolution:
    ## BFS solution - queue & iterative
    def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
        """
        TC: O(m*n)
        AS: O(m*n)
        """

        rows = len(mat)
        columns = len(mat[0])
        dirs = [(0,-1), (0,1), (-1,0), (1,0)]

        queue = deque()

        for i in range(rows):
            for j in range(columns):
                # Convert original 1's to -1's (to avoid confusion between original 1's and dist 1's) 
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    # all 0's to add to queue
                    queue.append((i, j))
        
        dist = 1
        # BFS on each 
        while queue:
            # take size variable because we have to increase distance after each level
            size = len(queue)

            # process all nodes of the level
            for s in range(size):
                r, c = queue.popleft()

                for dr, dc in dirs:
                    nr = r + dr
                    nc = c + dc

                    # bound check ; and the original 1's offset value >> add to queue
                    if 0 <= nr < rows and 0 <= nc < columns and mat[nr][nc] == -1:
                        queue.append((nr, nc))
                        mat[nr][nc] = dist

            # increase dist after level is completed
            dist += 1
        return mat
            
