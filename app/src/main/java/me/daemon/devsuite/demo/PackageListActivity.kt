package me.daemon.devsuite.demo

import android.content.pm.ApplicationInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import me.daemon.infrastructure.application.application

class PackageListActivity : AppCompatActivity(R.layout.activity_package_list) {

    private val adapter = PackageListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<RecyclerView>(R.id.rv_pkg_list).apply {
            adapter = this@PackageListActivity.adapter
        }

        val applications = packageManager.getInstalledApplications(0)
        applications.forEach {
            Log.e("PackageListActivity", "${it.packageName}->${it.sourceDir}")
        }
        adapter.setData(applications)
    }
}

private class PackageItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val iconView: ImageView = itemView.findViewById(R.id.iv_icon)
    val nameView: TextView = itemView.findViewById(R.id.tv_name)
    val pkgView: TextView = itemView.findViewById(R.id.tv_package_name)
    val sourceDirView: TextView = itemView.findViewById(R.id.tv_source_dir)
}

private class PackageListAdapter : RecyclerView.Adapter<PackageItemViewHolder>() {

    private val applicationList = mutableListOf<ApplicationInfo>()

    fun setData(applicationList: List<ApplicationInfo>) {
        this.applicationList.clear()
        this.applicationList.addAll(applicationList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageItemViewHolder =
        PackageItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_package_list, parent, false)
        )

    override fun onBindViewHolder(holder: PackageItemViewHolder, position: Int) {
        val applicationInfo = applicationList[position]
        holder.iconView.setImageDrawable(applicationInfo.loadIcon(application.packageManager))
        holder.nameView.text = applicationInfo.loadLabel(application.packageManager)
        holder.pkgView.text = applicationInfo.packageName
        holder.sourceDirView.text = applicationInfo.sourceDir
    }

    override fun getItemCount(): Int = applicationList.size

}