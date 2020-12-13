package com.amrilhakimsihotang.submissionarchitecturecomponent.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrilhakimsihotang.submissionarchitecturecomponent.DetailTvshowActivity
import com.amrilhakimsihotang.submissionarchitecturecomponent.R
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.ListTvshowBinding
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.TiviModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TiviShowAdapter(private val listiviShow: ArrayList<TiviModel>) :
        RecyclerView.Adapter<TiviShowAdapter.TiviShowViewHolder>() {

    inner class TiviShowViewHolder(val binding: ListTvshowBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(tiviModel: TiviModel) {
            Glide.with(itemView.context)
                    .load(tiviModel.poster_path)
                    .apply(RequestOptions().override(800, 600))
                    .error(R.drawable.ic_baseline_tag_faces_24)
                    .into(binding.imgPosterTvshow)
            binding.tvshowTitle.text = tiviModel.original_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiviShowViewHolder {
        val binding = ListTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TiviShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TiviShowViewHolder, position: Int) {
        holder.bind(listiviShow[position])
        val tiviShowData = listiviShow[position]
        holder.itemView.setOnClickListener {
            val tivishowIntent = TiviModel(
                    tiviShowData.original_name,
                    tiviShowData.poster_path,
                    tiviShowData.overview,
                    tiviShowData.creatorcast,
                    tiviShowData.seriescast,
                    tiviShowData.writingcast

            )
            val mIntent = Intent(it.context, DetailTvshowActivity::class.java)
            mIntent.putExtra(DetailTvshowActivity.DETAIL_TIVISHOW, tivishowIntent)
            it.context.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return listiviShow.size
    }
}