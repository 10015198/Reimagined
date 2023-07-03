/*
 * Reimagined for Android - Globe's Design System
 *
 * Copyright (c) 2023 . Globe Telecom. All rights reserved.
 * Last modified 26/06/2023, 4:55 PM
 */
package com.globe.designsystem.reimagined.button
import android.content.Context
import android.content.res.ColorStateList
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.globe.designsystem.reimagined.R
import com.google.android.material.button.MaterialButton


class ButtonPill @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialButton(context, attrs, defStyleAttr) {


    var buttonStyle : ButtonStyle = ButtonStyle.YELL
        set(value) {
            field = value
            setButtonStyle()
        }

    init {

        val styledAttributes =
            context.obtainStyledAttributes(attrs, R.styleable.Button, defStyleAttr,  com.google.android.material.R.style.Widget_MaterialComponents_Button)

        try {

            buttonStyle = ButtonStyle.values()[styledAttributes.getInt(
                R.styleable.Button_ButtonStyle, 0)]
            cornerRadius = 100
            maxLines = 1
            gravity = Gravity.CENTER
            isClickable = true
            ellipsize = TextUtils.TruncateAt.END


            setTextAppearance(R.style.gone_label_base_bold)
            setPadding(24,0,24,0)
            setButtonStyle()
            requestLayout()

        } finally {
            styledAttributes.recycle()
        }

    }

    private fun setButtonStyle(){
        when (buttonStyle) {
            ButtonStyle.YELL-> {
                setTextColor(getTextStyleColor())
                backgroundTintList = getBackgroundColor()
                compoundDrawableTintList = getTextStyleColor()
            }
            ButtonStyle.MURMUR -> {
                setTextColor(getTextStyleColor())
                backgroundTintList = getBackgroundColor()
                compoundDrawableTintList = getTextStyleColor()
                strokeWidth = 4
                strokeColor = getTextStyleColor()
            }
            ButtonStyle.WHISPER -> {
                setTextColor(getTextStyleColor())
                backgroundTintList = getBackgroundColor()
                compoundDrawableTintList = getTextStyleColor()
            }
        }
    }


    private fun getBackgroundColor() : ColorStateList? {
        return when (buttonStyle) {
            ButtonStyle.YELL -> {
                ContextCompat.getColorStateList(context,
                R.color.reimagined_button_yell_background_color)
            }
            ButtonStyle.MURMUR -> {
                ContextCompat.getColorStateList(context,
                    R.color.reimagined_button_murmur_background_color)
            }
            ButtonStyle.WHISPER -> {
                ContextCompat.getColorStateList(context,
                    R.color.reimagined_button_whisper_background_color)
            }
        }
    }


    private fun getTextStyleColor() : ColorStateList? {
        return when (buttonStyle) {
            ButtonStyle.YELL -> {
                ContextCompat.getColorStateList(context, R.color.reimagined_button_yell_text_color)
            }
            ButtonStyle.MURMUR -> {
                ContextCompat.getColorStateList(context, R.color.reimagined_button_murmur_text_color)
            }
            ButtonStyle.WHISPER -> {
                ContextCompat.getColorStateList(context, R.color.reimagined_button_whisper_text_color)
            }
        }
    }

    enum class ButtonStyle {
        YELL,
        MURMUR,
        WHISPER
    }



}
