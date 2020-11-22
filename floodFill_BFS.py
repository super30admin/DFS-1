#Leetcode(733) : Successful

class Solution:
    def floodFill(self, image, sr, sc, newColor):
        #base case
        if image == None or len(image) == 0:
            return None
        #return if the source is equal to newColor
        if image[sr][sc] == newColor:
            return image
        visited = [([False]*len(image[0]))]*len(image)
        queue = []
        color = image[sr][sc]
        #push indices of the source
        queue.append([sr,sc])
        #mark visited True
        #keep a visited array so that we don't visit the cell repeatedly
        visited[sr][sc]=True
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]

        while len(queue) != 0:
            #pop from queue
            curr = queue.pop(0)
            #set the popped cell to newColor
            image[curr[0]][curr[1]] = newColor
            #traverse to the neighbours of the source/popped cell
            for dir in dirs:
                i = curr[0]+ dir[0]
                j = curr[1]+ dir[1]
                #edge case
                #check for array index bound error and if neighbours color == source color
                if(i>=0 and i<len(image) and j>=0 and j<len(image[0]) and image[i][j] == color and not(visited[i][j])):
                    #append to queue
                    queue.append([i,j])
                    #mark as visited
                    visited[i][j] = True
        return image
obj = Solution()
print(obj.floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2))
