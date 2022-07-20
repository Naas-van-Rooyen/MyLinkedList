public class MyLinkedList<E>  {
  private Node<E> head, tail;
 
  public MyLinkedList() {
     head = null;
	 tail = null;
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (head == null) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (head==null) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void prepend(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
   
    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void append(E item) {
    
	Node<E> newNode = new Node<>(item); // Create a new for element e

    if (head == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = newNode; // tail now points to the last node
    }
  }

  
  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (head == null) {
      return null;
    }
    else {
      E temp = head.element;
      head = head.next;
      if (head == null) {
        tail = null;
      }
      return temp;
    }
  }
  
	public boolean delete(E item)
   {
	   Node<E> ptr = head;
	   Node<E> prvPtr = null;
	   while (ptr!= null&& ((Comparable)ptr.element).compareTo(item)!= 0)
	   {
		   prvPtr=ptr;
		   ptr=ptr.next;
	   }
	   if (ptr == null)//item not found
		   return false;
	   if (ptr==head) // item is first element
		   head= head.next;
	   else // general case
		   prvPtr.next=ptr.next;
	   if (ptr==tail)// last element
		   tail=prvPtr;
	   return true;
   }

  public MyLinkedList merge(MyLinkedList paramlist)
	{
		Node<E> ptrThis, ptrParam;
		ptrThis = head;
		ptrParam = paramlist.head;
		MyLinkedList returnlist = new MyLinkedList();
		
		if(head==null)// caling list is empty - set this list to param list
		{
			while(ptrParam != null)
			{
				returnlist.append(ptrParam.element);
				ptrParam = ptrParam.next;
			}
			return returnlist;
			
		}
		
		if(paramlist.head == null)// param list is empty - make no changes
		{
			while(ptrThis != null)
			{
				returnlist.append(ptrThis.element);
				ptrThis = ptrThis.next;
			}
			return returnlist; 
		}
		
		while((ptrThis != null) && (ptrParam != null))// continue up to end of one list
		{
			if (((Comparable)ptrThis.element).compareTo(ptrParam.element)<=0)
			{
				returnlist.append(ptrThis.element);
				ptrThis = ptrThis.next;
			}
			else
			{
				returnlist.append(ptrParam.element);
				ptrParam = ptrParam.next;
			}
		}
		
		if(ptrThis == null)// copy rest of param list
		{
			while(ptrParam != null)
			{
				returnlist.append(ptrParam.element);
				ptrParam = ptrParam.next;
			}
		}
		if(ptrParam == null) // copy rest of calling list
		{
			while(ptrThis != null)
			{
				returnlist.append(ptrThis.element);
				ptrThis = ptrThis.next;
			}
		}
		return returnlist;
	}



  public String toString() {
    String result = "[";

    Node<E> ptr = head;
    for (ptr= head;ptr!=null; ptr=ptr.next) 
	{
		 result = result +  ptr.element.toString();     
		 if (ptr.next != null)
             result = result + ","; // add commas but not to the final 1   
	}
    result += "]"; // Insert the closing ] in the string
    return result;
  }


  public void clear() {
     head = tail = null;
  }
  
  public MyLinkedList makePalindrome()
  {
	  MyLinkedList list2 = new MyLinkedList();
	  MyLinkedList list3 = new MyLinkedList();
	  int counter = 0;
	  Node<E> ptr1 = head;
	  
	  if(head == null)
		  return list2;
	  
	  while(ptr1 != null)
	  {
		  list2.append(ptr1.element);
		  list3.append(ptr1.element);
		  ptr1 = ptr1.next;
		  counter++;
	  }
	  
	  for(int i = 0; i < counter; i++)
	  {
		  if(i == 0)
		  {
			  list2.append(tail.element);
			  list3.delete(tail.element);
		  }
		  else
		  {
			  list2.append(list3.tail.element);
			  list3.delete(list3.tail.element);
		  }
	  }
	  return list2;
  }


  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
	  next = null;
    }
  }
} // end myLinkedList class

