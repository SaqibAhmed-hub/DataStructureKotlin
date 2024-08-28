package maps

class BasicMaps {
    
    
    private var map1 = mapOf("Key1" to 1,"Key2" to 2,"Key3" to 3)


    fun printMap(){
        println("Map Value ==> ${map1.values} , ${map1.values::class}")
        println("Map Key ==> ${map1.keys},  ${map1.keys::class}")

    }
    
    
    
    
}