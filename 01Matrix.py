#Time Complexity : O(mn)^2 where m is is number of columns and n is number of rows
#Space Complexity :  O(mn) where m is is number of columns and n is number of rows

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Iterate through the 2D array and if we come across a 1 then perform BFS from that one going in all 4 directions, finding the closest 0 and updating that distance in the output matrix.


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        output = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]

        dirs = [(0,1), (1,0), (-1,0), (0,-1)]
        def bfs(matrix, r, c):
            q = deque([[(r,c), 0]])
            visited = set()

            level = 0
            while q:
                size = len(q)
                for _ in range(size):
                    coords, l = q.popleft()
                    r, c = coords[0], coords[1]
                    visited.add((r,c))
                    if matrix[r][c] == 0:
                        return l
                    for x, y in dirs:
                        newX, newY = x+r, y+c
                        if newX >= 0 and newX < len(matrix) and newY >= 0 and newY < len(matrix[0]) and (newX, newY) not in visited:
                            q.append([(newX, newY), l+1])

            return -1

        for r in range(len(matrix)):
            for c in range(len(matrix[0])):
                if matrix[r][c] == 1:
                    lev = bfs(matrix, r, c)
                    output[r][c] = lev
        return output
