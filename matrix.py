class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # TC O(mn)
        # SC O(mn)
        if mat is None or len(mat) == 0 :
            return mat
        
        m = len(mat)
        n= len(mat[0])
        quer = deque([])
        quec = deque([])
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
      
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    quer.append(i)
                    quec.append(j)
                else:
                    mat[i][j] = -1
        lvl = 1
        while len(quer) > 0:
            size = len(quer)
            for i in range(size):
                r = quer.popleft()
                c = quec.popleft()
                for d in dirs:
                    nr = r + d[0]
                    nc = c + d[1]
                    # print("bf,", r, c )
                    if ( nr < m) and (nr >= 0) and (nc <n) and (nc >= 0) and (mat[nr][nc] == -1):
                        quer.append(nr)
                        quec.append(nc)
                        mat[nr][nc] =lvl
                        
                        
            lvl += 1
        return mat
