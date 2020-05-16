public class LinkedList {
    Node head;
    private int size;
    Node tail;

    /**
     * Linked List Constructor to
     * initialize the variables
     */
    LinkedList(){
        head = null;
        size = 0;
        tail = null;
    }

    /**
     * Node Class
     */
    class Node{
        String value;
        Node next;

        /**
         * Constructor for Node
         * @param val
         */
        Node(String val){
            this.value = val;
            this.next = null;
        }
    }

    /**
     * Gets size of the List
     * @return
     */
    int getSize(){
        return size;
    }

    /**
     * Add elements to the tail of the list
     * Runtime - O(1)
     * @param val
     */
    void enqueue(String val){
        Node toAdd = new Node(val);
        if (size == 0){
            head = toAdd;
            tail = toAdd;
        } else {
            tail.next = toAdd;
            tail = toAdd;
        }
        size++;
    }

    /**
     * Add element to the head of the list
     * Runtime - O(1)
     * @param val
     */
    void push(String val){
        Node toAdd = new Node(val);
        if (size == 0){
            head = toAdd;
            tail = toAdd;
        } else {
            toAdd.next = head;
            head = toAdd;
        }
        size++;
    }

    /**
     * Add element anywhere in the list
     * Runtime - O(1)
     * @param val
     * @param pos - if 0 it means to insert it at head, if pos == size then it means insert it at tail
     */
    void addAnywhere(String val, int pos){
        if (pos < 0 || pos > size){
            System.out.println("Please enter a valid position");
            return;
        }

        if (pos == 0){
            push(val);
            return;
        } else if(pos == size){
            enqueue(val);

        } else {
            Node toAdd = new Node(val);
            Node curr = head;
            Node prev = curr;
            int counter = pos;
            while(counter != 0){
                prev = curr;
                curr = curr.next;
                counter--;
            }
            prev.next = toAdd;
            toAdd.next = curr;
            size++;

        }

    }

    /**
     * Removes the head of the List
     * @return
     */
    Node dequeue(){
        Node toRemove = head;
        head = head.next;
        size--;
        return toRemove;
    }

    /**
     * Removes an element anywhere in the List
     * @return
     */
    Node removeAnywhere(int pos){
        if (pos < 0 || pos > size-1){
            return null;
        }
        if (pos == 0){
            return dequeue();
        }

        int counter = pos;
        Node curr = head;
        Node prev = curr;

        while(counter != 0){
            prev = curr;
            curr = curr.next;
            counter--;
        }
        Node toRemove = curr;
        prev.next = prev.next.next;
        if (curr.next == null){
            tail = prev;
        }
        size--;
        return toRemove;
    }


    /**
     * Prints all elements of the list
     * Runtime - O(N)
     */
    void printList(){
        Node curr = head;
        System.out.printf("%s ", curr.value);

        while (curr.next != null){
            System.out.printf("-> %s ", curr.next.value);
            curr = curr.next;
        }
    }
}
