package ew.bookofplans.model

import java.util.*

abstract class Plan() {

    abstract var name: String
    abstract var who: String
    abstract var date: Date

    constructor(name: String, who: String, date: Date) : this() {
        this.name = name
        this.who = who
        this.date = date
    }
}