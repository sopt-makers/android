package org.sopt.official.feature.search

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.official.style.SoptTheme

/**
 * 검색 분기
 * 1. 검색 전 -> BeforeSearch
 * 2. 검색 후
 *      2-1. 검색 결과 있음 -> SearchResult
 *      2-2. 검색 결과 없음 -> NoSearchResult
 *      2-3. 검색 오류 -> SearchErrorResult
 */

@Composable
fun SearchScreen() {
    SoptTheme {
        SearchBar()
    }
}


@OptIn(ExperimentalComposeUiApi::class) // for LocalSoftwareKeyboardController
@Composable
private fun SearchBar() {
//    /** TODO
//     * clearButton -> 텍스트 지우기
//     * backButton -> 뒤로가기 onNavigateBack()
//     * keyboardController -> 검색 완료시 키보드 숨기기
//     * focusRequester -> 화면 진입시 검색창에 포커스 주기
//     * ...?
//     */

    val showClearButton by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) { // 화면 진입시에
        focusRequester.requestFocus() // 검색창에 포커스 주기
    }

    TopAppBar(
        title = { Text(text = "검색어를 입력해주세요 ") },
        navigationIcon = {
            IconButton(onClick = { /*TODO onNavigateBack */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    modifier = Modifier,
                    contentDescription = "back button"
                )
            }
        },
        actions = {/*TODO serach */ },
        backgroundColor = SoptTheme.colors.background
    )
}

/** BeforeSearch */
@Composable
private fun BeforeSearch() {
}

/** NoSearchResult */
@Composable
private fun NoSearchResult() {
}

/** SearchErrorResult */
@Composable
private fun SearchErrorResult() {
}

/** SearchResult */
@Composable
private fun SearchResult() {
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
        val isNewNotice = listOf(true, false, false, true, false, true, true, true, true, true)[notice]
        NoticeContent(notice, isNewNotice) { getIcon() }
    }
}

@Composable
private fun getIcon() = Icon(
    modifier = Modifier
        .size(24.dp)
        .padding(end = 4.dp),
    imageVector = Icons.Filled.Check,
    contentDescription = "ad",
    tint = SoptTheme.colors.primary,
)


@Composable
private fun NoticeContent(notice: Int, isNewNotice: Boolean, icon: @Composable () -> Unit) {
//    TODO  isNewNotice는 공지 상세 전후로 변동 되는 값 -> rememberSaveable
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
                    icon()
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

/** Previews */

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SoptTheme {
        SearchBar()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun NoticesPreview() {
    SoptTheme {
        Notices()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun NoticesDarkPreview() {
    SoptTheme(true) {
        Notices()
    }
}