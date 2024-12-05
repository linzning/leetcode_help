package datastructer;

/**
 * 堆存储的线段树，没有动态开点
 * 支持区间修改和区间增减
 */
public class SegmentTree {
    private int MAXN;
    private int[] arr;// arr[]为原序列的信息从0开始，但在arr里是从1开始的
    private int[] sum;// sum[]模拟线段树维护区间和
    private int[] lazy;// lazy[]为累加和懒惰标记
    private int[] change;// change[]为更新的值
    private boolean[] update;// update[]为更新慵懒标记

    /**
     * 从数组中初始化线段树
     * @param origin
     */
    public SegmentTree(int[] origin) {
        MAXN = origin.length + 1;
        arr = new int[MAXN]; // arr[0] 不用 从1开始使用
        for (int i = 1; i < MAXN; i++) {
            arr[i] = origin[i - 1];
        }
        sum = new int[MAXN << 2]; // 某一个范围的累加和信息
        lazy = new int[MAXN << 2]; // 某一个范围没有往下传的累加任务
        change = new int[MAXN << 2]; // 某一个范围有没有更新操作的任务
        update = new boolean[MAXN << 2]; // 某一个范围更新任务，更新成了什么
    }

    /**
     * 初始化sum数组的递归方法
     * @param l arr左下标，包含
     * @param r arr右下标，包含
     * @param rt 这个范围在sum中的下标
     */
    public void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, rt << 1);
        build(mid + 1, r, rt << 1 | 1);
        pushUp(rt);
    }

    /**
     * 下往上更新
     * @param rt
     */
    private void pushUp(int rt) {
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    /**
     * 上往下更新，支持区间加，区间修改的pushdown
     * @param rt 在线段树节点中的下标
     * @param ln 左子树元素结点个数
     * @param rn 右子树结点个数
     */
    private void pushDown(int rt, int ln, int rn) {
        if (update[rt]) {
            // 将子节点懒更新标记位ture
            update[rt << 1] = true;
            update[rt << 1 | 1] = true;
            // 更新的值
            change[rt << 1] = change[rt];
            change[rt << 1 | 1] = change[rt];
            // 标记累加和懒惰标记是0,更改之后前面的add标记就作废了，所以一定要先处理区间更新
            lazy[rt << 1] = 0;
            lazy[rt << 1 | 1] = 0;
            // 更新sum的值
            sum[rt << 1] = change[rt] * ln;
            sum[rt << 1 | 1] = change[rt] * rn;
            update[rt] = false;
        }
        // 有累加和懒惰标记
        if (lazy[rt] != 0) {
            // 累加和懒惰标记下放
            lazy[rt << 1] += lazy[rt];
            lazy[rt << 1 | 1] += lazy[rt];
            // 更新子节点sum
            sum[rt << 1] += lazy[rt] * ln;
            sum[rt << 1 | 1] += lazy[rt] * rn;
            // 已经下放就归0
            lazy[rt] = 0;
        }
    }

    /**
     * 区间修改成特定值C
     * @param L arr左下标，也就是修改的区间，包含
     * @param R arr右下标
     * @param C 更新成的值
     * @param l 当前节点的左边界
     * @param r 当前节点的右边界
     * @param rt 当前节点下标
     */
    public void update(int L, int R, int C, int l, int r, int rt) {
        // 修改范围覆盖整个节点,整个节点都要修改
        if (L <= l && r <= R) {
            update[rt] = true;
            change[rt] = C;
            sum[rt] = C * (r - l + 1);
            lazy[rt] = 0;
            return;
        }
        int mid = (l + r) >> 1;
        // 当前任务躲不掉，无法懒更新，要往下发
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            update(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            update(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        // 下面更新完后重新计算当前节点sum
        pushUp(rt);
    }

    /**
     * 区间增加特定值C
     * @param L arr左下标 修改的区间
     * @param R arr右下标
     * @param C 增加的值
     * @param l 当前节点的左边界
     * @param r 前节点的右边界
     * @param rt 当前节点下标
     */
    public void add(int L, int R, int C, int l, int r, int rt) {
        // 修改范围覆盖整个节点,整个节点都要修改
        if (L <= l && r <= R) {
            // 直接修改sum,并修改累加和懒标记
            sum[rt] += C * (r - l + 1);
            lazy[rt] += C;
            return;
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            add(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }
    // 1~6 累加和是多少？ 1~8 rt

    /**
     * 查询区间和
     * @param L 区间arr左下标
     * @param R 区间arr右下标
     * @param l 节点左边界
     * @param r 节点右边界
     * @param rt 节点下标
     * @return 区间和
     */
    public long query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return sum[rt];
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        long ans = 0;
        if (L <= mid) {
            ans += query(L, R, l, mid, rt << 1);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, r, rt << 1 | 1);
        }
        return ans;
    }
}
