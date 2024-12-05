package utils.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 计数器类，暂时只支持Integer,Character
 * @param <T>
 */
public class Counter<T> {
    private final HashMap<T, Long> count;
    private final Class<T> typeClass;

    public Counter() {
        count = new HashMap<>();
        typeClass = null;
    }

    @SuppressWarnings("unchecked")
    public Counter(int[] nums) {
        typeClass = (Class<T>) Integer.class;
        count = (HashMap<T, Long>) Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
    }

    @SuppressWarnings("unchecked")
    public Counter(List<Integer> nums) {
        typeClass = (Class<T>) Integer.class;
        count = (HashMap<T, Long>) nums.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
    }

    @SuppressWarnings("unchecked")
    public Counter(char[] nums) {
        typeClass = (Class<T>) Character.class;
        count = new HashMap<>();
        for (char c : nums) {
            count.put((T) Character.valueOf(c),
                    count.getOrDefault((T) Character.valueOf(c), 0L) + 1);
        }
    }

    @SuppressWarnings("unchecked")
    public Counter(String s) {
        typeClass = (Class<T>) Character.class;
        count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put((T) Character.valueOf(c),
                    count.getOrDefault((T) Character.valueOf(c), 0L) + 1);
        }
    }

    /**
     * 增加次数
     * @param num
     */
    public void add(T num) {
        assert typeClass.isInstance(num);
        count.put(num, count.getOrDefault(num, 0L) + 1);
    }

    /**
     * 获取次数
     * @param num
     * @return
     */
    public Long get(T num) {
        assert typeClass.isInstance(num);
        return count.getOrDefault(num, 0L);
    }

    public HashMap<T, Long> getCounts() {
        return count;
    }

    @Override
    public String toString() {
        return count.toString().replaceAll("=", ":");
    }
}
