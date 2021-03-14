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
package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import com.example.androiddevchallenge.R

@Stable
class GardenItem(
    val name: String,
    @StringRes val description: Int,
    @DrawableRes val imageResource: Int,
    selected: Boolean = false
) {
    val selected = mutableStateOf(selected)
}

val gardenCollection = listOf(
    GardenItem("Desert chic ", R.string.item_description, R.drawable.desert_chic),
    GardenItem("Tiny terrariums ", R.string.item_description, R.drawable.tiny_terrariums),
    GardenItem("Jungle vibes ", R.string.item_description, R.drawable.jungle_vibes),
    GardenItem("Easy care ", R.string.item_description, R.drawable.easy_care),
    GardenItem("Statements ", R.string.item_description, R.drawable.statements),
    GardenItem("Monstrea ", R.string.item_description, R.drawable.monstera),
    GardenItem("Aglaonema ", R.string.item_description, R.drawable.aglaonema),
    GardenItem("Peace lily ", R.string.item_description, R.drawable.peace_lily),
    GardenItem("Fiddle leaf ", R.string.item_description, R.drawable.fiddle_leaf),
    GardenItem("Snake plant ", R.string.item_description, R.drawable.snake_plant),
    GardenItem("Pothos ", R.string.item_description, R.drawable.pothos)
)
