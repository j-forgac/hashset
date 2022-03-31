import java.util.*


class HashSet<T>(private val tableSize: Int) {
    private var arr: Array<LinkedList<T>> = Array(tableSize) { LinkedList() }

    fun size(): Int = arr.flatMap { it }.size

    fun iterator(): Iterator<T> = arr.flatMap { it }.iterator()

    fun add(i: T): Boolean {
        if (i !in arr[i.hashCode() % tableSize]) {
            arr[i.hashCode() % tableSize].add(i)
            return true
        }
        return false
    }

    fun has(i: T): Boolean {
        return i in arr[i.hashCode() % tableSize]
    }

    fun delete(i: T): Boolean {
        if (i !in arr[i.hashCode() % tableSize]) {
            arr[i.hashCode() % tableSize].remove(i)
            return true
        }
        return false
    }
}

fun main() {
    val hashSet: HashSet<Int?> = HashSet(4)
    println(hashSet.size())
    hashSet.add(1)
    hashSet.add(1828)
    hashSet.add(10)
    for(x in hashSet.iterator()) println(x)
}