package com.example.backgroundshape

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), onClickListenerAdapter {
    private lateinit var  mainItem : RelativeLayout
    private lateinit var lst_background_shape : RecyclerView
    private var backgroundShapeAdapter : BackgroundShapeAdapter? = null
    private var shapeSelected : Int = Constant.SELECT_DEFAULT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initWidget()
        setCornerRadius(mainItem, Constant.backgoundShape_1)

        backgroundShapeAdapter = BackgroundShapeAdapter(this, Constant.SELECT_DEFAULT, this)
        lst_background_shape.addItemDecoration(SpaceItemDecoration(16))
        lst_background_shape.adapter = backgroundShapeAdapter
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.HORIZONTAL
        lst_background_shape.layoutManager = layout
    }


    private fun setCornerRadius(view : View, radius : FloatArray?){
        val drawable = GradientDrawable()
        drawable.setColor(Color.MAGENTA)
        drawable.cornerRadii = radius
        view.background = drawable
    }

    private fun initWidget() {
        mainItem = findViewById(R.id.main_item)
        lst_background_shape = findViewById(R.id.background_shape_lst)
    }

    override fun onClick(position: Int) {
        when (position){
            Constant.SELECT_1 -> {
                setCornerRadius(mainItem, Constant.backgoundShape_1)
            }
            Constant.SELECT_2 -> {
                setCornerRadius(mainItem, Constant.backgoundShape_2)
            }
            Constant.SELECT_3 -> {
                setCornerRadius(mainItem, Constant.backgoundShape_3)
            }
            Constant.SELECT_4 -> {
                setCornerRadius(mainItem, Constant.backgoundShape_4)
            }
            else -> {
                setCornerRadius(mainItem, Constant.backgoundShape_default)
            }
        }
    }
}
