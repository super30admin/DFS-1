//TC: O(m*n)
//SC: O(m*n)

//Approach: Store the original color of the cell sr and sc, push these co-ordintaes on queue, then until queue is not empty keep iterating over dirs matrix and check if the newighboring cell is valid and that it has same color as original color, then push new co-ords in queue and keep repeating until our q is empty. return image here.
class Solution {
public:
int m,n;
int original;
vector<vector<int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
    void dfs(vector<vector<int>>& image, int sr, int sc, int color)
    {
        if(isValid(sr,sc) and image[sr][sc]!=original)
        {
           return;
        }

        image[sr][sc]=color;
        for(auto dir: dirs)
        {
            int r=sr+dir[0];
            int c=sc+dir[1];
            
                dfs(image, r,c ,color);
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {

        if(image.size()==0 and image[sr][sc]==color)
            return image;
        original = image[sr][sc];
         m=image.size();
         n=image[0].size();
       // image[sr][sc]=color;
        dfs(image,sr, sc, color);
       /* if(image.empty() || image[sr][sc]==color)
            return image;

        int original=image[sr][sc];

         vector<vector<int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
         m=image.size();
         n=image[0].size();
        
        queue<pair<int,int>> q; 
        q.push({sr, sc});
        image[sr][sc]=color;
        while(!q.empty())
        {
            auto curr=q.front(); q.pop();
           
           
            for(auto dir:dirs)
            {
                int newR= curr.first + dir[0];
                int newC= curr.second + dir[1];
                
                if(isValid(newR, newC) && original==image[newR][newC])
                {
                    q.push({newR,newC});
                    image[newR][newC]=color;
                }
                
            }
         
        }*/
   
        return image;
    }
    bool isValid(int r, int c)
    {
        return r>=0 && c>=0 && r<m && c<n;
    }
};