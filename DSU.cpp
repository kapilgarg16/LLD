class Solution {
    public:
        vector<int>parent;
        vector<int>rank;
    
        void intial(int n){
            parent.resize(n+1);
            rank.resize(n+1, 1);
            iota(parent.begin(), parent.end(), 0);
        }
        int find(int x){
            if(x == parent[x]){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        bool union1(int x, int y){
            x = find(x);
            y = find(y);
    
            if(x == y){
                return false;
            }
            if(rank[x] < rank[y])
            swap(x, y);
    
            parent[y] = x;
            rank[x] += rank[y];
            return true;
    
        }
        int makeConnected(int n, vector<vector<int>>& connections) {
            intial(n);
            int extra = 0, numOfCom = 0;
            for(int i = 0 ; i < connections.size() ; i++){
                if(!union1(connections[i][0], connections[i][1])){
                    extra++;
                }
            }
            for(int i = 0 ; i < n ; i++){
                if(i == find(i))
                numOfCom++;
            }
    
            if(numOfCom - 1 > extra){
                return -1;
            }
            return numOfCom-1;
        }
    };