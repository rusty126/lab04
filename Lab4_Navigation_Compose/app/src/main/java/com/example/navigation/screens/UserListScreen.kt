package com.example.navigation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.components.UserCard
import com.example.navigation.data.getSampleUsers

/**
 * Экран списка пользователей.
 * @param navController контроллер переходов
 * @param modifier модификатор разметки
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val users = remember { getSampleUsers() }
    var selectedFilter by rememberSaveable { mutableStateOf("") }

    Scaffold(topBar = { TopAppBar(title = { Text("Список пользователей") }) }) { padding ->
        LazyColumn(
            modifier = modifier.fillMaxSize().padding(padding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 8.dp)
        ) {
            items(users.filter { it.name.contains(selectedFilter, ignoreCase = true) }, key = { it.id }) { user ->
                UserCard(user = user, onClick = {
                    navController.navigate("user_detail/${user.id}")
                })
            }
        }
    }
}


/** Предпросмотр экрана списка в Android Studio. */
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun UserListPreview() {
    UserListScreen(navController = androidx.navigation.compose.rememberNavController())
}
