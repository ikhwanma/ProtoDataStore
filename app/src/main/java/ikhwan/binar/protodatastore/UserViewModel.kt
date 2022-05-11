package ikhwan.binar.protodatastore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val repo = UserRepository(application)

    val data = repo.readProto.asLiveData()

    fun updateData(name : String) = viewModelScope.launch {
        repo.updateData(name)
    }

    fun clearData() = viewModelScope.launch {
        repo.clearData()
    }
}