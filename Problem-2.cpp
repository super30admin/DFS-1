/*
Time Complexity = O(M*N)
Space Complexity = O(M*N)
Where M is the number of rows and n is the number of coloumns in the matrix.
*/
class Solution {
public:
    int m,n;
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int i,j,lvl=1;
        m = mat.size();
        n = mat[0].size();
        queue<vector<int>> q;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    q.push({i,j});
                else
                    mat[i][j]=-1;
            }
        }
        vector<vector<int>> dir{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.empty())
        {
            int size = q.size();
            for(i=0;i<size;i++)
            {
                vector<int> temp(q.front());
                q.pop();
                for(j=0;j<4;j++)
                {
                    int r = temp[0]+dir[j][0];
                    int c = temp[1]+dir[j][1];
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==-1)
                    {
                        q.push({r,c});
                        mat[r][c]=lvl;
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
};
