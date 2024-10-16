package com.alvaroapodaca.registrorecetaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.alvaroapodaca.registrorecetaapp.ui.theme.RegistroRecetaAppTheme


data class Recipe(
    val name: String,
    val prepTime: String,
    val ingredients: String,
    val calories: String,
    val imageUrl: String
)

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroRecetaAppTheme {
                // Aplicar tema oscuro o claro
                Surface(modifier = Modifier.fillMaxSize()) {
                    RecipeApp()
                }
            }
        }
    }
}

@Composable
fun RecipeApp() {
    var recipeList by remember { mutableStateOf(listOf<Recipe>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Formulario de ingreso de receta
        RecipeForm { newRecipe ->
            recipeList = recipeList + newRecipe
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Lista de recetas
        LazyColumn {
            items(recipeList.size) { index ->
                RecipeItem(recipe = recipeList[index]) {
                    recipeList = recipeList.toMutableList().also { it.removeAt(index) }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeForm(onAddRecipe: (Recipe) -> Unit) {
    var name by remember { mutableStateOf("") }
    var prepTime by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Nombre del plato") })
        TextField(value = prepTime, onValueChange = { prepTime = it }, label = { Text("Tiempo de preparación") })
        TextField(value = ingredients, onValueChange = { ingredients = it }, label = { Text("Ingredientes (separados por comas)") })
        TextField(value = calories, onValueChange = { calories = it }, label = { Text("Calorías por porción") })
        TextField(value = imageUrl, onValueChange = { imageUrl = it }, label = { Text("URL de la imagen") })

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val recipe = Recipe(name, prepTime, ingredients, calories, imageUrl)
            onAddRecipe(recipe)
            // Limpiar formulario
            name = ""
            prepTime = ""
            ingredients = ""
            calories = ""
            imageUrl = ""
        }) {
            Text("Agregar Receta")
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onDelete: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = recipe.name, style = MaterialTheme.typography.titleMedium)
        LazyRow {
            item {
                Column(modifier = Modifier.padding(end = 8.dp)) {
                    Text(text = "Tiempo: ${recipe.prepTime}")
                    Text(text = "Ingredientes: ${recipe.ingredients}")
                    Text(text = "Calorías: ${recipe.calories}")
                    // Aquí podrías cargar la imagen desde la URL usando Coil o Glide
                    Image(
                        painter = rememberAsyncImagePainter(recipe.imageUrl),
                        contentDescription = "Imagen del plato",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
        Button(onClick = onDelete, modifier = Modifier.padding(top = 8.dp)) {
            Text("Eliminar")
        }
    }
}



