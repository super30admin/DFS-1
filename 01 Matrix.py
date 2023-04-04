# Time Complexity :  O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = []
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    queue.append((i,j))
                else:
                    mat[i][j] = -1
        dist = 1
        while(len(queue) > 0):
            size = len(queue)
            for i in range(size):
                (p,q) = queue.pop(0)

                if p > 0 and mat[p-1][q] == -1:
                    queue.append((p-1,q))
                    mat[p-1][q] = dist

                if p < len(mat)-1 and mat[p+1][q] == -1:
                    queue.append((p+1,q))
                    mat[p+1][q] = dist

                if q > 0 and mat[p][q-1] == -1:
                    queue.append((p,q-1))
                    mat[p][q-1] = dist
                
                if q < len(mat[0])-1 and mat[p][q+1] == -1:
                    queue.append((p,q+1))
                    mat[p][q+1] = dist
                
            dist += 1
        return mat
                
