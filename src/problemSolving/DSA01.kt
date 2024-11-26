package problemSolving

fun countingValleys(steps: Int, path: String): Int {
    // Write your code here
    var seaLevel = 0
    var valleyCount = 0
    for(i in 0..<steps){
        if(path[i] == 'U'){
            seaLevel+=1
            if(seaLevel == 0){
                valleyCount+=1
            }
        }else{
            seaLevel-=1
        }

    }
    return valleyCount
}

fun main() {
    val step = 12
    val path = "DDUUDDUDUUUD"
    val result = countingValleys(step,path)
    println(result)
}


