package com.example.aad_playground.ut02.exercise04.data

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.aad_playground.R
import com.example.aad_playground.ut02.exercise04.domain.CustomerModel
import com.example.aad_playground.ut02.exercise04.domain.IModels
import com.example.aad_playground.ut02.exercise04.serializer.JsonSerializer


/**
 * Clase para persistir información en SharedPreferences Encriptado
 */
class CustomerSharPrefLocalSource(
    context: Context,
    private val json: JsonSerializer
) : LocalSource {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptSharedPref = EncryptedSharedPreferences(
        context,
        context.getString(R.string.preference_file_exercise04),
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Función que me permite guardar un cliente en un SharedPreferences.
     */
    override fun save(model: IModels) {
        with(encryptSharedPref.edit()) {
            putString(
                model.getId().toString(),
                json.toJson(model, IModels::class.java)
            )
            apply()
        }
    }

    /**
     * Función que me permite guardar un listado de clientes en un SharedPreferences.
     */
    override fun save(modelList: List<IModels>) {
        removeAll()
        modelList.map { entity ->
            save(entity)
        }
    }

    /**
     * Función que me permite modificar los datos de un cliente que se encuentran en un fichero.
     * Se puede modificar cualquier dato excepto el id del cliente.
     */
    fun update(customer: CustomerModel) {
        if (encryptSharedPref.contains(customer.customerId.toString())) {
            remove(customer.customerId)
        }
        encryptSharedPref.edit()
            .putString(
                customer.customerId.toString(),
                json.toJson(customer, CustomerModel::class.java)
            )
            .apply()

    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    override fun remove(modelId: Int) {
        if (encryptSharedPref.contains(modelId.toString())) {
            val edit = encryptSharedPref.edit()
            edit.remove(modelId.toString())
            edit.apply()
        }
    }

    /**
     * Función que elimina todos los customer del archivo
     */
    fun removeAll() {
        val edit = encryptSharedPref.edit()
        encryptSharedPref.all.map {
            edit.remove(it.key)
        }
        edit.apply()
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    override fun fetch(): List<CustomerModel> {
        val list: MutableList<CustomerModel> = mutableListOf()
        encryptSharedPref.all.map {
            list.add(it.value as CustomerModel)
        }
        return list
    }

    override fun fetchById(modelId: Int): IModels? {
        return encryptSharedPref.getString(modelId.toString(), "def")
            ?.let { json.fromJson(it, CustomerModel::class.java) }
    }
}