    # Time Complexity : O(mxn)
    # Space Complexity : O(mxn)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No


class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        if (len(mat))==0 or not mat:
            return []
        m=len(mat)
        n=len(mat[0])
        mat_dir= [[0,1], [0, -1], [-1, 0], [1,0]]
        q=[]
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        count =1 
        while(q):
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for d in mat_dir:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    if r>=0 and c>=0 and r<m and c<n and mat[r][c]==-1:
                        q.append([r,c])
                        mat[r][c] = count
        
            count +=1
            
        return mat
        