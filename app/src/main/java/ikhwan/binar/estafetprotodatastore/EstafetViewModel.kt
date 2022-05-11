package ikhwan.binar.estafetprotodatastore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EstafetViewModel(application: Application):AndroidViewModel(application) {
    private val repo = EstafetRepository(application)

    val data = repo.readProto.asLiveData()

    fun updateData(username: String, password: String)= viewModelScope.launch {
        repo.updateData(username, password)
    }
}