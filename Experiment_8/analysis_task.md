# 1. Why does Binary Search consistently demonstrate efficient performance across large input sizes?

Binary Search demonstrates high efficiency because it follows a **divide-and-conquer approach**, resulting in logarithmic time complexity O(log n).

Instead of checking each element sequentially, it repeatedly divides the search space into halves. This dramatically reduces the number of operations required.

In Java implementation, even for an array of size 1,000,000, the number of operations remains around 20, making it extremely scalable.

---

# 2. Explain why Subset Sum is computationally difficult to solve but relatively easy to verify.

The Subset Sum problem involves determining whether any subset of a given set sums to a target value.

* **Solving:** Requires checking all possible subsets → O(2^n)
* **Verification:** Simply adds given elements → O(n)

In Java, recursive calls in the decision version grow exponentially, while verification uses a simple loop, making it significantly faster.

---

# 3. Identify the input size at which the Traveling Salesman Problem becomes infeasible and justify the reason.

The Traveling Salesman Problem (TSP) becomes infeasible around **15–20 cities** when solved using brute force.

This is because it has factorial time complexity O(n!), meaning the number of possible routes increases extremely fast.

In Java implementation:

* Small inputs (4 cities) execute quickly
* Larger inputs (15 cities) exceed the timeout threshold (2000 ms)

---

# 4. Differentiate between solving a problem and verifying a given solution.

| Feature         | Solving                           | Verifying                                |
| --------------- | --------------------------------- | ---------------------------------------- |
| Definition      | Finding the solution from scratch | Checking correctness of a given solution |
| Time Complexity | Often exponential or factorial    | Usually polynomial                       |
| Example         | Solving Subset Sum                | Verifying a subset sum                   |

In Java:

* Solving uses recursion and explores all combinations
* Verifying uses iteration and simple arithmetic

---

# 5. Discuss why NP-Complete problems are considered the most challenging class within NP.

NP-Complete problems are considered difficult because:

1. Every NP problem can be reduced to them
2. No polynomial-time solution is known
3. Solving one efficiently would solve all NP problems

Examples include:

* Subset Sum
* Traveling Salesman Problem

In Java implementations, these problems quickly become infeasible for larger inputs due to exponential or factorial growth.
