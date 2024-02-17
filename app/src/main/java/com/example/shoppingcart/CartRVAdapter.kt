package com.example.shoppingcart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartRVAdapter(

    var list: List<CartItems>,
    val cartItemClickInterface: CartItemClickInterface
) : RecyclerView.Adapter<CartRVAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val PName = itemView.findViewById<TextView>(R.id.idTVItemName)
        val pQty = itemView.findViewById<TextView>(R.id.idTVQuantity)
        val price = itemView.findViewById<TextView>(R.id.idTVRate)

        val pDelete = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    interface CartItemClickInterface{
        fun onItemClick(cartItems: CartItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_rv_item, parent, false)

        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.PName.text = list.get(position).itemName
        holder.pQty.text = list.get(position).itemQuantity.toString()
        holder.price.text = "$. " + list.get(position).itemPrice.toString()
        val total: Int = list.get(position).itemPrice * list.get(position).itemQuantity
        holder.pDelete.setOnClickListener{
            cartItemClickInterface.onItemClick(list.get(position))
        }
    }
}