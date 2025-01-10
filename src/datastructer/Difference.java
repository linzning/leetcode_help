package datastructer;

public class Difference {
    int[]difference_arr;
    int N;
    /**
     * 根据已有数组构造差分数组
     * @param nums
     */
    public Difference(int[]nums){
        N=nums.length;
        difference_arr=new int[N];
        difference_arr[0]=nums[0];
        for(int i=1;i<N;i++){
            difference_arr[i-1]=nums[i]-nums[i-1];
        }
    }

    public Difference(int n){
        N=n;
        difference_arr=new int[N];
    }

    /**
     * 区间增[l,r]+=num
     * @param l 区间左端点
     * @param r 区间右端点
     * @param num 增加的值
     */
    public void add(int l,int r, int num){
        difference_arr[l]+=num;
        if(r+1<N)difference_arr[r+1]-=num;
    }

    /**
     * 区间减[l,r]-=num
     * @param l 区间左端点
     * @param r 区间右端点
     * @param num 增加的值
     */
    public void sub(int l,int r, int num){
        difference_arr[l]-=num;
        if(r+1<N)difference_arr[r+1]+=num;
    }
}
