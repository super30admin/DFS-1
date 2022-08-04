class Solution(object):
    def __init__(self):
        self.dirs=None
        self.ogcolor=None
    def __dfs(self,image, sr,sc,color, m, n):
        #Base case
        #Check bounds
        if sr<0 or sc<0 or sr>=m or sc>=n or image[sr][sc]!=self.ogcolor:
            return
        
        #Make that cell new color
        image[sr][sc]=color
        #iterate through directions
        for d in self.dirs:
            nr=sr+d[0]
            nc=sc+d[1]
            #call dfs
            self.__dfs(image, nr,nc,color, m, n)
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        '''We can do either BFS or DFS as we have connected components.'''
        #Time Complexity: O(mn)
        #Space Complexity: O(h)
        #null case
        if len(image)==0 or image[sr][sc]==color:
            return image
        
        m=len(image)
        n=len(image[0])
        #direction array right, left, top, bottom
        self.dirs=[[0,1],[0,-1],[-1,0],[1,0]]
        
        self.ogcolor=image[sr][sc]
      
        
        #DFS
        self.__dfs(image, sr,sc,color, m, n)
                    
        return image
        
        
