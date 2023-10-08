class Solution {
public:
int m, n;
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
         m=mat.size();
         n=mat[0].size();
        vector<vector<int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
        queue<pair<int,int>> q;
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

        while(!q.empty())
        {
            auto curr=q.front();
            q.pop();
            for(auto dir:dirs)
            {
                int newR=curr.first+dir[0];
                int newC=curr.second+dir[1];
                if(valid(newR,newC) and mat[newR][newC]==-1)
                {
                    q.push({newR,newC});
                    mat[newR][newC]=mat[curr.first][curr.second]+1;
                }
            }
        }
        return mat;
    }
    bool valid(int r, int c)
    {
        return r>=0 and c>=0 and r<m and c<n;
    }

};