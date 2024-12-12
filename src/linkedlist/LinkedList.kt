package linkedlist

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0
    private fun isEmpty(): Boolean {
        return size == 0
    }
    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    /**
     * adding value to the first node of the List
     *  also known as "head-first insertion"
     */
    fun push(value: T){
        head = Node(value = value, next = head)
        if (tail == null){
            tail = head
        }
        size++
    }

    /**
     *  adding the value to the end of the list
     *  also known as " tail-end insertion"
     */
    fun append(value : T){
        if (isEmpty()){
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }


    /**
     * inserting at the particular node
     *
     */
    fun insert(value: T,afterNode: Node<T>):Node<T>{
        if (tail == afterNode){
            append(value)
            return tail!!
        }

        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }


    /**
     * find the node value at given position
     */
    fun nodeAt(index: Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode

    }


    /**
     * removing the value for the first node
     */
    fun pop(): T?{
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()){
            tail = null
        }
        return result
    }

    /**
     * removing the last node from the list
     * Time Complexity : O(n)
     */
    fun removeLast() : T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null){
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev

        return current.value

    }


    /**
     * removing the list at a particular position
     */
     fun removeAfter(node: Node<T>) : T?{
        val result = node.next?.value

        if (node.next == tail){
            tail = node
        }

        if (node.next != null){
            size--
        }
        node.next = node.next?.next
        return  result
     }


}

fun main(args: Array<String>){
    val llist = LinkedList<Int>()

    llist.push(1)
    llist.push(2)
    llist.push(3)
    llist.push(3)
    llist.push(3)

    println(llist)

}