#T(N) = O(N)
#S(N) = O(N)
class Solution:
    vi={}
    m=0
    n=0
    image=[[]]
    def dfs(self,sr,sc,color,co):
        
        dirs=[(0,1),(1,0),(-1,0),(0,-1)]
        for i in dirs:
                a=sr+i[0]
                b=sc+i[1]
                if a>=0 and a<self.m and b>=0 and b<self.n and self.image[a][b]==co and self.vi.get((a,b),-1)!=True:
                    self.image[a][b]=color
                    self.vi[(a,b)]=True
                    self.dfs(a,b,color,co)
        
        
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        from collections import deque
        self.image=image
        self.m=len(image)
        self.n=len(image[0])
        qu=deque()
        qu.append((sr,sc))
        co=image[sr][sc]
        dirs=[(0,1),(1,0),(-1,0),(0,-1)]
        image[sr][sc]=color
        self.vi={}
        self.vi[(sr,sc)]=True
        # while qu:
        #     te=qu.popleft()
        #     for i in dirs:
        #         a=te[0]+i[0]
        #         b=te[1]+i[1]
        #         if a>=0 and a<m and b>=0 and b<n and image[a][b]==co and vi.get((a,b),-1)!=True:
        #             image[a][b]=color
        #             qu.append((a,b))
        #             vi[(a,b)]=True
        self.dfs(sr,sc,color,co)
        return image
            
                    
                
            
        