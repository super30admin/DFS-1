# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return matrix
        q = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append((i,j))
                elif matrix[i][j] == 1:
                    matrix[i][j] = -1
        
        nei = [(0,1), (1,0), (-1,0), (0,-1)]
        while len(q) != 0:
            curr = q.popleft()

            for n in nei:
                r = n[0] + curr[0]
                c = n[1] + curr[1]

                if r < len(matrix) and r >= 0 and c >= 0 and c < len(matrix[0]) and matrix[r][c] == -1:
                    matrix[r][c] = matrix[curr[0]][curr[1]]+1
                    q.append((r,c))

        return matrix