# Time Complexity : O(r*c) 
# Space Complexity : O(r*c) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        m,n = len(mat),len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.append([i,j])
        print(mat)
        dist = 1
        while q:
            s =len(q)
            #print(q)
            for i in range(s):
                ele = q.popleft()
                for dire in dirs:
                    r = ele[0]+dire[0]
                    c = ele[1]+dire[1]
                    if r >= 0 and c>=0 and r<m and c<n and mat[r][c] == -1:
                        mat[r][c] = dist
                        #print('change',mat[r][c])
                        q.append([r,c])
                        #print(q)
            dist= dist+1
        return mat
