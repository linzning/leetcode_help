package datastructer;

/**
 * 求区间最大最小值问题，不支持数组修改
 */
public class STtable {
    int[][] maxST;
    int[][] minST;
    int[] lg;
    int n;

    /**
     * 初始化ST表
     * 注意:查询时下标要+1!
     * @param nums
     */
    public STtable(int[]nums){
        n=nums.length;
        int k = (int) (Math.log(n * 1.0) / Math.log(2.0));
        maxST = new int[n + 1][k + 1];
        minST = new int[n + 1][k + 1];
        lg = new int[n + 1];

        /* f[i][j]表示[i,i+2^j-1]的最值 */
        for (int i = 1; i <= n; i++) {
            maxST[i][0] = nums[i - 1];
            minST[i][0] = nums[i - 1];
        }

        /* lg[i]=log_2(i)向下取整 */
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i >> 1] + 1;
        }

        /* f[i][j]=max(f[i][j-1],f[i+2^(j-1)][j-1] */
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n - (1 << j) + 1; i++) {
                maxST[i][j] = Math.max(maxST[i][j - 1], maxST[i + (1 << (j - 1))][j - 1]);
                minST[i][j] = Math.min(minST[i][j - 1], minST[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    /**
     * 求区间最大值
     * @param l
     * @param r
     * @return
     */
    public int rangeMax(int l, int r) {
        int k = lg[r - l + 1];
        /*
        k=log_2(r-l+1)向下
        这两部分会有重叠区间，但max(x,x)=x，是可重复贡献问题，所以没事
         */
        return Math.max(maxST[l][k], maxST[r - (1 << k) + 1][k]);
    }

    /**
     * 求区间最小值
     * @param l
     * @param r
     * @return
     */
    public int rangeMin(int l, int r) {
        int k = lg[r - l + 1];
        return Math.min(minST[l][k], minST[r - (1 << k) + 1][k]);
    }

    public static void main(String[] args) {
        int[]nums=new int[]{2,3,1,2};

        STtable st=new STtable(nums);
        int n=nums.length;
        System.out.print("\t");
        for(int i=0;i<n;i++){
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(i+"\t");
            for(int j=0;j<n;j++){
                if(i>j) System.out.print("\t");
                else System.out.print(st.rangeMax(i+1,j+1)+"\t");
            }
            System.out.println();
        }
    }
}
