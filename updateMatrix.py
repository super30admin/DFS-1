# Time Complexity : Brute Force: O(r.c)^2 | Optimized: O(r.c)
# Space Complexity :: Brute Force O(1) | Optimized: O(r.c)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Thinking the optimized solution


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                dist = float('inf')
                if matrix[i][j] == 1:
                    for k in range(len(matrix)):
                        for l in range(len(matrix[0])):
                            if matrix[k][l] == 0:
                                dist = min(dist, (abs(i-k)) + abs(j-l))
                                matrix[i][j] = dist
        return matrix

class Solution:
    def updateMatrixTwo(self, matrix: List[List[int]]) -> List[List[int]]:
        q = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.insert(0, (i,j))
                else:
                    matrix[i][j] = float('inf')
        directs = [(0,-1),(0,1),(-1,0),(1,0)]          
        while q:
            curr = q.pop()
            for direct in directs:
                r = curr[0] + direct[0]
                c = curr[1] + direct[1]
                if r >= 0 and c >= 0 and r < len(matrix) and c < len(matrix[0]) and matrix[r][c] > matrix[curr[0]][curr[1]] + 1:
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
                    q.insert(0,(r,c))
        return matrix
                                