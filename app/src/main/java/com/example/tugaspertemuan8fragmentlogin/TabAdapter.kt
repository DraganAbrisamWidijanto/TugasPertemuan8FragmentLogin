package com.example.tugaspertemuan8fragmentlogin

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    // Menyimpan peta (map) dari nama halaman ke objek Fragment yang sesuai
    private val page = mapOf<String, Fragment>(
        "register" to RegisterFragment(), // Menetapkan fragment RegisterFragment() untuk halaman "register"
        "login" to LoginFragment() // Menetapkan fragment LoginFragment() untuk halaman "login"
    )

    // Mendapatkan jumlah halaman yang dikelola oleh adapter
    override fun getItemCount(): Int = page.size

    // Membuat fragment pada posisi tertentu
    override fun createFragment(position: Int): Fragment {
        // Mengembalikan fragment pada posisi tertentu dari peta (map) halaman
        return page.values.elementAt(position)
    }
}
