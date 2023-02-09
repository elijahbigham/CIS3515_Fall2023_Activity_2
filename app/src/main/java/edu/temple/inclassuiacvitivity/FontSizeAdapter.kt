package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Float.max

class FontSizeAdapter(_context: Context, _sizes: Array<Int>): BaseAdapter() {
    private val context = _context
    private val fontSizes = _sizes


    override fun getCount() = fontSizes.size

    override fun getItem(p0: Int) = fontSizes[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return (getDropDownView(position, convertView, parent) as TextView).apply {
            textSize = 24F
        }
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: TextView

        if(convertView == null) {

            textView = TextView(context)
            textView.setPadding(20,20,0,20)
        } else {
            textView = convertView as TextView
        }

        textView.text = fontSizes[position].toString()
        textView.textSize = max(fontSizes[position].toFloat(), 14F)

        return textView
    }
}