package com.example.ProsjektIKT205

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ProsjektIKT205.databinding.ExampleListBinding

//import kotlinx.android.synthetic.main.exampleList.view.*



class todoAdapter(private var exampleList: List<ToDo>): RecyclerView.Adapter<todoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ExampleListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: ToDo) {
            binding.exampleToDo.text = todo.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ExampleListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = exampleList.size

    public fun updateCollection(newToDos:List<ToDo>){
        exampleList = newToDos
        notifyDataSetChanged()
    }

}