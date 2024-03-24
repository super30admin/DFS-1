#Time Complexity : O(m*n)
#Space Complexity : O(m*n)
#Any problem you faced while coding this : -

#The approach is a standard level-order traversal using a queue. Initially, we are adjusting the value 1 cell by initializing it to -1 in order to set the premise for further distance logic and adding the value 0 elements to the queue for processing.  At each level, we are adding the distance value to the 0-neighboring cells at that level.
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])

        dirs = [[0,1],[1,0],[-1,0],[0,-1]]

        q = collections.deque()

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append([i,j])
                else:
                    matrix[i][j] = -1

        dist = 1
        while len(q)!=0 :
            size = len(q)

            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]

                    if nr >= 0 and nc >= 0 and nr < m and nc < n and matrix[nr][nc] == -1:
                        matrix[nr][nc] = dist
                        q.append([nr,nc])

            dist += 1

        return matrix