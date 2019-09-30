package ca.vitos.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.vitos.dogs.model.DoogBreed

class DetailViewModel: ViewModel() {

    val dogLiveData = MutableLiveData<DoogBreed>()

    fun fetch() {
        // TODO this is temp option, you will pass the values through navigation fragmane t
        val dog =  DoogBreed("1","Corgi","15 years", "breedGroup","bredFor","temperament")

        dogLiveData.value = dog


    }


}