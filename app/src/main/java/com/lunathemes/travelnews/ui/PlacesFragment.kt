package com.lunathemes.travelnews.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.lunathemes.travelnews.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.lunathemes.travelnews.adapter.AdapterPlaces
import org.json.JSONArray
import org.json.JSONObject
import com.lunathemes.travelnews.PlacesData
import org.json.JSONException
import com.lunathemes.travelnews.ui.PlacesFragment
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayList
import kotlin.Throws

class PlacesFragment : Fragment() {
    private var mRecyclerView: RecyclerView? = null
    private val viewItems: MutableList<Any> = ArrayList()
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private val mContext: Context? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState);
        val view = inflater.inflate(R.layout.fragment_places, container, false)
        mRecyclerView = view.findViewById<View>(R.id.my_recycler_view) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this.activity)
        mRecyclerView!!.layoutManager = layoutManager
        mAdapter = AdapterPlaces(this, viewItems)
        mRecyclerView!!.adapter = mAdapter
        addItemsFromJSON()
        return view
    }

    private fun addItemsFromJSON() {
        try {
            val jsonDataString = readJSONDataFromFile()
            val jsonArray = JSONArray(jsonDataString)
            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val city = itemObj.getString("city")
                val observation = itemObj.getString("observation")
                val placesData = PlacesData(city, observation)
                viewItems.add(placesData)
            }
        } catch (e: JSONException) {
            Log.d(TAG, "addItemsFromJSON: ", e)
        } catch (e: IOException) {
            Log.d(TAG, "addItemsFromJSON: ", e)
        }
    }

    @Throws(IOException::class)
    private fun readJSONDataFromFile(): String {
        var inputStream: InputStream? = null
        val builder = StringBuilder()
        try {
            var jsonString: String? = null
            inputStream = resources.openRawResource(R.raw.places)
            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream, "UTF-8")
            )
            while (bufferedReader.readLine().also { jsonString = it } != null) {
                builder.append(jsonString)
            }
        } finally {
            inputStream?.close()
        }
        return String(builder)
    }

    companion object {
        private const val TAG = "PlacesFragment"
    }
}