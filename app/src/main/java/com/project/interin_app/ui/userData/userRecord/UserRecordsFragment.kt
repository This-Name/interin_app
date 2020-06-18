package com.project.interin_app.ui.userData.userRecord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.userData.Records
import kotlinx.coroutines.launch

class UserRecordsFragment : Fragment(R.layout.fragment_user_records) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "Записи"

        val userRecordsViewModel by viewModels<UserRecordsViewModel>()

        viewLifecycleOwner.lifecycleScope.launch {
            var content = userRecordsViewModel.getRecords()
            if(content == null){
                content = mutableListOf()
            }
            val recyclerView = view.findViewById<RecyclerView>(R.id.fud_rv_user_records)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter =
                UserRecordsAdapter(
                    content,
                    object :
                        UserRecordsAdapter.Listener {
                        override fun onItemClick(record: Records) {
                            val bundle = Bundle()
                            val data = ArrayList<String>() // можно помещать любые данные которые нужны дальше
                            data.add(record._ID)
                            data.add(record.BOOK_ID)
                            data.add(record.Date)
                            data.add(record.Doctor)
                            bundle.putStringArrayList("infSlot", data)
                            findNavController().navigate(R.id.action_user_RecordsFragment_to_user_Edit_RecordsFragment, bundle)
                        }
                    })
        }
    }
}