package ew.bookofplans.model

import java.util.*

class Film(override var name: String,
           override var who: String,
           override var date: Date,
           override var inFuture: Boolean,
           var genre: String,
           var highPriority: Boolean = false) : Plan(name, who, date, inFuture) {


}