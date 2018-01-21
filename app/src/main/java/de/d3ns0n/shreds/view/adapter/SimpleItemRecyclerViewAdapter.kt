package de.d3ns0n.shreds.view.adapter

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.d3ns0n.shreds.R
import de.d3ns0n.shreds.ShredDetailActivity
import de.d3ns0n.shreds.ShredDetailFragment
import de.d3ns0n.shreds.view.activity.ShredListActivity
import de.d3ns0n.shreds.model.TextShred
import kotlinx.android.synthetic.main.shred_list_content.view.*

class SimpleItemRecyclerViewAdapter(private val mParentActivity: ShredListActivity,
                                    private val mValues: List<TextShred>,
                                    private val mTwoPane: Boolean) :
            RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val mOnClickListener: View.OnClickListener

        init {
            mOnClickListener = View.OnClickListener { v ->
                val item = v.tag as TextShred
                if (mTwoPane) {
                    val fragment = ShredDetailFragment().apply {
                        arguments = Bundle().apply {
                            putInt(ShredDetailFragment.ARG_ITEM_ID, item.id)
                        }
                    }
                    mParentActivity.supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.shred_detail_container, fragment)
                            .commit()
                } else {
                    val intent = Intent(v.context, ShredDetailActivity::class.java).apply {
                        putExtra(ShredDetailFragment.ARG_ITEM_ID, item.id)
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.shred_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = mValues[position]
            holder.mIdView.text = item.id.toString()
            holder.mContentView.text = item.content

            with(holder.itemView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }
        }

        override fun getItemCount(): Int {
            return mValues.size
        }

        inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
            val mIdView: TextView = mView.id_text
            val mContentView: TextView = mView.content
        }
    }