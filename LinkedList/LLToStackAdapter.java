public class LLToStackAdapter {
    BasicOfLinkedList.LinkedList list;
    private LLToStackAdapter () {
        list = new BasicOfLinkedList.LinkedList();

    }
    int size() {
        return list.size;
    }
    void push(int val) {
        list.addFirst(val);
    }
    void pop () {
        if (size() == 0) {
            System.out.println("Stack Underflow.....");
        }
        else {
            list.removeFirst();
        }

    }
    int top () {
        if (size() == 0) {
            System.out.println("Stack Underflow.....");
            return -1;
        }
        else {
            return list.getFirst();
        }
    }
}
