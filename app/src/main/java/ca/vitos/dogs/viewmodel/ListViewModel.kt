package ca.vitos.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.vitos.dogs.model.DogsApiService
import ca.vitos.dogs.model.DoogBreed
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {

    private val dogService = DogsApiService()
    private val disposable = CompositeDisposable()

    val dogs = MutableLiveData<List<DoogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {

        fetchFromRemote()

    }

    private fun fetchFromRemote() {
        loading.value = true
        disposable.add(
            dogService.getDogs().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DoogBreed>>(){
                    override fun onSuccess(dogList: List<DoogBreed>) {
                       dogs.value = dogList
                        dogsLoadError.value  = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        dogsLoadError.value  = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}