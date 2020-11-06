package com.decouikit.atom.components.image_gallery.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.decouikit.atom.components.image_gallery.activity.FullImageActivity
import com.decouikit.atom.components.image_gallery.adapter.ImageGalleryListAdapter
import com.decouikit.atom.components.image_gallery.interfaces.OnClickListener
import com.decouikit.atom.R
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import kotlinx.android.synthetic.main.fragment_content_image_galley_category.view.*

class ImageGalleryListFragment : Fragment(), OnClickListener {

    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<ImageGalleryViewItem>
    private lateinit var adapter: ImageGalleryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.items = arguments?.getParcelableArrayList<ImageGalleryViewItem>(ITEM_DATA) ?: ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_image_galley_list, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        adapter = ImageGalleryListAdapter(items)
        viewLayout.rvContainer?.layoutManager = GridLayoutManager(context, 2)
        viewLayout.rvContainer?.adapter = adapter
        adapter.onClickListener = this
    }

    override fun onClickListener(item: ImageGalleryViewItem, position: Int) {
        val intent = Intent(requireActivity(), FullImageActivity::class.java)
        intent.putExtra("item", items)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(list: ArrayList<ImageGalleryViewItem>): ImageGalleryListFragment {
            val fragment = ImageGalleryListFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            fragment.arguments = args
            return fragment
        }
    }
}
