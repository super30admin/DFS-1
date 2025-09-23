class Solution(object):
    # tc : O(mn) at worst case we have all 1's and only one zero then have to process all the cells
    # sc : O(mn) start's with 1 node and then 4 of its neighbors and then 4 of each of these 4 and keep on gng and ends up mn
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # intution find the nearest 0 for 1's or rephrasing a bit find the nearest 1 for 0's and update the 1 with the distance from the 0 to 1 
        # approach : have a queue , where the current 0's index and update the 1 to -1 so that when i update the distance i can see if 1 is the cell which is already processed and -1 is the cell
        # which needs to be updated with the distance from the nearest zero 
        # check the processed cell neighbors to check if there are any -1's near that cell and with bfs update those cells also with the distance. 
        # will use the queue size to keep track of distance

        q = deque()
        dirs = [[-1,0], [1,0], [0,1], [0,-1]] # 4 directions of the neighhbors

        for i in range(len(mat)):
            for j in range(len(mat[0])): 
                if mat[i][j] == 0:
                    q.append([i,j])
                else: # mat has 0 or 1 only
                    mat[i][j] = -1

        distance = 1 # start with distance 1 
        while q:
            size = len(q)
            for neighbor in range(size):
                cell = q.popleft()
                for dir in dirs:
                    row = dir[0] + cell[0] 
                    col = dir[1] + cell[1]

                    if 0 <= row < len(mat) and 0 <= col < len(mat[0]) and mat[row][col] == -1: # if found the cell
                        mat[row][col] = distance # update it with distance
                        q.append([row,col]) # Append the current cell to process its neighbors

                
            distance +=1 # once we process one level of cells all these cells are 1+ the distance steps from the 0's 

    
        return mat







        
        

        


