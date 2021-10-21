package com.example.sampleapiarch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapiarch.databinding.ItemUsersBinding
import com.example.sampleapiarch.response.userRespone.Data

class UserAdapter(private val mList: List<Data>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
        holder.binding.tvUserName.text = data.firstName
    }

    override fun getItemCount() = mList.size

    class ViewHolder(val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {


    }

}