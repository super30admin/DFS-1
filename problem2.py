#0-1 matrix

# // Time Complexity :O(N*M) - Going though every grids
# // Space Complexity : O(N*M) worst casae could be all the grids with 0 value
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def updateMatrix( mat):
    if mat==None: return mat
    queue=[]                                                                #using BFS
    directions = [[1,0],[0,1],[-1,0],[0,-1]]
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if(mat[i][j]==0):                                           #add all the grid with 0 to the queue
                queue.append((i,j))
            if (mat[i][j]==1):                                          #change all the 1 values to -1, so we know those arent visited yet
                mat[i][j]=-1
                
    while(queue):
        grid = queue.pop(0)
        for i in directions:
            r = grid[0]+i[0]
            c = grid[1]+i[1]
            if( r>=0 and c>=0 and r<len(mat) and c<len(mat[0]) and mat[r][c]==-1 ):             #for all the values that are visited, check if their neighbors are -1, if they are change their values to the currrent value +1
                mat[r][c]=(mat[grid[0]][grid[1]])+1
                queue.append((r,c))                                                             #add the visited grid to the queue
    return mat


