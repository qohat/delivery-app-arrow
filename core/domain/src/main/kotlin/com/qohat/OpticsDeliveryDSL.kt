package com.qohat

object OpticsDeliveryDSL {

    val move: (Char) -> (Location) -> Location = {
        command -> {
            location ->
                when(command) {
                    'U' -> goAheadOptic(location)
                    'R' -> turnRightOptic(location)
                    'L' -> turnLeftOptic(location)
                    else -> location
                }
        }
    }


    private fun turnLeftOptic(location: Location): Location =
        when(location.coordinate.direction) {
            North -> Location.coordinate.direction.modify(location) { East }
            West -> Location.coordinate.direction.modify(location) { North }
            South -> Location.coordinate.direction.modify(location) { West }
            East -> Location.coordinate.direction.modify(location) { South }
        }
    
    private fun turnRightOptic(location: Location): Location =
        when(location.coordinate.direction) {
            North -> Location.coordinate.direction.modify(location) { West }
            West -> Location.coordinate.direction.modify(location) { South }
            South -> Location.coordinate.direction.modify(location) { East }
            East -> Location.coordinate.direction.modify(location) { North }
        }

    private fun goAheadOptic(location: Location): Location =
        when(location.coordinate.direction) {
            North -> Location.coordinate.y.modify(location) { location.coordinate.y.value + 1}
            West -> Location.coordinate.x.modify(location) { location.coordinate.x.value + 1}
            South -> Location.coordinate.y.modify(location) { location.coordinate.y.value - 1}
            East -> Location.coordinate.x.modify(location) { location.coordinate.x.value - 1}
        }
}