package farees.hussain.runningtracker.ui.fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import farees.hussain.runningtracker.R

class CancelTrackingDialog : DialogFragment() {

    private var yesListener: (() -> Unit) ?= null
    fun setYesListener(listner:()->Unit){
        yesListener = listner
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the Run?")
            .setMessage("Are you sure to cancel the current run ?")
            .setPositiveButton("Yes"){_,_->
                yesListener?.let { yes->
                    yes()
                }
            }
            .setNegativeButton("No"){ dialog: DialogInterface?, _: Int ->
                dialog!!.cancel()
            }
            .create()
        dialog!!.show()
    }
}