package de.d3ns0n.shreds

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.d3ns0n.shreds.dummy.DummyContent
import de.d3ns0n.shreds.model.TextShred
import kotlinx.android.synthetic.main.activity_shred_detail.*
import kotlinx.android.synthetic.main.shred_detail.view.*

/**
 * A fragment representing a single Shred detail screen.
 * This fragment is either contained in a [ShredListActivity]
 * in two-pane mode (on tablets) or a [ShredDetailActivity]
 * on handsets.
 */
class ShredDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var mItem: TextShred? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                mItem = DummyContent.ITEM_MAP[it.getInt(ARG_ITEM_ID, 1)]
                activity?.toolbar_layout?.title = mItem?.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.shred_detail, container, false)

        // Show the dummy content as text in a TextView.
        mItem?.let {
            rootView.shred_detail.text = it.content
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
