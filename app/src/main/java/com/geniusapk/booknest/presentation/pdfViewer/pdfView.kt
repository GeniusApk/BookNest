package com.geniusapk.booknest.presentation.pdfViewer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PdfViewerScreen(url: String) {
        val pdfState = rememberVerticalPdfReaderState(
            resource = ResourceType.Remote(url),
            isZoomEnable = true
        )

    VerticalPDFReader(
        state = pdfState,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    )
}
