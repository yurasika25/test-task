package mate.academy

import kotlin.random.Random

open class ColorSupplier {


    companion object {
        fun getRandomColor(): String {
            val index = Random.nextInt(Colors.values().size)
            return Colors.values()[index].toString()
        }
    }
}
