package cmps312.lab.qatar2022.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.qatar2022.model.Stadium
import com.example.qatar2022.R

import kotlinx.android.synthetic.main.list_item_stadium.view.*

//Step 2 -> IMPLEMENT/EXTEND THE ADAPTER
class StadiumAdapter(val stadiums : List<Stadium>, val context : Context) :
    RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder>() {

    //STEP 1 : to create the view holder
    class StadiumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(stadium : Stadium){
           itemView.apply {
               nameTv.text = stadium.name
               cityTv.text = stadium.city
               statusTv.text = stadium.status

               val imageName = stadium.imageName
               val imageId = context.resources.getIdentifier(imageName, "drawable",
                   context.packageName)
               stadiumIv.setImageResource(imageId)
           }

        }
    }

    //step 4 , and always will have this two lines
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumViewHolder {
       //inflate the view
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.list_item_stadium, parent , false)
        return StadiumViewHolder(itemView)

    }

    //final step
    override fun onBindViewHolder(holder: StadiumViewHolder, position: Int) {
        holder.bind(stadiums[position])
    }

    //Step 3
    override fun getItemCount() = stadiums.size

}