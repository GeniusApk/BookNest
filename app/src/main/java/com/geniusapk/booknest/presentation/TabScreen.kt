package com.geniusapk.booknest.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Redeem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)

@Composable
fun TabScreen() {

    val tabs = listOf(
        TabItem("Category", Icons.Default.Category),
        TabItem("Random", Icons.Default.Redeem)
    )
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()


    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 16.dp,
            modifier = Modifier.fillMaxWidth(),
//            indicator = { tabPositions ->
//                SecondaryIndicator(
//                   modifier =  Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
//                    height = 4.dp,
//                    color = MaterialTheme.colorScheme.primary
//                )
//            }
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(tab.title)
                        }
                    }
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> CategoryScreen()
                1 -> RandomScreen()
                // Add more screens as needed
            }
        }
    }
}

data class TabItem(val title: String, val icon: ImageVector)



@Composable
fun CategoryScreen() {
    // Your Category screen content here
    Text(text = "Category Content")
}

@Composable
fun RandomScreen() {
    // Your Random screen content here
    Text(text = "Random Content")
}