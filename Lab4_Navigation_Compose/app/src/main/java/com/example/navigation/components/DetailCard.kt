package com.example.navigation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigation.data.User

/** Карточка с подробной информацией о пользователе. */
@Composable
fun DetailCard(user: User, modifier: Modifier = Modifier) {
    Card(modifier.fillMaxWidth()) {
        Column(Modifier.padding(20.dp)) {
            Text(user.name, style = MaterialTheme.typography.headlineSmall)
            Text("Возраст: ${user.age} лет", Modifier.padding(top = 12.dp))
            Text("Город: ${user.city}", Modifier.padding(top = 8.dp))
            Text("Email: ${user.email}", Modifier.padding(top = 8.dp))
        }
    }
}
