package com.example.aad_playground.ut_01.ex02

/**
 * Clase para persistir información en ficheros.
 */
class InvoiceFileLocalSource {

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(invoice: InvoiceModel) {
        //TODO
    }

    /**
     * Función que me permite eliminar un cliente de un fichero.
     */
    fun remove(invoiceId: Int) {

    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un fichero.
     */
    fun fetch(): List<InvoiceModel> {
        //TODO
        return emptyList()
    }

    fun findById(invoiceId: Int): InvoiceModel? {
        //TODO
        return null
    }
}