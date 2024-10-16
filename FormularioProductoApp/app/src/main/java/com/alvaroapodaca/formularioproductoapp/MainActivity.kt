package com.alvaroapodaca.formularioproductoapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@Composable
fun FormularioProducto() {
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var existencia by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("Electrónica") }

    // Opciones de categoría
    val categorias = listOf("Electrónica", "Ropa", "Alimentos")

    Column(modifier = Modifier.padding(16.dp)) {
        // Campo para el nombre del producto
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo para el precio del producto
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo para la marca del producto
        TextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo para la existencia del producto
        TextField(
            value = existencia,
            onValueChange = { existencia = it },
            label = { Text("Existencia") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Selector de categoría con RadioButton
        Text("Categoría:")
        categorias.forEach { opcion ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = categoria == opcion,
                    onClick = { categoria = opcion }
                )
                Text(opcion)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para enviar y borrar el formulario
        Button(
            onClick = {
                // Limpiar los campos
                nombre = ""
                precio = ""
                marca = ""
                existencia = ""
                categoria = "Electrónica"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioProductoPreview() {
    FormularioProducto()
}