package com.chikeandroid.tutsplusespressotesting

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button


class PickContactActivity : AppCompatActivity() {

    val PICK_REQUEST = 101
    private lateinit var contact: Uri
    private lateinit var selectContactButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_contact)
        selectContactButton = findViewById(R.id.btn_login)
    }

    fun pickContact(v: View) {
        val i = Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(i, PICK_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  data: Intent) {
        if (requestCode == PICK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                contact = data.data
                selectContactButton.setEnabled(true)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (contact != null) {
            outState.putParcelable("contact", contact)
        }
    }

    override fun onRestoreInstanceState(state: Bundle) {
        super.onRestoreInstanceState(state)
        contact = state.getParcelable<Parcelable>("contact") as Uri
        selectContactButton.setEnabled(contact != null)
    }
}
