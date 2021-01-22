#Time: O(mxn)
#space: O(mxn)
#leetcode: yes

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if (image==[] or len(image)==0 or image[sr][sc]==newColor):
            return image
        q=deque()
        row=len(image)
        column=len(image[0])
        color=image[sr][sc]
        q.append([sr,sc])
        image[sr][sc]=newColor
        direct=[[0,1],[1,0],[-1,0],[0,-1]]
        while(q!=deque()):
            for v in range(len(q)):
                r,c=q.popleft()
                for d in direct:
                    i=r+d[0]
                    j=c+d[1]
                    if(i>=0 and i<row and j>=0 and j<column and image[i][j]==color):
                        image[i][j]=newColor
                        q.append([i,j])
    
        return image
            