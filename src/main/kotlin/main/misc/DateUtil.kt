package main.misc

import org.joda.time.DateTime
import java.util.*


/**
 * Utility functions that work with [Date].
 */

/**
 * Convert function, String -> LocalDateTime
 */
//val dateTimeStrToLocalDateTime: (String) -> LocalDateTime = {
//    LocalDateTime.parse(it, DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm"))
//}

/**
 * String version for the current day. Minutes and seconds are truncated, only day, month and year information
 */
//public val today: () -> Date = {
//    Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS))
//}

/**
 * Extension function over [Date].
 * Adds minutes.
 * @param minutes to add
 * @return current value plus set minutes
 */
fun Date.addMinutes(minutes: Int) : Date {
    return DateTime(this).plusMinutes(minutes).toDate()
}
