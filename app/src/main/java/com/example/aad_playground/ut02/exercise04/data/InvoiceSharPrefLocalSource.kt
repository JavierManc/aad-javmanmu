package com.example.aad_playground.ut02.exercise04.data

import android.content.Context
import com.example.aad_playground.R
import com.example.aad_playground.ut02.exercise04.domain.InvoiceModel
import com.example.aad_playground.ut02.exercise04.serializer.JsonSerializer


/**
 * Clase para persistir información en SharedPreferences.
 */
class InvoiceSharPrefLocalSource(
    context: Context,
    private val json: JsonSerializer
) : InvoiceLocalSource {

    private val sharedpref = context.getSharedPreferences(
        context.getString(R.string.preference_file_exercise04),
        Context.MODE_PRIVATE
    )

    /**
     * Función que me permite guardar un cliente en un sharedprefe.
     */
    override fun save(model: InvoiceModel) {
        with(sharedpref.edit()) {
            putString(model.invoiceId.toString(), json.toJson(model, InvoiceModel::class.java))
            apply()
        }
    }

    override fun save(modelList: List<InvoiceModel>) {
        removeAll()
        modelList.map { entity ->
            save(entity)
        }
    }

    fun removeAll() {
        val edit = sharedpref.edit()
        sharedpref.all.map {
            edit.remove(it.key)
        }
        edit.apply()
    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    override fun remove(modelId: Int) {
        if (sharedpref.contains(modelId.toString())) {
            val edit = sharedpref.edit()
            edit.remove(modelId.toString())
            edit.apply()
        }
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    override fun fetch(): List<InvoiceModel> {
        val invoiceList: MutableList<InvoiceModel> = mutableListOf()
        sharedpref.all.map {
            invoiceList.add(it.value as InvoiceModel)
        }

        return invoiceList
    }

    override fun fetchById(modelId: Int): InvoiceModel? {
        return sharedpref.getString(modelId.toString(), "def")
            ?.let { json.fromJson(it, InvoiceModel::class.java) }
    }
}