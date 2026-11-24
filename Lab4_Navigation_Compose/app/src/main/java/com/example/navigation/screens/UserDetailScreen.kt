package com.example.navigation.screens

import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.components.DetailCard
import com.example.navigation.data.getSampleUsers

/**
 * Детальный экран выбранного пользователя.
 * @param userId идентификатор пользователя из маршрута
 * @param navController контроллер навигации
 * @param modifier модификатор разметки
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(userId: Int, navController: NavController, modifier: Modifier = Modifier) {
    val user = getSampleUsers().firstOrNull { it.id == userId }
    val editedName = navController.currentBackStackEntry
        ?.savedStateHandle
        ?.getStateFlow("edited_name", user?.name.orEmpty())
        ?.collectAsState()
        ?.value ?: user?.name.orEmpty()
    val snackbarHostState = androidx.compose.runtime.remember { SnackbarHostState() }

    LaunchedEffect(userId) {
        snackbarHostState.showSnackbar("Открыт профиль пользователя")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Профиль пользователя") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            if (user == null) {
                Text("Пользователь с таким идентификатором не найден.")
            } else {
                DetailCard(user.copy(name = editedName))
                Button(
                    onClick = { navController.navigate("user_edit/${user.id}") },
                    modifier = Modifier.padding(top = 20.dp)
                ) { Text("Редактировать профиль") }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun UserDetailPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    UserDetailScreen(userId = 1, navController = navController)
}
