package org.example

data class Disk(val size: Int)

class Tower(val name: String) {
    val disks = mutableListOf<Disk>()

    fun addDisk(disk: Disk){
        disks.add(0, disk)
    }
}