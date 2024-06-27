class Node {
    Node left;
    Node right;
    int valueToAdd;
    boolean isCovered;
}

// SegmentTree class encapsulating the tree operations
class SegmentTree {
    private Node root = new Node();

    // Constructor is not necessary, Java provides a default one

    // Update the segment tree, marking ranges
    public void modify(int left, int right, int value) {
        modify(left, right, value, 1, (int) 1e9, root);
    }

    // Helper function to modify nodes in the given range [left, right] recursively
    private void modify(int left, int right, int value, int start, int end, Node node) {
        if (start >= left && end <= right) {
            node.isCovered = value == 1;
            node.valueToAdd = value;
            return;
        }
        pushdown(node);
      
        int mid = (start + end) >> 1; // Equivalent to dividing by 2
        if (left <= mid) {
            modify(left, right, value, start, mid, node.left);
        }
        if (right > mid) {
            modify(left, right, value, mid + 1, end, node.right);
        }
        pushup(node);
    }

    // Query the segment tree to check coverage of range [left, right]
    public boolean query(int left, int right) {
        return query(left, right, 1, (int) 1e9, root);
    }

    // Helper function to query the tree recursively
    private boolean query(int left, int right, int start, int end, Node node) {
        if (node == null) {
            return false;
        }
        if (start >= left && end <= right) {
            return node.isCovered;
        }

        pushdown(node);

        int mid = (start + end) >> 1;
        boolean result = true;
        if (left <= mid) {
            result = result && query(left, right, start, mid, node.left);
        }
        if (right > mid) {
            result = result && query(left, right, mid + 1, end, node.right);
        }
        return result;
    }

    // Function to update node coverage based on child nodes
    private void pushup(Node node) {
        if (node.left != null && node.right != null) {
            node.isCovered = node.left.isCovered && node.right.isCovered;
        }
    }

    // Function to propagate changes to child nodes
    private void pushdown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();

        if (node.valueToAdd != 0) {
            // Propagate valueToAdd down to children and reset it for the current node
            node.left.valueToAdd = node.valueToAdd;
            node.right.valueToAdd = node.valueToAdd;
            node.left.isCovered = node.valueToAdd == 1;
            node.right.isCovered = node.valueToAdd == 1;
            node.valueToAdd = 0;
        }
    }
}

// RangeModule class to handle range adding, querying, and removing
class RangeModule {
    private SegmentTree tree = new SegmentTree();

    // Adds a range to the module
    public void addRange(int left, int right) {
        tree.modify(left, right - 1, 1);
    }

    // Queries if the range is fully covered
    public boolean queryRange(int left, int right) {
        return tree.query(left, right - 1);
    }

    // Removes a range from the module
    public void removeRange(int left, int right) {
        tree.modify(left, right - 1, -1);
    }
}

/**
 * Your RangeModule object will be instantiated and called as follows:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left, right);
 * boolean param_2 = obj.queryRange(left, right);
 * obj.removeRange(left, right);
 */
