package com.example.hafhashtad.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.hafhashtad.domain.Product

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductListScreen(modifier: Modifier = Modifier, productList: List<Product>) {

    Column(modifier = Modifier.fillMaxSize()) {
        val title = remember {
            mutableStateOf("")
        }
        TextField(value = title.value, onValueChange = {
            title.value = it
        })
        LazyColumn() {
            stickyHeader {
                product.category
            }
            items(productList) { product ->

                Row() {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = product.title)
                        Text(text = product.description)
                        Text(text =)

                    }
                }

            }
        }
    }
}