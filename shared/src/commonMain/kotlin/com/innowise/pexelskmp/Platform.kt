package com.innowise.pexelskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform