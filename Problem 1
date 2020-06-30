//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    //BFS solution
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size()==0 || image[sr][sc]==newColor) return image;
        queue<vector<int>> q;
       
        int dirs[4][2] = {{0,1},{0,-1},{-1,0},{1,0}};
        int color = image[sr][sc];
        image[sr][sc]=newColor;
        vector<int> temp;
        temp.push_back(sr);temp.push_back(sc);
        
        q.push(temp);
        
        while(q.empty()==false){
            int size = q.size();
            for(int i=0; i<size; i++){
                vector<int> arr = q.front(); q.pop();
                for(int j=0; j<4; j++){
                    int r = dirs[j][0]+arr[0];
                    int c = dirs[j][1]+arr[1];
                    if(r>=0 && r<image.size() && c>=0 && c<image[0].size() && image[r][c]==color){
                        image[r][c]=newColor;
                        vector<int> a;
                        a.push_back(r);a.push_back(c);
                        q.push(a);
                    }
                }
            }
            
        }
        
        return image;

    }
};


class Solution {
public:
    //DFS solution
    void helper(vector<vector<int>>& image, int sr, int sc, int newColor, int color){
        int  dirs[4][2] ={{0,1},{0,-1},{-1,0},{1,0}};
        
        if(sr<0 || sr>=image.size()) return;
        
        if(sc<0 || sc>=image[0].size()) return;
        
         if(image[sr][sc]==newColor) return;
                
        if(image[sr][sc]!=color) return;

        image[sr][sc]=newColor;
        
        for(int i=0; i<4; i++){
            int r  = sr+dirs[i][0];
            int c  = sc+dirs[i][1];
            helper(image, r, c, newColor, color);
        }
 
    }
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int m = image.size(); int n = image[0].size();
        if(image.size()==0) return image;
        int color=image[sr][sc];
        helper(image, sr, sc, newColor, color);
        return image;
    }
};