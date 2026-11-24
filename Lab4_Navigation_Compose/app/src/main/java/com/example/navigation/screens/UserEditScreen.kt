package com.example.navigation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.data.getSampleUsers

/**
 * Экран редактирования демонстрационного профиля.
 * Изменённое имя передаётся предыдущему экрану через SavedStateHandle.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserEditScreen(userId: Int, navController: NavController) {
    val user = getSampleUsers().firstOrNull { it.id == userId }
    var name by remember(userId) { mutableStateOf(user?.name.orEmpty()) }

    Scaffold(topBar = { TopAppBar(title = { Text("Редактирование профиля") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            if (user == null) {
                Text("Пользователь не найден")
            } else {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Имя пользователя") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set("edited_name", name)
                        navController.popBackStack()
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) { Text("Сохранить и вернуться") }
            }
        }
    }
}


/** Предпросмотр экрана редактирования в Android Studio. */
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun UserEditPreview() {
    UserEditScreen(userId = 1, navController = androidx.navigation.compose.rememberNavController())
}
