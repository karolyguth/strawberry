package com.karolyguth.core_ui.components.shapes
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


object ArchedCutoffShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val rectangleHeight = size.height * 0.93f

        val path = Path().apply {
            // Drawn rectangle as the base for the shape
            addRect(Rect(left = 0f, top = 0f, right = size.width, bottom =rectangleHeight))
            // Move starting point to the bottom left corner of my rectangle
            moveTo(0f, rectangleHeight)
            // Draw a line up to the start of the curve
            lineTo(0f, size.height)
            // Draw the curve from left to right at the bottom
            cubicTo(
                x1 = size.width / 4f,
                y1 = rectangleHeight,
                x2 = size.width * 3f / 4f,
                y2 = rectangleHeight,
                x3 = size.width,
                y3 = size.height
            )
            // Draw a line down to the bottom right corner
            lineTo(size.width, rectangleHeight)
            // Close the path back to the starting point
            close()
        }
        return Outline.Generic(path)
    }
}

