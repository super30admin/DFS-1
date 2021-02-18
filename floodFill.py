#TimeComplexity:O(N*M) 
#SpaceComplexity: O(N*M) Maximum no of elements with similr color as oldColor
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        queue=[]
        queue.append((sr,sc))
        oldColor=image[sr][sc]
        if oldColor==newColor:
            return image
        image[sr][sc]=newColor
        while(queue):
            for index in [queue.pop(0)]:
                for dir in dirs:
                    i=index[0]+dir[0]
                    j=index[1]+dir[1]
                    if(i>=0 and j>=0 and i<len(image) and j<len(image[0]) and image[i][j]==oldColor):
                        image[i][j]=newColor
                        queue.append((i,j))
        return image
                        
                
        