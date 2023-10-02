# Time Complexity: O(mn) where m and n is the size of the matrix
# Space Complexity:  O(mn)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None:
            return mat
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        q = deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        count = 0
        while(len(q) > 0):
            count += 1
            size = len(q)
            for _ in range(size):
                cell = q.popleft()

                for i, j in self.dirs:
                    r = i + cell[0]
                    c = j + cell[1]
                    if r >=0 and r < len(mat) and c >=0 and c < len(mat[0]) and mat[r][c] == -1:
                        mat[r][c] = count
                        q.append([r,c])
        return mat
