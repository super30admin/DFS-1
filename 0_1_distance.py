# Time Complexity :
# O(M*N)

# Space Complexity :
# O(M*N)

# Did this code successfully run on Leetcode :
#Yes

#We first go through the matrix, then we add all 0 elements to the queue. We change all 1s to -1.
#Then we start processing the queue - pop an element, go over all it's valid neighbours and update their distance as curr_val of a location (which represents the distance from a 0) as 1+ element's distance
#We do this until all the elements have been processed

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        self.visited = [[0 for j in range(len(mat[0]))] for i in range(len(mat))]
        self.queue = []
        for i in range(0,len(mat)):
            for j in range(0,len(mat[0])):
                if mat[i][j] != 0:
                    #self.dfs(mat,i,j,0)
                    mat[i][j] = -1
                if mat[i][j] == 0 :
                    self.queue.append((i,j))

        neighbours = [(1,0),(-1,0),(0,1),(0,-1)]

        while (len(self.queue) != 0 ):
            curr_elem = self.queue.pop(0)
            cr = curr_elem[0]
            cc = curr_elem[1]
            for neighbour in neighbours:
                x = cr + neighbour[0]
                y = cc + neighbour[1]
                if self.is_valid_coord(x,y,len(mat),len(mat[0])) :
                    #mat[x][y] = min(mat[cr][cc] + 1,mat[x][y])
                    if mat[x][y] == -1 :
                        mat[x][y] = mat[cr][cc] + 1
                        self.queue.append((x,y))
        return mat

    def is_valid_coord(self,x,y,size_x,size_y):
        if x < 0 or x >= size_x :
            return False
        if y < 0 or y >= size_y :
            return False
        return True
