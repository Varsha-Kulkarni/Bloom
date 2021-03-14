/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.GardenItem
import com.example.androiddevchallenge.data.gardenCollection
import com.example.androiddevchallenge.ui.theme.gray

private val BottomBarHeight = 56.dp

private val bottomNavigationItems = listOf(
    BottomNavigationItem.Home,
    BottomNavigationItem.Favorites,
    BottomNavigationItem.Profile,
    BottomNavigationItem.Cart,
)

sealed class BottomNavigationItem(val title: String, val icon: ImageVector) {
    object Home : BottomNavigationItem("Home", Icons.Filled.Home)
    object Favorites : BottomNavigationItem("Favorites", Icons.Outlined.FavoriteBorder)
    object Profile : BottomNavigationItem("Profile", Icons.Filled.AccountCircle)
    object Cart : BottomNavigationItem("Cart", Icons.Filled.ShoppingCart)
}

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    elevation = 16.dp,
                    modifier = Modifier.height(56.dp),
                ) {
                    bottomNavigationItems.forEach { item ->
                        BottomNavigationItem(
                            onClick = {},
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                )
                            },
                            label = {
                                Text(
                                    item.title,
                                    style = MaterialTheme.typography.caption,
                                    color = MaterialTheme.colors.onPrimary,
                                )
                            },
                            selected = item == BottomNavigationItem.Home,
                        )
                    }
                }
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, bottom = BottomBarHeight)
            ) {
                val scroll = rememberScrollState(0)
                Header()
                Body(scroll)
            }
        }
    }
}

@Composable
fun Header() {
    OutlinedTextField(
        "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
            )
        },
        placeholder = {
            Text(
                stringResource(R.string.search_placeholder),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary,
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
    )
}

@Composable
fun Body(scroll: ScrollState) {
    Column(modifier = Modifier.verticalScroll(scroll)) {
        Text(
            stringResource(R.string.browse_themes),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.paddingFromBaseline(top = 32.dp),
        )

        LazyRow(modifier = Modifier.padding(top = 16.dp)) {
            items(gardenCollection) { item ->
                ThemeItem(item)
                Spacer(modifier = Modifier.size(8.dp))
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        ) {
            Text(
                stringResource(R.string.design_garden),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
            )
            Icon(
                Icons.Filled.FilterList,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(24.dp),
            )
        }
        for (item in gardenCollection) {
            DesignGardenItem(item)
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun ThemeItem(item: GardenItem) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp,
        modifier = Modifier
            .size(138.dp)
            .padding(2.dp),
    ) {
        Surface(color = MaterialTheme.colors.surface) {
            Column {
                Image(
                    painterResource(item.imageResource),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier.height(96.dp),
                )
                Text(
                    item.name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .height(40.dp)
                        .padding(start = 8.dp)
                        .paddingFromBaseline(top = 24.dp),
                )
            }
        }
    }
}

@Composable
fun DesignGardenItem(item: GardenItem) {
    val (selected, setSelected) = item.selected

    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Log.i(" ", "${item.imageResource}")
        Image(
            painterResource(item.imageResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.small),
        )
        Box {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
                    .height(64.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Text(
                        item.name,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp),
                    )
                    Text(
                        stringResource(id = item.description),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.paddingFromBaseline(bottom = 24.dp),
                    )
                }
                Checkbox(
                    selected,
                    onCheckedChange = setSelected,
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = MaterialTheme.colors.background,
                    ),
                    modifier = Modifier.padding(bottom = 24.dp),
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp),
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    color = gray,
                )
            }
        }
    }
}
