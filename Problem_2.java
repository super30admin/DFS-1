// 01 Matrix

// Time Complexity : O(M*N)
// Space Complexity :  O(M*N)
// Did this code successfully run on Leetcode : Yes, Java Solution got Accepted with Runtime: 13 ms and
// Memory Usage: 41.1 MB 
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach : 
"""
Using approach which starts traversal with 0 (being independet element) and
than putting all 0's at one level in queue, Initially changing 1's to -1's  and 
popping elements until queue is not empty and looking if -1 is found in neighbors adding it to other level. 
to avoid duplicate values and once found change it to 1. Level is returned. 

"""
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix ==null || matrix.length==0){
            return matrix;
        }
        Queue<int[]> q=new LinkedList<>();
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    q.add(new int[] {i,j});
                }
                else
                {
                    matrix[i][j]=-1;
                }
            }
        }
    int dist=1;
    int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
    while(!q.isEmpty())
          {
              int size=q.size();
              for(int i=0;i<size;i++)
              {
                  int[] curr=q.poll();
                  for(int[] dir:dirs){
                      int r=curr[0]+dir[0];
                      int c=curr[1]+dir[1];
                      if (r>=0 && r<m && c>=0 && c<n && matrix[r][c]==-1)
                      {
                          matrix[r][c]=dist;
                          q.add(new int[] {r,c});
                      }
                  }
              }
              dist++;
          }
            
        return matrix;
    }
}

""" Python Solution
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix==None or len(matrix)==0:
            return matrix
        q = deque()
        m=len(matrix)
        n=len(matrix[0])
        curr=[]
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                     q += [(i, j)]
                else:
                    matrix[i][j]=-1
        dist=1
        directions=[[1,0],[-1,0],[0,1],[0,-1]]
        while(q):
            size=len(q)
            for i in range(size):
                curr=q.pop();
                for dirc in directions:
                    r=curr[0]+dirc[0]
                    c=curr[1]+dirc[1]
                    if r>=0 and r<m and c>=0 and c<n and matrix[r][c]==-1:
                        matrix[r][c]=dist
                        q+=[(r,c)]
            dist+=1
        return matrix 
                


"""