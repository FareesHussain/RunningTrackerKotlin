package farees.hussain.runningtracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import farees.hussain.runningtracker.R
import farees.hussain.runningtracker.database.Run
import farees.hussain.runningtracker.other.TrackingUtility
import kotlinx.android.synthetic.main.item_run.view.*
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter :RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    val diffCallback = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this,diffCallback)
    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_run,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(run.img).into(ivRunImage)
            val calendar = Calendar.getInstance().apply {
                timeInMillis = run.timestamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy",Locale.getDefault())
            tvDate.text = dateFormat.format(calendar.time)
            val avgSpeed = "${run.avgSpeedInKMH}kmph"
            tvAvgSpeed.text = avgSpeed
            val distanceInKM = "${run.distanceInkm/1000f} KM"
            tvDistance.text = distanceInKM
            tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
            val caloriesBurned = "${run.caloriesBurned} Kcal"
            tvCalories.text = caloriesBurned
        }
    }

    inner class RunViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
}