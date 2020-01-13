package ca.vitos.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ca.vitos.dogs.R
import ca.vitos.dogs.model.DoogBreed
import ca.vitos.dogs.util.getProgressDrawable
import ca.vitos.dogs.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*
import kotlinx.coroutines.joinAll

class DogsListAdapter(val dogsList: ArrayList< DoogBreed >):
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {
    fun updateDogList(newDogsList: List<DoogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog,parent,false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {

        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifeSpan.text = dogsList[position].lifeSpan

        holder.view.setOnClickListener{
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
        holder.view.imageView.loadImage(
            dogsList[position].imageUrl,
            getProgressDrawable(context = holder.view.imageView.context))
    }

    class DogViewHolder(var view:View): RecyclerView.ViewHolder(view)

}