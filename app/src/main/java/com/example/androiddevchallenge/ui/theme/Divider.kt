package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Divider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f),
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp,
) {
    androidx.compose.material.Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
        startIndent = startIndent,
    )
}