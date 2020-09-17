# 542. 01 Matrix

# Code:

# Approach: Created an array of same length as given matrix with all inf values.
# Iterated over the given matrix, updated the newMatrix with 0 whereever we can see a 0 in the given matrix
# Then added the places where 0 is present in the queue and perform BFS in all 4 directions



class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        q= collections.deque()
        
        res = [[float('inf') for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    res[i][j] = 0
                    q.append((i,j))
        
        while q:
            r,c = q.popleft()
            for i in range(4):
                nr = r+dirs[i][0]
                nc = c+dirs[i][1]
                
                if nr<0 or nc<0 or nr>=len(matrix) or nc>=len(matrix[0]):
                    continue
                
                if res[nr][nc]==float('inf'):
                    res[nr][nc] = res[r][c]+1
                    q.append((nr,nc))
        return res

# Time Complexity: O(n*m)
# Space Complexity: O(n*m)
# Accepted on Leetcode: Yes
                        
                    