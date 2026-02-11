public class SegmentTree {
    public int[] segmin, segmax, lazy;

    public SegmentTree(int n) {
        lazy = new int[4 * n + 1];
        segmax = new int[4 * n + 1];
        segmin = new int[4 * n + 1];
    }

    public void push(int idx, int l, int r) {
        if (lazy[idx] != 0) {
            segmin[idx] += lazy[idx];
            segmax[idx] += lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    public void updateRange(int idx, int l, int r, int low, int high, int val) {
        push(idx, l, r);

        if (r < low || high < l) {
            return;
        }

        if (low <= l && r <= high) {
            lazy[idx] += val;
            push(idx, l, r);
            return;
        }

        int mid = l + (r - l) / 2;

        updateRange(2 * idx + 1, l, mid, low, high, val);
        updateRange(2 * idx + 2, mid + 1, r, low, high, val);

        segmin[idx] = Math.min(segmin[2 * idx + 1], segmin[2 * idx + 2]);
        segmax[idx] = Math.max(segmax[2 * idx + 1], segmax[2 * idx + 2]);
    }

    public int get(int idx, int l, int r) {
        push(idx, l, r);

        if (segmin[idx] > 0 || segmax[idx] < 0)
            return -1;

        if (l == r)
            return l;

        int mid = l + (r - l) / 2;

        int left = get(2 * idx + 1, l, mid);
        if (left != -1)
            return left;

        int right = get(2 * idx + 2, mid + 1, r);
        return right;
    }
}