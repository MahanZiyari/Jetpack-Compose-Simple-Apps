package com.mahan.simplecoilapp

// Utility function to get a random number
// between lowerBound and upperBound
fun getRandomNumber(lowerBound: Int, upperBound: Int) =
    (lowerBound..upperBound).toList().shuffled().first()