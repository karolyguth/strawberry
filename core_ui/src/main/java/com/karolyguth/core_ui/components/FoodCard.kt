package com.karolyguth.core_ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.karolyguth.core_ui.R
import kotlinx.coroutines.Dispatchers.IO

@Composable
fun SampleScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val imageUrl = "http://192.168.1.49:8080/images/vegetables.jpg"
        val placeholder = androidx.core.R.drawable.ic_call_answer


        // Build an ImageRequest with Coil
        val listener = object : ImageRequest.Listener {
            override fun onError(request: ImageRequest, result: ErrorResult) {
                super.onError(request, result)
            }

            override fun onSuccess(request: ImageRequest, result: SuccessResult) {
                super.onSuccess(request, result)
            }
        }
        val imageRequest = ImageRequest.Builder(context)
            .data(imageUrl)
            .listener(listener)
            .dispatcher(IO)
            .memoryCacheKey(imageUrl)
            .diskCacheKey(imageUrl)
            .placeholder(placeholder)
            .error(placeholder)
            .fallback(placeholder)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()

        // Load and display the image with AsyncImage
        AsyncImage(
            model = imageRequest,
            contentDescription = "Image Description",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}


@Composable
fun FoodCard(imageUrl: String, name: String = "placeholder!", caloricValue: String, usePlaceholder: Boolean = false) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.size(width = 160.dp, height = 218.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (usePlaceholder) {
                val image: Painter = painterResource(id = R.drawable.veggies)
                Image(
                    painter = image,
                    contentDescription = name,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .drawWithCache {
                            onDrawWithContent {

                            }
                        },
                    contentScale = ContentScale.Crop
                )
            } else {
                // Load image from URL at runtime
                AsyncImage(
                    model = imageUrl,
                    contentDescription = name,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 10.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "$caloricValue calories",
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }

        }
    }
}




@Preview(showBackground = true, name = "Food Card Preview")
@Composable
fun FoodCardPreview() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp)
        .background(color = Color.White)) {
        FoodCard(
            imageUrl = "http://192.168.1.49:8080/images/vegetables.jpg",
            name = "Tomatoes",
            caloricValue = "513",
            usePlaceholder = true  // Use local image for preview
        )
    }
}
