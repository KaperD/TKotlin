package ru.tinkoff.game

fun main() {
    val hero = Hero("Jo", 0, 0)

    val wolf1 = Wolf("A", -1, -1)
    val wolf2 = Wolf("B", 1, 1)

    val creatures = listOf(hero, wolf1, wolf2)

    creatures.forEach { println(it); println() }

    hero.attack(wolf1)
    require(wolf1.hp == 10)
    wolf2.hide()
    hero.attack(wolf2)
    require(wolf2.hp == 50)

    creatures.forEach { println(it); println() }

    wolf1.attack(hero)
    require(hero.hp == 100 && hero.shieldHp == 70)
    wolf2.attack(hero)
    require(hero.hp == 100 && hero.shieldHp == 70)
    wolf2.reveal()
    wolf2.attack(hero)
    require(hero.hp == 100 && hero.shieldHp == 40)
    wolf1.attack(hero)
    wolf1.attack(hero)
    wolf1.attack(hero)
    require(hero.hp == 70 && hero.shieldHp == 0)
    hero.drinkPotion()
    require(hero.hp == 100 && hero.shieldHp == 0 && hero.numberOfPotions == 2)

    hero.attack(wolf1)
    require(!wolf1.isAlive())

    creatures.forEach { println(it); println() }

    val tree = Tree(3, 5)
    val all = listOf(tree, hero, wolf1, wolf2)

    all.forEach { println(it); println() }
    all.forEach { it.moveUp(); it.moveLeft() }
    all.forEach { println(it); println() }
}