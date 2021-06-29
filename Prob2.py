#Time complexity for put and get: O(rc)
#Space complexity: O(rc)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        #bfs works for this as dfs is too complicated
        #add all 0's to queue as their dist is 0
        # make all non 0's as -1 to not cause confusion when specifying distance
        q = deque()
        for i in xrange(len(mat)):
            for j in xrange(len(mat[0])):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        dist = 1
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        #bfs
        while q:
            size = len(q)
            #with each level dist increases by 1
            for i in xrange(size):
                node = q.popleft()
                for d in dirs:
                    nr = node[0]+d[0]
                    nc = node[1]+d[1]
                    if nr>=0 and nc>=0 and nr<len(mat) and nc<len(mat[0]) and mat[nr][nc] == -1:
                        # make neighbours as the distance
                        mat[nr][nc] = dist
                        # add these neighbours to queue
                        q.append((nr,nc))
            dist += 1
        return mat
                        