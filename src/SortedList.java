
public class SortedList {

    public static void main(String[] args){
        SortedList sortedList = new SortedList();
        sortedList.add("b");
        sortedList.add("a");
        sortedList.add("d");
        sortedList.add("e");
        sortedList.add("g");
        sortedList.add("f");
        sortedList.add("c");

        sortedList.printList();
    }

    ListItem front = null;
    ListItem rear = null;

    public void add(String s) {
        ListItem newItem = new ListItem();
        newItem.data = s;

        ListItem current;
        if(front== null || front.data.compareTo(newItem.data)>0){
            newItem.next = front;
            front = newItem;
        }
        else {
            current = front;
            while (current.next!=null && current.next.data.compareTo(s)<=0){
                current= current.next;

            }
            newItem .next = current.next;
            current.next = newItem;
        }

    }

    public void remove(String s) {
        ListItem listPtr = front;
        while (listPtr != null) {
            if (listPtr.data.equals(s)) {
                break;
            }
            listPtr = listPtr.next;
        }
        if(listPtr!=null){

            // listPtr is pointing to front;
            if(listPtr==front){

                front = front.next;
                front.next.prev = null;

            }
            else if(listPtr==rear){
                //listPtr is pointing to rear;
                rear = rear.prev;
                rear.next=null;


            }
            else {
                //listPtr is at somewhere in the middle of the list

                listPtr.prev.next = listPtr.next;
                listPtr.next.prev = listPtr.prev;


            }
            // garbage collection will remove this.
            listPtr=null;
            System.out.println("\""+s+"\" Removed from list");
        }
        else{
            System.out.println("\""+s+"\" does not exist in the list");
        }
    }

    public void printList() {
        //Forward Direction.
        System.out.print("List:\n");
        ListItem listPtr = front;
        while (listPtr != null) {
            System.out.println(" " + listPtr.data);
            listPtr = listPtr.next;
        }
        System.out.println();
    }

    public void printReverse() {
        //Similar to what we had before
        //Reverse Direction.
        System.out.print("List:");
        ListItem listPtr = rear;
        while (listPtr != null) {
            System.out.println(" " + listPtr.data);
            listPtr = listPtr.prev;
        }
        System.out.println();
    }
}

class ListItem{
    String data;
    ListItem prev;
    ListItem next;
}