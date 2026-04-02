import java.util.*;

class HamiltonianCycle {
    int V;
    ArrayList<ArrayList<Integer>> adj;
    ArrayList<Integer> path;
    boolean[] vis;

    HamiltonianCycle(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        path = new ArrayList<>();
        vis = new boolean[V];
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }

    boolean dfs(int u, int cnt) {
        if (cnt == V) {
            return adj.get(u).contains(path.get(0));
        }

        for (int v : adj.get(u)) {
            if (!vis[v]) {
                vis[v] = true;
                path.add(v);

                if (dfs(v, cnt + 1))
                    return true;

                vis[v] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    boolean hamiltonianCycle() {
        Arrays.fill(vis, false);
        path.clear();

        path.add(0);
        vis[0] = true;

        return dfs(0, 1);
    }

    public static void main(String[] args) {
        HamiltonianCycle g = new HamiltonianCycle(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        if (g.hamiltonianCycle())
            System.out.println("Hamiltonian Cycle exists: " + g.path);
        else
            System.out.println("No Hamiltonian Cycle");
    }
}
