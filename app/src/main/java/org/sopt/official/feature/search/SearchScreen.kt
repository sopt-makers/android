package org.sopt.official.feature.search

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.official.style.SoptTheme

@Composable
fun SearchScreen() {
    SoptTheme {
        Notices()
    }
}

@Composable
private fun SearchBar() {

}

@Composable
private fun Notices(notices: List<Int> = List(10) { it }) {
    LazyColumn(modifier = Modifier.padding(vertical = 8.dp)) {
        items(items = notices) { name ->
            Notice(notice = name)
        }
    }
}

@Composable
private fun Notice(notice: Int) {
    Card(
        backgroundColor = SoptTheme.colors.background, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        val isNewNotice = listOf<Boolean>(true, false, false, true, false, true, true, true, true, true)[notice]
        NoticeContent(notice, isNewNotice)
    }
}

@Composable
private fun NoticeContent(notice: Int, isNewNotice: Boolean) {
//    val isNewNotice by rememberSaveable { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 4.dp)
            ) {
                if (isNewNotice) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp),
                        imageVector = Icons.Filled.Check,
                        contentDescription = "ad",
                        tint = SoptTheme.colors.primary,
                    )
                }
                Text(
                    text = "31th SOPT 공지 $notice",
                    color = SoptTheme.colors.onSurface90,
                    style = SoptTheme.typography.b1,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            Text(
                text = "공지공지공지공지공지공지공지", color = SoptTheme.colors.onSurface30, style = SoptTheme.typography.caption
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun NoticesPreview() {
    SoptTheme {
        Notices()
    }
}