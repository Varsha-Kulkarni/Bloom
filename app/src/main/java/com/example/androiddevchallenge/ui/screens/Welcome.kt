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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome(onLogin: () -> Unit = {}) {
    Surface(color = MaterialTheme.colors.primary) {

        Box {
            Image(
                painterResource(R.drawable.ic_welcome_bg),
                contentDescription = null,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight(),
            ) {
                Row(modifier = Modifier.padding(top = 48.dp, start = 88.dp)) {
                    Image(
                        painterResource(R.drawable.ic_welcome_illos),
                        contentDescription = null,
                    )
                }
                Image(
                    painterResource(R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 48.dp),
                )
                Text(
                    stringResource(R.string.welcome_message),
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                )
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary
                    ),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Text(
                        stringResource(R.string.create_account),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary,
                    )
                }
                TextButton(
                    onClick = onLogin,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(48.dp),
                ) {
                    Text(
                        stringResource(R.string.login),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.secondary,
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}
