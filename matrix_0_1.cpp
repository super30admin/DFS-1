// Time Complexity : O(m*n*(m+n))
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : Almost (Got Time Limit on Last Test Case)
// Any problem you faced while coding this - Need to find a more time efficient solution

class Solution {
public:
    int get_distance(vector<vector<int>> &mat, int r, int c)
    {
        int m = mat.size();
        int n = mat[0].size();
        int i, j;
        
        int visited[m][n];
        
        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }
        
        queue<pair<int, int>> qcor;
        queue<int> qdis;
        
        qcor.push(pair(r, c));
        qdis.push(0);
        
        pair<int, int> tcor;
        int tdis;
        
        vector<pair<int, int>> dir;
        int tr, tc;
        
        dir.push_back(pair(-1,0));
        dir.push_back(pair(1,0));
        dir.push_back(pair(0,-1));
        dir.push_back(pair(0,1));
        
        while(!qcor.empty())
        {
            tcor = qcor.front(); qcor.pop();
            tdis = qdis.front(); qdis.pop();
            
            if(mat[tcor.first][tcor.second] == 0)
            {
                return tdis;
            }
            
            visited[tcor.first][tcor.second] == 1;
            
            for(i = 0; i < dir.size(); i++)
            {
                tr = tcor.first + dir[i].first;
                tc = tcor.second + dir[i].second;
                
                if(tr >= 0 && tc >= 0 && tr < m && tc < n)
                {
                    if(visited[tr][tc] == 0)
                    {
                        qcor.push(pair(tr,tc));
                        qdis.push(tdis+1);
                    }
                }
            }
        }
        
        return -1;
    }
    
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        vector<vector<int>> ret_vect;
        
        int m = mat.size();
        int n = mat[0].size();
        int i, j;
        int val;
        
        for(i = 0; i < m; i++)
        {
            vector<int> temp;
            ret_vect.push_back(temp);
            
            for(j = 0; j < n; j++)
            {
                val = get_distance(mat, i, j);
                
                ret_vect[i].push_back(val);
            }
        }
        
        return ret_vect;
    }
};