package ikhwan.binar.estafetprotodatastore

import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import ikhwan.binar.protodatastore.LoginPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

class EstafetRepository(context: Context) {
    private val dataStore: DataStore<LoginPreferences> = context.createDataStore(
        "loginData",
        serializer = EstafetSerializer()
    )

    val readProto: Flow<LoginPreferences> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                Log.e(ContentValues.TAG, "Error reading sort order preferences.", exception)
                emit(LoginPreferences.getDefaultInstance())
            } else {
                throw exception
            }
        }

    suspend fun updateData(username: String, password: String){
        dataStore.updateData {
            it.toBuilder().setUsername(username).setPassword(password).build()
        }
    }

    suspend fun clearData(){
        dataStore.updateData {
            it.toBuilder().clearUsername().clearPassword().build()
        }
    }
}