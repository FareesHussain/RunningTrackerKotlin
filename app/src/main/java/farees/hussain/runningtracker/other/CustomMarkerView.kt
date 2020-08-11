package farees.hussain.runningtracker.other

import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import farees.hussain.runningtracker.database.Run
import kotlinx.android.synthetic.main.marker_view.view.*
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    val runs:List<Run>,
    context: Context,
    layoutId:Int
) : MarkerView(context,layoutId){

    override fun getOffset(): MPPointF {
        return MPPointF(-width/2f,-height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if(e == null)
            return
        val curRunId = e.x.toInt()
        val run = runs[curRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        tvDate.text = dateFormat.format(calendar.time)
        val avgSpeed = "${run.avgSpeedInKMH}kmph"
        tvAvgSpeed.text = avgSpeed
        val distanceInKM = "${run.distanceInkm/1000f} KM"
        tvDistance.text = distanceInKM
        tvDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
        val caloriesBurned = "${run.caloriesBurned} Kcal"
        tvCaloriesBurned.text = caloriesBurned
    }
}