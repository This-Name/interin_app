package com.project.interin_app.ui.userData.userRecord

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R
import kotlinx.coroutines.launch

class UserEditRecordFragment : Fragment(R.layout.fragment_user_edit_record) {
    private val userEditRecordViewModel by viewModels<UserEditRecordViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.record)

        val inputData = arguments?.getStringArrayList("infSlot")

        view.findViewById<TextView>(R.id.fuer_record2).text = inputData?.get(4)
        view.findViewById<TextView>(R.id.fuer_record3).text = inputData?.get(5)
        view.findViewById<TextView>(R.id.fuer_record4).text = inputData?.get(3)
        view.findViewById<TextView>(R.id.fuer_record5).text = inputData?.get(2)
        val id = inputData?.get(1)
        val slotId = inputData?.get(0)
        val doctor = inputData?.get(3)
        view.findViewById<Button>(R.id.fuer_delete_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                userEditRecordViewModel.deleteRecordAPI("{ID:\"$id\",SLOT_ID:\"$slotId\"}")
                userEditRecordViewModel.deleteRecordDB("$doctor")
                findNavController().navigate(R.id.action_user_Edit_RecordsFragment_to_user_RecordsFragment)
            }
        }
    }
}
