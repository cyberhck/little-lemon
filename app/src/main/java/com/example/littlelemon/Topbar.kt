package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Topbar(profile: Painter?, onProfileIconClick: (() -> Unit)?) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(if (profile != null) 0.8f else 1f)
                .padding(10.dp)
        )
        if (profile != null) {
            Image(
                painter = profile,
                contentDescription = "Profile",
                modifier = Modifier.clickable {
                    if (onProfileIconClick != null) {
                        onProfileIconClick()
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun TopbarPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                Topbar(painterResource(R.drawable.profile), null)
            }
        }
    }
}
