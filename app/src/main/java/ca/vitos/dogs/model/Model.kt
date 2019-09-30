package ca.vitos.dogs.model

import com.google.gson.annotations.SerializedName

data class DoogBreed(

    @SerializedName(value = "id")
    val breedID: String?,
    @SerializedName(value = "name")
    val dogBreed: String?,
    @SerializedName(value = "life_span")
    val lifeSpan: String?,
    @SerializedName(value = "bred_for")
    val bredFor: String?,
    @SerializedName(value= "temperament")
    val temperament: String?,
    @SerializedName(value = "url")
    val imageUrl: String?


)