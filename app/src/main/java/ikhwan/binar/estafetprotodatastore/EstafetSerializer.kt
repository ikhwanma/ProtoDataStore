package ikhwan.binar.estafetprotodatastore

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import ikhwan.binar.protodatastore.LoginPreferences
import java.io.InputStream
import java.io.OutputStream

class EstafetSerializer : Serializer<LoginPreferences> {
    override fun readFrom(input: InputStream): LoginPreferences {
        try {
            return LoginPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: LoginPreferences, output: OutputStream) {
        t.writeTo(output)
    }
}