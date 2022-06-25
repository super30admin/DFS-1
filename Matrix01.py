# // Time Complexity : O(M*N)
# // Space Complexity : O(M*N)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        r = len(mat)
        c = len(mat[0])
        if not mat:
            return [[]]
        queue = collections.deque([])
        for i in range(r):
            for j in range(c):
                if mat[i][j] == 0:
                    queue.append((i,j))
                elif mat[i][j] == 1:
                    mat[i][j] = -1
        directions = [(0,1),(1,0),(0,-1),(-1,0)]
        lvl = 1
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                for x,y in directions:
                    nx = x+curr[0]
                    ny = y+curr[1]
                    if 0 <= nx < r and 0 <= ny < c and mat[nx][ny] == -1 :
                        mat[nx][ny] = lvl
                        queue.append((nx,ny))
            lvl += 1
        return mat