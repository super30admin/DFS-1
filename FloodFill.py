#code using BFS
#TC:O(m*n)
#SC:O(m*n) because stack space which is m*n
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if image==None or image[sr][sc]==color: return image
        row=len(image)
        col=len(image[0])
        pc=image[sr][sc]
        dire=[[-1,0],[0,-1],[1,0],[0,1]]
        q=[]
        q.append([sr,sc])
        if image[sr][sc]==pc:
            image[sr][sc]=color
        while q:
            curr=q.pop(0)
            
            for i in range(len(dire)):
                cr=curr[0]+dire[i][0]
                cc=curr[1]+dire[i][1]
                if cr<0 or cc<0 or cr>=row or cc>=col: continue
                if image[cr][cc]==pc:
                    q.append([cr,cc])
                    image[cr][cc]=color
        return image
        
'''
#TC:O(m*n)
#SC:O(m*n) because stack space which is m*n
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if image==None or image[sr][sc]==color: return image
        row=len(image)
        col=len(image[0])
        pc=image[sr][sc]
        dire=[[-1,0],[0,-1],[1,0],[0,1]]
        
    
        def dfs(image,sr,sc,color):
            if image[sr][sc]==pc:
                image[sr][sc]=color
            for i in range(len(dire)):
                cr=sr+dire[i][0]
                cc=sc+dire[i][1]
                if cr<0 or cc<0 or cr>=row or cc>=col: continue
                if image[cr][cc]==pc:
                    
                    dfs(image,cr,cc,color)
        dfs(image,sr,sc,color)
        return image
        
'''