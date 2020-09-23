# Time Complexity : O(n * m)
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        dirs=((0,-1),(-1,0),(1,0),(0,1))
        
        queue = deque([])
        visited = set()
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                    visited.add((i,j))
        
        while queue:
            x,y = queue.popleft()
            
            for r_x,r_y in dirs:
                    r = x + r_x
                    c = y + r_y
                    if r>=0 and r<len(matrix) and c>=0 and c<len(matrix[0]) and matrix[r][c] != 0 and (r,c) not in visited:
                        queue.append((r,c))
                        visited.add((r,c))
                        matrix[r][c] = matrix[x][y] + 1
        
        return matrix