package com.example.spaceapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.R
import com.example.spaceapp.databinding.ItemHomeLayoutBinding

class ItemAdapter (var context: Context) : RecyclerView.Adapter<ItemAdapter.ItemHomeViewHolder>() {

    class ItemHomeViewHolder(var itemHomeLayoutBinding: ItemHomeLayoutBinding) :
        RecyclerView.ViewHolder(itemHomeLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHomeViewHolder {
        var itemHomeLayoutBinding = DataBindingUtil.inflate<ItemHomeLayoutBinding>(
            LayoutInflater.from(parent.context), R.layout.item_home_layout, parent, false
        )
        return ItemHomeViewHolder(itemHomeLayoutBinding)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ItemHomeViewHolder, position: Int) {
        when(position)
        {
            0->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image1))
            1->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image2))
            2->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image3))
            3->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image4))
            4->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image5))
            5->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image6))
            6->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image7))
            7->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image8))
            8->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image9))
            9->holder.itemHomeLayoutBinding.iconImg.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.image10))
        }
        holder.itemHomeLayoutBinding.cardView.setOnClickListener {
            var intent= Intent(context,DetailActivity::class.java).apply {
                putExtra("Pos",position)
            }
            (context as AppCompatActivity).startActivity(
                intent
            )
            (context as AppCompatActivity).overridePendingTransition(
                R.anim.bottom_up,
                R.anim.nothing
            )
        }

    }
}