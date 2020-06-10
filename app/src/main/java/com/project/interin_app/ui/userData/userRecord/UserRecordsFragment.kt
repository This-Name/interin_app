package com.project.interin_app.ui.userData.userRecord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.userData.Records
import kotlinx.coroutines.launch

class UserRecordsFragment : Fragment(R.layout.fragment_user_records) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

                        }
                    })
        }
    }
}