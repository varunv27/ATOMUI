package com.decouikit.atom.components.lists.swipe.icon.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.swipe.icon.adapter.SwipeIconAdapter
import com.decouikit.atom.components.lists.swipe.icon.interfaces.OnSwipeItemListener
import com.decouikit.atom.components.lists.swipe.icon.model.SwipeViewItem
import com.h6ah4i.android.widget.advrecyclerview.animator.SwipeDismissItemAnimator
import com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager
import com.h6ah4i.android.widget.advrecyclerview.touchguard.RecyclerViewTouchActionGuardManager
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils

class SwipeIconFragment : Fragment(), OnSwipeItemListener {

    private lateinit var viewLayout: View
    private var mRecyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    private lateinit var items: ArrayList<SwipeViewItem>
    private var mAdapter: SwipeIconAdapter? = null
    private var mWrappedAdapter: RecyclerView.Adapter<*>? = null
    private var mRecyclerViewSwipeManager: RecyclerViewSwipeManager? = null
    private var mRecyclerViewTouchActionGuardManager: RecyclerViewTouchActionGuardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(LIST_SWIPE_ICON_DATA)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_list, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        mRecyclerView = viewLayout.findViewById(R.id.rvList)
        mLayoutManager = LinearLayoutManager(view.context)
        mRecyclerView!!.layoutManager = mLayoutManager

        // touch guard manager  (this class is required to suppress scrolling while swipe-dismiss animation is running)
        mRecyclerViewTouchActionGuardManager = RecyclerViewTouchActionGuardManager()
        mRecyclerViewTouchActionGuardManager!!.setInterceptVerticalScrollingWhileAnimationRunning(
            true
        )
        mRecyclerViewTouchActionGuardManager!!.isEnabled = true


        // swipe manager
        mRecyclerViewSwipeManager = RecyclerViewSwipeManager()

        mAdapter = SwipeIconAdapter(items, this)


        mWrappedAdapter = mRecyclerViewSwipeManager!!.createWrappedAdapter(mAdapter!!)


        val animator = SwipeDismissItemAnimator()
        // Change animations are enabled by default since support-v7-recyclerview v22.
        // Disable the change animation in order to make turning back animation of swiped item works properly.
        animator.supportsChangeAnimations = false

        mRecyclerView?.adapter = mWrappedAdapter  // requires *wrapped* adapter
        mRecyclerView?.itemAnimator = animator
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.setItemViewCacheSize(20)

        // priority: TouchActionGuard > Swipe > DragAndDrop
        mRecyclerViewTouchActionGuardManager?.attachRecyclerView(mRecyclerView!!)
        mRecyclerViewSwipeManager?.attachRecyclerView(mRecyclerView!!)
    }

    override fun onItemPinned(position: Int) {
        Handler().postDelayed({
            val size = items.size
            for (i in 0 until size) {
                if (i != position) {
                    if (items[i].isPinned) {
                        // unpin if tapped the pinned item
                        items[i].isPinned = false
                        mAdapter?.notifyDataSetChanged()
                    }
                }
            }
        }, 100)
    }

    override fun removeItem(view: View, item: SwipeViewItem, position: Int) {
        mAdapter?.removeItem(item)
    }

    override fun addItem(view: View, item: SwipeViewItem, position: Int) {
        Toast.makeText(
            view.context,
            getString(R.string.list_clicked_item_text, position),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onItemClick(item: SwipeViewItem) {
        Toast.makeText(
            view?.context,
            item.title,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        if (mRecyclerViewSwipeManager != null) {
            mRecyclerViewSwipeManager!!.release()
            mRecyclerViewSwipeManager = null
        }

        if (mRecyclerViewTouchActionGuardManager != null) {
            mRecyclerViewTouchActionGuardManager!!.release()
            mRecyclerViewTouchActionGuardManager = null
        }

        if (mRecyclerView != null) {
            mRecyclerView?.itemAnimator = null
            mRecyclerView?.adapter = null
            mRecyclerView = null
        }

        if (mWrappedAdapter != null) {
            WrapperAdapterUtils.releaseAll(mWrappedAdapter)
            mWrappedAdapter = null
        }
        mAdapter = null
        mLayoutManager = null
        super.onDestroyView()
    }

    companion object {
        private const val LIST_SWIPE_ICON_DATA = "LIST_SWIPE_ICON_DATA"
        fun newInstance(items: ArrayList<SwipeViewItem>): SwipeIconFragment {
            val fragment = SwipeIconFragment()
            val args = Bundle()
            args.putParcelableArrayList(LIST_SWIPE_ICON_DATA, items)
            fragment.arguments = args
            return fragment
        }
    }
}