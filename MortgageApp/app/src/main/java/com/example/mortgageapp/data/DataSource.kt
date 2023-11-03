package com.example.mortgageapp.data

enum class MortgageTerms(val years: Int){
    TEN(10),
    FIFTEEN(15),
    THIRTY(30),
}

@JvmInline
value class Money(val value: String)

@JvmInline
value class Apr(val value: String)
