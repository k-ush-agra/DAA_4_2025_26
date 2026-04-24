## 🧠 Algorithms and Complexity Analysis

---

## ♟️ 1. N-Queens Problem

### 📌 Algorithm (Backtracking)

1. Start from the first row.
2. For each column in the current row:
   - Check if placing a queen is safe:
     - No other queen in the same column
     - No other queen in the same diagonal
3. If safe:
   - Place the queen
   - Recur for the next row
4. If all queens are placed:
   - Print the solution
   - Increment solution count
5. Backtrack:
   - Remove the queen and try next column

---

### ⏱️ Time Complexity

- Worst Case: **O(N!)**
- Reason:
  - Each row has N choices initially
  - Then reduces progressively due to constraints
- With hashing optimization:
  - Still exponential, but faster in practice

---

### 💾 Space Complexity

- O(N) → recursion stack
- O(N) → board array
- Total: **O(N)**

---

### ⚡ Optimizations Used

- Column hashing
- Diagonal hashing:
  - Main diagonal → (row - col)
  - Secondary diagonal → (row + col)
- Avoids repeated safety checks

---

### 📌 Applications

- Constraint Satisfaction Problems (CSP)
- Scheduling problems
- AI search algorithms

---

---

## 🔄 2. Hamiltonian Cycle

### 📌 Algorithm (Backtracking)

1. Start from vertex 0 and add it to path.
2. For each next position:
   - Try all vertices one by one
3. Check:
   - Vertex is adjacent to previous vertex
   - Vertex is not already in path
4. If valid:
   - Add to path
   - Recur for next position
5. If all vertices are included:
   - Check if last connects to first
   - If yes → cycle found
6. Else:
   - Backtrack and try another vertex

---

### ⏱️ Time Complexity

- Worst Case: **O(V!)**
- Reason:
  - All permutations of vertices are explored
- Highly inefficient for large graphs

---

### 💾 Space Complexity

- O(V) → path array
- O(V) → recursion stack
- Total: **O(V)**

---

### ⚡ Key Observations

- Works only for small graphs due to factorial growth
- No polynomial-time solution exists (NP-Complete problem)

---

### 📌 Applications

- Routing problems
- Traveling Salesman Problem (TSP)
- Genome sequencing
- Network topology design

---

---

## 📊 Comparison Summary

| Feature              | N-Queens          | Hamiltonian Cycle   |
|---------------------|------------------|--------------------|
| Technique           | Backtracking     | Backtracking       |
| Problem Type        | Constraint-based | Graph traversal    |
| Time Complexity     | O(N!)            | O(V!)              |
| Space Complexity    | O(N)             | O(V)               |
| Optimization Scope  | Moderate         | Limited            |

---

## 🧾 Conclusion

Both problems demonstrate the power and limitations of backtracking:

- Guarantees correct solution
- Extremely expensive for large inputs
- Useful for understanding recursion and constraint solving

Efficient alternatives exist only for specific cases or approximations.

---

