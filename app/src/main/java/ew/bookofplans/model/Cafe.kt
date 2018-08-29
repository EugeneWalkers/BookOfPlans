package ew.bookofplans.model

import java.util.*

class Cafe(override var name: String, override var who: String, override var date: Date):Plan(name, who, date) {
    var address: String? = null;
    var comfortableSofas: Boolean? = null
}