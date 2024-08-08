package com.example.cadastrocartao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cadastrocartao.model.CartaoModel
import com.example.cadastrocartao.repository.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(/* savedInstanceState = */ savedInstanceState)
        setContentView(R.layout.activity_main)

        val cartaoDatabase = AppDatabase.getDataBase(this).CartaoDao()

        val retornoInsert = cartaoDatabase.InsertCartao(CartaoModel().apply {
            this.numero_cartao = "123.345.678"
            this.titular = "Ana Clara"
            this.cvv = "500"
            this.data_vencimento = "01/11/2029"
        })

        val retornoSelectMultiplo = cartaoDatabase.getAll()

        for (item in retornoSelectMultiplo) {
            Log.d(
                "Retorno",
                "id_cartao: ${item.id_cartao}, numero: ${item.numero_cartao}, titular: ${item.titular}, cvv: ${item.cvv}, data_vencimento: ${item.data_vencimento}"
            )
        }
    }
}


