class Solution:
    ## BFS solution
    # Tc - O(n*m)
    # Sc - o(n*m)
    # def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
    #     if image == None or image[0] == None:
    #         return []
    #     ## If the color is same as the new color return    
    #     if image[sr][sc] == color:
    #         return image    
    #     queue = deque()
    #     queue.append((sr,sc))
    #     previouscolor = image[sr][sc]
    #     m = len(image) # row
    #     n = len(image[0]) # col
    #     dirs = [[0,-1],[-1,0],[0,1],[1,0]]
    #     while len(queue)!=0:
    #         sr,sc = queue.popleft()
    #         image[sr][sc] = color
    #         for r,c in dirs:
    #             newsr = sr+r
    #             newsc = sc+c
    #             if  0<=newsr and newsr<m and  newsc <n and newsc>=0 and image[newsr][newsc] == previouscolor:
    #                 queue.append((newsr,newsc))

    #     return image 


    ## DFS solution 
    # TC - o(m*n) 
    # Sc - O(M*n)
    def __init__(self):
        self.previouscolor = None
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:  
        if image == None or image[0] == None:
            return []
        if image[sr][sc] == color:
            return image    
        self.previouscolor = image[sr][sc]    
        self.dfs(image,sr,sc,color, len(image), len(image[0]),image[sr][sc])  
        return image    


    def dfs(self,image,r,c,color,m,n,oldcolor):
        ## base condition 
        if (r>=m or r<0) or (c>=n or c<0):
            return 

        if image[r][c]!= oldcolor:
            return    

        image[r][c] = color
        ## logic
        for dirr,dirc in self.dirs:
            self.dfs(image,r+dirr, c+dirc,color,m,n,oldcolor)
                         



        
