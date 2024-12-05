package utils.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Counter<T> {
    HashMap<T, Long>count;
    public Counter(){
        count=new HashMap<>();
    }
    public Counter(int[] nums){
        count= (HashMap<T, Long>) Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num->num,Collectors.counting()));
    }
    public Counter(List<Integer> nums){
        count= (HashMap<T, Long>) nums.stream()
                .collect(Collectors.groupingBy(num->num,Collectors.counting()));
    }


    public void add(T num){
        count.put(num,count.getOrDefault(num,0L)+1);
    }

    public Long get(T num){
        return count.getOrDefault(num,0L);
    }

    public HashMap<T,Long> getCounts(){
        return count;
    }

    @Override
    public String toString(){
        return count.toString().replaceAll("=",":");
    }
}
