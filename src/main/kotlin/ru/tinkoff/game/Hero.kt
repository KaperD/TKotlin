package ru.tinkoff.game

import kotlin.math.max
import kotlin.math.min

class Hero(name: String, x: Int, y: Int) : Creature(name, x, y, 5, 100, 20, 3) {
    var shieldHp: Int = 100
        private set
    var numberOfPotions = 3
        private set

    override fun defend(other: Creature): Boolean {
        if (shieldHp > 0) {
            shieldHp = max(0, shieldHp - other.damage)
            return false // successfully defended
        }
        return super.defend(other)
    }

    override fun attack(other: Creature): Boolean {
        super.attack(other)
        return super.attack(other) // has two swords
    }

    fun drinkPotion() {
        if (numberOfPotions > 0) {
            numberOfPotions--
            hp = min(100, hp + 40)
        }
    }

    override fun toString(): String {
        return """Hero
                 |Name: $name
                 |Position: ($xPos, $yPos)
                 |Speed: $speed
                 |Hp: $hp
                 |Attack: $damage
                 |Shield Hp: $shieldHp
                 |Potions: $numberOfPotions
               """.trimMargin()
    }
}