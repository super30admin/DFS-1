#Time Complexity : O(mn)
#Space Complexity : O(mn) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat) == 0:
            return mat
        q = deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        while q:
            curr = q.popleft()
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if r>=0 and r<len(mat) and c>=0 and c<len(mat[0]) and mat[r][c]== -1:
                    q.append([r, c])
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
        return mat