class SegmentTree {
    class Node {
        public int numberOfPeaks;
        public int firstNumber;
        public int secondNumber;
        public int lastNumber;
        public int secondLastNumber;
        public int size;

        public Node(int peaks, int fN, int sN, int lN, int sLN, int size) {
            this.numberOfPeaks = peaks;
            this.firstNumber = fN;
            this.secondNumber = sN;
            this.lastNumber = lN;
            this.secondLastNumber = sLN;
            this.size = size;
        }
    }

    private Node[] segmentTreeArr;
    private int size;

    public SegmentTree(int size, int[] arr) {
        this.segmentTreeArr = new Node[4 * size];
        this.size = size;
        buildTree(arr, 0, size - 1, 1);
    }

    private void buildTree(int[] arr, int start, int end, int sgIndex) {
        if (start == end) {
            segmentTreeArr[sgIndex] = new Node(0, arr[start], Integer.MAX_VALUE, arr[start], Integer.MAX_VALUE, 1);
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(arr, start, mid, 2 * sgIndex);
        buildTree(arr, mid + 1, end, 2 * sgIndex + 1);
        mergeNodes(sgIndex);
    }

    private void mergeNodes(int sgIndex) {
        Node leftNode = segmentTreeArr[2 * sgIndex];
        Node rightNode = segmentTreeArr[2 * sgIndex + 1];

        int numberOfPeaks = leftNode.numberOfPeaks + rightNode.numberOfPeaks;

        // Check if there is a peak at the boundary of left and right segments
        if (leftNode.lastNumber > leftNode.secondLastNumber && leftNode.lastNumber > rightNode.firstNumber) {
            numberOfPeaks++;
        } else if (rightNode.firstNumber > leftNode.lastNumber && rightNode.firstNumber > rightNode.secondNumber) {
            numberOfPeaks++;
        }

        segmentTreeArr[sgIndex] = new Node(
            numberOfPeaks,
            leftNode.firstNumber,
            leftNode.size == 1 ? rightNode.firstNumber : leftNode.secondNumber,
            rightNode.lastNumber,
            rightNode.size == 1 ? leftNode.lastNumber : rightNode.secondLastNumber,
            leftNode.size + rightNode.size
        );
    }

    public void updateNumberAtIndex(int position, int number) {
        updateSegments(1, 0, size - 1, position, number);
    }

    private void updateSegments(int sgIndex, int left, int right, int arrPos, int num) {
        if (left == right) {
            if (right == arrPos) {
                segmentTreeArr[sgIndex] = new Node(0, num, Integer.MAX_VALUE, num, Integer.MAX_VALUE, 1);
            }
            return;
        }

        int mid = left + (right - left) / 2;
        if (arrPos <= mid) {
            updateSegments(sgIndex * 2, left, mid, arrPos, num);
        } else {
            updateSegments(sgIndex * 2 + 1, mid + 1, right, arrPos, num);
        }
        mergeNodes(sgIndex);
    }

    public int queryNumberOfPeaks(int left, int right) {
        return queryUtil(1, 0, size - 1, left, right);
    }

    private int queryUtil(int sgIndex, int arrLeft, int arrRight, int queryLeft, int queryRight) {
        if (queryLeft <= arrLeft && queryRight >= arrRight) {
            return segmentTreeArr[sgIndex].numberOfPeaks;
        }
        if (arrRight < queryLeft || arrLeft > queryRight) {
            return 0;
        }

        int mid = arrLeft + (arrRight - arrLeft) / 2;
        int leftPeaks = queryUtil(sgIndex * 2, arrLeft, mid, queryLeft, queryRight);
        int rightPeaks = queryUtil(sgIndex * 2 + 1, mid + 1, arrRight, queryLeft, queryRight);
        int ans = leftPeaks + rightPeaks;

        Node leftNode = segmentTreeArr[2 * sgIndex];
        Node rightNode = segmentTreeArr[2 * sgIndex + 1];
        leftNode.secondNumber = leftNode.size == 1 ? rightNode.firstNumber : leftNode.secondNumber;
        rightNode.secondLastNumber = rightNode.size == 1 ? leftNode.lastNumber : rightNode.secondLastNumber;

        // if (mid >= queryLeft && mid <= queryRight && (mid + 1) >= queryLeft && (mid + 1) <= queryRight) {
            if ((mid) >= queryLeft && (mid+2) <= queryRight &&segmentTreeArr[sgIndex * 2].lastNumber < segmentTreeArr[sgIndex * 2 + 1].firstNumber
                    && segmentTreeArr[sgIndex * 2 + 1].firstNumber > segmentTreeArr[sgIndex * 2 + 1].secondNumber) {
                ans += 1;
            } else if (((mid-1) >= queryLeft) && ((mid+1) <= queryRight) && segmentTreeArr[sgIndex * 2].secondLastNumber < segmentTreeArr[sgIndex * 2].lastNumber
                    && segmentTreeArr[sgIndex * 2 + 1].firstNumber < segmentTreeArr[sgIndex * 2].lastNumber) {
                ans += 1;
            }
        // }

        return ans;
    }
}

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        SegmentTree peakCounter = new SegmentTree(nums.length, nums);
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int queryType = query[0];
            if (queryType == 1) {
                int left = query[1];
                int right = query[2];
                int peaks = peakCounter.queryNumberOfPeaks(left, right);
                result.add(peaks);
            } else {
                int index = query[1];
                int value = query[2];
                peakCounter.updateNumberAtIndex(index, value);
            }
        }

        return result;
    }
}
