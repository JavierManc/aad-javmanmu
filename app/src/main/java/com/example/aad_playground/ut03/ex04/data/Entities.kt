package com.example.aad_playground.ut03.ex04.data

import androidx.room.*
import com.example.aad_playground.ut03.ex04.domain.CustomerModel
import java.util.*

@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String
) {
    fun toModel(): CustomerModel {
        return CustomerModel(
            this.id,
            this.name,
            this.surname
        )
    }

    companion object {
        fun toEntity(customer: CustomerModel): CustomerEntity {
            return CustomerEntity(
                customer.id,
                customer.name,
                customer.surname
            )
        }
    }
}

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "price") val price: Double
)

@Entity(tableName = "invoice")
data class InvoiceEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "customer_id") val customerId: Int
)

@Entity(
    tableName = "invoice_lines_entity",
    primaryKeys = ["invoice_id", "product_id"]
)
data class InvoiceLinesEntity(
    @ColumnInfo(name = "invoice_id") val invoiceId: Int,
    @ColumnInfo(name = "product_id") val productId: Int
) {
    companion object {
        fun toEntity(invoiceId: Int, productsId: List<Int>) {
            productsId.map { InvoiceLinesEntity(invoiceId, it) }
        }
    }
}

data class InvoiceLinesWithCustomer(
    @Embedded val invoiceEntity: InvoiceEntity,
    @Relation(
        parentColumn = "customer_id",
        entityColumn = "id"
    ) val customerEntity: CustomerEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = InvoiceLinesEntity
        )
    )
)

