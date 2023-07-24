# Time Complexity : O(mn)
# Space Complexity :O(mn)
# Passed on Leetcode: yes

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        import queue

        m = len(mat)
        n = len(mat[0])
        q = queue.Queue()
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.put([i, j])
                else:
                    mat[i][j] = -1


        level = 1
        while not q.empty():
            for i in range(q.qsize()):
                
                r, c = q.get()
                for idx in dirs:
                    if (r+idx[0] >= 0 and r+idx[0] < m) and \
                    (c+idx[1] >= 0 and c+idx[1] < n) and \
                    (mat[r+idx[0]][c+idx[1]] == -1):
                        mat[r+idx[0]][c+idx[1]] = level
                        q.put([r+idx[0], c+idx[1]])
            level += 1
                        

        return mat



