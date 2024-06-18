public class Main {
    public static void main(String[] args) {

        LinkList list1 = new LinkList();
        list1.DisplayLinkList();
        list1.addEnd(1);
        list1.addStart(2);
        list1.addEnd(3);
        list1.addEnd(4);
        list1.DisplaySize();
        for (int i = 0; i < 3; i++) {
            list1.RemoveStart();
        }
        list1.RemoveEnd();
        list1.DisplaySize();
        LinkList list2 = new LinkList();
        list1.ConcatCDDL(list2);// first list concatenates with second one.If first,second or both lists are
                                // empty it will also tell which is empty
        LinkList l3 = new LinkList();
        l3.addEnd(1);
        l3.addEnd(2);
        l3.addEnd(3);
        l3.addEnd(5);
        l3.addEnd(4);
        System.out.println(l3.IsSorted());// Also check for empty linklist

    }
}