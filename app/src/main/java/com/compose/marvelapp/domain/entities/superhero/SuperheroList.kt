package com.compose.marvelapp.domain.entities.superhero

object SuperheroList {
    val superheroes = listOf(
        SuperheroModel(
            name = "Iron Man",
            urlGifImage = "https://steamuserimages-a.akamaihd.net/ugc/951830941729198784/E067F4BC94F5A6ACB40BB16C6DACCE3917179F67/?imw=5000&imh=5000&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=false"
        ),
        SuperheroModel(
            name = "Thor",
            urlGifImage = "https://i.pinimg.com/originals/5b/d8/ff/5bd8ff1b342ed586b6661584f5e13065.gif"
        ),
        SuperheroModel(
            name = "Hulk",
            urlGifImage = "https://i.pinimg.com/originals/ca/2b/36/ca2b365919138f12b807f29931eeb98b.gif"
        ),
        SuperheroModel(
            name = "Captain America",
            urlGifImage = "https://i.gifer.com/MOvr.gif"
        )
    )
}