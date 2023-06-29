public class LLToQueueAdapter {
    BasicOfLinkedList.LinkedList list;
    private LLToQueueAdapter () {
        list = new BasicOfLinkedList.LinkedList();
    }
    int size() {
        return list.size;
    }
    void add(int val) {
        list.addLast(val);
    }
    void remove () {
        if (size() == 0) {
            System.out.println("Queue Underflow.....");
        }
        else {
            list.removeFirst();
        }
    }
    int peek () {
        if (size() == 0) {
            System.out.println("Queue Underflow.....");
            return -1;
        }
        else {
            return list.getFirst();
        }
    }
}
