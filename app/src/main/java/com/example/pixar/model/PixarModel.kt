package com.example.pixar.model

data class PixarModel(
    var hits: ArrayList<SearchResult>
)

data class SearchResult(
    var largeImageURL: String
)
