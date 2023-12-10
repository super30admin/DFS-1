# TC: O(M X N)
# SC: O(M X N)


class Solution:
    oldcolor=0
    color=0
    dir1=[]
    m=0
    n=0
   

    def dfs(self,image,i,j):
        image[i][j]=self.color
        print(str(i)+" "+str(j))
        for k in range(0,len(self.dir1)):
            r=i+self.dir1[k][0]
            c=j+self.dir1[k][1]

            if r>=0 and c>=0 and r<self.m and c<self.n and image[r][c]==self.oldcolor:
                self.dfs(image,r,c)


    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc]==color:
            return image

        self.m=len(image)
        self.n=len(image[0])
        self.dir1=[[0,1],[0,-1],[1,0],[-1,0]]
        self.oldcolor=image[sr][sc]
        self.color=color

        self.dfs(image,sr,sc)

        return image


#BFS APPROACH

        # m=len(image)
        # n=len(image[0])
        # dir1=[[0,1],[0,-1],[1,0],[-1,0]]
        # q=deque()
        # oldcolor=image[sr][sc]
        # q.append((sr,sc))
        # image[sr][sc]=color
        # while q:
        #     hr,hc=q.popleft()
        #     for i in range(0,len(dir1)):
        #         r=hr+dir1[i][0]
        #         c=hc+dir1[i][1]

        #         if r>=0 and c>=0 and r<m and c<n:
        #             if image[r][c]==oldcolor:
        #                 image[r][c]=color
        #                 q.append((r,c))
        # print(image)
        # return image



        