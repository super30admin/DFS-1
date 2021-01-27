# Time Complexity:O(mn) (where m:rows,n:columns)
# Space Complexity:O(mn) (where m:rows,n:columns)
# Did this code successfully run on LeetCode?:Yes
# Problems faced while coding this:None
# Approach: We have to find nearest distance : BFS approach


from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if matrix is None or len(matrix) == 0:
            return matrix
        
        row = len(matrix)
        col = len(matrix[0])
        
        q = deque()
        
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 0:
                    q.append((i,j))
                    
                else:
                    matrix[i][j] = -1
                    
        distance = 1
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]

        while q:
            size = len(q)
            
            for i in range(size):
                
                r, c = q.popleft()
                for dir in dirs:
                    cr = r + dir[0]
                    cc = c + dir[1]
                    
                    if cr >= 0 and cr < row and cc >= 0 and cc < col and matrix[cr][cc] == -1:
                        q.append((cr, cc))
                        matrix[cr][cc] = distance
                        
            distance += 1
                
        return matrix