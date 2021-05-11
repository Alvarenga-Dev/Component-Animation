package com.alvarengadev.componentanimation.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.alvarengadev.componentanimation.R

class CardAnimation(
    context: Context,
    attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {
    private var view: View? = null
    private var motionLayout: MotionLayout? = null
    private var isClick = false
    private var imageView: ImageView? = null
    private var imageView2: ImageView? = null
    private var imageView3: ImageView? = null

    init {
        view = LayoutInflater.from(context)
            .inflate(
                R.layout.component_card_animation,
                this,
                true
            )
        motionLayout = view?.findViewById(R.id.motionLayout)
        imageView = view?.findViewById(R.id.imageView)
        imageView2 = view?.findViewById(R.id.imageView2)
        imageView3 = view?.findViewById(R.id.imageView3)

        initClicks()
    }

    private fun ImageView.setOnClickCloseCardAnimation(onClickListener: OnClickListener) {
        this.setOnClickListener {
            isClick = false
            motionLayout?.transitionToStart()
            onClickListener.onClick(this)
        }
    }

    private fun initClicks() {
        imageView?.setOnClickCloseCardAnimation {
            Toast.makeText(context, "Click 01", Toast.LENGTH_SHORT).show()
        }

        imageView2?.setOnClickCloseCardAnimation {
            Toast.makeText(context, "Click 02", Toast.LENGTH_SHORT).show()
        }
        imageView3?.setOnClickCloseCardAnimation {
            Toast.makeText(context, "Click 03", Toast.LENGTH_SHORT).show()
        }
    }

    fun startAnimation() {
        if (isClick) {
            isClick = false
            motionLayout?.transitionToStart()
        } else {
            isClick = true
            motionLayout?.transitionToEnd()
        }
    }
}