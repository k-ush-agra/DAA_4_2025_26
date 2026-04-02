# Cheapest Flights Within K Stops

## Problem Statement

There are n cities connected by flights. You are given a list of flights where:

flights[i] = [from, to, price]

This represents a flight from city `from` to city `to` with cost `price`.

You are also given:
- src → source city  
- dst → destination city  
- k → maximum number of stops  

### Objective  
Find the cheapest price from `src` to `dst` with at most k stops.  
If no such route exists, return -1.

---

## Approach

This problem is solved using a Modified Bellman-Ford Algorithm.

### Key Idea

- Each iteration represents one edge traversal  
- Maximum allowed edges = k + 1  
- So we relax edges k + 1 times  

---

## Algorithm Steps

1. Initialize distance array:
   - Set all values to ∞  
   - Set dist[src] = 0  

2. Repeat for k + 1 iterations:
   - Create a temporary copy of dist  
   - Traverse all flights  
   - Relax edges using previous iteration values  

3. Return:
   - dist[dst] if reachable  
   - else -1  

---

## Code (Java)

```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n);

            for (int[] f : flights) {
                int u = f[0], v = f[1], cost = f[2];

                if (dist[u] == Integer.MAX_VALUE) continue;

                if (dist[u] + cost < temp[v]) {
                    temp[v] = dist[u] + cost;
                }
            }

            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
```
---

## ⏱Complexity Analysis

### Time Complexity
O((k + 1) × E)

- k = maximum number of stops  
- E = number of flights (edges)  
- We relax all edges (k + 1) times  

---

### Space Complexity
O(n)

- n = number of cities  
- We use two arrays: dist[] and temp[]  
---

## Dry Run

### Input:
n = 5  
flights =  
[  
  [0,1,200],  
  [1,2,300],  
  [0,3,400],  
  [3,2,100],  
  [2,4,150]  
]  
src = 0, dst = 4, k = 2  

---

### Iteration 0 (Initial State):
dist = [0, ∞, ∞, ∞, ∞]

---

### Iteration 1:
- 0 → 1 = 200  
- 0 → 3 = 400  

dist = [0, 200, ∞, 400, ∞]

---

### Iteration 2:
- 1 → 2 = 200 + 300 = 500  
- 3 → 2 = 400 + 100 = 500  

dist = [0, 200, 500, 400, ∞]

---

### Iteration 3:
- 2 → 4 = 500 + 150 = 650  

dist = [0, 200, 500, 400, 650]

---

### Final Output:
650

## Submission Proof

Below is the screenshot of the accepted solution on LeetCode:

<img width="1919" height="870" alt="image" src="Screenshot 2026-03-31 191151.png" />