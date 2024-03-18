package org.example


import org.jline.reader.LineReaderBuilder
import org.jline.terminal.TerminalBuilder
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val game = model()
    val terminal = TerminalBuilder.terminal()
    val reader = LineReaderBuilder.builder().terminal(terminal).build()

    game.printGameState()

    while (!game.isGameWon()) {
        val input = reader.readLine("Enter your move (AB to move from A to B): ").trim().uppercase(Locale.getDefault())
        if (input.length == 2 && input.all { it in 'A'..'C' }) {
            game.moveDisk(input[0], input[1])
            game.printGameState()
        } else {
            println("Invalid input. Please enter only two letters (AB).")
        }
    }

    println("You won!")
}