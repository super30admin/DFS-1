#Time complexity:O(mn)
#Space Complexity:O(mn)

#BFS approach

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image)==0 or image[sr][sc]==newColor:                       # if the image is empty or the new color is same as old return image
            return image
        m=len(image)                                                        #Obtain number of rows
        n=len(image[0])                                                     #obtain number of columns
        color=image[sr][sc]                                                 #obtain the original color
        image[sr][sc]=newColor                                              #assign new color to the given index
        d=deque()                                                           #create a queue
        d.append(sr)                                                        #append the index of curerent change to the queue
        d.append(sc)
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]                                    #initialize the 4 directions
        while d:                                                            #if the deque is not empty
            cr=d.popleft()                                                  #obtain row
            cc=d.popleft()                                                  #obtain column
            for dr in dirs:                                                 #for all four positions around the current position
                r=cr+dr[0]                                                  #calculate the row and column index
                c=cc+dr[1]
                if(0<=r<m and 0<=c<n and image[r][c]==color):               #if the index position is within the image and the value is same as old colour
                    image[r][c]=newColor                                    #change the value to new color
                    d.append(r)                                             #add the cyurrent row and column to the queue
                    d.append(c)
        return image                                                        #return the final image


#DFS approach
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image)==0 or image[sr][sc]==newColor:                        # if the image is empty or the new color is same as old return image
            return image
        m=len(image)                                                        #Obtain number of rows
        n=len(image[0])                                                     #obtain number of columns
        color=image[sr][sc]                                                 #obtain the original color
        image[sr][sc]=newColor                                              #assign new color to the given index
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]                                    #initialize the 4 directions
        for dr in dirs:                                                     #for all four positions around the current position
            r=sr+dr[0]                                                      #calculate the row and column index
            c=sc+dr[1]
            if(0<=r<m and 0<=c<n and image[r][c]==color):                   #if the index position is within the image and the value is same as old colour
                self.floodFill(image,r,c,newColor)                          #call the recursive function for the new row and column
        return image                                                        #return the image