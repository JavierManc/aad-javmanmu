package com.example.aad_playground.ut02.exercise04

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.aad_playground.R
import com.example.aad_playground.ut02.exercise04.serializer.JsonSerializer


/**
 * Clase para persistir información en SharedPreferences Encriptado
 */
class CustomerSharPrefLocalSource(
    activity: AppCompatActivity,
    private val json: JsonSerializer
) {

    private val sharedpref = activity.getSharedPreferences(
        activity.getString(R.string.preference_file_exercise04),
        Context.MODE_PRIVATE
    )

    private val masterKey = MasterKey.Builder(activity)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptSharedPref = EncryptedSharedPreferences(
        activity,
        activity.getString(R.string.preference_file_exercise04),
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Función que me permite guardar un cliente en un SharedPreferences.
     */
    fun save(customer: CustomerModel) {
        val edit = encryptSharedPref.edit()
        edit.putString(customer.id.toString(), json.toJson(customer, CustomerModel::class.java))
        edit.apply()
    }

    /**
     * Función que me permite guardar un listado de clientes en un SharedPreferences.
     */
    fun save(customers: List<CustomerModel>) {

    }

    /**
     * Función que me permite modificar los datos de un cliente que se encuentran en un fichero.
     * Se puede modificar cualquier dato excepto el id del cliente.
     */
    fun update(customer: CustomerModel) {
        //TODO
    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    fun remove(customerId: Int) {

    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    /*fun fetch(): List<CustomerModel> {
        val list: MutableList<CustomerModel>
        encryptSharedPref.all.values
    }
*/
    fun findById(customerId: Int): CustomerModel? {
        return encryptSharedPref.getString(customerId.toString(), "def")?.let { json.fromJson(it, CustomerModel::class.java) }
    }
}