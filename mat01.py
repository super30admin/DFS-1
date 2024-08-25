# time: O(n)
# space: O(n)
class Solution(object):
    def updateMatrix(self, mat):
        q = []
        dirs = [[-1,0],[0,-1],[0,1],[1,0]]
        # first lets make push all 0 indices to q and make 1 as -1
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        
        dist = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                r, c = curr[0], curr[1]
                for d in dirs:
                    rn, cn = d[0] + r, d[1] + c
                    if rn >=0 and rn < len(mat) and cn >= 0 and cn < len(mat[0]) and mat[rn][cn] == -1:
                        mat[rn][cn] = dist + 1
                        q.append([rn, cn])

            dist += 1
        return mat