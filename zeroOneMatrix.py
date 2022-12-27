# // Time Complexity : O(MxN) for bfs and dfs , O(M^2 N^2) for bruteforce
# // Space Complexity : O(MN))
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class solution:
    ## bfs is straight forward as we start from all 0 put in the queue and we pop them out accordingly and compute the 
    ## length going outward from a cell. if the cells in 4 directions is =-1 , that is it is not processed yet then we give it a new length
    ## and we append that cell to the queue
    def bfs(self, mat):

        queue = collections.deque()
        directions= [[-1,0],[1,0],[0,1],[0,-1]]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        length = 0
        while queue:
            qsize = len(queue)
            length+=1
            for i in range(qsize):
                curr_row, curr_col = queue.popleft()
                for dir in directions:
                    new_r = curr_row+dir[0]
                    new_c = curr_col+dir[1]

                    if new_c >=0 and new_c < len(mat[0]) and new_r >=0 and new_r <len(mat) and mat[new_r][new_c] == -1:
                        mat[new_r][new_c] = length
                        queue.append([new_r,new_c])
        return mat

## dfs is a bit trickier as in this we start from every cell and perform a dfs. and every cell that we go through, we compute the minum of the 4 directions
## in this, if left and top are computed that is their values are not zero we take them as it is because they have been processed.
## but for bottom and right we dont know if they are computed or not. if they are not computed we do dfs on them but if they are computer we take them.
## in the end we return the min of these 4 +1 to the cell.
    def dfs(self, mat):
        result = [[0 for i in range(len(mat[0]))] for j in range(len(mat))]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                result[i][j] = self.helper(mat, result, i, j)
        return result
    def helper(self,mat, result, row, col):

        ##base
        if row<0 or col<0 or row>= len(mat) or col >= len(mat[0]): return 9999

        if mat[row][col] == 0: return 0

        if row > 0 and mat[row-1][col] == 0: return 1
        if col > 0 and mat[row][col-1] == 0: return 1
        if row < len(mat)-1 and mat[row+1][col] == 0: return 1
        if col < len(mat[0])-1 and mat[row][col+1] == 0: return 1

        ##logic
        top = bottom = right = left  = 9999
        if row > 0 and result[row-1][col] != 0:
            top = result[row-1][col]
        
        if col >0 and result[row][col-1] != 0:
            left = result[row][col-1]
        
        if row <len(mat)-1: 
            if result[row+1][col] == 0:
                result[row+1][col] = self.helper(mat, result, row, col)
            bottom = result[row+1][col]

        if col < len(mat[0]):
            if result[row][col+1] == 0:
                result[row][col+1] = self.helper(mat, result, row, col)
            right = result[row][col+1]

        return min(top, left, right, bottom)+1
    

    def bruteForce(self, mat):
        
        dir= [[-1,0],[1,0],[0,1],[0,-1]]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] ==1:
                    queue = collections.deque()
                    queue.add([i,j])
                    dist = 1
                    flag = False
                    while queue:
                        qsize = len(queue)
                        for i in range(qsize):
                            curr = queue.popleft()
                            for d in dir:
                                new_r = curr[0]+d[0]
                                new_c = curr[1]+d[1]

                                if new_c >=0 and new_c < len(mat[0]) and new_r >=0 and new_r <len(mat):
                                    if mat[new_r][new_c] == 0:
                                        flag = True
                                        mat[curr[0]][curr[1]] = dist+1
                                        break
                                    else:
                                        queue.append([new_r, new_c])
                                
                            if flag:
                                break
                        if flag:
                            break
                        dist+=1
        return mat
