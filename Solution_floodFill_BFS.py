"""
Time Complexity -->O(m*n)
Space complexity ---> 0(m*n) [recursive stack]

"""

class Solution_floodFill_BFS:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image)==0 or image[sr][sc]==newColor:
            return image
        
        color=image[sr][sc]
        q=[]
        dirs=[[1,0 ],[0,1],[0,-1],[-1,0]]
        q.append([sr,sc])
        image[sr][sc]=newColor
        
        while q:
            curr=q.pop(0)
            for dir in dirs:
                r=dir[0]+curr[0]
                c=dir[1]+curr[1]
                if(r>=0 and r<len(image) and c>=0 and c<len(image[0]) and image[r][c]==color):
                    q.append([r,c])
                    image[r][c]=newColor
        return image
                   
    
                
                
        
        
     