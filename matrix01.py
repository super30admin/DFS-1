// Time Complexity : O(r.c)
// Space Complexity : O(r.c)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
            viewed = set()
            q = deque([])
            matrix2 = matrix[:]
            for i in range(len(matrix)):
                for j in range(len(matrix[0])):
                    if matrix[i][j] == 0:
                        q.append(((i,j),0))
                        matrix2[i][j] = 0
                        viewed.add((i,j))
            while q:
                m = q.popleft()
                for x,y in [[m[0][0]+1,m[0][1]],[m[0][0]-1,m[0][1]],[m[0][0],m[0][1]+1],[m[0][0],m[0][1]-1]]:
                    if 0<=x<len(matrix) and 0<=y<len(matrix[0]) and (x,y) not in viewed:
                        matrix2[x][y] = m[1]+1
                        viewed.add((x,y))
                        q.append(((x,y),m[1]+1))
            return matrix2