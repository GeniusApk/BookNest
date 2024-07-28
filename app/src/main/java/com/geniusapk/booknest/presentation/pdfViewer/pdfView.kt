package com.geniusapk.booknest.presentation.pdfViewer

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.Brightness7
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.geniusapk.booknest.data.roomdatabase.booksRoomModel
import com.geniusapk.booknest.presentation.ViewModel.PdfViewerViewModel
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfViewerScreen(
    url: String,
    title: String,
    navHostController: NavHostController,
    BookAuthor: String,
    BookImage: String,
    initialPage: Int = 0,
    viewModel: PdfViewerViewModel = hiltViewModel()
) {
    var isDarkMode by remember { mutableStateOf(false) }
    val bookmarks by viewModel.bookmarks.collectAsState()
    var isLoading by remember { mutableStateOf(true) }
    var loadingProgress by remember { mutableStateOf(0f) }
    var startPage = initialPage


    val pdfState = rememberVerticalPdfReaderState(
        resource = ResourceType.Remote(url),
        isZoomEnable = true,
        isAccessibleEnable = true,


        )
    val listState = rememberLazyListState()


    LaunchedEffect(url) {
        viewModel.loadBookmarks(url)

    }

    LaunchedEffect(pdfState.isLoaded) {
        if (pdfState.isLoaded) {
            isLoading = false
            loadingProgress = 1f
            pdfState.currentPage
            pdfState.isScrolling

          //  listState.scrollToItem(initialPage)


        } else {
            // Simulate loading progress
            launch {
                while (!pdfState.isLoaded && loadingProgress < 0.9f) {
                    delay(100)
                    loadingProgress += 0.01f
                }
            }
        }
    }

    MaterialTheme(
        colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navHostController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { isDarkMode = !isDarkMode }) {
                            Icon(
                                imageVector = if (isDarkMode) Icons.Filled.Brightness7 else Icons.Filled.Brightness4,
                                contentDescription = "Toggle Dark Mode"
                            )
                        }

                        IconButton(onClick = {
                            viewModel.addBookmark(
                                booksRoomModel(
                                    BookName = title,
                                    BookAuthor = BookAuthor,
                                    BookUrl = url,
                                    BookImage = BookImage,
                                    BookPage = pdfState.currentPage
                                )
                            )
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Bookmark,
                                contentDescription = "Bookmark Page"
                            )
                        }
                    }
                )
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(if (isDarkMode) Color.Black else MaterialTheme.colorScheme.background)
            ) {
                VerticalPDFReader(
                    state = pdfState,

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(color = if (isDarkMode) Color.Black else MaterialTheme.colorScheme.background),


                )


                if (!pdfState.isLoaded) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center)
                    ) {
                        CircularProgressIndicator(
                            progress = { loadingProgress },
                            modifier = Modifier.matchParentSize(),
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Text(
                            text = "${(loadingProgress * 100).toInt()}%",
                            modifier = Modifier.align(Alignment.Center),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }
    }
}