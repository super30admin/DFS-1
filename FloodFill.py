# Time Complexity : O(m*n) 
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        #Assign required variables
        m = len(image)
        n = len(image[0])
        dirs = [(0,-1),(0,1),(-1,0),(1,0)]
        q = deque()
        #To check if the new color is equal to old color i.e, nothing to do
        oldcolor = image[sr][sc]
        if(oldcolor==color):
            return image
        else:
            #Append the given sr,sc element in the queue
            q.append([sr,sc])
            #Chnage the oldcolor with new color
            image[sr][sc]=color
            #Loop runs until all adjacent elements of oldcolor are changed to new
            while(len(q)>0):
                #Pop the current element from the queue
                currRow, currCol = q.popleft()
                #To check neighbors in all four directions
                for dir in dirs:
                    r = dir[0] + currRow
                    c = dir[1] + currCol
                    #If the neighbor is not out of bound and has oldcolor
                    if(r>=0 and c>=0 and r<m and c<n and image[r][c]==oldcolor):
                        #Change it to new color, add it to queue and repeat the process of checking their neighbors
                        image[r][c]=color
                        q.append([r,c])
        return image


        

        