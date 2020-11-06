package com.decouikit.atom.components.image_gallery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.decouikit.atom.R
import com.decouikit.atom.components.image_gallery.adapter.TouchImageAdapter
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.fragment_content_image_gallery_full_screen.view.*

class ImageGalleryFullImageFragment : Fragment(), ViewPager.OnPageChangeListener {


    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<ImageGalleryViewItem>
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.items = arguments?.getParcelableArrayList<ImageGalleryViewItem>(ITEM_DATA) ?: ArrayList()
        this.position = arguments?.getInt(ITEM_INDEX, 0) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_image_gallery_full_screen, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        if (SharedPrefs(requireContext()).isRtlEnabled) {
            viewLayout.ivBack.rotation = 180f
        }
        view.viewPager.adapter = TouchImageAdapter(items)
        view.viewPager.currentItem = position
        view.viewPager.addOnPageChangeListener(this)
        view.tabDots.setupWithViewPager(view.viewPager)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        private const val ITEM_INDEX = "ITEM_INDEX"

        fun newInstance(list: ArrayList<ImageGalleryViewItem>, position: Int = 0): ImageGalleryFullImageFragment {
            val fragment = ImageGalleryFullImageFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            args.putInt(ITEM_INDEX, position)
            fragment.arguments = args
            return fragment
        }
    }
}
