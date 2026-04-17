# Step 2: Measure Metrics

## 2.1 Metric Definitions and Measurement Methodology

To empirically evaluate the scalability of the implemented algorithms, performance data was captured during execution in **Java**. The following key performance metrics were recorded:

**Execution Time:**
The total wall-clock time required for the algorithm to process the input, measured in milliseconds (ms). This was captured using `System.nanoTime()` to ensure high precision timing.

**Approximate Number of Operations:**
A discrete integer counter was incremented during the fundamental operation of each algorithm (e.g., inside the loop for Binary Search or at each recursive call for Subset Sum). This provides a hardware-independent way to validate theoretical time complexity.

**Feasibility Status:**
To prevent excessive computation time and system freezing, a strict execution timeout threshold of **2000 ms (2 seconds)** was enforced.

* **Completed:** Algorithm finished within the time limit
* **Timeout (Infeasible):** Algorithm exceeded the time limit

---

## 2.2 Environmental Variables

To ensure reproducibility, all executions were performed under the following system conditions:

**Hardware:**
Ryzen 7 Processor, 16GB RAM

**Programming Language:**
Java (JDK 17 or later recommended)

**Execution Environment:**
Standard Java runtime without additional optimization flags

---

## 2.3 Structured Execution Log

| Algorithm                 | Complexity Class | Input Size (N) | Operations Count | Execution Time (ms) | Feasibility Status |
| ------------------------- | ---------------- | -------------- | ---------------- | ------------------- | ------------------ |
| Binary Search             | O(log n)         | 1,000,000      | ~20              | ~0.002              | Completed          |
| Subset Sum (Verification) | O(n)             | 8              | 8                | ~0.001              | Completed          |
| Subset Sum (Decision)     | O(2^n)           | 6              | 63               | ~0.02               | Completed          |
| Subset Sum (Decision)     | O(2^n)           | 45             | >10,000,000      | >2000               | Timeout            |
| TSP (Brute Force)         | O(n!)            | 4              | 24               | ~0.01               | Completed          |
| TSP (Brute Force)         | O(n!)            | 15             | >15,000,000      | >2000               | Timeout            |
