package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

class AdaptiveMessageView : LinearLayout {

    private var messageImage: ImageView
    private var messageText: TextView

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setAttrs(attrs, 0)
    }

    private fun setAttrs(
        attrs: AttributeSet?,
        @Suppress("UNUSED_PARAMETER")
        defStyleAttr: Int
    ) {
        if (attrs != null) {
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.MessageViewAttrs,
                0,
                0
            ).apply {
                try {
                    setImage(this)
                    setMessage(this)
                } finally {
                    recycle()
                }
            }
        }
    }

    private fun setImage(typedArray: TypedArray) {
        val image = typedArray.getDrawable(
            R.styleable.MessageViewAttrs_message_image
        ) ?: ContextCompat.getDrawable(
            context,
            R.drawable.ic_adaptive_message_view_image
        )
        messageImage.setImageDrawable(image)
        val defaultImageTint = ContextCompat.getColor(
            context,
            R.color.adaptive_message_view_image_color
        )
        val imageTint = typedArray.getColor(
            R.styleable.MessageViewAttrs_message_image_tint,
            defaultImageTint
        )
        DrawableCompat.setTint(
            messageImage.drawable,
            imageTint
        )
    }

    private fun setMessage(typedArray: TypedArray) {
        val message = typedArray.getString(
            R.styleable.MessageViewAttrs_message_text
        ) ?: context.getString(R.string.adaptive_message_view_text)
        messageText.text = message

        val defaultMessageColor = ContextCompat.getColor(
            context,
            R.color.adaptive_message_view_text_color
        )
        val messageColor = typedArray.getColor(
            R.styleable.MessageViewAttrs_message_text_color,
            defaultMessageColor
        )
        messageText.setTextColor(messageColor)

        val defaultMessageSize = context.resources.getDimensionPixelSize(
            R.dimen.adaptive_message_view_text_size
        )
        val messageSize = typedArray.getDimensionPixelSize(
            R.styleable.MessageViewAttrs_message_text_size,
            defaultMessageSize
        )
        messageText.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            messageSize.toFloat()
        )

        val messageAtCenter = typedArray.getBoolean(
            R.styleable.MessageViewAttrs_message_text_at_center,
            false
        )
        if (messageAtCenter) {
            messageText.gravity = Gravity.CENTER
        }
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setAttrs(attrs, defStyleAttr)
    }

    init {
        LayoutInflater.from(context).inflate(
            R.layout.view_adaptive_message,
            this,
            true
        )

        messageImage = findViewById(R.id.adaptive_message_view_image)
        messageText = findViewById(R.id.adaptive_message_view_text)
    }

    fun setImage(imageResId: Int) {
        messageImage.setImageResource(imageResId)
        reload()
    }

    private fun reload() {
        invalidate()
        requestLayout()
    }

    fun setImage(drawable: Drawable) {
        messageImage.setImageDrawable(drawable)
        reload()
    }

    fun setMessageText(messageResId: Int) {
        messageText.setText(messageResId)
        reload()
    }

    fun setMessageText(message: String) {
        messageText.text = message
        reload()
    }

}
