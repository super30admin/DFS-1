from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # define row
        row = len(mat)
   
        col = len(mat[0])
        
        queue = deque()
        
        for i in range(row):
            for j in range(col):
                if mat[i][j] == 0:
                    queue.append((i, j))
                    
        visited = set()
       
        visited.update(queue)
        count = 0
        
        # BFS
        while queue:
            
            for _ in range(len(queue)):
                x, y = queue.popleft()
                
                
                for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    xx, yy = x + dx, y + dy

                    # skip the out border case
                    if xx < 0 or xx == row or yy < 0 or yy == col:
                        continue

                    # skip the visited position coordinate
                    if (xx, yy) in visited:
                        continue

                   
                    queue.append((xx, yy))

                    # we put the coordinate of the neighbor into the visited set
                    visited.add((xx, yy))
                
              
                if mat[x][y] == 0:
                    mat[x][y] = 0
                else:
                    mat[x][y] = mat[x][y] + count - 1
            
            # when each level traversal finishes, we count + 1
            count += 1
            
        return mat