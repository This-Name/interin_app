package com.project.interin_app.ui.doctorProfile.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R
import com.project.interin_app.repository.userData.Records
import com.project.interin_app.repository.userData.User
import com.project.interin_app.repository.userRecord.Registration
import kotlinx.coroutines.launch

class DoctorRegistrationFragment : Fragment(R.layout.fragment_registration_doctor) {
    lateinit var slotId: String
    private val doctorRegistrationViewModel by viewModels<DoctorRegistrationViewModel>()
    // информация о записи по порядку: место, специальность, врач, датавремя
    lateinit var appointmentInfo: ArrayList<String>
    lateinit var slot: Registration
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        slotId = arguments?.getString("slotId")!!
        appointmentInfo = arguments?.getStringArrayList("appointmentInfo")!!
        activity?.title = getString(R.string.record)

        view.findViewById<TextView>(R.id.frgd_record2).text = appointmentInfo[0]
        view.findViewById<TextView>(R.id.frgd_record3).text = appointmentInfo[1]
        view.findViewById<TextView>(R.id.frgd_record4).text = appointmentInfo[2]
        view.findViewById<TextView>(R.id.frgd_record5).text = appointmentInfo[3]
        doctorRegistrationViewModel.getUserData()?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                view.findViewById<EditText>(R.id.frgd_patient_name).setText(it.firstName)
                view.findViewById<EditText>(R.id.frgd_patient_lastname).setText(it.lastName)
                view.findViewById<EditText>(R.id.frgd_patient_birthday).setText(it.birthday)
                view.findViewById<EditText>(R.id.frgd_patient_phone).setText(it.phone)
                view.findViewById<EditText>(R.id.frgd_patient_email).setText(it.email)
                view.findViewById<EditText>(R.id.frgd_patient_policy).setText(it.policy)
            }
        })
        view.findViewById<Button>(R.id.frgd_registration_to_doctor_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val name = view.findViewById<EditText>(R.id.frgd_patient_name).text.toString()
                val lastName =
                    view.findViewById<EditText>(R.id.frgd_patient_lastname).text.toString()
                val birthday =
                    view.findViewById<EditText>(R.id.frgd_patient_birthday).text.toString()
                val phone =
                    view.findViewById<EditText>(R.id.frgd_patient_phone).text.toString()
                val email =
                    view.findViewById<EditText>(R.id.frgd_patient_email).text.toString()
                val policy =
                    view.findViewById<EditText>(R.id.frgd_patient_policy).text.toString()
                val comments =
                    view.findViewById<EditText>(R.id.frgd_patient_comments).text.toString()
                slot = doctorRegistrationViewModel.createRecord(
                    "{SLOT_ID:\"$slotId\",PATIENT_NAME:\"$name\",PATIENT_LASTNAME:\"$lastName\"," +
                            "PATIENT_BIRTHDAY:\"$birthday\",PATIENT_PHONE:\"$phone\",PATIENT_EMAIL:\"$email\"," +
                            "PATIENT_POLICY:\"$policy\",COMMENTS:\"$comments\"}"
                )
                doctorRegistrationViewModel.insertUserRecord(
                    Records(
                        slot.id,
                        slot.bookId,
                        slotId,
                        appointmentInfo[3],
                        appointmentInfo[2],
                        appointmentInfo[1],
                        appointmentInfo[0]
                    )
                )
                doctorRegistrationViewModel.updateUser(
                    User(
                        name,
                        lastName,
                        birthday,
                        phone,
                        email,
                        policy
                    )
                )
                findNavController().navigate(R.id.action_doctor_RegistrationFragment_to_user_RecordsFragment)
            }
        }
    }
}
