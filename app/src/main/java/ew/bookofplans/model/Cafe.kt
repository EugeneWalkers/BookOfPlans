package ew.bookofplans.model

import java.util.*

class Cafe(override var name: String,
           override var who: String,
           override var date: Date,
           var address: String,
           override var inFuture: Boolean = true,
           var comfortableSofas: String = "Неизвестно",
           var food: String = "Неизвестно",
           var drinks: String = "Неизвестно") : Plan(name, who, date, inFuture) {
}