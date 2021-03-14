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
package com.example.androiddevchallenge.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.Home
import com.example.androiddevchallenge.ui.screens.LogIn
import com.example.androiddevchallenge.ui.screens.Welcome

/**
 * Models the screens in the app and any arguments they require.
 */
@Composable
fun NavGraph(startDestination: String = "Welcome") {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = startDestination) {
        composable("Welcome") { Welcome(onLogin = actions.login) }
        composable("Login") { LogIn(onHome = actions.home) }
        composable("Home") { Home() }
    }
}

/**
 * Models the navigation actions in the app.
 */
class Actions(navController: NavController) {
    val login: () -> Unit = {
        navController.navigate("Login")
    }

    val home: () -> Unit = {
        navController.navigate("Home")
    }
}
