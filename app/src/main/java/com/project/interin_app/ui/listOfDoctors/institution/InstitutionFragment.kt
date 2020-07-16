package com.project.interin_app.ui.listOfDoctors.institution

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.sheuduleMedInstitution.ROWS
import kotlinx.coroutines.launch

class InstitutionFragment : Fragment(R.layout.fragment_institution) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Учреждения"

        val institutionViewModel by viewModels<InstitutionViewModel>()
        val recyclerView = view.findViewById<RecyclerView>(R.id.fin_rv_med_institution)

        viewLifecycleOwner.lifecycleScope.launch {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter =
                InstitutionAdapter(
                    institutionViewModel.getMedInstitution().ROWS,
                    object :
                        InstitutionAdapter.Listener {
                        override fun onItemClick(institution: ROWS) {
                            val bundle = Bundle()
                            val data =
                                ArrayList<String>() // можно помещать любые данные которые нужны дальше
                            data.add(institution._ID)
                            data.add(institution.NAME)
                            bundle.putStringArrayList(
                                "idAndNameOfInstitution",
                                data
                            ) // передаю id и name в следующий фрагмент
                            findNavController().navigate(
                                R.id.action_med_institution_to_specialization_doctor,
                                bundle
                            )
                        }
                    })
        }
    }
}
