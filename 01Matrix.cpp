// TC:O(m*n)
// SC:O(m*n) Queue
// Here in worst case all cells can be traversed;

// Initially 
// There are multiple paths for 1 from different zeros so if we do dfs from zero/one we are redoing thee work.
// So DFS is not better 
// Going for BFS 
// what to push in to queue ,suppose if I pushed 1 ,I need to do one BFS for '1',So total O((m*n)^2) space complexity
// Further optimising always push independent variables in to queue ,In this problem '0' is independent and '1's are dependent on zeros
// Pushing zeros into queue 
// Next do we need to maintain level?
// Yes, because that is what we require to store at each 1
// Why mutating ?
// So if we dont mutate 1 to -1 in matrix if suppose some cells may have distance of 1 from zero,we cant differentiate whether it is visited or not

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) 
    {
        queue<vector<int>>q;
        int m=mat.size();
        int n=mat[0].size();

        vector<vector<int>>dir= {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                 q.push({i,j});  
                else
                mat[i][j]=-1; 
            }
        }
         
        int lvl=1;

        while(!q.empty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                vector<int>temp=q.front();
                q.pop();

                for(int k=0;k<dir.size();k++)
                {
                    int nr=temp[0]+dir[k][0];
                    int nc=temp[1]+dir[k][1];

                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1)
                    {
                          q.push({nr,nc});
                          mat[nr][nc]=lvl;
                    }
                }
            }
            lvl++;
        }




        return mat;
    }
};