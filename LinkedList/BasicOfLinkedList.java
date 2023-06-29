public class BasicOfLinkedList {
    public static class Node {
        int data;
        Node next;
    }
    public static class LinkedList {
        Node head, tail;
        int size;
        public void addLast (int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }
            else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        public int size () {
            return size;
        }
        public void display () {
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        public void removeFirst () {
            if (size == 0) {
                System.out.println("List is Empty !!");
            }
            else if (size == 1) {
                head = tail = null;
                size = 0;
            }
            else {
                head = head.next;
                size--;
            }

        }
        public int getFirst () {
            if (size == 0) {
                System.out.println("List is Empty !!");
                return -1;
            } else {
                return head.data;
            }
        }
        public int getLast () {
            if (size == 0) {
                System.out.println("List is Empty !!");
                return -1;
            } else {
                return tail.data;
            }
        }
        public int getAt (int idx) {
            if (size == 0) {
                System.out.println("List is Empty !!");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments !!");
                return -1;
            }
            else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }
        public void addFirst (int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if (size == 0){
                tail = temp;
            }
            size++;
        }
        public void addAt (int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid Arguments.........");
            }
            else if (idx == 0) {
                addFirst(val);
            }
            else if (size == idx) {
                addLast(val);
            }
            else {
                Node node = new Node();
                node.data = val;
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }
        public void removeLast () {
            if (size == 0) {
                System.out.println("List is Empty !!");
            }
            else if (size == 1) {
                head = tail = null;
                size = 0;
            }
            else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
                size--;
            }
        }
        private Node getAtNode (int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }
        public void reverseLinkedList () {
            int leftIdx = 0;
            int rightIdx = size - 1;
            while (leftIdx < rightIdx) {
                Node left = getAtNode(leftIdx);
                Node right = getAtNode(rightIdx);
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                leftIdx++;
                rightIdx--;
            }
        }
        public void reversePointerIterative () {
            Node pre = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            temp = temp;
        }
        public void removeAt (int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid Argument......");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            }
            else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
       }
        public int kthElement (int k) {
            Node s = head;
            Node f = head;
            for (int i = 0; i < k; i++) {
                f = f.next;
            }
            while (f != null) {
                s = s.next;
                f = f.next;
            }
            return s.data;
        }
        public int middleOfLinkedList () {
            Node s = head;
            Node f = head;
            while (f.next != null && f.next.next != null) {
                s = s.next;
                f = f.next.next;
            }
            return s.data;
        }
        public static LinkedList mergeTwoSortedList (LinkedList l1, LinkedList l2){
            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();

            while (one != null && two != null) {
                if (one.data < two.data) {
                    res.addLast(one.data);
                    one = one.next;
                }
                else {
                    res.addLast(two.data);
                    two = two.next;
                }
            }
            while (one != null) {
                res.addLast(one.data);
                one = one.next;
            }
            while (two != null) {
                res.addLast(two.data);
                two = two.next;
            }
            return res;
        }
        public static LinkedList mergeSort (Node head, Node tail) {
            if (head == tail) {
                LinkedList baseResult = new LinkedList();
                baseResult.addLast(head.data);
                return baseResult;
            }
            Node mid = midNode(head, tail);
            LinkedList firstSortedHalf = mergeSort(head, mid);
            LinkedList lastSortedHalf = mergeSort(mid.next, tail);
            LinkedList sumOfTwoSortedList = mergeTwoSortedList(firstSortedHalf, lastSortedHalf);
            return sumOfTwoSortedList;
        }
        public static Node midNode(Node head, Node tail) {
            Node f = head;
            Node s = head;
            while (f != tail && f.next != tail) {
                f = f.next.next;
                s = s.next;
            }
            return s;
        }
        public void removeDuplicates () {
            LinkedList res = new LinkedList();
            while (this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();
                if (res.size() == 0 || res.tail.data != val) {
                    res.addLast(val);
                }
            }
            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }
        public void oddEven () {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while (this.size > 0){
                int val = this.getFirst();
                if (val % 2 == 0) {
                    even.addLast(val);
                }
                else {
                    odd.addLast(val);
                }
            }
            if (odd.size > 0 && even.size > 0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if (odd.size > 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            } else if (even.size > 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }
        public void kReverseInLinkedList (int k) {
            LinkedList pre = new LinkedList();
            while (this.size > 0) {
                LinkedList curr = new LinkedList();
                if (this.size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }
                else {
                    int currSize = this.size;
                    for (int i = 0; i < currSize; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }
                if (pre == null) {
                    pre = curr;
                }
                else {
                    pre.tail.next = curr.head;
                    pre.tail = curr.tail;
                    pre.size += curr.size;
                }
            }
            this.head = pre.head;
            this.tail = pre.tail;
            this.size = pre.size;
        }
        public void displayReverse () {
            displayReverseHelper(head);
            System.out.println();
        }
        private void displayReverseHelper(Node head) {
            if (head == null) {
                return;
            }
            displayReverseHelper(head.next);
            System.out.println(head.data + " ");
        }
        public void reversePointerRecursion () {
            reversePointerRecursionHelper(head);
//            System.out.println();
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }
        private void reversePointerRecursionHelper(Node head) {
            if (head == null) {
                return;
            }
            reversePointerRecursionHelper(head.next);
            if (head == tail) {
                //do nothing....
            }
            else {
                head.next.next = head;
            }
        }
        Node recursiveLeft; // this makes in heap because this is a global property
        public void reverseDataRecursive () {
            recursiveLeft = head;
            reverseDataRecursiveHelper(head, 0);
        }
        private void reverseDataRecursiveHelper(Node right, int floor) {
            if (right == null) {
                return;
            }
            reverseDataRecursiveHelper(right.next, floor + 1);
            if (floor >= size / 2){
                int temp = right.data;
                right.data = recursiveLeft.data;
                recursiveLeft.data = temp;

                recursiveLeft = recursiveLeft.next;
            }
        }
        Node palindromeLeft;
        public boolean isPalindrome () {
            palindromeLeft = head;
            return isPalindromeHelper(head);
        }
        private boolean isPalindromeHelper(Node right) {
            if (right == null) {
                return true;
            }
            boolean recursiveResult = isPalindromeHelper(right.next);
            if (recursiveResult == false){
                return false;
            } else if (palindromeLeft.data != right.data) {
                return false;
            }
            else {
                palindromeLeft = palindromeLeft.next;
                return true;
            }
        }
        Node foldLeft;
        public void foldLinkedList () {
            foldLeft = head;
            foldLinkedListHelper(head, 0);
        }
        public void foldLinkedListHelper(Node right, int floor) {
            if (right == null) {
                return;
            }
            foldLinkedListHelper(right.next, floor + 1);
            if (floor > size / 2) {
                Node temp = foldLeft.next;
                foldLeft = right;
                right.next = temp;
                foldLeft = temp;
            } else if (floor == size / 2) {
                tail = right;
                tail.next = null;
            }
        }
        public static LinkedList addTwoLinkedList (LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int oldCarry = addTwoLinkedListHelper(one.head, one.size, two.head, two.size, res);
            if (oldCarry > 0) {
                res.addFirst(oldCarry);
            }
            return res;
        }
        public static int addTwoLinkedListHelper(Node one, int size1, Node two, int size2, LinkedList res) {
            if (one == null && two == null) {
                return 0;
            }
            int data = 0;
            if (size1 > size2) {
                int oldCarry = addTwoLinkedListHelper(one.next, size1 - 1, two, size2, res);
                data = one.data + oldCarry;
            } else if (size1 < size2) {
                int oldCarry = addTwoLinkedListHelper(one, size1, two.next, size2 - 1, res);
                data = two.data + oldCarry;
            } else {
                int oldCarry = addTwoLinkedListHelper(one.next, size1 - 1, two.next, size2 - 1, res);
                data = one.data + two.data + oldCarry;
            }
            int newData = data % 10;
            int newCarry = data / 10;
            res.addFirst(newData);
            return newCarry;
        }
        public static int findInterSection (LinkedList one, LinkedList two) {
            Node t1 = one.head;
            Node t2 = two.head;
            int delta = Math.abs(one.size - two.size);
            if (one.size > two.size) {
                for (int i = 0; i < delta; i++) {
                    t1 = t1.next;
                }
            } else {
                for (int i = 0; i < delta; i++) {
                    t2 = t2.next;
                }
            }
            while (t1 != t2) {
                t1 = t1.next;
                t2 = t2.next;
            }
            return t1.data;
        }
    }
    public static void main(String[] args) {
        System.out.println("all solutions are only for LinkedList.........");
    }
}
