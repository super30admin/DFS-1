#TC - O(m*n)
#SC - O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q=collections.deque()
        visit = set()
        ROWS = len(mat)
        dist = mat.copy()
        COLS = len(mat[0])
        for i in range(ROWS):
            for j in range(COLS):
                if mat[i][j]==0:
                    visit.add((i,j))
                    q.append([(i,j),0])
                
        while q:
            [(row,col),steps] = q.popleft()
            distance = [[0,-1],[-1,0],[1,0],[0,1]]
            dist[row][col] = steps
            for dr,dc in distance:
                r,c = row+dr, col+dc
                if r>=0 and c>=0 and r< ROWS and c<COLS and (r,c) not in visit :
                    visit.add((r,c))
                    q.append([(r,c),steps+1])
        return dist
