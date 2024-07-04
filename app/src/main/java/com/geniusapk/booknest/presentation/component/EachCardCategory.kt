package com.geniusapk.booknest.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.geniusapk.booknest.presentation.nav.Routes


@Composable
fun EachCardCategory(
    imageUrl: String,
    Category: String,
//    author: String,
//    description: String,
    navHostController: NavHostController,
) {

    Card(
        modifier = Modifier

            .padding(8.dp)
            .clickable {
                navHostController.navigate(Routes.BooksByCategory(Category))
            }
    ) {

        Column(
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    //.aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp)),
                loading = {
                    //imageani()
                },
                error = {
                    Text(text = "Error loading image")
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = Category,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 2,)
        }

    }


}