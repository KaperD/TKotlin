package ru.tinkoff.game

class Wolf(name: String, x: Int, y: Int) : Creature(name, x, y, 7, 50, 30, 2) {
    private var isHidden: Boolean = false

    fun hide() {
        isHidden = true
    }

    fun reveal() {
        isHidden = false
    }

    override fun attack(other: Creature): Boolean {
        if (isHidden) return false
        return super.attack(other)
    }

    override fun defend(other: Creature): Boolean {
        if (isHidden) return false
        return super.defend(other)
    }

    override fun toString(): String {
        return """Wolf
                 |Name: $name
                 |Position: ($xPos, $yPos)
                 |Speed: $speed
                 |Hp: $hp
                 |Attack: $damage
                 |Is Hidden: $isHidden
               """.trimMargin()
    }
}