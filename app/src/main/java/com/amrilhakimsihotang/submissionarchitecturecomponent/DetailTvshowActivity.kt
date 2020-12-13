package com.amrilhakimsihotang.submissionarchitecturecomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.ActivityDetailTvshowBinding
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.TiviModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailTvshowActivity : AppCompatActivity() {
    companion object {
        const val DETAIL_TIVISHOW = "detail_tivishow"
    }

    private lateinit var detailTvshowBinding: ActivityDetailTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvshow)
        detailTvshowBinding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(detailTvshowBinding.root)
        if (supportActionBar != null) {
            supportActionBar?.title = resources.getString(R.string.detailtivishow)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        try {
            val tiviModel =
                    intent.getParcelableExtra<TiviModel>(DETAIL_TIVISHOW) as TiviModel
            Glide.with(this)
                    .load(tiviModel.poster_path)
                    .apply(RequestOptions().override(800, 600))
                    .error(R.drawable.ic_baseline_tag_faces_24)
                    .into(detailTvshowBinding.detpostertv)

            detailTvshowBinding.dettitletv.text = tiviModel.original_name
            detailTvshowBinding.detoverviewtv.text = tiviModel.overview
            detailTvshowBinding.detcreator.text = resources.getString(R.string.creator, tiviModel.creatorcast)
            detailTvshowBinding.detwriter.text = resources.getString(R.string.writer, tiviModel.writingcast)
            detailTvshowBinding.detseriescast.text = tiviModel.seriescast

        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
        try {
            detailTvshowBinding.fab.setOnClickListener {
                val sMessage: String =
                        resources.getString(R.string.sharedetailtv) + " " + detailTvshowBinding.dettitletv.text.toString() + " " + resources.getString(R.string.sharedetailtv2)
                val mIntent = Intent(Intent.ACTION_SEND)
                mIntent.type = "text/plain"
                mIntent.putExtra(Intent.EXTRA_TEXT, sMessage)
                startActivity(Intent.createChooser(mIntent, "Share to: "))
            }
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}