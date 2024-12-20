package com.yanic.api.test.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yanic.api.test.MainViewModel
import com.yanic.api.test.R

@Composable
fun CardListScreen(viewModel: MainViewModel = viewModel()) {
    val cards by viewModel.cards.collectAsState()
    val isLoading by viewModel.isLoading

    LaunchedEffect(Unit) {
        viewModel.fetchCards()
    }

    if (isLoading) {
        // Loading indicator
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (cards.isEmpty()) {
        // Error message if data is not available
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(stringResource(R.string.unexpected_error))
        }
    } else {
        // Show List
        LazyColumn {
            items(cards) { card ->
                CardItem(card)
            }
        }
    }
}