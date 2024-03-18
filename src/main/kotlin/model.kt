package org.example

class model {
    val towers = listOf(Tower("A"), Tower("B"), Tower("C"))

    init{
        for(size in 3 downTo 1){
            towers[0].addDisk(Disk(size))
        }

    }
    fun moveDisk(fromTower: Char, toTower: Char){
        val from = towers.first {it.name == fromTower.toString()}
        val to = towers.first { it.name == toTower.toString()}

        if(from.disks.isNotEmpty() && (to.disks.isEmpty() || from.disks.first().size < to.disks.first().size)){
            to.disks.add(0, from.disks.removeAt(0))
            println("Moved from Tower $fromTower to $toTower")
        }
        else{
            println("Invalid move. Please try again!")
        }

    }

    fun printGameState(){
        towers.forEach{
                tower ->
            println("Tower ${tower.name} : ${tower.disks.joinToString { it.size.toString() }}")
        }
    }

    fun isGameWon() : Boolean{
        return towers[2].disks.size == 3
    }
}