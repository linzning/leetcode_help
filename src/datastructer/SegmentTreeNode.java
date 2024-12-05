package datastructer;

import org.w3c.dom.Node;

public class SegmentTreeNode {
    SegmentTreeNode ls, rs;
    int val;
    //懒标记
    int add;

    public static void build(SegmentTreeNode root, int l, int r, int[] arr) {
        if (l == r) {
            root.val = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        if (root.ls == null) root.ls = new SegmentTreeNode();
        if (root.rs == null) root.rs = new SegmentTreeNode();
        build(root.ls, l, mid, arr);
        build(root.rs, mid + 1, r, arr);
        pushup(root);
    }

    /**
     * 从上往下更新
     *
     * @param p
     * @param ln
     * @param rn
     */
    public static void pushdowm(SegmentTreeNode p, int ln, int rn) {
        if (p.ls == null) p.ls = new SegmentTreeNode();
        if (p.rs == null) p.rs = new SegmentTreeNode();
        if (p.add == 0) return;
        // 懒标记下放
        p.ls.add = p.add;
        p.rs.add = p.add;
        // 值更新
        p.ls.val += p.add * ln;
        p.rs.val += p.add * rn;
        // 当前节点懒标记清空
        p.add = 0;
    }

    /**
     * 从下往上更新
     *
     * @param p
     */
    public static void pushup(SegmentTreeNode p) {
        p.val = p.ls.val + p.rs.val;
    }

    /**
     * 区间增减
     *
     * @param p 当前节点
     * @param L 修改的左下标
     * @param R 修改的右下标
     * @param l 当前节点的左边界
     * @param r 当前节点的右边界
     * @param x 增加的值
     */
    public static void update(SegmentTreeNode p, int L, int R, int l, int r, int x) {
        if (L <= l && R >= r) {
            p.val += x * (r - l + 1);
            p.add = x;
            return;
        }
        int mid = l + ((r - l) >> 1);
        pushdowm(p, mid - l + 1, r - mid);
        if (L <= mid) {
            update(p.ls, L, R, l, mid, x);
        }
        if (R > mid) {
            update(p.rs, L, R, mid + 1, r, x);
        }
        pushup(p);
    }

    /**
     * 区间查询
     *
     * @param p 当前节点
     * @param L 查询左下标
     * @param R 查询右下标
     * @param l 节点左边界
     * @param r 节点右边界
     * @return 区间和
     */
    public static long query(SegmentTreeNode p, int L, int R, int l, int r) {
        if (L <= l && R >= r) {
            return p.val;
        }
        int m = l + ((r - l) >> 1);
        pushdowm(p, m - l + 1, r - m);
        long ans = 0;
        if (L <= m) {
            ans += query(p.ls, L, R, l, m);
        }
        if (R > m) {
            ans += query(p.rs, L, R, m + 1, r);
        }
        return ans;
    }

}
