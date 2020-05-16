public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.enqueue("hi");
        list.enqueue("my");
        list.enqueue("name");
        list.enqueue("is");
        list.enqueue("Arham");
        list.push("Sparta");
        list.push("is");
        list.push("this");
        list.addAnywhere("Random", 0);
        list.dequeue();
        list.removeAnywhere(8);
        list.printList();
        System.out.println(list.getSize());
    }
}
