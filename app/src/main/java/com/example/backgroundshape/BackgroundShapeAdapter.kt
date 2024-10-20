package com.example.backgroundshape

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView


class BackgroundShapeAdapter(private var mContext: Context, positionSelected :Int,private var mListener : onClickListenerAdapter) : RecyclerView.Adapter<BackgroundShapeAdapter.BackgroundShapeViewHolder>() {
    private var mPositionSelected = positionSelected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackgroundShapeViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.background_shape_item, parent, false)
        return BackgroundShapeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Constant.MAX_SHAPE
    }

    override fun onBindViewHolder(holder: BackgroundShapeViewHolder, position: Int) {
        when(position){
            Constant.SELECT_1 -> {
                setCornerRadius(holder, Constant.backgoundShape_1,position)
            }
            Constant.SELECT_2 -> {
                setCornerRadius(holder, Constant.backgoundShape_2,position)
            }
            Constant.SELECT_3 -> {
                setCornerRadius(holder, Constant.backgoundShape_3,position)
            }
            Constant.SELECT_4 -> {
                setCornerRadius(holder, Constant.backgoundShape_4,position)
            }
            else -> {
                setCornerRadius(holder, Constant.backgoundShape_default,position)
            }
        }
        holder.itemView.setOnClickListener {
            notifyItemChanged(mPositionSelected)
            mPositionSelected = holder.adapterPosition
            mListener.onClick(holder.adapterPosition)
            notifyItemChanged(mPositionSelected)
        }

    }

    private fun setCornerRadius(view : BackgroundShapeAdapter.BackgroundShapeViewHolder, radius : FloatArray?, position: Int){
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.RECTANGLE
        drawable.cornerRadii = radius
        if(mPositionSelected == position) {
            view.isFocus.visibility = View.VISIBLE
            drawable.setColor(Color.GRAY)
        }else{
            view.isFocus.visibility = View.GONE
            drawable.setColor(Color.WHITE)
        }
        val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.BLACK), drawable, null)
        view.Bg_container.background = rippleDrawable
    }

    inner class BackgroundShapeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  Bg_container : RelativeLayout = itemView.findViewById(R.id.bg_container)
        var isFocus : ImageView = itemView.findViewById(R.id.item_focus)
    }

}
class SpaceItemDecoration (private val space : Int) : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) {
            return
        }

        // Thêm khoảng cách giữa các item
        outRect.top = space
        outRect.bottom = space

        // Nếu muốn thêm khoảng cách giữa các item ở hai bên (horizontal space)
        outRect.left = space
        outRect.right = space
    }
}
interface onClickListenerAdapter {
    fun onClick(position: Int)
}