package com.project.interin_app.ui.doctorProfile.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R
import com.project.interin_app.repository.userData.Records
import com.project.interin_app.repository.userData.User
import com.project.interin_app.repository.userRecord.Registration
import kotlinx.coroutines.launch

class DoctorRegistrationFragment : Fragment(R.layout.fragment_registration_doctor) {
    // slot ID
    lateinit var slotId: String
    // информация о записи по порядку: место, специальность, врач, датавремя
    lateinit var appointmentInfo: ArrayList<String>
    lateinit var slot: Registration
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.title = "Запись на прием"
        val doctorRegistrationViewModel by viewModels<DoctorRegistrationViewModel>()
        slotId = arguments?.getString("slotId")!!
        appointmentInfo = arguments?.getStringArrayList("appointmentInfo")!!

        viewLifecycleOwner.lifecycleScope.launch {
            val content = doctorRegistrationViewModel.getUser()

            view.findViewById<EditText>(R.id.frgd_patient_name).setText(content.FirstName)
            view.findViewById<EditText>(R.id.frgd_patient_lastname).setText(content.LastName)
            view.findViewById<EditText>(R.id.frgd_patient_birthday).setText(content.Birthday)
            view.findViewById<EditText>(R.id.frgd_patient_phone).setText(content.Phone)
            view.findViewById<EditText>(R.id.frgd_patient_email).setText(content.Email)
            view.findViewById<EditText>(R.id.frgd_patient_policy).setText(content.Policy)
        }

        view.findViewById<Button>(R.id.frgd_registration_to_doctor_button).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val name = view.findViewById<EditText>(R.id.frgd_patient_name).getText().toString()
                val lastmane =
                    view.findViewById<EditText>(R.id.frgd_patient_lastname).getText().toString()
                val birthday =
                    view.findViewById<EditText>(R.id.frgd_patient_birthday).getText().toString()
                val phone =
                    view.findViewById<EditText>(R.id.frgd_patient_phone).getText().toString()
                val email =
                    view.findViewById<EditText>(R.id.frgd_patient_email).getText().toString()
                val policy =
                    view.findViewById<EditText>(R.id.frgd_patient_policy).getText().toString()
                val comments =
                    view.findViewById<EditText>(R.id.frgd_patient_comments).getText().toString()


                slot = doctorRegistrationViewModel.createRecord(
                    "{SLOT_ID:\"$slotId\",PATIENT_NAME:\"$name\",PATIENT_LASTNAME:\"$lastmane\"," +
                            "PATIENT_BIRTHDAY:\"$birthday\",PATIENT_PHONE:\"$phone\",PATIENT_EMAIL:\"$email\"," +
                            "PATIENT_POLICY:\"$policy\",COMMENTS:\"$comments\"}"
                )
                doctorRegistrationViewModel.insertUserRecord(
                    Records(
                        slot.ID,
                        slot.BOOK_ID, slotId, appointmentInfo.get(3), appointmentInfo.get(2), "qwwq", "qwd"
                    )
                )
                val test: String = "fff"
                doctorRegistrationViewModel.updateUser(
                    User(
                        name,
                        lastmane,
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