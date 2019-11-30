

#include <stdio.h>
#include <stdlib.h>

struct listNode {
    char data;
    struct listNode *nextPtr;
    struct listNode *ileriA;
    struct listNode *ileriB;
    struct listNode *ileriC;
    struct listNode *ileriD;
    struct listNode *ileriE;
    struct listNode *ileriF;
    struct listNode *ileriG;
    struct listNode *ileriH;
    struct listNode *ileriI;
    struct listNode *ileriJ;
    struct listNode *ileriK;
    struct listNode *ileriL;
    struct listNode *ileriM;
    struct listNode *ileriN;
    struct listNode *ileriO;
    struct listNode *ileriP;
    struct listNode *ileriQ;
    struct listNode *ileriR;
    struct listNode *ileriS;
    struct listNode *ileriT;
    struct listNode *ileriU;
    struct listNode *ileriV;
    struct listNode *ileriW;
    struct listNode *ileriX;
    struct listNode *ileriY;
    struct listNode *ileriZ;
};

typedef struct listNode ListNode;
typedef ListNode *ListNodePtr;

void insert(ListNodePtr *sPtr, char word[], char meaning[]);
//char delete(ListNodePtr *sPtr, char value);
int isEmpty(ListNodePtr sPtr);
void printList(ListNodePtr currentPtr);
void instructions(void);
//void kelime_ekle();
//void Kelime_arama(ListNodePtr *sPtr, char word[]);

int main(void) {
    ListNodePtr startPtr = NULL;
    unsigned int choice;
    char word[100];
    char meaning[100];
    instructions();
    printf("%s", "? ");
    scanf("%u", &choice);
    while (choice != 3) {
        switch (choice) {
            case 1:
                printf("%s", "Enter a character: ");
                scanf("\n%s", &word);
                scanf("%s", &meaning);
                int i = 0;
                while (word[i]) {
                    //putchar(toupper(word[i]));
                    word[i] = toupper(word[i]);
                    i++;
                }
                i = 0;
                while (meaning[i]) {
                    //putchar(toupper(meaning[i]));
                    meaning[i] = (toupper((meaning[i])));
                    i++;
                }

                insert(&startPtr, word, meaning);
                printList(startPtr);
                break;
                /* case 2:
                     if (!isEmpty(startPtr)) {
                         printf("%s", "Enter character to be deleted: ");
                         scanf("\n%c", &word);
                         if (delete(&startPtr, word)) {
                             printf("%c deleted.\n", word);
                             printList(startPtr);
                         } else {
                             printf("%c not found.\n\n", word);
                         }
                     } else {
                         puts("List is empty.\n");
                     }
                     break;
                 default: puts("Invalid choice\n");
                     instructions;
                     break;*/

        }
        printf("%s", "? ");
        scanf("%u", &choice);

    }
    puts("End of run");
}

void instructions(void) {
    puts("Enter your choice:\n"
            "1 to insert an element inito the list.\n"
            "2 to delete an element from the list.\n"
            "3 to end");
}

void insert(ListNodePtr *sPtr, char word[], char meaning[]) {
    ListNodePtr newPtr;
    //ListNodePtr previousPtr;
    ListNodePtr currentPtr;

    newPtr = malloc(sizeof (ListNode));

    if (newPtr != NULL) {
        newPtr->data = word;
        newPtr->nextPtr = NULL;
        //   previousPtr = NULL;
        currentPtr = *sPtr;
        int i = 0;
        char bosluga_ekleme[100];
        while (i != strlen(word)) {//currentPtr != NULL && word > currentPtr->data
            //    previousPtr = currentPtr;
            bosluga_ekleme[i] = word[i];
            switch (word[i]) {
                case 'A':currentPtr = currentPtr->ileriA;
                    printf("ileri_A->\n");
                    break;
                case 'B':currentPtr = currentPtr->ileriB;
                    printf("ileri_B->\n");
                    break;
                case 'C':currentPtr = currentPtr->ileriC;
                    printf("ileri_C->\n");
                    break;
                case 'D':currentPtr = currentPtr->ileriD;
                    printf("ileri_D->\n");
                    break;
                case 'E':currentPtr = currentPtr->ileriE;
                    printf("ileri_E->\n");
                    break;
                case 'F':currentPtr = currentPtr->ileriF;
                    printf("ileri_F->\n");
                    break;
                case 'G':currentPtr = currentPtr->ileriG;
                    printf("ileri_G->\n");
                    break;
                case 'H':currentPtr = currentPtr->ileriH;
                    printf("ileri_H->\n");
                    break;
                case 'I':currentPtr = currentPtr->ileriI;
                    printf("ileri_I->\n");
                    break;
                case 'J':currentPtr = currentPtr->ileriJ;
                    printf("ileri_J->\n");
                    break;
                case 'K':currentPtr = currentPtr->ileriK;
                    printf("ileri_K->\n");
                    break;
                case 'L':currentPtr = currentPtr->ileriL;
                    printf("ileri_L->\n");
                    break;
                case 'M':currentPtr = currentPtr->ileriM;
                    printf("ileri_M->\n");
                    break;
                case 'N':currentPtr = currentPtr->ileriN;
                    printf("ileri_N->\n");
                    break;
                case 'O':currentPtr = currentPtr->ileriO;
                    printf("ileri_O->\n");
                    break;
                case 'P':currentPtr = currentPtr->ileriP;
                    printf("ileri_P->\n");
                    break;
                case 'Q':currentPtr = currentPtr->ileriQ;
                    printf("ileri_Q->\n");
                    break;
                case 'R':currentPtr = currentPtr->ileriR;
                    printf("ileri_R->\n");
                    break;
                case 'S':currentPtr = currentPtr->ileriS;
                    printf("ileri_S->\n");
                    break;
                case 'T':currentPtr = currentPtr->ileriT;
                    printf("ileri_T->\n");
                    break;
                case 'U':currentPtr = currentPtr->ileriU;
                    printf("ileri_U->\n");
                    break;
                case 'V':currentPtr = currentPtr->ileriV;
                    printf("ileri_V->\n");
                    break;
                case 'W':currentPtr = currentPtr->ileriW;
                    printf("ileri_W->\n");
                    break;
                case 'X':currentPtr = currentPtr->ileriX;
                    printf("ileri_X->\n");
                    break;
                case 'Y':currentPtr = currentPtr->ileriY;
                    printf("ileri_Y->\n");
                    break;
                case 'Z':currentPtr = currentPtr->ileriZ;
                    printf("ileri_Z->\n");
                    break;

                default: printf("Harfler uzerınde ilerken hata meydana geldi");

            }//currentPtr != NULL && word > currentPtr->data
            //if(currentPtr==NULL){}
            i++;
        }
        /*if (previousPtr == NULL) {
            newPtr->nextPtr = *sPtr;
         *sPtr = newPtr;
        } else {
            previousPtr-> nextPtr = newPtr;
            newPtr->nextPtr = currentPtr;
        }*/newPtr->nextPtr = currentPtr;
    } else {
        printf("%s not inserted. No memory available.\n", word);
    }
}

/*char delete(ListNodePtr *sPtr, char value) {
    ListNodePtr previousPtr;
    ListNodePtr currentPtr;
    ListNodePtr tempPtr;
    if (value == (*sPtr)->data) {
        tempPtr = *sPtr;
 *sPtr = (*sPtr)->nextPtr;
        free(tempPtr);
        return value;
    } else {
        previousPtr = *sPtr;
        currentPtr = (*sPtr)->nextPtr;

        while (currentPtr != NULL && currentPtr->data != value) {
            previousPtr = currentPtr;
            currentPtr = currentPtr->nextPtr;
        }
        if (currentPtr != NULL) {
            tempPtr = currentPtr;
            previousPtr->nextPtr = currentPtr->nextPtr;
            free(tempPtr);
            return value;
        }
    }
    return '\0';
}*/

int isEmpty(ListNodePtr sPtr) {

    return sPtr == NULL;
}

void printList(ListNodePtr currentPtr) {
    if (isEmpty(currentPtr)) {
        puts("List is empty.\n");
    } else {
        puts("The list is: ");
        while (currentPtr != NULL) {
            printf("%s --> ", currentPtr->data);
            currentPtr = currentPtr->nextPtr;
        }
        puts("NULL\n");
    }
}



/*
 * 
 */
/*int main(int argc, char** argv) {
    printf("hello world\n");
    int x,y,toplam;
    scanf("%d %d",&x,&y);
    toplam=x+y;
    printf("%d\n",toplam);
    return (EXIT_SUCCESS);
}
 */
