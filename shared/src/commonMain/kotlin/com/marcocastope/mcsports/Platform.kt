package com.marcocastope.mcsports

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform