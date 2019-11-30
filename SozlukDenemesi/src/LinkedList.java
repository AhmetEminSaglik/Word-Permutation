
class Node {

    public String data;
    //  Node next;
    public Node ileriA;
    public Node ileriB;
    public Node ileriC;
    public Node ileriD;
    public Node ileriE;
    public Node ileriF;
    public Node ileriG;
    public Node ileriH;
    public Node ileriI;
    public Node ileriJ;
    public Node ileriK;
    public Node ileriL;
    public Node ileriM;
    public Node ileriN;
    public Node ileriO;
    public Node ileriP;
    public Node ileriQ;
    public Node ileriR;
    public Node ileriS;
    public Node ileriT;
    public Node ileriU;
    public Node ileriV;
    public Node ileriW;
    public Node ileriX;
    public Node ileriY;
    public Node ileriZ;

    public Node(String d) {
        data = d;

    }

    public void listele() {
        System.out.println(data + " ");
    }
}

class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
    }

    public void insert(String word, String anlami) // Verinin standart geldiği yapılandırıcı 
    // void yerine --> LinkedList  ve return vardı
    {
        System.out.println("************************************");

        Node aktif = head;

        Node new_node = new Node(word);

        if (head == null) {
            System.out.println("liste başı boşş");
            System.out.println(word + " kelimesi için ");

            Node new_node2 = new Node("head-baslangic");
            head = new_node2;
            aktif = head;
        } else {
            System.out.println("Liste başı boş değil   " + aktif.data);
            System.out.println("aktif --> " + aktif.data);

        }
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
                    aktif = aktif.ileriL;
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
                System.out.println("new_node (Anlamı olmayan düğüme eklenecek String):---> " + new_node2.data);
                aktif = new_node2;

            }
            //     System.out.println(sizeCharOfWord + "  new_node (dolu): " + new_node.data);

            sizeCharOfWord++;
        }
        Node new_node3 = new Node(anlami);

        new_node = new_node3;
        System.out.println("new_node3 (anlamı eklenecek olan düğüm)  [==>] : " + new_node.data);

    }

    public void deneme(LinkedList list, String denem) {
        Node currNode = list.head;
        System.out.println("currNode.data : " + currNode.data);
        currNode = currNode.ileriC;

        System.out.println("currNode.data : " + currNode.data);
        currNode = currNode.ileriA;
        System.out.println("currNode.data : " + currNode.data);
        currNode = currNode.ileriR;
        System.out.println("currNode.data : " + currNode.data);

    }

    public void AnlamınaBak(LinkedList list, String word) {
        Node currNode = list.head;
        System.out.println("currNode.data : " + currNode.data);

        int sizeCharOfWord = 0;
        String kelime = "";
        String chardan_Stringe_cevirme = "";
        while (!word.equals(kelime)) {//currNode.data.length() != sizeCharOfWord

            char ilerleme = word.charAt(sizeCharOfWord);
            switch (ilerleme) {
                case 'a':

                    currNode = currNode.ileriA;
                    kelime += ilerleme;

                    //           veri = veriA;
                    break;
                case 'b':
                    currNode = currNode.ileriB;
                    kelime += ilerleme;
                    //           veri = veriB;
                    break;
                case 'c':

                    currNode = currNode.ileriC;
                    kelime += ilerleme;

                    //           veri = veriC;
                    break;
                case 'd':
                    currNode = currNode.ileriD;
                    kelime += ilerleme;
                    //           veri = veriD;
                    break;
                case 'e':
                    currNode = currNode.ileriE;
                    kelime += ilerleme;
                    //           veri = veriE;
                    break;
                case 'f':
                    currNode = currNode.ileriF;
                    kelime += ilerleme;
                    //           veri = veriF;
                    break;
                case 'g':
                    currNode = currNode.ileriG;
                    kelime += ilerleme;
                    //           veri = veriG;
                    break;
                case 'h':
                    currNode = currNode.ileriH;
                    kelime += ilerleme;
                    //           veri = veriH;
                    break;
                case 'i':
                    currNode = currNode.ileriI;
                    kelime += ilerleme;
                    //           veri = veriI;
                    break;
                case 'j':
                    currNode = currNode.ileriJ;
                    kelime += ilerleme;
                    //           veri = veriJ;
                    break;
                case 'k':
                    currNode = currNode.ileriK;
                    kelime += ilerleme;
                    //           veri = veriK;
                    break;
                case 'l':
                    currNode = currNode.ileriL;
                    kelime += ilerleme;
                    //           veri = veriL;
                    break;
                case 'm':
                    currNode = currNode.ileriM;
                    kelime += ilerleme;
                    //           veri = veriM;
                    break;
                case 'n':
                    currNode = currNode.ileriN;
                    kelime += ilerleme;
                    //           veri = veriN;
                    break;
                case 'o':
                    currNode = currNode.ileriO;
                    kelime += ilerleme;
                    //           veri = veriO;
                    break;
                case 'p':
                    currNode = currNode.ileriP;
                    kelime += ilerleme;
                    //           veri = veriP;
                    break;
                case 'q':
                    currNode = currNode.ileriQ;
                    kelime += ilerleme;
                    //           veri = veriQ;
                    break;
                case 'r':

                    currNode = currNode.ileriR;
                    kelime += ilerleme;

                    //           veri = veriR;
                    break;
                case 's':
                    currNode = currNode.ileriS;
                    kelime += ilerleme;
                    //           veri = veriS;
                    break;
                case 't':
                    currNode = currNode.ileriT;
                    kelime += ilerleme;
                    //           veri = veriT;
                    break;
                case 'u':
                    currNode = currNode.ileriU;
                    kelime += ilerleme;
                    //           veri = veriU;
                    break;
                case 'v':
                    currNode = currNode.ileriV;
                    kelime += ilerleme;
                    //           veri = veriV;
                    break;
                case 'w':
                    currNode = currNode.ileriW;
                    kelime += ilerleme;
                    //           veri = veriW;
                    break;
                case 'x':
                    currNode = currNode.ileriX;
                    kelime += ilerleme;
                    //           veri = veriX;
                    break;

                case 'y':
                    currNode = currNode.ileriY;
                    kelime += ilerleme;
                    //           veri = veriY;
                    break;

                case 'z':
                    currNode = currNode.ileriZ;
                    kelime += ilerleme;
                    //           veri = veriZ;
                    break;

            }
            sizeCharOfWord++;

            if (currNode == null) {
                System.out.println("Okuma ilerisi bos");

                chardan_Stringe_cevirme += ilerleme;
                Node new_node2 = new Node(chardan_Stringe_cevirme);
                currNode = new_node2;

            }
            System.out.println(" new_node : " + currNode.data);
        }

        System.out.println(" Anlami : " + currNode.data);
    }

}
