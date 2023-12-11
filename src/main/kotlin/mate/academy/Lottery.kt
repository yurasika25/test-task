package mate.academy

import kotlin.random.Random

class Lottery : ColorSupplier() {
    fun getRandomBall(): Ball {
        return Ball().apply {

            setBallColor(ColorSupplier.getRandomColor())

            setBallNumber(Random.nextInt(100))

        }
    }
}
