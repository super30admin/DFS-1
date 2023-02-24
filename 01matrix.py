#All TC passed on leetcode


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:


        #Here we add all 0's into queue and modify all 1's to -1 so that we can differentiate b/w visited 1's and not visited 1's. During processing of each queue iteration we check in all 4 direction's of poped element, if any neighbor is -1 then we update its value to poped elements's value + 1.
        #Time complexity - O(m.n)
        #Space complexity - O(m.n)
        m = len(mat)
        n = len(mat[0])
        directions = [[1,0], [-1,0], [0,-1], [0,1]]
        queue = collections.deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    queue.append((i,j))
                if mat[i][j]==1:
                    mat[i][j] = -1
        
        while queue:

            for i in range(len(queue)):
                r, c = queue.popleft()

                for dr, dc in directions:
                    nr = dr + r
                    nc = dc + c
                    if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc]=mat[r][c]+1
                        queue.append((nr,nc))

        return mat


#--------------------------------------OR------------------------------------------


        #Time complexity - O(m.n)^2 as we perform freshly new DFS starting from every cell which is equal to 0
        #Space complexity - O(m.n)
        #DFS approach
        m = len(mat)
        n = len(mat[0])
        directions = [[1,0], [-1,0], [0,-1], [0,1]]

        def dfs(r,c,dist):
            if r<0 or c<0 or r>=m or c>=n:
                return
            if mat[r][c]!=-1 and mat[r][c]<dist:
                return

            mat[r][c] = dist
            for dr, dc in directions:
                dfs(r+dr, c+dc, dist+1)

        for i in range(m):
            for j in range(n):
                if mat[i][j]==1:
                    mat[i][j] = -1

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    dfs(i, j, 0)
        return mat



#--------------------------------------OR------------------------------------------
        #Time complexity - O(m.n)^2 as we perform freshly new BFS on every cell which is equal to 1
        #Space complexity - O(m.n)

        m = len(mat)
        n = len(mat[0])
        
        directions = [[1,0], [-1,0], [0,-1], [0,1]]

        for i in range(m):
            for j in range(n):
                if mat[i][j]==1:
                    queue = collections.deque()
                    dist = 0
                    flag = False
                    queue.append((i,j))
                    while queue:
                        for k in range(len(queue)):
                            r, c = queue.popleft()

                            for dr, dc in directions:
                                nr = dr + r
                                nc = dc + c
                                if nr>=0 and nc>=0 and nr<m and nc<n:
                                    if mat[nr][nc]==0:
                                        mat[i][j] = dist+1
                                        flag = True
                                        break
                                    else:
                                        queue.append((nr,nc))
                            if flag:
                                break

                        dist += 1
                        if flag:
                            break
        
        return mat

                                


