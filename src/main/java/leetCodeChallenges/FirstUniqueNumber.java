package leetCodeChallenges;

import java.util.HashMap;
import java.util.Map;

/**
 * You have a queue of integers, you need to retrieve the first unique integer
 * in the queue. Implement the FirstUnique class: FirstUnique(int[] nums)
 * Initializes the object with the numbers in the queue. int showFirstUnique()
 * returns the value of the first unique integer of the queue, and returns -1 if
 * there is no such integer. void add(int value) insert value to the queue.
 * 
 * Example 1: Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]] Output: [null,2,null,2,null,3,null,-1]
 * 
 * Explanation: FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2 firstUnique.add(5); // the queue
 * is now [2,3,5,5] firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2); // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3 firstUnique.add(3); // the queue
 * is now [2,3,5,5,2,3] firstUnique.showFirstUnique(); // return -1
 * 
 * Example 2: Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]] Output:
 * [null,-1,null,null,null,null,null,17]
 * 
 * Explanation: FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1 firstUnique.add(7); // the queue
 * is now [7,7,7,7,7,7,7] firstUnique.add(3); // the queue is now
 * [7,7,7,7,7,7,7,3] firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17); // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * 
 * Example 3: Input: ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]] Output: [null,809,null,-1]
 * 
 * Explanation: FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809 firstUnique.add(809); // the
 * queue is now [809,809] firstUnique.showFirstUnique(); // return -1
 *
 * Constraints: 1 <= nums.length <= 10^5 1 <= nums[i] <= 10^8 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */

public class FirstUniqueNumber {
	private class ListNode{
        ListNode next;
        ListNode prev;
        int val;
        
        public ListNode(int val){
            this.val = val;
            next=null;
            prev=null;
        }
    }
    
    private class MyDDL{
        private ListNode head;
        private ListNode tail;
        
        public MyDDL(){
            head = new ListNode(-1);
            tail = new ListNode(-1);
            
            head.next=tail;
            tail.prev=head;
        }
        
        public ListNode getFirst(){
            return head.next;
        }
        
        public boolean isEmpty(){
            return head.next == tail; 
        }
        
        public void remove(ListNode node){
            ListNode prev = node.prev;
            ListNode next = node.next;
            
            prev.next = next;
            next.prev = prev;
        }
        
        public ListNode append(int num){
            ListNode node = new ListNode(num);
            ListNode prev = tail.prev;
            prev.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = prev;
            return node;
        }
    }
    
    private MyDDL keys;
    private Map<Integer, ListNode> map;
    
    public void FirstUnique(int[] nums) {
        map = new HashMap<Integer, ListNode>();
        keys = new MyDDL();
        
        for(int n: nums){
            add(n);
        }
    }
    
    public int showFirstUnique() {
        if(keys.isEmpty()){
            return -1;
        }    
        return keys.getFirst().val;
    }
    
    public void add(int value) {
        if(map.containsKey(value)){
            if(map.get(value) != null){
                keys.remove(map.get(value));
                map.put(value, null);
            }
        }else{
        ListNode node = keys.append(value);
        map.put(value, node);
    }
    }
}
