fun main() {
    //printParentPair()
    printParentMap()
}

data class Child(val firstName: String, val secondName: String);

data class Parent( val firstName: String, val secondName: String, val childrenList: List<Child>) {

};

fun printParentPair(): Unit {
    val parent1ChildrenList: List<Child> = listOf(
        Child("child1Name", "child1SecondName"), Child("child2Name", "child12SecondName")
    )
    val parent1 = Parent("parent1name", "parent1SecondName", parent1ChildrenList)

    val parentPair: Pair<Int, Parent> = 1 to parent1;
}

fun printParentMap() : Unit {
    val parent1ChildrenList: List<Child> = listOf(
        Child("child1Name", "child1SecondName"), Child("child2Name", "child12SecondName")
    )
    val parent1 = Parent("parent1name", "parent1SecondName", parent1ChildrenList)

    val parent2ChildrenList: List<Child> = listOf(
        Child("child3Name", "child3SecondName"), Child("child4Name", "child4SecondName")
    )
    val parent2 = Parent("parent12name", "parent12SecondName", parent2ChildrenList)

    val parentsMap: Map<Int, Parent> = mapOf(1 to parent1, 2 to parent2)

    val entries: Set<Map.Entry<Int, Parent>> = parentsMap.entries
    println(parentsMap)
}
