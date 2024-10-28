# Approach
# find all the 0 and add to the queue and then the children with value are diatance 1 and then update the length and then ter children are at distance +1


#Complexities
# Time : O(N*M)
#Space: O(N)


from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = []

        rows = len(mat)
        columns = len(mat[0])
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(rows):
            for j in range(columns):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    mat[i][j]=-1

        length = 1
        while queue:
            size = len(queue)
            for _ in range(size):
                (i, j) = queue.pop(0)
                for [ri, rj] in directions:
                    nr, nc = i + ri, j + rj
                    if nr >= 0 and nr < rows and nc >= 0 and nc < columns and mat[nr][nc]==-1:
                            queue.append((nr, nc))
                            mat[nr][nc] = length
            length += 1
        return mat

