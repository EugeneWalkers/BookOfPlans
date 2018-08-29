package ew.bookofplans.model

import java.util.*

class Other(override var name: String, override var who: String, override var date: Date):Plan(name, who, date) {

    var description: String? = null
    var priority: String? = null

}