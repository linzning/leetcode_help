package linklist;

import java.util.Random;

public class ListNode {
    public Integer val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "val: " + this.val + " next: " + (this.next == null ? "null" : this.next.val);
    }

    /**
     * 数组构建链表
     * @param listValues
     * @return
     */
    public static ListNode buildList(int[] listValues) {
        if (listValues == null || listValues.length == 0)
            return null;

        ListNode dummyHead = new ListNode(); // Dummy head node to simplify logic
        ListNode current = dummyHead;

        for (int val : listValues) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummyHead.next; // Skip the dummy head node
    }


    /**
     * 打印链表
     * @param head
     */
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }


    /**
     * 获取链表长度
     * @param head
     * @return
     */
    public static int getLength(ListNode head){
        int ans=0;
        while(head!=null){
            ans++;
            head=head.next;
        }
        return ans;
    }

    /**
     * 链表倒转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        ListNode dummy=new ListNode(-1,null);
        ListNode cur=head,nex;
        while(cur!=null){
            nex=cur.next;
            cur.next=dummy.next;
            dummy.next=cur;
            cur=nex;
        }
        return dummy.next;
    }

    /**
     * 链表插入排序
     * @param head
     * @return
     */
    public static ListNode insertSort(ListNode head){
        ListNode dummy=new ListNode(-1,head);
        ListNode cur=head.next,nex,pre;
        head.next=null;
        while(cur!=null){
            nex=cur.next;
            pre=dummy;
            while(pre.next!=null&&pre.next.val<cur.val){
                pre=pre.next;
            }
            cur.next=pre.next;
            pre.next=cur;
            cur=nex;
        }
        return dummy.next;
    }

    /**
     * 找到链表中点，偏左
     * @param head
     * @return
     */
    public static ListNode getMiddle_l(ListNode head){
        ListNode l=head,r=head.next;
        while(r!=null&&r.next!=null){
            l=l.next;
            r=r.next.next;
        }
        return l;
    }

    /**
     * 找到入环节点
     * @param head
     * @return
     */
    public ListNode getCircleHead(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {//存在环
                //找入环节点
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }


    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoSortedList(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }


    /**
     * 链表归并排序
     * @param head
     * @return
     */
    public static ListNode listMergeSort(ListNode head){
        if(head.next==null)return head;
        ListNode pre= linklist.ListNode.getMiddle_l(head);
        ListNode head1=pre.next;
        pre.next=null;
        head=listMergeSort(head);
        head1=listMergeSort(head1);
        return mergeTwoSortedList(head,head1);
    }

    /**
     * 均匀随机获取链表元素
     */
    public static int getRandom(ListNode head) {
        Random r=new Random();
        ListNode p=head;
        int ans=0;
        int k=0;
        while(p!=null){
            k++;
            int ran=r.nextInt(k);
            if(ran==0){
                ans=p.val;
            }
            p=p.next;
        }
        return ans;
    }
}
