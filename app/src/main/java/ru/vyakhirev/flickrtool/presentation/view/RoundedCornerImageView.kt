package ru.vyakhirev.flickrtool.presentation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import ru.vyakhirev.flickrtool.R

class RoundedCornerImageView : androidx.appcompat.widget.AppCompatImageView {

    private var radius = 8.0f
    private var path: Path = Path()
    private var rect: RectF = RectF()
    private var initRect: Boolean = false

    private var heightRatio: Float = 0.0f

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {

        // get the attributes specified in attrs.xml using the name we included
        if (attrs != null) {
            val typedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.RoundedCornerImageView, 0, 0
            )
            if (typedArray.length() > 0) {
                try {
                    // get the text and colors specified using the names in attrs.xml
                    this.radius =
                        typedArray.getDimension(R.styleable.RoundedCornerImageView_corner, 8.0f)
                } finally {
                    typedArray.recycle()
                }
            }
        }
    }

    // Here we will set the aspect ratio
    fun setHeightRatio(ratio: Float) {
        if (ratio != heightRatio) {
            heightRatio = ratio
            requestLayout()
        }
    }

    fun getHeightRatio(): Float = heightRatio

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (heightRatio > 0.0) {
            // set the image views size
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height = (width * heightRatio).toInt()
            initRect = false
            invalidate()
            setMeasuredDimension(width, height)
        } else {
            invalidate()
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (!initRect) {
            rect = RectF(0f, 0f, this.width.toFloat(), this.height.toFloat())
            initRect = true
        }

        path.addRoundRect(rect, radius, radius, Path.Direction.CW)
        canvas.clipPath(path)
        super.onDraw(canvas)
    }
}
