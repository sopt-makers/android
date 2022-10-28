package org.sopt.official.feature.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import org.sopt.official.R
import org.sopt.official.config.navigation.SettingNavGraph
import org.sopt.official.designsystem.components.TopBarIconButton
import org.sopt.official.designsystem.style.SoptTheme

@SettingNavGraph(start = true)
@Destination("menu")
@Composable
fun SettingScreen(
    navigator: DestinationsNavigator,
) {
    SoptTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Toolbar { navigator.popBackStack() }

        }
    }
}

@Composable
private fun Toolbar(
    onBack: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TopBarIconButton(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                onClick = onBack
            )
            Text(
                text = "설정",
                style = SoptTheme.typography.h5
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    SettingScreen(navigator = EmptyDestinationsNavigator)
}
