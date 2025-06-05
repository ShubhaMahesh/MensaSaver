package com.example.mensasaver

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AccountFragment : Fragment() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        dbHelper = DatabaseHelper(requireContext())

        val loggedInEmail = MainActivity.loggedInEmail
        Log.d("AccountFragment", "LoggedInEmail: $loggedInEmail")// Get the global email

        val textViewName = view.findViewById<TextView>(R.id.textview_name)
        val textViewEmail = view.findViewById<TextView>(R.id.textview_uniid)

        if (loggedInEmail != null) {
            val userDetails = dbHelper.getUserDetails(loggedInEmail) // Password is not needed here
            if (userDetails != null) {
                textViewName.text = userDetails.first
                textViewEmail.text = userDetails.second
            } else {
                textViewName.text = "Name not found"
                textViewEmail.text = "Email not found"
            }
        } else {
            textViewName.text = "No user logged in"
            textViewEmail.text = ""
        }

        return view
    }
}
