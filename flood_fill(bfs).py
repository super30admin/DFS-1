class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or image[sr][sc]==color:
            return image
        
        #Getting basic data
        rows=len(image)
        cols=len(image[0])
        directions=[[1,0],[-1,0],[0,-1],[0,1]]
        #Storing the initial color in a variable
        initial_color=image[sr][sc]
        q=[]
        
        #Adding it to the queue
        q.append(sr)
        q.append(sc)
        
        #Changing the color of the start point
        image[sr][sc]=color
        while q:
            #getting the current row and col
            cr=q.pop(0)
            cc=q.pop(0)
            
            for d in directions:
                nr=cr+d[0]
                nc=cc+d[1]
                
                #bound check
                if (nr>=0 and nc>=0 and nr<rows and nc<cols and image[nr][nc]==initial_color ):
                    q.append(nr)
                    q.append(nc)
                    image[nr][nc]=color
                    
        return image
                    
                    
        