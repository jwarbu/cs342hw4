// submitted by Jennifer Wartick cs342 on Feb.14th, 2017 ~4:30pm

import java.util.Scanner;
import java.io.*;
import java.util.jar.Pack200;

/**
 * GDList is a generic doubly linked list.
 * All elements are distinct
 **/
public class GDList<E> implements Cloneable
{
    /**
     * Nested class
     * GNode is a generic class representing a node in a list
     * E is generic type parameter of data
     * Has both previous and next pointers
     **/

// GNODE CLASS STARTS HERE
    public static class GNode<E> implements Cloneable
    {

        public E data;
        private GNode<E> previous;
        private GNode<E> next;

        // constructor
        public GNode(E e)
        {
            data = e;
            previous = null;
            next = null;
        }

        public E getData()
        {
            return data;
        }

        public GNode getPrevious()
        {
            return previous;
        }

        public GNode getNext()
        {
            return next;
        }

        public void setData(E e)
        {
            data = e;
        }

        public void setPrevious(GNode p)
        {
            previous = p;
        }

        public void setNext(GNode p)
        {
            next = p;
        }

        public GNode clone()
        {
            GNode answer;

            try
            {
                answer = (GNode) super.clone();
            } catch (CloneNotSupportedException e)
            {
                throw new RuntimeException("This class does not implement Cloneable.");
            }
            return answer;
        }

    }
// GNODE CLASS ENDS HERE


    public GNode<E> head;
    public GNode<E> tail;
    public int size;       // number of nodes in a list

    /**
     * no-arg constructor creates an empty list
     **/

    public GDList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * create a clone!
     */


    /**
     * add a new node with data e to the head
     * if a node with e already exists, return 1
     * if not, create and add a new node with e to the head (this new node is the head now), and return 0
     * increment the size
     **/
    public int addToHead(E e)
    {
        GNode temp = new GNode(e);
        if (head == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            if (findNode(head, e) == null) //checking for duplicates
            {
                temp.setNext(head);
                head.setPrevious(temp);
                head = temp;
            }
            else return 1;
        }
        size++;
        return 0;
    }

    /**
     * add a new node with data e to the tail
     * if a node with e already exists, return 1
     * if not, create and add a new node with e to the tail (this new node is the tail now), and return 0
     * increment the size
     **/
    public int addToTail(E e)
    {

        GNode temp = new GNode(e);
        if (head == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            if (findNode(head, e) == null)
            {
                temp.setPrevious(tail);
                tail.setNext(temp);
                tail = temp;
            }
            else return 1;
        }
        size++;
        return 0;
    }

    /**
     * insert a new node with data e after node n
     * n is not null
     * if a node with e already exists, return 1
     * if not, create and add a new node with e after node n, and return 0
     * increment the size
     **/
    public int addAfter(GNode n, E e)
    {

        if (n == null)
            throw new IllegalArgumentException
                    ("The node n cannot be null");

        if (findNode(head, e) != null) return 1;
        if (n == tail)
        {
            addToTail(e);
        }
        else
        {
            GNode temp = new GNode(e);
            GNode tempNext = n.getNext();
            temp.setNext(tempNext);
            tempNext.setPrevious(temp);
            temp.setPrevious(n);
            n.setNext(temp);
            size++;
        }
        return 0;
    }

    /**
     * insert a new node with data e before node n
     * n is not null
     * if a node with e already exists, return 1
     * if not, create and add a new node with e before node n, and return 0
     * increment the size
     **/
    public int addBefore(GNode n, E e)
    {

        if (n == null)
            throw new IllegalArgumentException
                    ("The node n cannot be null");

        if (findNode(head, e) != null) return 1;
        if (n == head) addToHead(e);
        else
        {
            GNode temp = new GNode(e);
            GNode tempPrevious = n.getPrevious();
            temp.setNext(n);
            n.setPrevious(temp);
            tempPrevious.setNext(temp);
            temp.setPrevious(tempPrevious);
            size++;
        }
        return 0;
    }

    /**
     * delete the node with data e
     * if a node with e does not exist, return null
     * if exists, delete the node and return the pointer to the deleted node
     * decrement the size
     **/
    public GNode deleteNode(E e)
    {
        // implement this method
        GNode temp = findNode(head, e); //temp is the node to delete

        if (temp == null)
        {
            return null;
        }

        else if (temp == head)
        {
            head = temp.getNext();
        }

        else if (temp == tail)
        {
            tail = temp.getPrevious();
            tail.setNext(null);
        }

        else
        {
            // replace previous node's next pointer with e's next pointer
            GNode tempPrevious = temp.getPrevious();
            tempPrevious.setNext(temp.getNext());

            // replace next node's previous pointer with e's previous pointer
            GNode tempNext = temp.getNext();
            tempNext.setPrevious(temp.getPrevious());
        }

        size--;
        return temp;

    }

    /**
     * delete the node which is located after the node with data e
     * if the node with e is tail, return null
     * if a node with e does not exist, return null
     * if a node with e exists, delete the node after that node and return the pointer to the deleted node
     * decrement the size
     **/
    public GNode deleteAfter(E e)
    {
        GNode temp = findNode(head, e);
        if (temp == tail || temp == null)
        {
            return null;
        }

        return (deleteNode((E) temp.getNext().data));
    }

    /**
     * delete the node which is located before the node with data e
     * if the node with e is head, return null
     * if a node with e does not exist, return null
     * if a node with e exists, delete the node before that node and return the pointer to the deleted node
     * decrement the size
     **/
    public GNode deleteBefore(E e)
    {
        GNode temp = findNode(head, e);
        if (temp == head || temp == null) return null;
        return (deleteNode((E) temp.getPrevious().data));
    }

    /**
     * find a node with element e
     * start the search beginning at node p
     * if node with e does not exist, return null
     * if node with e exists, return the pointer to the node
     **/
    public GNode findNode(GNode p, E e)
    {
        GNode current = p;
        while (current != null && current.data != e)
            current = current.getNext();
        return current;
    }


    /**
     * exchange two nodes n1 and n2
     * n1 is not null
     * n2 is not null
     * exchange node n1 and node n2 (do not just exchange the data).
     **/
    public void exchange(GNode n1, GNode n2)
    {
        // will cause problems if they are adjacent to each other or head/tail !!FIXED!!
        GNode tempNext1 = n1.getNext();
        GNode tempNext2 = n2.getNext();
        GNode tempPrevious1 = n1.getPrevious();
        GNode tempPrevious2 = n2.getPrevious();

        if(size == 2) // head and tail are swapping
        {
            GNode tempHead = head;
            GNode tempTail = tail;

            head = tempTail;
            tail = tempHead;
        }

        else if (n1.getNext() == n2) // set n1 previous to n2 and n2 previous to n1
        {
            n1.getPrevious().setNext(n2);
            n2.getNext().setPrevious(n1);

            n1.setPrevious(n2);
            n1.setNext(tempNext2);

            n2.setPrevious(tempPrevious1);
            n2.setNext(n1);

        }

        else if (n2.getNext() == n1)
        {
            n2.getPrevious().setNext(n1);
            n1.getNext().setPrevious(n2);

            n2.setPrevious(n1);
            n2.setNext(tempNext1);

            n1.setPrevious(tempPrevious2);
            n1.setNext(n2);
        }

        else if (head == n1 && tail == n2) // removes sections causing null pointer (n1 previous and n2 next)
        {
            n1.getNext().setPrevious(n2);
            n2.getPrevious().setNext(n1);

            n1.setPrevious(tempPrevious2);
            n1.setNext(tempNext2);

            n2.setNext(tempNext1);

            head = n2;
            tail = n1;

        }

        else if(head == n2 && tail == n1)
        {
            n1.getPrevious().setNext(n2);
            n2.getNext().setPrevious(n1);

            n1.setNext(tempNext2);

            n2.setPrevious(tempPrevious1);
            n2.setNext(tempNext1);

            head = n1;
            tail = n2;

        }

        else if (head == n1)  // removes n1.getPrevious, n2setPrevious to prevent nullpointer
        {
            n1.getNext().setPrevious(n2);
            n2.getPrevious().setNext(n1);
            n2.getNext().setPrevious(n1);

            n1.setPrevious(tempPrevious2);
            n1.setNext(tempNext2);

            n2.setNext(tempNext1);

            head = n2;
        }

        else if (head == n2) // removes n2.getPrevious, n1.setPrevious to prevent nullpointer
        {
            n1.getPrevious().setNext(n2);
            n1.getNext().setPrevious(n2);
            n2.getNext().setPrevious(n1);

            n1.setNext(tempNext2);

            n2.setPrevious(tempPrevious1);
            n2.setNext(tempNext1);

            head = n1;
        }

        else if (tail == n1) // removes n1.getNext
        {
            n1.getPrevious().setNext(n2);
            n2.getPrevious().setNext(n1);
            n2.getNext().setPrevious(n1);

            n1.setPrevious(tempPrevious2);
            n1.setNext(tempNext2);

            n2.setPrevious(tempPrevious1);
            n2.setNext(tempNext1);


            tail = n2;
        }

        else if (tail == n2) // removes n2.getNext to prevent nullpointer
        {
            n1.getPrevious().setNext(n2);
            n2.getPrevious().setNext(n1);
            n2.getNext().setPrevious(n1);

            n1.setPrevious(tempPrevious2);
            n1.setNext(tempNext2);

            n2.setPrevious(tempPrevious1);
            n2.setNext(tempNext1);

            tail = n1;
        }
        else
        {
            n1.getPrevious().setNext(n2);
            n1.getNext().setPrevious(n2);
            n2.getPrevious().setNext(n1);
            n2.getNext().setPrevious(n1);

            n1.setPrevious(tempPrevious2);
            n1.setNext(tempNext2);

            n2.setPrevious(tempPrevious1);
            n2.setNext(tempNext1);
        }



    }

    /**
     * add a new node with e at the specified position
     * pos specifies where new node is added
     * pos of the first element in a list is 0
     * pos >= 0
     * if a node with e already exists, return 1
     * if not, create and add a new node with e at position pos and return 0
     * increment the size
     */
    public int addPos(E e, int pos)
    {
        // implement this method

        if (findNode(head, e) != null)
        {
            return 1;
        }

        else // do not need to explicitly increment size as is done within the called methods
        {
            if (pos == 0)
            {
                addToHead(e);
            }

            if (pos == size)
            {
                addToTail(e);
            }

            if (pos > 0 && pos < size)
            {
                // walk through list until you hit pos
                GNode pointer = head;

                for (int i = 1; i < pos; i++) // start at 1 since head is declared outside loop (?)
                {
                    pointer = pointer.getNext(); // sets pointer to the node previous to desired position
                }

                addAfter(pointer, e);

            }

            // if (pos > size)   // this will create empty nodes between size and pos and set new node as tail??

            return 0;
        }

    }

    /**
     * replace the node at the specified position with a new node with e
     * pos specifies the position of the node to be replaced
     * pos of the first element in a list is 0
     * pos >= 0
     * if a node with e already exists, return null
     * if not, create a new node with e and let it replace the node at position pos
     * return the pointer to the replaced node
     */
    public GNode replacePos(E e, int pos)
    {
        // implement this method

        if (findNode(head, e) != null)
        {
            return null;
        }

        else
        {
            GNode newNode = new GNode(e);
            GNode oldNode = null;

            if (pos == 0)
            {
                oldNode = head;
                newNode.setPrevious(oldNode.getPrevious());
                newNode.setNext(oldNode.getNext());

                // update next node's pointer
                oldNode.getNext().setPrevious(newNode);

                head = newNode;
            }

            if (pos == size)
            {
                oldNode = tail;
                newNode.setPrevious(oldNode.getPrevious());
                newNode.setNext(oldNode.getNext());

                //update previous node's pointer
                oldNode.getPrevious().setNext(newNode);

                tail = newNode;
            }

            if (pos > 0 && pos < size)
            {
                GNode pointer = head;

                for (int i = 1; i <= pos; i++)  // walk through list until you find node at pos
                {
                    pointer = pointer.getNext();
                }
                oldNode = pointer;

                // give newNode pointers from oldNode
                newNode.setPrevious(oldNode.getPrevious());
                newNode.setNext(oldNode.getNext());
                // update pointers for previous and next nodes
                oldNode.getPrevious().setNext(newNode);
                oldNode.getNext().setPrevious(newNode);

            }

            return oldNode;
        }

    }

    public void printList()
    {
        System.out.print("Number of nodes = " + size + ", List is: ");
        if (head != null)
        {
            GNode current = head;
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.getNext();
            }
        }
        else
        {
            System.out.println("The list is empty");
        }
        System.out.println();
    }
 // this method is specific to CourseRecords
    public CourseRecord findData(String s)
    {
        if(head != null)
        {
            GNode current = head;
            CourseRecord courses = (CourseRecord)current.data;
            while (current != null)
            {
                if(courses.getName().equals(s))
                {
                    break;
                }

                else
                {
                    current = current.getNext();
                    courses = (CourseRecord)current.data;
                }
            }
            return courses;
        }

        else
        {
            return null;
        }
    }

    public void prettyPrint()
    {
        if (head != null)
        {
            GNode current = head;
            CourseRecord courses = (CourseRecord)current.data;

            for (int i = 0; i<size; i++)
            {
                courses.displayCourse();
                current = current.getNext();
                if (current!=null)
                {
                    courses = (CourseRecord)current.data;
                }
                System.out.println();
            }
        }
    }


}
