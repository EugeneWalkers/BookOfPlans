package ew.bookofplans.model

import java.util.*

abstract class Plan() {

    abstract var name: String
    abstract var who: String
    abstract var date: Date
    abstract var inFuture: Boolean

    constructor(name: String, who: String, date: Date, inFuture: Boolean) : this() {
        this.name = name
        this.who = who
        this.date = date
        this.inFuture = inFuture
    }
}