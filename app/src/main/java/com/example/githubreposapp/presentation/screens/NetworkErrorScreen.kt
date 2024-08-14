package com.example.githubreposapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.githubreposapp.R
import com.example.githubreposapp.presentation.screens.common_components.AppBar
import com.example.githubreposapp.theme.GithubReposAppTheme

@ExperimentalMaterial3Api
@Composable
fun NetworkErrorScreen() {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.animation)
            )
            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = LottieConstants.IterateForever
            )
            AppBar(
                title = R.string.github_repositories,
                showBackButton = false
            )
            HorizontalDivider(thickness = 1.dp)
            Spacer(modifier = Modifier.weight(0.7f))
            LottieAnimation(
                composition = composition,
                progress = {
                    progress
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            )
            Text(
                text =
                stringResource(id = R.string.something_went_wrong),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(18.dp)
            )
            Text(
                text = stringResource(id = R.string.network_exception_meesage),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                onClick = { },
                shape = MaterialTheme.shapes.extraSmall,
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    width = 3.dp,
                    brush = Brush.linearGradient(
                        listOf(
                            MaterialTheme.colorScheme.outline,
                            MaterialTheme.colorScheme.outline
                        )
                    ),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .padding(horizontal = 32.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.retry),
                    fontSize = 22.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.outline,
                    letterSpacing = 2.sp
                )

            }
            Spacer(modifier = Modifier.weight(0.7f))

        }

    }

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
private fun NetworkErrorScreenPreview() {
    GithubReposAppTheme {
        NetworkErrorScreen()
    }

}