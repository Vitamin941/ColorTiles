package ru.isu.math.colortiles.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ru.isu.math.colortiles.R

class RulesDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.rules_dialog)
                .setPositiveButton(R.string.Ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        // START THE GAME!
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}