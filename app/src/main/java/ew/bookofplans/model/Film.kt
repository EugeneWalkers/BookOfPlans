package ew.bookofplans.model

import java.util.*

class Film(override var name: String, override var who: String, override var date: Date, var priority: String, var genre: String):Plan(name, who, date){


}