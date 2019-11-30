
import java.io.*;

// Java program to implement 
// a Singly Linked List 
public class LinkedList {

    static Node head; // head of list 

    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node {

        String data;
        Node next;
        Node ileriA;
        Node ileriB;
        Node ileriC;
        Node ileriD;
        Node ileriE;
        Node ileriF;
        Node ileriG;
        Node ileriH;
        Node ileriI;
        Node ileriJ;
        Node ileriK;
        Node ileriL;
        Node ileriM;
        Node ileriN;
        Node ileriO;
        Node ileriP;
        Node ileriQ;
        Node ileriR;
        Node ileriS;
        Node ileriT;
        Node ileriU;
        Node ileriV;
        Node ileriW;
        Node ileriX;
        Node ileriY;
        Node ileriZ;

        // Constructor 
        Node(String d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node 
    public static LinkedList insert(LinkedList list, String word, String anlami) {
        // Create a new node with given data 
        Node new_node = new Node(word);
        new_node.next = null;

        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) {
            //list.head = new_node;
            System.out.println("list.head = null a girdi");
            list.head = new Node("BASLANGIC");
        } else {
            // Else traverse till the last node 
            // and insert the new_node there 
            /*  Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }*/

            // Insert the new_node at last node 
            //last.next = new_node;
            Node aktif = list.head;
            int sizeCharOfWord = 0;
            String chardan_Stringe_cevirme = "";
            while (new_node.data.length() != sizeCharOfWord) {

                char ilerleme = word.charAt(sizeCharOfWord);
                switch (ilerleme) {
                    case 'a':

                        aktif = aktif.ileriA;

                        break;
                    case 'b':
                        aktif = aktif.ileriB;

                        break;
                    case 'c':

                        aktif = aktif.ileriC;

                        break;
                    case 'd':
                        aktif = aktif.ileriD;

                        break;
                    case 'e':
                        aktif = aktif.ileriE;

                        break;
                    case 'f':
                        aktif = aktif.ileriF;

                        break;
                    case 'g':
                        aktif = aktif.ileriG;

                        break;
                    case 'h':
                        aktif = aktif.ileriH;
                        //           veri = veriH;
                        break;
                    case 'i':
                        aktif = aktif.ileriI;
                        //           veri = veriI;
                        break;
                    case 'j':
                        aktif = aktif.ileriJ;
                        //           veri = veriJ;
                        break;
                    case 'k':
                        aktif = aktif.ileriK;
                        //           veri = veriK;
                        break;
                    case 'l':
//            while (new_node.data.length() != sizeCharOfWord) {                        
                        if (new_node.data.length() == sizeCharOfWord - 1) {
                            break;
                        } else {
                            aktif = aktif.ileriL;
                        }
                        //           veri = veriL;
                        break;
                    case 'm':
                        aktif = aktif.ileriM;
                        //           veri = veriM;
                        break;
                    case 'n':
                        aktif = aktif.ileriN;
                        //           veri = veriN;
                        break;
                    case 'o':
                        aktif = aktif.ileriO;
                        //           veri = veriO;
                        break;
                    case 'p':
                        aktif = aktif.ileriP;
                        //           veri = veriP;
                        break;
                    case 'q':
                        aktif = aktif.ileriQ;
                        //           veri = veriQ;
                        break;
                    case 'r':

                        aktif = aktif.ileriR;

                        //           veri = veriR;
                        break;
                    case 's':
                        aktif = aktif.ileriS;
                        //           veri = veriS;
                        break;
                    case 't':
                        aktif = aktif.ileriT;
                        //           veri = veriT;
                        break;
                    case 'u':
                        aktif = aktif.ileriU;
                        //           veri = veriU;
                        break;
                    case 'v':
                        aktif = aktif.ileriV;
                        //           veri = veriV;
                        break;
                    case 'w':
                        aktif = aktif.ileriW;
                        //           veri = veriW;
                        break;
                    case 'x':
                        aktif = aktif.ileriX;
                        //           veri = veriX;
                        break;

                    case 'y':
                        aktif = aktif.ileriY;
                        //           veri = veriY;
                        break;

                    case 'z':
                        aktif = aktif.ileriZ;
                        //           veri = veriZ;
                        break;
                    default:
                        System.out.println(" --- --- --> harflendirmede bir hata meydana geldi !!!!");

                }

                if (aktif == null) {
                    chardan_Stringe_cevirme += ilerleme;
                    Node new_node2 = new Node(chardan_Stringe_cevirme);
                    System.out.println("new_node2 (Anlamı olmayan düğüme eklenecek String):---> " + new_node2.data);
                    aktif = new_node2;

                }
                //     System.out.println(sizeCharOfWord + "  new_node (dolu): " + new_node.data);

                sizeCharOfWord++;
            }
            Node new_node3 = new Node(anlami);

            aktif = new_node3;
        }  //} else {
        // Else traverse till the last node 
        // and insert the new_node there 
        /*  Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }*/

        // Insert the new_node at last node 
        //last.next = new_node;
        // Return the list by head 
        return list;
    }

    // Method to print the LinkedList. 
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList 
        while (currNode != null) {
            // Print the data at current node 
            System.out.print(currNode.data + " ");

            // Go to next node 
            currNode = currNode.next;
        }
    }

    // **************MAIN METHOD************** 
    // method to create a Singly linked list with n nodes 
    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        // 
        // ******INSERTION****** 
        // 
        // Insert the values 
        list = insert(list, "call", "arama");
        list = insert(list, "call", "arama");
        list = insert(list, "caller", "arayan kimse");

        // Print the LinkedList 
        printList(list);
    }
}
