package farees.hussain.runningtracker.service

import android.content.Intent
import androidx.lifecycle.LifecycleService
import farees.hussain.runningtracker.other.Constants
import farees.hussain.runningtracker.other.Constants.ACTION_PAUSE_SERVICE
import farees.hussain.runningtracker.other.Constants.ACTION_START_OR_RESUME_SERVICE
import farees.hussain.runningtracker.other.Constants.ACTION_STOP_SERVICE
import timber.log.Timber

class TrackingService : LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when(it.action){
                ACTION_START_OR_RESUME_SERVICE ->{
                    Timber.d("Started or resumed service")
                }
                ACTION_PAUSE_SERVICE ->{
                    Timber.d("Paused service")
                }
                ACTION_STOP_SERVICE->{
                    Timber.d("Stoped service")
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
}