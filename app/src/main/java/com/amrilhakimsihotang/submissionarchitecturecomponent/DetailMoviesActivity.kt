package com.amrilhakimsihotang.submissionarchitecturecomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.ActivityDetailMoviesBinding
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.MoviesModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_MOVIES = "detail_movies"
    }

    private lateinit var detailMoviesBinding: ActivityDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movies)

        if (supportActionBar != null) {
            supportActionBar?.title = resources.getString(R.string.detailmovie)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        try {

            detailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
            setContentView(detailMoviesBinding.root)

            val moviesModel = intent.getParcelableExtra<MoviesModel>(DETAIL_MOVIES) as MoviesModel
            Glide.with(this)
                .load(moviesModel.poster_path)
                .apply(RequestOptions().override(800, 600))
                .error(R.drawable.ic_baseline_tag_faces_24)
                .into(detailMoviesBinding.detpostermovies)
            detailMoviesBinding.dettitlemovies.text = moviesModel.original_title
            detailMoviesBinding.detoverviewmovies.text = moviesModel.overview
            detailMoviesBinding.detdirector.text=resources.getString(R.string.director, moviesModel.director)
            detailMoviesBinding.detwriter.text=resources.getString(R.string.writer, moviesModel.writer)
            detailMoviesBinding.detscreenplay.text=resources.getString(R.string.screenplay,moviesModel.screenplay)
            detailMoviesBinding.detpersoncasting.text= moviesModel.person_cast

        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }


        try {
            detailMoviesBinding.fabshare.setOnClickListener {
                val sMessage: String =
                    resources.getString(R.string.sharedetail) +" "+ detailMoviesBinding.dettitlemovies.text.toString() +" " + resources.getString(R.string.sharedetail2)
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