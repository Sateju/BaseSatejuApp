package jjtelechea.example.basesatejuapp.utils.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    this.load(url) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}