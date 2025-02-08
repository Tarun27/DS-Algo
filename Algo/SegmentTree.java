package Algo;


/**
 *
 * A Segment Tree is a data structure used for efficiently performing range queries and range updates
 * on an array. It allows operations like sum, minimum, maximum, GCD, etc. over a subarray in O(log n) time.
 *
 * A Segment Tree is a binary tree where:
 *
 * Each leaf node represents an element of the original array.
 * Each internal node represents a function (e.g., sum, min, max) of its children.
 * The tree is built in O(n) time and allows queries/updates in O(log n).
 *
 *   arr=[2,4,3,7,1,5,6,8]
 *
 * A Segment Tree for range minimum query (RMQ) would look like:
 *
 *                 1
 *               /   \
 *             2       1
 *            / \     /  \
 *          2    3   1    5
 *         / \  / \ / \   / \
 *        2  4 3  7 1 6  5  8
 *
 * Each node stores the minimum of its range. (we can create segment tree with support for both min/max)
 * The root represents the minimum of the entire array.
 *
 * 🔹 When to Use? If you need fast range queries and updates, use a Segment Tree instead of brute force.
 * 🔹 Best Alternative? If only updates OR queries are needed, Fenwick Tree (Binary Indexed Tree - BIT)
 *    might be simpler.
 *
 * 🚀 Segment Trees provide optimal performance in competitive programming and real-world applications
 *    like databases, analytics, and games!
 *
 *    // todo: range update with lazy propogation
 */

class SegmentTree {

    private int[] arr;  // Original array
    private  int[] tree; // Segment tree, this stores min values, we can array for max values as well
    private final int n;      // Size of the array

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];  // Allocate sufficient space (4*n)
        build(arr, 0, 0, n - 1);
    }


    /**
     *
     * Recursively divide the array into halves.
     * Combine results at each node.
     * Base case: A single element is stored in the leaf.
     *
     * 2 * node + 1 → Left child of node.
     * 2 * node + 2 → Right child of node.
     * start, mid → Left half of the array.
     * mid + 1, end → Right half of the array.
     *
     *  Time Complexity: O(n)
     *
     * @param arr
     * @param node
     * @param start
     * @param end
     */
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {  // Leaf node case
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);   // Build left child
            build(arr, 2 * node + 2, mid + 1, end); // Build right child
            tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]); // Parent stores min(left, right)
           // tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // Sum of children, if we want sum in range segment tree
           // tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]); // for max in range
        }
    }


    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    /**
     *
     *  Query: Range Minimum/Sum  --- similarly we can create for max
     *  Given a range [L, R], return the minimum or sum in that range.
     *  Time Complexity: O(log n)
     *
     * @param node
     * @param start
     * @param end
     * @param L
     * @param R
     * @return
     */
    private int query(int node, int start, int end, int L, int R) {
        if (R < start || L > end) return Integer.MAX_VALUE; // Out of range
        if (L <= start && end <= R) return tree[node]; // Complete overlap

        int mid = (start + end) / 2;
        int leftQuery = query(2 * node + 1, start, mid, L, R);
        int rightQuery = query(2 * node + 2, mid + 1, end, L, R);
        return Math.min(leftQuery, rightQuery); // Return min of two halves
    }


    public void update(int idx, int newVal) {
        update(0, 0, n - 1, idx, newVal);
    }

    /**
     *
     * The update operation in a Segment Tree modifies a specific element in the original array
     * and updates the tree accordingly
     *
     * Steps for Updating an Element
     *
     * 1. Find the Leaf Node:
     *
     * Traverse the segment tree recursively to locate the leaf node corresponding to the index we want to
     * update.
     *
     * 2. Update the Leaf Node:
     * Change the value at that leaf node to the new value.
     *
     * 3. Propagate the Changes Upward:
     * Since the segment tree stores aggregated values (sum, min, max, etc.), we must update all parent
     * nodes that depend on this leaf node.
     *
     * update value at idx with new value.
     *
     * @param node
     * @param start
     * @param end
     * @param idx
     * @param newVal
     */
    private void update(int node, int start, int end, int idx, int newVal) {
        if (start == end) {
            tree[node] = newVal;  // Update leaf node
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) { // If index is in left subtree
                update(2 * node + 1, start, mid, idx, newVal);
            } else { // If index is in right subtree
                update(2 * node + 2, mid + 1, end, idx, newVal);
            }
            // Recompute min( or max or sum) for this node
            tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]); // Update parent
        }
    }



    // Print segment tree
    public void printTree() {
        for (int i = 0; i < 4 * n; i++) {
            if (tree[i] != 0) System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 7, 1, 5, 6, 8};
        SegmentTree segTree = new SegmentTree(arr);

        segTree.printTree();

        System.out.println("Min in range [2, 5]: " + segTree.query(2, 5));

        segTree.update(3, 10);
        System.out.println("Updated element at index 3 to 10");

        System.out.println("Min in range [2, 5] after update: " + segTree.query(2, 5));

    }
}
