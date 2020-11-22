#Time Complexity:O(n2)
#space Complexity:O(1)
#LeetCode Submission:successful
#We use Bfs to find the same color cell and add it to queue and do bfs till there is a element in q
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        m=len(image)
        n=len(image[0])
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        old =image[sr][sc]
        if old==newColor:
            return image
        q=[]
        q.append([sr,sc])
        while(len(q)>0):
            size=len(q)
            
            for i in range(size):
                source=q.pop(0)
                image[source[0]][source[1]]=newColor
                for d in dirs:
                    a=d[0]+source[0]
                    b=d[1]+source[1]
                    if a>=0 and a<m and b>=0 and b<n and image[a][b]==old:
                        image[a][b]=newColor
                        q.append([a,b])
        return image