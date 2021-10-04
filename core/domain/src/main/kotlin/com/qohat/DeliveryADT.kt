package com.qohat

import arrow.optics.optics
import java.util.*

data class Id(val value: String = UUID.randomUUID().toString())

@optics
data class X(val value: Int) { companion object }
@optics
data class Y(val value: Int) { companion object }

@optics
sealed class Direction { companion object }
object North : Direction()
object South: Direction()
object West: Direction()
object East: Direction()

@optics
data class Coordinate(val x: X, val y: Y, val direction: Direction) { companion object }
@optics
data class Location(val id: Id, val coordinate: Coordinate) { companion object }

sealed class CommandList
object Nil: CommandList()
data class Command(val head: Char, val tail: CommandList) : CommandList()

interface Deliver {
    fun run(f: (Char) -> (Location) -> Location, commands: CommandList, location: Location): Location =
        when(commands) {
            Nil -> location
            is Command -> f(commands.head)(run(f, commands.tail, location))
        }
}