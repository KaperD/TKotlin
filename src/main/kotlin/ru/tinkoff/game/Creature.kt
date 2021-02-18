package ru.tinkoff.game

import kotlin.math.abs
import kotlin.math.max

open class Creature(name: String, x: Int, y: Int, speed: Int, hp: Int, open val damage: Int, open val attackRange: Int)
    : GameObject(name, x, y, speed) {
    var hp: Int = hp
        protected set

    fun isAlive(): Boolean = hp > 0

    // return true if damage was made
    protected open fun defend(other: Creature): Boolean {
        if (!isAlive()) return false
        hp = max(0, hp - other.damage)
        return true
    }

    // return true if attack was successful
    open fun attack(other: Creature): Boolean {
        val dist = max(abs(xPos - other.xPos), abs(yPos - other.yPos))
        if (dist <= attackRange) {
            return other.defend(this)
        }
        return false
    }

    override fun moveUp() {
        if (isAlive()) super.moveUp()
    }
    override fun moveDown() {
        if (isAlive()) super.moveDown()
    }
    override fun moveLeft() {
        if (isAlive()) super.moveLeft()
    }
    override fun moveRight() {
        if (isAlive()) super.moveRight()
    }

    override fun toString(): String {
        return """Creature
                 |Name: $name
                 |Position: ($xPos, $yPos)
                 |Speed: $speed
                 |Hp: $hp
                 |Attack: $damage
               """.trimMargin()
    }
}