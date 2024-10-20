package com.example.backgroundshape

object Constant {
    val SELECT_DEFAULT = 0
    val SELECT_1 = 1
    val SELECT_2 = 2
    val SELECT_3 = 3
    val SELECT_4 = 4
    val backgoundShape_default = floatArrayOf(
        50f,50f,// top-left
        50f,50f,//top-right
        50f,50f,// bottom-right
        50f,50f,//bottom-left
    )
    val backgoundShape_1 = floatArrayOf(
        50f,50f,// top-left
        0f,0f,//top-right
        50f,50f,// bottom-right
        0f,0f,//bottom-left
    )
    val backgoundShape_2 = floatArrayOf(
        0f,0f,// top-left
        50f,50f,//top-right
        0f,0f,// bottom-right
        50f,50f,//bottom-left
    )
    val backgoundShape_3 = floatArrayOf(
        50f,50f,// top-left
        0f,0f,//top-right
        50f,50f,// bottom-right
        50f,50f,//bottom-left
    )
    val backgoundShape_4 = floatArrayOf(
        50f,50f,// top-left
        50f,50f,//top-right
        0f,0f,// bottom-right
        50f,50f,//bottom-left
    )
     val lst_shapes = listOf(
        backgoundShape_default,
        backgoundShape_1,
        backgoundShape_2,
        backgoundShape_3,
        backgoundShape_4
    )
    val MAX_SHAPE = 5
}