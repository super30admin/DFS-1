class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
//         int color = image[sr][sc];
//         if(color!=newColor)helper(image,sr,sc,color,newColor);
//         return image;
        
//     }
    
//     void helper(vector<vector<int>>& image,int r,int c,int color,int newColor){
//         if(image[r][c] ==color){
//             image[r][c] = newColor;
//             if(r >=1)helper(image,r-1,c,color,newColor);
//             if(c>=1)helper(image,r,c-1,color,newColor);
//             if(r <=image.size()-2)helper(image,r+1,c,color,newColor);
//             if(c <= image[0].size()-2)helper(image,r,c+1,color,newColor);
//         }
//     }
    stack<pair<int,int>>st;
    int temp = image[sr][sc];
    if(temp == newColor)return image;
    st.push(make_pair(sr,sc));
    vector<vector<bool>>visited(image.size(),vector<bool>(image[0].size(),false));
    while(!st.empty()){
        pair<int,int>coor =st.top();st.pop();
        int r = coor.first;
        int c = coor.second;
        visited[r][c]=true;
        if(image[r][c]==temp)image[r][c] = newColor;
        if(r>=1 && !visited[r-1][c] && image[r-1][c]==temp )st.push(make_pair(r-1,c));
        if(c>=1 && !visited[r][c-1]&& image[r][c-1]==temp)st.push(make_pair(r,c-1));
        if(r <= image.size()-2 && !visited[r+1][c] && image[r+1][c]==temp)st.push(make_pair(r+1,c));
        if(c <= image[0].size()-2 && !visited[r][c+1] && image[r][c+1]==temp)st.push(make_pair(r,c+1));
    }
        return image;
    }
        
    
    
    
};