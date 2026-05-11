## Contest Problems

### Q1. Event Score Tracker

#### Problem Statement

You are given a string array `events`.

Initially, `score = 0` and `counter = 0`. Each element in `events` is one of the following:

- `"0"`, `"1"`, `"2"`, `"3"`, `"4"`, `"6"`: Add that value to the total score.
- `"W"`: Increase the counter by `1`. No score is added.
- `"WD"`: Add `1` to the total score.
- `"NB"`: Add `1` to the total score.

Process the array from left to right. Stop processing when either:

- All elements in `events` have been processed, or
- The `counter` becomes `10`.

Return an integer array `[score, counter]`, where:

- `score` is the final total score.
- `counter` is the final counter value.

---


### Q2. Minimum Modifications to Make Binary String Coherent

#### Problem Statement

You are given a binary string `s`.

A string is considered coherent if it does not contain `"011"` or `"110"` as subsequences.

In one operation, you can flip any character in `s` (`'0'` to `'1'` or `'1'` to `'0'`).

Return an integer denoting the minimum number of modifications required to make `s` coherent.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.


---


### Q3. Minimum Generation to Obtain Target Point

#### Problem Statement

You are given a 2D integer array `points` where `points[i] = [xi, yi, zi]` represents a point in 3D space, and an integer array `target` representing a target point.

Define generation `0` as the initial list of points.

For each integer `k >= 1`, form generation `k` as follows:

- Consider every pair of two distinct points
  `a = [x1, y1, z1]` and `b = [x2, y2, z2]`
  taken from all points produced in generations `0` through `k - 1`.

- For each such pair, compute:

```text
c = [
    floor((x1 + x2) / 2),
    floor((y1 + y2) / 2),
    floor((z1 + z2) / 2)
]
```

- Collect every such `c` into generation `k`.

- All points in generation `k` are produced simultaneously from points in generations `0` through `k - 1`.

- After generation `k` is formed, the points in generation `k` are considered available for forming later generations.

Return the smallest integer `k` such that the `target` appears in one of the generations `0` through `k`.

If the target is already in the initial points, return `0`.

If it is impossible to obtain the target, return `-1`.

##### Notes

- `floor` denotes rounding down to the nearest integer.
- "Two distinct points" means the two chosen points must have different `(x, y, z)` coordinates.
- A point cannot be paired with itself, and pairing two points with identical coordinates is not possible.


---


### Q4. Minimum Threshold for Valid Path

#### Problem Statement

There is an undirected weighted graph with `n` nodes labeled from `0` to `n - 1`.

The graph is represented by a 2D integer array `edges`, where:

```text
edges[i] = [ui, vi, wi]
```

indicates that there is an undirected edge between nodes `ui` and `vi` with weight `wi`.

You are also given integers `source`, `target`, and `k`.

A threshold value determines whether an edge is considered light or heavy:

- An edge is **light** if its weight is less than or equal to `threshold`.
- An edge is **heavy** if its weight is greater than `threshold`.

A path from `source` to `target` is valid if it contains at most `k` heavy edges.

Return the minimum integer `threshold` such that at least one valid path exists from `source` to `target`.

If no such path exists, return `-1`.
