vector<int> dijkstra(int n, vector<vector<pair<int,int>>>& adj, int src) {
    // Min heap → {distance, node}
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

    vector<int> dist(n + 1, INT_MAX);
    dist[src] = 0;

    pq.push({0, src});

    while (!pq.empty()) {
        auto [d, node] = pq.top();
        pq.pop();

        // महत्वपूर्ण optimization
        if (d > dist[node]) continue;

        for (auto [next, weight] : adj[node]) {
            if (dist[next] > d + weight) {
                dist[next] = d + weight;
                pq.push({dist[next], next});
            }
        }
    }

    return dist;
}

vector<vector<pair<int,int>>> adj(n + 1);

for (auto &t : times) {
    adj[t[0]].push_back({t[1], t[2]});
}