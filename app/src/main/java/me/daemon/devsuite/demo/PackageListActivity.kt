package me.daemon.devsuite.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class PackageListActivity : AppCompatActivity(R.layout.activity_package_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val applications = packageManager.getInstalledApplications(0)
        applications.forEach {
            Log.e("PackageListActivity", "${it.packageName}->${it.sourceDir}")
        }
    }

}