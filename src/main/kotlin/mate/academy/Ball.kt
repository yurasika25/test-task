package mate.academy

class Ball {
    private var ballColor: String = ""
    private var ballNumber: Int = 0

    constructor()

    constructor(color: String, number: Int) {
        this.ballColor = color
        this.ballNumber = number
    }

    fun getBallColor(): String {
        return ballColor
    }

    fun setBallColor(color: String) {
        ballColor = color
    }

    fun getBallNumber(): Int {
        return ballNumber
    }

    fun setBallNumber(number: Int) {
        ballNumber = number
    }

    override fun toString(): String {
        return "Ball with number: $ballNumber and color: $ballColor"
    }
}
