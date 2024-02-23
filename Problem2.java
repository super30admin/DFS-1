// ## Problem2 (https://leetcode.com/problems/01-matrix/)

// Time Complexity : BFS - O(M*N)
// Space Complexity : BFS - O(M*N) -- taken up by queue as aux space in BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach


class Solution {
    private int[][] dirs={{0,1}, {1,0}, {-1,0}, {0,-1}};

    //1. BFS
    //Time: O(M*N)
    //Space:O(M*N) -- taken up by queue as aux space in BFS
    private int[][] bfsHelper(int[][] max){
        int m=max.length;
        int n=max[0].length;

        Queue<Integer> q=new LinkedList<>();

        // Add all zeroes to queue (Independent nodes)
        // Make 1s as -1 to keep track of visited 1s
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(max[i][j]==0){
                    q.add(i);
                    q.add(j);
                }
                if(max[i][j]==1){
                    max[i][j]=-1;
                }
            }
        }


        int currLevel=1;
        while(!q.isEmpty()){
            int size_n=q.size();

            // Process current level
            for(int i=0;i<size_n;i=i+2){
                int cr=q.poll();
                int cc=q.poll();

                for(int[] dir:dirs){
                    int nr=cr+dir[0];
                    int nc=cc+dir[1];

                    // Bounds check
                    if(nr>=0 && nc>=0 && nr<m && nc<n && max[nr][nc]==-1){
                        //Add to queue
                        q.add(nr);
                        q.add(nc);

                        // Update distance
                        max[nr][nc]=currLevel;
                    }
                }
            }
            currLevel++;
        }

        return max;
    }

    public int[][] updateMatrix(int[][] mat) {
        //1. BFS
        return bfsHelper(mat);
    }
}