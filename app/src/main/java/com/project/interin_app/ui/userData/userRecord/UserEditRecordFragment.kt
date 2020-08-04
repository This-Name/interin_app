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
import com.project.interin_app.repository.userData.Records
import kotlinx.coroutines.launch

class UserEditRecordFragment : Fragment(R.layout.fragment_user_edit_record) {
    private val userEditRecordViewModel by viewModels<UserEditRecordViewModel>()
    private lateinit var inputData: Records
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.record)
        inputData = arguments?.getParcelable("Record")!!

        view.findViewById<TextView>(R.id.fuer_record2).text = inputData.institution
        view.findViewById<TextView>(R.id.fuer_record3).text = inputData.specialization
        view.findViewById<TextView>(R.id.fuer_record4).text = inputData.doctor
        view.findViewById<TextView>(R.id.fuer_record5).text = inputData.date
        val id = inputData.idRecord
        val slotId = inputData.slotId
        val doctor = inputData.doctor
        view.findViewById<Button>(R.id.fuer_delete_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                userEditRecordViewModel.deleteRecordAPI("{ID:\"$id\",SLOT_ID:\"$slotId\"}")
                userEditRecordViewModel.deleteRecordDB(doctor)
                findNavController().navigate(R.id.action_user_Edit_RecordsFragment_to_user_RecordsFragment)
            }
        }
    }
}
