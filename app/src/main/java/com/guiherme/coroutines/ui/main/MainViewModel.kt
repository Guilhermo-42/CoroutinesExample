package com.guiherme.coroutines.ui.main

import androidx.lifecycle.*
import com.guiherme.coroutines.network.FactsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val factApi: FactsApi) : ViewModel(), LifecycleObserver {

    private val mutableText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val textLive: LiveData<String> get() = mutableText

    fun onSubmitClicked() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val fact = factApi.getAFact()
//
//            withContext(Dispatchers.Main) {
//                mutableText.postValue(fact.factDescription)
//            }
//        }

        viewModelScope.launch {
            val androidFact = async { factApi.getAndroidFact() }
            val iosFact = async { factApi.getIosFact() }

            withContext(Dispatchers.Main) {
                mutableText.postValue(androidFact.await().factDescription.plus(" ").plus(iosFact.await().factDescription))
            }
        }

    }

}