# problem 2 

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        my_dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        my_queue = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    my_queue.append([i,j])
                else:
                    mat[i][j] *= -1
        dist = 1 
        while(my_queue):
            size = len(my_queue)
            for _ in range(size):
                curr_val = my_queue.popleft()
                for my_dir in my_dirs:
                    r  = my_dir[0]+curr_val[0]
                    c = my_dir[1]+curr_val[1]
                    if r >= 0 and c >= 0 and r<m and c <n and mat[r][c] == -1:
                        mat[r][c] = dist
                        my_queue.append([r,c])
            dist+=1
        return mat
    