package com.qohat

object DeliveryDSL {

    val move: (Char) -> (Location) -> Location = {
        command -> {
            location ->
                when (command) {
                    'U' -> goAhead(location)
                    'R' -> turnRight(location)
                    'L' -> turnLeft(location)
                    else -> location
                }
            }
        }

    private val turnLeft: (location: Location) -> Location = {
        location ->
        when(location.coordinate.direction) {
            North -> location.copy(coordinate = location.coordinate.copy(direction = East))
            West -> location.copy(coordinate = location.coordinate.copy(direction = North))
            South -> location.copy(coordinate = location.coordinate.copy(direction = West))
            East -> location.copy(coordinate = location.coordinate.copy(direction = South))
        }
    }

    private val turnRight: (location: Location) -> Location = {
        location ->
        when(location.coordinate.direction) {
            North -> location.copy(coordinate = location.coordinate.copy(direction = West))
            West -> location.copy(coordinate = location.coordinate.copy(direction = South))
            South -> location.copy(coordinate = location.coordinate.copy(direction = East))
            East -> location.copy(coordinate = location.coordinate.copy(direction = North))
        }
    }

    private val goAhead: (location: Location) -> Location = {
        location ->
        when(location.coordinate.direction) {
            North -> location.copy(coordinate = location.coordinate.copy(y = location.coordinate.y.copy(value = location.coordinate.y.value + 1)))
            West -> location.copy(coordinate = location.coordinate.copy(x = location.coordinate.x.copy(value = location.coordinate.x.value + 1)))
            South -> location.copy(coordinate = location.coordinate.copy(y = location.coordinate.y.copy(value = location.coordinate.y.value - 1)))
            East -> location.copy(coordinate = location.coordinate.copy(x = location.coordinate.x.copy(value = location.coordinate.x.value - 1)))
        }
    }
}

