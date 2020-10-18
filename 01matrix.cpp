//time complexity:O(m*n)
//space complexity:O(m*n)
//executed on leetcode: yes
//approach:using dfs
//any issues faced? yes, but understood it

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        if(matrix.size()==0)
            return matrix;
        int nrow=matrix.size();
        int ncol=matrix[0].size();
        queue<pair<int,int>>q;
        vector<vector<int>>dirs{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0; i<nrow; i++)
        {
            for(int j=0; j<ncol; j++)
            {
                if(matrix[i][j]==0)
                    q.push({i,j});
                else
                    matrix[i][j]=INT_MAX;
            }
        }
        int qsize=0;
        while(!q.empty())
        {
            qsize=q.size();
            pair<int,int>curr=q.front();
            q.pop();
            int rowidx=curr.first;
            int colidx=curr.second;
            for(vector<int>dir:dirs)
            {
                int newx=dir[0]+rowidx;
                int newy=dir[1]+colidx;
                if(newx>=0 && newy>=0 && newx<matrix.size() && newy<matrix[0].size())
                {
                    if(matrix[rowidx][colidx]+1<matrix[newx][newy])
                    {
                        matrix[newx][newy]=matrix[rowidx][colidx]+1;
                        q.push({newx,newy});
                    }
                }
            }
        }
        return matrix;
        
    }
};