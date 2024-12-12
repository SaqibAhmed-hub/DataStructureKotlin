package linkedlist

data class SinglyLinkedListNode(var data: Int , var next: SinglyLinkedListNode? = null)

class SinglyLinkedList {
    var head: SinglyLinkedListNode? = null
    private var tail: SinglyLinkedListNode? = null

    fun insertNode(nodeData: Int) {
        val node = SinglyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }

        tail = node
    }

}

fun printSinglyLinkedList(head: SinglyLinkedListNode?, sep: String) {
    var node = head

    while (node != null) {
        print(node.data)
        node = node.next

        if (node != null) {
            print(sep)
        }
    }
}


fun insertNodeAtPosition(llist: SinglyLinkedListNode?, data: Int, position: Int): SinglyLinkedListNode? {

    val newNode = SinglyLinkedListNode(data)

    if (position == 0) {
        newNode.next = llist
    }

    var currentNode = llist
    var currentIndex = 0

    while(currentNode != null && currentIndex < position - 1 ){
        currentNode = currentNode.next
        currentIndex++
    }

    newNode.next = currentNode?.next
    currentNode?.next = newNode

    return llist
}


fun deleteNode(llist: SinglyLinkedListNode?, position: Int): SinglyLinkedListNode? {

    var currentNode = llist
    var currentIndex = 0

    if (position == 0) return llist?.next

    while (currentNode != null && currentIndex < position - 1 ){
        currentNode = currentNode.next
        currentIndex++
    }
    currentNode?.next = currentNode?.next?.next
    return llist
}

fun main(args: Array<String>) {

    val llist = SinglyLinkedList()

    llist.insertNode(16)
    llist.insertNode(13)
    llist.insertNode(7)
    llist.insertNode(88)

    val position = 0

    val llistHead = deleteNode(llist.head, position)

    printSinglyLinkedList(llistHead, " ")
}


