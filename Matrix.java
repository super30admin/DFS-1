// Time Complexity :O(n*m)
// Space Complexity : O(n*m)// since, we are storing indices in Queue
// Did this code successfully run on Leetcode 542 :yes
/*Approach: firstly, we are adding all the indexes of zeroes in matrix and changes all 1s to -1s (inorder
to differentiate if it is visited) and then for each index in the queue we are looking for its neighbors
 whose value tends to -1 and then adding its index to the queue. The count of how many units away is given
 by the value at current index in the queue + 1.(i,e, a child value is equal to its parent +1)*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null||mat.length==0)
            return mat;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m=mat.length;
        int n=mat[0].length;
        //int level=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                if(mat[i][j]==1)
                    mat[i][j]=-1;
                    }
        }
            while(!q.isEmpty()){

                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n && mat[nr][nc]==-1)
                    {mat[nr][nc]=mat[curr[0]][curr[1]]+1;
                        q.add(new int[]{nr,nc});}
                }


                 //level++;
            }

        return mat;
    }
}
