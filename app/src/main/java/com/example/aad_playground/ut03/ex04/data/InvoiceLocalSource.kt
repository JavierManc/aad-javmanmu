package com.example.aad_playground.ut03.ex04.data

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.aad_playground.ut03.ex04.app.Ut03Ex04DataBase
import com.example.aad_playground.ut03.ex04.domain.InvoiceLinesModel
import com.example.aad_playground.ut03.ex04.domain.InvoiceModel
import com.example.aad_playground.ut03.ex04.domain.ProductModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class InvoiceLocalSource(aplicationContext: Context) {

    private val db = Ut03Ex04DataBase.getInstance(aplicationContext)

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchAll(): List<InvoiceModel> {
        return db.invoiceDao().findAllInvoice().map { entity -> invoiceLinesToModel(entity) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchById(id: Int): InvoiceModel {
        return invoiceLinesToModel(db.invoiceDao().findInvoiceById(id))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun invoiceLinesToModel(invoiceLinesWithCustomer: InvoiceLinesWithCustomer): InvoiceModel {
        return InvoiceModel(
            invoiceLinesWithCustomer.invoiceEntity.id,
            LocalDate.parse(
                invoiceLinesWithCustomer.invoiceEntity.date,
                DateTimeFormatter.ISO_DATE
            ),
            invoiceLinesWithCustomer.customerEntity.toModel(),
            invoiceLinesWithCustomer.invoiceLinesEntity.map { entity ->
                InvoiceLinesModel(
                    entity.invoiceId,
                    getProductById(entity.productId).toModel()
                )
            }
        )
    }

    private fun getProductById(id: Int): ProductEntity {
        return db.productDao().findProductById(id)
    }

    fun saveInvoice(invoice: InvoiceModel) {
        db.invoiceDao().saveInvoice(
            InvoiceEntity(invoice.id, invoice.date.toString(), invoice.customerModel.id),
            CustomerEntity(
                invoice.customerModel.id,
                invoice.customerModel.name,
                invoice.customerModel.surname
            ),
            invoice.invoiceLinesModel.map { entity ->
                InvoiceLinesEntity(
                    entity.id,
                    entity.product.id
                )
            }
        )

        invoice.invoiceLinesModel.forEach { model ->
            saveProduct(model.product)
        }
    }

    private fun saveProduct(product: ProductModel) {
        db.productDao().saveProduct(
            ProductEntity(
                product.id,
                product.name,
                product.model,
                product.price
            )
        )
    }


}