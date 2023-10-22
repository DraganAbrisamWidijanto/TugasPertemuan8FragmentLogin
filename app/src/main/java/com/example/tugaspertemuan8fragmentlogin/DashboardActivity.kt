package com.example.tugaspertemuan8fragmentlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.tugaspertemuan8fragmentlogin.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Mengatur judul aktivitas menjadi "Dashboard"
        title = "Dashboard"

        super.onCreate(savedInstanceState)

        // Menghubungkan binding dengan layout ActivityDashboardBinding
        binding = ActivityDashboardBinding.inflate(layoutInflater)

        // Menetapkan tata letak (layout) dari aktivitas ke tata letak yang dihubungkan melalui binding
        setContentView(binding.root)
    }

    // Menginflasi (inflate) menu dan menambahkannya ke toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu) // Inflasi menu dari resource app_menu
        return true
    }

    // Menangani item yang dipilih (selected) dari menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when {
            item.itemId == R.id.logout_button -> {
                finish() // Menutup aktivitas saat item menu logout_button ditekan
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
