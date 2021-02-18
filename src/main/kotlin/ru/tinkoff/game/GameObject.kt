package ru.tinkoff.game

abstract class GameObject(val name: String, x: Int, y: Int, val speed: Int) {
    var xPos: Int = x
        protected set
    var yPos: Int = y
        protected set

    open fun moveUp() {
        yPos -= speed
    }
    open fun moveDown() {
        yPos += speed
    }
    open fun moveLeft() {
        xPos -= speed
    }
    open fun moveRight() {
        xPos += speed
    }

    override fun toString(): String {
        return """GameObject
                 |Name: $name
                 |Position: ($xPos, $yPos)
                 |Speed: $speed
               """.trimMargin()
    }
}