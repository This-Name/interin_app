package com.project.interin_app.ui.userData.userRecord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.userData.Records

class UserRecordsFragment : Fragment(R.layout.fragment_user_records) {
    private val userRecordsViewModel by viewModels<UserRecordsViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.records)
        val recyclerView = view.findViewById<RecyclerView>(R.id.fud_rv_user_records)
        val adapter = UserRecordsAdapter(
            mutableListOf(),
            object :
                UserRecordsAdapter.Listener {
                override fun onItemClick(record: Records) {
                    val bundle = Bundle()
                    bundle.putParcelable("Record", record)
                    findNavController().navigate(
                        R.id.action_user_RecordsFragment_to_user_Edit_RecordsFragment,
                        bundle
                    )
                }
            })
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        userRecordsViewModel.getUserData()?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.loadRecords(it)
            }
        })
    }
}
