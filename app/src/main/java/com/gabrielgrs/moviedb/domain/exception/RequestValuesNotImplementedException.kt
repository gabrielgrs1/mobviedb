package com.gabrielgrs.moviedb.domain.exception

class RequestValuesNotImplementedException : RuntimeException() {

    override val message: String?
        get() = "Needs to be implement class" + this.javaClass.name
}