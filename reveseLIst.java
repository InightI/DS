package lx20190903;


class ListNode
{
	int val;
	ListNode next;
	
	public  ListNode(int val)
	{
		this.val = val;
	}
	
}



public class reveseLIst 
{

	
	
//	
//	   public static ListNode ReverseLink(ListNode first){
//	        ListNode cur = first;      //原链表头结点
//	        ListNode node = null;    //暂时保存的原来的头结点
//	        ListNode result = null;   //新链表头结点
//	        while(cur != null){
//	         node = cur;       
//	         cur = cur.next;
//	          node.next = result;      
//	         result = node;
//	            }
//	            return result;
//	 
//	    }  
	   
	   public static ListNode ReverseList(ListNode head)
	   {
		   ListNode cur = head;
		   ListNode node = null;
		   ListNode newList = null;
		   while(cur != null)
		   {
			   node = cur;//原来的头(cur)被装进了node飞船,ndoe飞船来到了新的领土
			   cur = cur.next; // 这是原来链表的指针,因为头被删掉了,自己往后走
			   node.next = newList;//node里装的是原国王(cur),原国王抵达新领土,代码只有结果,无细致过程
			   newList = node;//这里newList指新国王,上一行指新领土
		   }
		   return newList;
	   }
	
	   
	   public static void  display(ListNode head)
	   {
		   for(ListNode cur = head; cur != null; cur = cur.next )
		   {
			   System.out.println(cur.val + "");
		   }
		   System.out.println();
	   }
	   public static void testReverseList()
	   {
		   
		   
		   System.out.println("测试逆置链表");
		   ListNode n1 = new ListNode (1);
		   ListNode n2 = new ListNode (2);
		   ListNode n3 = new ListNode (3);
		   ListNode n4 = new ListNode (4);
		   ListNode n5 = new ListNode (5);
		   
		   n1.next = n2;
		   n2.next = n3;
		   n3.next = n4;
		   n4.next = n5;
		 System.out.println("原链表为,执行链表逆置");  
		display(n1);
		   System.out.println("==================");
		   System.out.println("链表逆置后为");
		ListNode newList = ReverseList(n1);   
		display(newList);
		   
	   }
	   
	   public static void main(String[] args)
	   {
		   testReverseList();
	   }
	   

}	
	
