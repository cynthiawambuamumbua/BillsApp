//package com.example.appasessment
//
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
//
//class billsRvAdapter(var Bills:List<bills>):RecyclerView.Adapter<billsRvAdapter.ContactsViewHolder>(){
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): ContactsViewHolder {
//        val binding=AppCompatActivity.inflate(bills.from(parent.context),parent,false)
//        return ContactsViewHolder(binding)
//
//    }
//    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
//        val bills=bills.get(position)
//        val binding=holder.binding
//        binding.tvUserName.text=bills.toString()
//        binding.tvImage.tag=bills.toString()
//        binding.tvEmail.text=bills.toString()
//        binding.tvphoneNumber.text=bills.toString()
//    }
//    override fun getItemCount(): Int {
//        return bills.get(position)
//    }
//    class ContactsViewHolder(val binding: bills):RecyclerView.ViewHolder(binding.root)
//}
//
//
