# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we add all the zeroes in a queue(since 0s are independent)
# we start iterating from the queue
# all the neighboring elements to the zero need to be incrememented by 1 from the current cell
# if the neighboring element has not been visited
# each cell would be the minimum distance from the nearest 0
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = list()
        row_l = len(mat)
        col_l = len(mat[0])
        ones = 0
        for i in range(row_l):
            for j in range(col_l):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
                    ones +=1 #optimization
        # level = 0
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        while len(queue)!=0: # and ones!=0:
            # size = len(queue)
            # level+=1
            # for i in range(size):
            curr = queue.pop(0)
            row = curr[0]
            col = curr[1]
            for dir in dirs:
                nr = row + dir[0]
                nc = col + dir[1]
                if (nr>=0 and nr<row_l) and (nc>=0 and nc<col_l):
                    if mat[nr][nc]==-1:
                        ones-=1 #optimization
                        # mat[nr][nc]=level
                        #this will mean if we currently are at level 0
                        # nr nc will be at next level
                        mat[nr][nc] = mat[row][col] + 1
                        if ones==0:
                            return mat
                        queue.append([nr,nc])
        return mat


    # def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
    #     queue = list()
    #     row_l = len(mat)
    #     col_l = len(mat[0])
    #     ones = 0
    #     for i in range(row_l):
    #         for j in range(col_l):
    #             if mat[i][j]==0:
    #                 queue.append([i,j])
    #             else:
    #                 mat[i][j] = -1
    #                 ones +=1 #optimization
    #     level = 0
    #     dirs = [[-1,0],[1,0],[0,-1],[0,1]]
    #     while len(queue)!=0: # and ones!=0:
    #         size = len(queue)
    #         level+=1
    #         for i in range(size):
    #             curr = queue.pop(0)
    #             row = curr[0]
    #             col = curr[1]
    #             for dir in dirs:
    #                 nr = row + dir[0]
    #                 nc = col + dir[1]
    #                 if (nr>=0 and nr<row_l) and (nc>=0 and nc<col_l):
    #                     if mat[nr][nc]==-1:
    #                         ones-=1 #optimization
    #                         mat[nr][nc]=level
    #                         if ones==0:
    #                             return mat
    #                         queue.append([nr,nc])
    #     return mat