package ew.bookofplans.model

import java.util.*

class Other(override var name: String,
            override var who: String,
            override var date: Date,
            override var inFuture: Boolean,
            var description: String,
            var highPriority: Boolean,
            var rating: String = "Неизвестно") : Plan(name, who, date, inFuture) {


}