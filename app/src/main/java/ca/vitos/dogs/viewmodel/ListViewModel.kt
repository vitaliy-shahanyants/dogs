package ca.vitos.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.vitos.dogs.model.DoogBreed

class ListViewModel: ViewModel() {

    val dogs = MutableLiveData<List<DoogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DoogBreed("1","Corgi","15 years", "breedGroup","bredFor","temperament")
        val dog2 = DoogBreed("2","Labrador", "10 years", "breedGroup","bredFor","temperament")
        val dog3 = DoogBreed("3","Rottweiler","20 years", "breedGroup","bredFor","temperament")
        val dogList = arrayListOf<DoogBreed>(dog1,dog2,dog3)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
    }
}