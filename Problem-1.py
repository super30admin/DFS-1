#Time Complexity :o(n)
#Space Complexity :o(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if(image==None):
            return []
        m=len(image)
        n=len(image[0])
        if(image[sr][sc]==newColor):
            return image
        queue=collections.deque()
        ogColor=image[sr][sc]
        queue.append([sr,sc])
        image[sr][sc]=newColor
    
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        while(len(queue)>0):
            curr=queue.popleft()
            for i in dirs:
                r=i[0]+curr[0]
                c=i[1]+curr[1]
                if(r>=0 and r<m and c<n and c>=0 and image[r][c]==ogColor):
                    queue.append([r,c])
                    image[r][c]=newColor
                    
                
        return image
        